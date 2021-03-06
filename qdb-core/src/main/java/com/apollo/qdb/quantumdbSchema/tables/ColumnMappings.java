/*
 * This file is generated by jOOQ.
 */
package com.apollo.qdb.quantumdbSchema.tables;


import com.apollo.qdb.quantumdbSchema.Keys;
import com.apollo.qdb.quantumdbSchema.Quantumdb;
import com.apollo.qdb.quantumdbSchema.tables.records.ColumnMappingsRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ColumnMappings extends TableImpl<ColumnMappingsRecord> {

    private static final long serialVersionUID = 1569891791;

    /**
     * The reference instance of <code>QUANTUMDB.COLUMN_MAPPINGS</code>
     */
    public static final ColumnMappings COLUMN_MAPPINGS = new ColumnMappings();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ColumnMappingsRecord> getRecordType() {
        return ColumnMappingsRecord.class;
    }

    /**
     * The column <code>QUANTUMDB.COLUMN_MAPPINGS.ID</code>.
     */
    public final TableField<ColumnMappingsRecord, Long> ID = createField(DSL.name("ID"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>QUANTUMDB.COLUMN_MAPPINGS.SOURCE_COLUMN_ID</code>.
     */
    public final TableField<ColumnMappingsRecord, Long> SOURCE_COLUMN_ID = createField(DSL.name("SOURCE_COLUMN_ID"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>QUANTUMDB.COLUMN_MAPPINGS.TARGET_COLUMN_ID</code>.
     */
    public final TableField<ColumnMappingsRecord, Long> TARGET_COLUMN_ID = createField(DSL.name("TARGET_COLUMN_ID"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>QUANTUMDB.COLUMN_MAPPINGS</code> table reference
     */
    public ColumnMappings() {
        this(DSL.name("COLUMN_MAPPINGS"), null);
    }

    /**
     * Create an aliased <code>QUANTUMDB.COLUMN_MAPPINGS</code> table reference
     */
    public ColumnMappings(String alias) {
        this(DSL.name(alias), COLUMN_MAPPINGS);
    }

    /**
     * Create an aliased <code>QUANTUMDB.COLUMN_MAPPINGS</code> table reference
     */
    public ColumnMappings(Name alias) {
        this(alias, COLUMN_MAPPINGS);
    }

    private ColumnMappings(Name alias, Table<ColumnMappingsRecord> aliased) {
        this(alias, aliased, null);
    }

    private ColumnMappings(Name alias, Table<ColumnMappingsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> ColumnMappings(Table<O> child, ForeignKey<O, ColumnMappingsRecord> key) {
        super(child, key, COLUMN_MAPPINGS);
    }

    @Override
    public Schema getSchema() {
        return Quantumdb.QUANTUMDB;
    }

    @Override
    public Identity<ColumnMappingsRecord, Long> getIdentity() {
        return Keys.IDENTITY_COLUMN_MAPPINGS;
    }

    @Override
    public UniqueKey<ColumnMappingsRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_B;
    }

    @Override
    public List<UniqueKey<ColumnMappingsRecord>> getKeys() {
        return Arrays.<UniqueKey<ColumnMappingsRecord>>asList(Keys.CONSTRAINT_B, Keys.COLUMN_MAPPINGS_SOURCE_TARGET_UNIQUENESS);
    }

    @Override
    public List<ForeignKey<ColumnMappingsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ColumnMappingsRecord, ?>>asList(Keys.COLUMN_MAPPINGS_SOURCE_COLUMN_ID, Keys.COLUMN_MAPPINGS_TARGET_COLUMN_ID);
    }

    public TableColumns columnMappingsSourceColumnId() {
        return new TableColumns(this, Keys.COLUMN_MAPPINGS_SOURCE_COLUMN_ID);
    }

    public TableColumns columnMappingsTargetColumnId() {
        return new TableColumns(this, Keys.COLUMN_MAPPINGS_TARGET_COLUMN_ID);
    }

    @Override
    public ColumnMappings as(String alias) {
        return new ColumnMappings(DSL.name(alias), this);
    }

    @Override
    public ColumnMappings as(Name alias) {
        return new ColumnMappings(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ColumnMappings rename(String name) {
        return new ColumnMappings(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ColumnMappings rename(Name name) {
        return new ColumnMappings(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, Long, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
