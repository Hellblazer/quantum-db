// Generated by delombok at Thu Mar 11 18:53:10 PST 2021
package io.quantumdb.cli.xml;

import static com.google.common.base.Preconditions.checkArgument;
import io.quantumdb.core.schema.operations.CopyTable;
import io.quantumdb.core.schema.operations.SchemaOperations;

public class XmlCopyTable implements XmlOperation<CopyTable> {
    static final String TAG = "copyTable";

    static XmlOperation<?> convert(XmlElement element) {
        checkArgument(element.getTag().equals(TAG));
        XmlCopyTable operation = new XmlCopyTable();
        operation.setSourceTableName(element.getAttributes().get("sourceTableName"));
        operation.setTargetTableName(element.getAttributes().get("targetTableName"));
        return operation;
    }

    private String sourceTableName;
    private String targetTableName;

    
    public XmlCopyTable() {
    }

    @java.lang.Override
    
    public boolean equals(final java.lang.Object o) {
        if (o == this)
            return true;
        if (!(o instanceof XmlCopyTable))
            return false;
        final XmlCopyTable other = (XmlCopyTable) o;
        if (!other.canEqual(this))
            return false;
        final java.lang.Object this$sourceTableName = this.getSourceTableName();
        final java.lang.Object other$sourceTableName = other.getSourceTableName();
        if (this$sourceTableName == null ? other$sourceTableName != null
                : !this$sourceTableName.equals(other$sourceTableName))
            return false;
        final java.lang.Object this$targetTableName = this.getTargetTableName();
        final java.lang.Object other$targetTableName = other.getTargetTableName();
        if (this$targetTableName == null ? other$targetTableName != null
                : !this$targetTableName.equals(other$targetTableName))
            return false;
        return true;
    }

    
    public String getSourceTableName() {
        return this.sourceTableName;
    }

    
    public String getTargetTableName() {
        return this.targetTableName;
    }

    @java.lang.Override
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $sourceTableName = this.getSourceTableName();
        result = result * PRIME + ($sourceTableName == null ? 43 : $sourceTableName.hashCode());
        final java.lang.Object $targetTableName = this.getTargetTableName();
        result = result * PRIME + ($targetTableName == null ? 43 : $targetTableName.hashCode());
        return result;
    }

    
    public void setSourceTableName(final String sourceTableName) {
        this.sourceTableName = sourceTableName;
    }

    
    public void setTargetTableName(final String targetTableName) {
        this.targetTableName = targetTableName;
    }

    @Override
    public CopyTable toOperation() {
        return SchemaOperations.copyTable(sourceTableName, targetTableName);
    }

    @java.lang.Override
    
    public java.lang.String toString() {
        return "XmlCopyTable(sourceTableName=" + this.getSourceTableName() + ", targetTableName="
                + this.getTargetTableName() + ")";
    }

    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof XmlCopyTable;
    }
}