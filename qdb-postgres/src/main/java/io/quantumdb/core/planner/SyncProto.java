/*
 * Copyright (c) 2021, salesforce.com, inc.
 * All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause
 * For full license text, see the LICENSE file in the repo root or https://opensource.org/licenses/BSD-3-Clause
 */
package io.quantumdb.core.planner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.h2.api.Trigger;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Operator;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.impl.DSL;

/**
 * @author hal.hildebrand
 *
 */
public abstract class SyncProto implements Trigger {

    private static String TEMPLATE = """
            $$
            public static org.h2.api.Trigger construct() {return new io.quantumdb.core.planner.SyncProto(%s, %s, %s) {};}
            $$
            """;

    public static String generate(String target, List<String> targetFields, List<String> identities) {
        return String.format(TEMPLATE, target, asList(targetFields), asList(identities));
    }

    private static String asList(List<String> fieldNames) {
        StringBuilder builder = new StringBuilder();
        builder.append("java.util.List.of(");
        int[] count = new int[] { fieldNames.size() };
        fieldNames.forEach(f -> {
            builder.append(f);
            if (--count[0] != 0) {
                builder.append(',');
            }
        });
        builder.append(')');
        return builder.toString();
    }

    private final List<Field<Object>>  identities;
    private final Map<String, Integer> positions = new HashMap<>();
    private final Table<?>             target;
    private final List<Field<Object>>  targetFields;

    private int type;

    @SuppressWarnings("unchecked")
    public SyncProto(String target, List<String> targetFields, List<String> identities) {
        this.target = DSL.table(DSL.name(target));
        this.targetFields = targetFields.stream()
                                        .map(f -> (Field<Object>) this.target.field(f))
                                        .collect(Collectors.toList());
        this.identities = identities.stream()
                                    .map(e -> (Field<Object>) this.target.field(e))
                                    .collect(Collectors.toList());
    }

    @Override
    public void close() throws SQLException {
    }

    @Override
    public void fire(Connection conn, Object[] oldRow, Object[] newRow) throws SQLException {
        DSLContext context = DSL.using(conn, SQLDialect.H2);
        switch (type) {
        case Trigger.INSERT: {
            context.insertInto(target, targetFields).values(List.of(newRow)).execute();
            break;
        }
        case Trigger.UPDATE: {
            if (context.selectCount().from(target).where(condition(oldRow)).fetchOne().value1() == 0) {
                context.insertInto(target, targetFields).values(values(newRow)).execute();
            }
            break;
        }
        case Trigger.DELETE: {
            context.deleteFrom(target).where(condition(oldRow));
        }
        default:
            throw new IllegalArgumentException("Invalid trigger type: " + type);
        }
    }

    private List<Object> values(Object[] newRow) {
        List<Object> values = new ArrayList<>();
        for (Field<Object> f : targetFields) {
            values.add(newRow[positions.get(f.get)]);
        }
        return values;
    }

    @Override
    public void init(Connection conn, String schemaName, String triggerName, String tableName, boolean before,
                     int type) throws SQLException {
        ResultSet rs = conn.getMetaData().getColumns(null, schemaName, tableName, null);
        int index = 0;
        while (rs.next()) {
            String column = rs.getString("COLUMN_NAME");
            positions.put(column, index++);
        }
        this.type = type;
    }

    @Override
    public void remove() throws SQLException {
    }

    private Condition condition(Object[] oldRow) {
        Condition condition = DSL.condition(true);
        if (identities.isEmpty()) {
            return condition;
        }
        List<Condition> conditions = new ArrayList<>();
        for (Field<Object> f : identities) {
            conditions.add(f.eq(oldRow[positions.get(f.getName())]));
        }
        return condition.and(DSL.condition(Operator.AND, conditions));
    }
}
