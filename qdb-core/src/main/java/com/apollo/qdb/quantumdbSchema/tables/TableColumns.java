/*
 * This file is generated by jOOQ.
 */
package com.apollo.qdb.quantumdbSchema.tables;


import com.apollo.qdb.quantumdbSchema.Keys;
import com.apollo.qdb.quantumdbSchema.Quantumdb;
import com.apollo.qdb.quantumdbSchema.tables.records.TableColumnsRecord;

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
public class TableColumns extends TableImpl<TableColumnsRecord> {

    private static final long serialVersionUID = 389338113;

    /**
     * The reference instance of <code>QUANTUMDB.TABLE_COLUMNS</code>
     */
    public static final TableColumns TABLE_COLUMNS = new TableColumns();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TableColumnsRecord> getRecordType() {
        return TableColumnsRecord.class;
    }

    /**
     * The column <code>QUANTUMDB.TABLE_COLUMNS.ID</code>.
     */
    public final TableField<TableColumnsRecord, Long> ID = createField(DSL.name("ID"), org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>QUANTUMDB.TABLE_COLUMNS.REF_ID</code>.
     */
    public final TableField<TableColumnsRecord, String> REF_ID = createField(DSL.name("REF_ID"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>QUANTUMDB.TABLE_COLUMNS.COLUMN_NAME</code>.
     */
    public final TableField<TableColumnsRecord, String> COLUMN_NAME = createField(DSL.name("COLUMN_NAME"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * Create a <code>QUANTUMDB.TABLE_COLUMNS</code> table reference
     */
    public TableColumns() {
        this(DSL.name("TABLE_COLUMNS"), null);
    }

    /**
     * Create an aliased <code>QUANTUMDB.TABLE_COLUMNS</code> table reference
     */
    public TableColumns(String alias) {
        this(DSL.name(alias), TABLE_COLUMNS);
    }

    /**
     * Create an aliased <code>QUANTUMDB.TABLE_COLUMNS</code> table reference
     */
    public TableColumns(Name alias) {
        this(alias, TABLE_COLUMNS);
    }

    private TableColumns(Name alias, Table<TableColumnsRecord> aliased) {
        this(alias, aliased, null);
    }

    private TableColumns(Name alias, Table<TableColumnsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> TableColumns(Table<O> child, ForeignKey<O, TableColumnsRecord> key) {
        super(child, key, TABLE_COLUMNS);
    }

    @Override
    public Schema getSchema() {
        return Quantumdb.QUANTUMDB;
    }

    @Override
    public Identity<TableColumnsRecord, Long> getIdentity() {
        return Keys.IDENTITY_TABLE_COLUMNS;
    }

    @Override
    public UniqueKey<TableColumnsRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_6;
    }

    @Override
    public List<UniqueKey<TableColumnsRecord>> getKeys() {
        return Arrays.<UniqueKey<TableColumnsRecord>>asList(Keys.CONSTRAINT_6, Keys.TABLE_COLUMNS_REF_ID_COLUMN_NAME_UNIQUENESS);
    }

    @Override
    public List<ForeignKey<TableColumnsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<TableColumnsRecord, ?>>asList(Keys.TABLE_COLUMNS_REF_ID);
    }

    public Refs refs() {
        return new Refs(this, Keys.TABLE_COLUMNS_REF_ID);
    }

    @Override
    public TableColumns as(String alias) {
        return new TableColumns(DSL.name(alias), this);
    }

    @Override
    public TableColumns as(Name alias) {
        return new TableColumns(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TableColumns rename(String name) {
        return new TableColumns(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TableColumns rename(Name name) {
        return new TableColumns(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}