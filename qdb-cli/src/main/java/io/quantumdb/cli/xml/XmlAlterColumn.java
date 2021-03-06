// Generated by delombok at Thu Mar 11 18:53:10 PST 2021
package io.quantumdb.cli.xml;

import static com.google.common.base.Preconditions.checkArgument;
import java.util.Map;
import java.util.Optional;
import io.quantumdb.core.schema.definitions.Column.Hint;
import io.quantumdb.core.schema.definitions.PostgresTypes;
import io.quantumdb.core.schema.operations.AlterColumn;
import io.quantumdb.core.schema.operations.SchemaOperations;

public class XmlAlterColumn implements XmlOperation<AlterColumn> {
    static final String TAG = "alterColumn";

    static XmlOperation<?> convert(XmlElement element) {
        checkArgument(element.getTag().equals(TAG));
        Map<String, String> attributes = element.getAttributes();
        XmlAlterColumn operation = new XmlAlterColumn();
        operation.setTableName(attributes.get("tableName"));
        operation.setColumnName(attributes.get("columnName"));
        Optional.ofNullable(attributes.get("newColumnName")).ifPresent(operation::setNewColumnName);
        Optional.ofNullable(attributes.get("newType")).ifPresent(operation::setNewType);
        Optional.ofNullable(attributes.get("nullable"))
                .map(Boolean.TRUE.toString()::equals)
                .ifPresent(operation::setNullable);
        return operation;
    }

    private String  columnName;
    private String  newColumnName;
    private String  newType;
    private Boolean nullable;
    private String  tableName;

    
    public XmlAlterColumn() {
    }

    @java.lang.Override
    
    public boolean equals(final java.lang.Object o) {
        if (o == this)
            return true;
        if (!(o instanceof XmlAlterColumn))
            return false;
        final XmlAlterColumn other = (XmlAlterColumn) o;
        if (!other.canEqual(this))
            return false;
        final java.lang.Object this$nullable = this.getNullable();
        final java.lang.Object other$nullable = other.getNullable();
        if (this$nullable == null ? other$nullable != null : !this$nullable.equals(other$nullable))
            return false;
        final java.lang.Object this$tableName = this.getTableName();
        final java.lang.Object other$tableName = other.getTableName();
        if (this$tableName == null ? other$tableName != null : !this$tableName.equals(other$tableName))
            return false;
        final java.lang.Object this$columnName = this.getColumnName();
        final java.lang.Object other$columnName = other.getColumnName();
        if (this$columnName == null ? other$columnName != null : !this$columnName.equals(other$columnName))
            return false;
        final java.lang.Object this$newColumnName = this.getNewColumnName();
        final java.lang.Object other$newColumnName = other.getNewColumnName();
        if (this$newColumnName == null ? other$newColumnName != null : !this$newColumnName.equals(other$newColumnName))
            return false;
        final java.lang.Object this$newType = this.getNewType();
        final java.lang.Object other$newType = other.getNewType();
        if (this$newType == null ? other$newType != null : !this$newType.equals(other$newType))
            return false;
        return true;
    }

    
    public String getColumnName() {
        return this.columnName;
    }

    
    public String getNewColumnName() {
        return this.newColumnName;
    }

    
    public String getNewType() {
        return this.newType;
    }

    
    public Boolean getNullable() {
        return this.nullable;
    }

    
    public String getTableName() {
        return this.tableName;
    }

    @java.lang.Override
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $nullable = this.getNullable();
        result = result * PRIME + ($nullable == null ? 43 : $nullable.hashCode());
        final java.lang.Object $tableName = this.getTableName();
        result = result * PRIME + ($tableName == null ? 43 : $tableName.hashCode());
        final java.lang.Object $columnName = this.getColumnName();
        result = result * PRIME + ($columnName == null ? 43 : $columnName.hashCode());
        final java.lang.Object $newColumnName = this.getNewColumnName();
        result = result * PRIME + ($newColumnName == null ? 43 : $newColumnName.hashCode());
        final java.lang.Object $newType = this.getNewType();
        result = result * PRIME + ($newType == null ? 43 : $newType.hashCode());
        return result;
    }

    
    public void setColumnName(final String columnName) {
        this.columnName = columnName;
    }

    
    public void setNewColumnName(final String newColumnName) {
        this.newColumnName = newColumnName;
    }

    
    public void setNewType(final String newType) {
        this.newType = newType;
    }

    
    public void setNullable(final Boolean nullable) {
        this.nullable = nullable;
    }

    
    public void setTableName(final String tableName) {
        this.tableName = tableName;
    }

    @Override
    public AlterColumn toOperation() {
        AlterColumn operation = SchemaOperations.alterColumn(tableName, columnName);
        Optional.ofNullable(newColumnName).ifPresent(operation::rename);
        Optional.ofNullable(newType).map(PostgresTypes::from).ifPresent(operation::modifyDataType);
        Optional.ofNullable(nullable).ifPresent(newNullable -> {
            if (newNullable) {
                operation.dropHint(Hint.NOT_NULL);
            } else {
                operation.addHint(Hint.NOT_NULL);
            }
        });
        // TODO: Support other hints?
        return operation;
    }

    @java.lang.Override
    
    public java.lang.String toString() {
        return "XmlAlterColumn(tableName=" + this.getTableName() + ", columnName=" + this.getColumnName()
                + ", newColumnName=" + this.getNewColumnName() + ", newType=" + this.getNewType() + ", nullable="
                + this.getNullable() + ")";
    }

    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof XmlAlterColumn;
    }
}
