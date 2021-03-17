// Generated by delombok at Thu Mar 11 18:53:10 PST 2021
package io.quantumdb.cli.xml;

import static com.google.common.base.Preconditions.checkArgument;
import io.quantumdb.core.schema.operations.DropForeignKey;
import io.quantumdb.core.schema.operations.SchemaOperations;

public class XmlDropForeignKey implements XmlOperation<DropForeignKey> {
    static final String TAG = "dropForeignKey";

    static XmlOperation<?> convert(XmlElement element) {
        checkArgument(element.getTag().equals(TAG));
        XmlDropForeignKey operation = new XmlDropForeignKey();
        operation.setTableName(element.getAttributes().get("tableName"));
        operation.setForeignKeyName(element.getAttributes().get("foreignKeyName"));
        return operation;
    }

    private String foreignKeyName;
    private String tableName;

    
    public XmlDropForeignKey() {
    }

    @java.lang.Override
    
    public boolean equals(final java.lang.Object o) {
        if (o == this)
            return true;
        if (!(o instanceof XmlDropForeignKey))
            return false;
        final XmlDropForeignKey other = (XmlDropForeignKey) o;
        if (!other.canEqual(this))
            return false;
        final java.lang.Object this$tableName = this.getTableName();
        final java.lang.Object other$tableName = other.getTableName();
        if (this$tableName == null ? other$tableName != null : !this$tableName.equals(other$tableName))
            return false;
        final java.lang.Object this$foreignKeyName = this.getForeignKeyName();
        final java.lang.Object other$foreignKeyName = other.getForeignKeyName();
        if (this$foreignKeyName == null ? other$foreignKeyName != null
                : !this$foreignKeyName.equals(other$foreignKeyName))
            return false;
        return true;
    }

    
    public String getForeignKeyName() {
        return this.foreignKeyName;
    }

    
    public String getTableName() {
        return this.tableName;
    }

    @java.lang.Override
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $tableName = this.getTableName();
        result = result * PRIME + ($tableName == null ? 43 : $tableName.hashCode());
        final java.lang.Object $foreignKeyName = this.getForeignKeyName();
        result = result * PRIME + ($foreignKeyName == null ? 43 : $foreignKeyName.hashCode());
        return result;
    }

    
    public void setForeignKeyName(final String foreignKeyName) {
        this.foreignKeyName = foreignKeyName;
    }

    
    public void setTableName(final String tableName) {
        this.tableName = tableName;
    }

    @Override
    public DropForeignKey toOperation() {
        return SchemaOperations.dropForeignKey(tableName, foreignKeyName);
    }

    @java.lang.Override
    
    public java.lang.String toString() {
        return "XmlDropForeignKey(tableName=" + this.getTableName() + ", foreignKeyName=" + this.getForeignKeyName()
                + ")";
    }

    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof XmlDropForeignKey;
    }
}