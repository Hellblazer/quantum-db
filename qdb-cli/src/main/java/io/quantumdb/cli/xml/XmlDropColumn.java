// Generated by delombok at Thu Mar 11 18:53:10 PST 2021
package io.quantumdb.cli.xml;

import static com.google.common.base.Preconditions.checkArgument;
import io.quantumdb.core.schema.operations.DropColumn;
import io.quantumdb.core.schema.operations.SchemaOperations;

public class XmlDropColumn implements XmlOperation<DropColumn> {
    static final String TAG = "dropColumn";

    static XmlOperation<?> convert(XmlElement element) {
        checkArgument(element.getTag().equals(TAG));
        XmlDropColumn operation = new XmlDropColumn();
        operation.setTableName(element.getAttributes().get("tableName"));
        operation.setColumnName(element.getAttributes().get("columnName"));
        return operation;
    }

    private String columnName;
    private String tableName;

    
    public XmlDropColumn() {
    }

    @java.lang.Override
    
    public boolean equals(final java.lang.Object o) {
        if (o == this)
            return true;
        if (!(o instanceof XmlDropColumn))
            return false;
        final XmlDropColumn other = (XmlDropColumn) o;
        if (!other.canEqual(this))
            return false;
        final java.lang.Object this$tableName = this.getTableName();
        final java.lang.Object other$tableName = other.getTableName();
        if (this$tableName == null ? other$tableName != null : !this$tableName.equals(other$tableName))
            return false;
        final java.lang.Object this$columnName = this.getColumnName();
        final java.lang.Object other$columnName = other.getColumnName();
        if (this$columnName == null ? other$columnName != null : !this$columnName.equals(other$columnName))
            return false;
        return true;
    }

    
    public String getColumnName() {
        return this.columnName;
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
        final java.lang.Object $columnName = this.getColumnName();
        result = result * PRIME + ($columnName == null ? 43 : $columnName.hashCode());
        return result;
    }

    
    public void setColumnName(final String columnName) {
        this.columnName = columnName;
    }

    
    public void setTableName(final String tableName) {
        this.tableName = tableName;
    }

    @Override
    public DropColumn toOperation() {
        return SchemaOperations.dropColumn(tableName, columnName);
    }

    @java.lang.Override
    
    public java.lang.String toString() {
        return "XmlDropColumn(tableName=" + this.getTableName() + ", columnName=" + this.getColumnName() + ")";
    }

    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof XmlDropColumn;
    }
}
