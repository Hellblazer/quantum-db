// Generated by delombok at Thu Mar 11 18:53:10 PST 2021
package io.quantumdb.cli.xml;

import static com.google.common.base.Preconditions.checkArgument;

public class XmlColumn {
    static XmlColumn convert(XmlElement element) {
        checkArgument(element.getTag().equals("column"));
        XmlColumn column = new XmlColumn();
        column.setName(element.getAttributes().get("name"));
        column.setType(element.getAttributes().get("type"));
        column.setDefaultExpression(element.getAttributes().get("defaultExpression"));
        column.setPrimaryKey(Boolean.TRUE.toString().equals(element.getAttributes().get("primaryKey")));
        column.setAutoIncrement(Boolean.TRUE.toString().equals(element.getAttributes().get("autoIncrement")));
        column.setNullable(Boolean.TRUE.toString().equals(element.getAttributes().get("nullable")));
        return column;
    }

    private boolean autoIncrement;
    private String  defaultExpression;
    private String  name;
    private boolean nullable;
    private boolean primaryKey;
    private String  type;

    
    public XmlColumn() {
    }

    @java.lang.Override
    
    public boolean equals(final java.lang.Object o) {
        if (o == this)
            return true;
        if (!(o instanceof XmlColumn))
            return false;
        final XmlColumn other = (XmlColumn) o;
        if (!other.canEqual(this))
            return false;
        if (this.isPrimaryKey() != other.isPrimaryKey())
            return false;
        if (this.isAutoIncrement() != other.isAutoIncrement())
            return false;
        if (this.isNullable() != other.isNullable())
            return false;
        final java.lang.Object this$name = this.getName();
        final java.lang.Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name))
            return false;
        final java.lang.Object this$type = this.getType();
        final java.lang.Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type))
            return false;
        final java.lang.Object this$defaultExpression = this.getDefaultExpression();
        final java.lang.Object other$defaultExpression = other.getDefaultExpression();
        if (this$defaultExpression == null ? other$defaultExpression != null
                : !this$defaultExpression.equals(other$defaultExpression))
            return false;
        return true;
    }

    
    public String getDefaultExpression() {
        return this.defaultExpression;
    }

    
    public String getName() {
        return this.name;
    }

    
    public String getType() {
        return this.type;
    }

    @java.lang.Override
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + (this.isPrimaryKey() ? 79 : 97);
        result = result * PRIME + (this.isAutoIncrement() ? 79 : 97);
        result = result * PRIME + (this.isNullable() ? 79 : 97);
        final java.lang.Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final java.lang.Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        final java.lang.Object $defaultExpression = this.getDefaultExpression();
        result = result * PRIME + ($defaultExpression == null ? 43 : $defaultExpression.hashCode());
        return result;
    }

    
    public boolean isAutoIncrement() {
        return this.autoIncrement;
    }

    
    public boolean isNullable() {
        return this.nullable;
    }

    
    public boolean isPrimaryKey() {
        return this.primaryKey;
    }

    
    public void setAutoIncrement(final boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    
    public void setDefaultExpression(final String defaultExpression) {
        this.defaultExpression = defaultExpression;
    }

    
    public void setName(final String name) {
        this.name = name;
    }

    
    public void setNullable(final boolean nullable) {
        this.nullable = nullable;
    }

    
    public void setPrimaryKey(final boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    
    public void setType(final String type) {
        this.type = type;
    }

    @java.lang.Override
    
    public java.lang.String toString() {
        return "XmlColumn(name=" + this.getName() + ", type=" + this.getType() + ", defaultExpression="
                + this.getDefaultExpression() + ", primaryKey=" + this.isPrimaryKey() + ", autoIncrement="
                + this.isAutoIncrement() + ", nullable=" + this.isNullable() + ")";
    }

    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof XmlColumn;
    }
}
