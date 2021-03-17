// Generated by delombok at Thu Mar 11 18:53:10 PST 2021
package io.quantumdb.cli.xml;

import static com.google.common.base.Preconditions.checkArgument;
import java.util.Objects;
import java.util.Optional;
import io.quantumdb.core.schema.operations.DataOperation;
import io.quantumdb.core.schema.operations.SchemaOperations;

public class XmlQuery implements XmlOperation<DataOperation> {
    static final String TAG = "sql";

    static XmlOperation<?> convert(XmlElement element) {
        checkArgument(element.getTag().equals(TAG));
        XmlQuery operation = new XmlQuery();
        operation.setQuery(Optional.ofNullable(element.getText())
                                   .orElseGet(() -> element.getChildren()
                                                           .stream()
                                                           .filter(child -> child.getTag() == null)
                                                           .map(XmlElement::getText)
                                                           .filter(Objects::nonNull)
                                                           .findFirst()
                                                           .orElseThrow(() -> new RuntimeException(
                                                                   "No query specified!"))));
        return operation;
    }

    private String query;

    
    public XmlQuery() {
    }

    @java.lang.Override
    
    public boolean equals(final java.lang.Object o) {
        if (o == this)
            return true;
        if (!(o instanceof XmlQuery))
            return false;
        final XmlQuery other = (XmlQuery) o;
        if (!other.canEqual(this))
            return false;
        final java.lang.Object this$query = this.getQuery();
        final java.lang.Object other$query = other.getQuery();
        if (this$query == null ? other$query != null : !this$query.equals(other$query))
            return false;
        return true;
    }

    
    public String getQuery() {
        return this.query;
    }

    @java.lang.Override
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $query = this.getQuery();
        result = result * PRIME + ($query == null ? 43 : $query.hashCode());
        return result;
    }

    
    public void setQuery(final String query) {
        this.query = query;
    }

    @Override
    public DataOperation toOperation() {
        return SchemaOperations.execute(query);
    }

    @java.lang.Override
    
    public java.lang.String toString() {
        return "XmlQuery(query=" + this.getQuery() + ")";
    }

    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof XmlQuery;
    }
}