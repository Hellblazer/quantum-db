// Generated by delombok at Thu Mar 11 18:53:10 PST 2021
package io.quantumdb.cli.xml;

import static com.google.common.base.Preconditions.checkArgument;
import io.quantumdb.core.schema.operations.RenameTable;
import io.quantumdb.core.schema.operations.SchemaOperations;

public class XmlRenameTable implements XmlOperation<RenameTable> {
    static final String TAG = "renameTable";

    static XmlOperation<?> convert(XmlElement element) {
        checkArgument(element.getTag().equals(TAG));
        XmlRenameTable operation = new XmlRenameTable();
        operation.setOldTableName(element.getAttributes().get("oldTableName"));
        operation.setNewTableName(element.getAttributes().get("newTableName"));
        return operation;
    }

    private String newTableName;
    private String oldTableName;

    
    public XmlRenameTable() {
    }

    @java.lang.Override
    
    public boolean equals(final java.lang.Object o) {
        if (o == this)
            return true;
        if (!(o instanceof XmlRenameTable))
            return false;
        final XmlRenameTable other = (XmlRenameTable) o;
        if (!other.canEqual(this))
            return false;
        final java.lang.Object this$oldTableName = this.getOldTableName();
        final java.lang.Object other$oldTableName = other.getOldTableName();
        if (this$oldTableName == null ? other$oldTableName != null : !this$oldTableName.equals(other$oldTableName))
            return false;
        final java.lang.Object this$newTableName = this.getNewTableName();
        final java.lang.Object other$newTableName = other.getNewTableName();
        if (this$newTableName == null ? other$newTableName != null : !this$newTableName.equals(other$newTableName))
            return false;
        return true;
    }

    
    public String getNewTableName() {
        return this.newTableName;
    }

    
    public String getOldTableName() {
        return this.oldTableName;
    }

    @java.lang.Override
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $oldTableName = this.getOldTableName();
        result = result * PRIME + ($oldTableName == null ? 43 : $oldTableName.hashCode());
        final java.lang.Object $newTableName = this.getNewTableName();
        result = result * PRIME + ($newTableName == null ? 43 : $newTableName.hashCode());
        return result;
    }

    
    public void setNewTableName(final String newTableName) {
        this.newTableName = newTableName;
    }

    
    public void setOldTableName(final String oldTableName) {
        this.oldTableName = oldTableName;
    }

    @Override
    public RenameTable toOperation() {
        return SchemaOperations.renameTable(oldTableName, newTableName);
    }

    @java.lang.Override
    
    public java.lang.String toString() {
        return "XmlRenameTable(oldTableName=" + this.getOldTableName() + ", newTableName=" + this.getNewTableName()
                + ")";
    }

    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof XmlRenameTable;
    }
}
