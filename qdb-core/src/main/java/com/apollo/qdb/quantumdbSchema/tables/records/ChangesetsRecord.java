/*
 * This file is generated by jOOQ.
 */
package com.apollo.qdb.quantumdbSchema.tables.records;


import com.apollo.qdb.quantumdbSchema.tables.Changesets;

import java.time.OffsetDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ChangesetsRecord extends UpdatableRecordImpl<ChangesetsRecord> implements Record6<String, String, String, OffsetDateTime, String, String> {

    private static final long serialVersionUID = -396502105;

    /**
     * Setter for <code>QUANTUMDB.CHANGESETS.ID</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>QUANTUMDB.CHANGESETS.ID</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>QUANTUMDB.CHANGESETS.VERSION_ID</code>.
     */
    public void setVersionId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>QUANTUMDB.CHANGESETS.VERSION_ID</code>.
     */
    public String getVersionId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>QUANTUMDB.CHANGESETS.AUTHOR</code>.
     */
    public void setAuthor(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>QUANTUMDB.CHANGESETS.AUTHOR</code>.
     */
    public String getAuthor() {
        return (String) get(2);
    }

    /**
     * Setter for <code>QUANTUMDB.CHANGESETS.CREATED</code>.
     */
    public void setCreated(OffsetDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>QUANTUMDB.CHANGESETS.CREATED</code>.
     */
    public OffsetDateTime getCreated() {
        return (OffsetDateTime) get(3);
    }

    /**
     * Setter for <code>QUANTUMDB.CHANGESETS.DESCRIPTION</code>.
     */
    public void setDescription(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>QUANTUMDB.CHANGESETS.DESCRIPTION</code>.
     */
    public String getDescription() {
        return (String) get(4);
    }

    /**
     * Setter for <code>QUANTUMDB.CHANGESETS.ALIAS</code>.
     */
    public void setAlias(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>QUANTUMDB.CHANGESETS.ALIAS</code>.
     */
    public String getAlias() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<String, String, String, OffsetDateTime, String, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<String, String, String, OffsetDateTime, String, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Changesets.CHANGESETS.ID;
    }

    @Override
    public Field<String> field2() {
        return Changesets.CHANGESETS.VERSION_ID;
    }

    @Override
    public Field<String> field3() {
        return Changesets.CHANGESETS.AUTHOR;
    }

    @Override
    public Field<OffsetDateTime> field4() {
        return Changesets.CHANGESETS.CREATED;
    }

    @Override
    public Field<String> field5() {
        return Changesets.CHANGESETS.DESCRIPTION;
    }

    @Override
    public Field<String> field6() {
        return Changesets.CHANGESETS.ALIAS;
    }

    @Override
    public String component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getVersionId();
    }

    @Override
    public String component3() {
        return getAuthor();
    }

    @Override
    public OffsetDateTime component4() {
        return getCreated();
    }

    @Override
    public String component5() {
        return getDescription();
    }

    @Override
    public String component6() {
        return getAlias();
    }

    @Override
    public String value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getVersionId();
    }

    @Override
    public String value3() {
        return getAuthor();
    }

    @Override
    public OffsetDateTime value4() {
        return getCreated();
    }

    @Override
    public String value5() {
        return getDescription();
    }

    @Override
    public String value6() {
        return getAlias();
    }

    @Override
    public ChangesetsRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public ChangesetsRecord value2(String value) {
        setVersionId(value);
        return this;
    }

    @Override
    public ChangesetsRecord value3(String value) {
        setAuthor(value);
        return this;
    }

    @Override
    public ChangesetsRecord value4(OffsetDateTime value) {
        setCreated(value);
        return this;
    }

    @Override
    public ChangesetsRecord value5(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public ChangesetsRecord value6(String value) {
        setAlias(value);
        return this;
    }

    @Override
    public ChangesetsRecord values(String value1, String value2, String value3, OffsetDateTime value4, String value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ChangesetsRecord
     */
    public ChangesetsRecord() {
        super(Changesets.CHANGESETS);
    }

    /**
     * Create a detached, initialised ChangesetsRecord
     */
    public ChangesetsRecord(String id, String versionId, String author, OffsetDateTime created, String description, String alias) {
        super(Changesets.CHANGESETS);

        set(0, id);
        set(1, versionId);
        set(2, author);
        set(3, created);
        set(4, description);
        set(5, alias);
    }
}
