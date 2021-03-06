/*
 * This file is generated by jOOQ.
 */
package com.apollo.qdb.quantumdbSchema.tables.records;


import com.apollo.qdb.quantumdbSchema.tables.ActiveVersions;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Row1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ActiveVersionsRecord extends UpdatableRecordImpl<ActiveVersionsRecord> implements Record1<String> {

    private static final long serialVersionUID = 1251222006;

    /**
     * Setter for <code>QUANTUMDB.ACTIVE_VERSIONS.VERSION_ID</code>.
     */
    public void setVersionId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>QUANTUMDB.ACTIVE_VERSIONS.VERSION_ID</code>.
     */
    public String getVersionId() {
        return (String) get(0);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record1 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row1<String> fieldsRow() {
        return (Row1) super.fieldsRow();
    }

    @Override
    public Row1<String> valuesRow() {
        return (Row1) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return ActiveVersions.ACTIVE_VERSIONS.VERSION_ID;
    }

    @Override
    public String component1() {
        return getVersionId();
    }

    @Override
    public String value1() {
        return getVersionId();
    }

    @Override
    public ActiveVersionsRecord value1(String value) {
        setVersionId(value);
        return this;
    }

    @Override
    public ActiveVersionsRecord values(String value1) {
        value1(value1);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ActiveVersionsRecord
     */
    public ActiveVersionsRecord() {
        super(ActiveVersions.ACTIVE_VERSIONS);
    }

    /**
     * Create a detached, initialised ActiveVersionsRecord
     */
    public ActiveVersionsRecord(String versionId) {
        super(ActiveVersions.ACTIVE_VERSIONS);

        set(0, versionId);
    }
}
