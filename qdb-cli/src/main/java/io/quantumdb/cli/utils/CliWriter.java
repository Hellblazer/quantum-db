// Generated by delombok at Thu Mar 11 18:53:10 PST 2021
package io.quantumdb.cli.utils;

import java.io.IOException;
import com.google.common.base.Strings;
import jline.ANSIBuffer;
import jline.ConsoleReader;
import jline.Terminal;

public class CliWriter {

    public enum Context {
        FAILURE, INFO, SUCCESS;
    }

    private boolean             enableBold = true;
    private int                 indent     = 0;
    private final ConsoleReader reader;
    private final Terminal      terminal;

    public CliWriter() {
        try {
            terminal = Terminal.setupTerminal();
            reader = new ConsoleReader();
            terminal.beforeReadLine(reader, "", (char) 0);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void close() {
        Terminal.resetTerminal();
    }

    public CliWriter enableBold(boolean enableBold) {
        this.enableBold = enableBold;
        return this;
    }

    @java.lang.Override
    
    public boolean equals(final java.lang.Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CliWriter))
            return false;
        final CliWriter other = (CliWriter) o;
        if (!other.canEqual(this))
            return false;
        if (this.isEnableBold() != other.isEnableBold())
            return false;
        if (this.getIndent() != other.getIndent())
            return false;
        final java.lang.Object this$terminal = this.getTerminal();
        final java.lang.Object other$terminal = other.getTerminal();
        if (this$terminal == null ? other$terminal != null : !this$terminal.equals(other$terminal))
            return false;
        final java.lang.Object this$reader = this.getReader();
        final java.lang.Object other$reader = other.getReader();
        if (this$reader == null ? other$reader != null : !this$reader.equals(other$reader))
            return false;
        return true;
    }

    
    public int getIndent() {
        return this.indent;
    }

    
    public ConsoleReader getReader() {
        return this.reader;
    }

    
    public Terminal getTerminal() {
        return this.terminal;
    }

    @java.lang.Override
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + (this.isEnableBold() ? 79 : 97);
        result = result * PRIME + this.getIndent();
        final java.lang.Object $terminal = this.getTerminal();
        result = result * PRIME + ($terminal == null ? 43 : $terminal.hashCode());
        final java.lang.Object $reader = this.getReader();
        result = result * PRIME + ($reader == null ? 43 : $reader.hashCode());
        return result;
    }

    public CliWriter indent(int delta) {
        indent += delta;
        return this;
    }

    
    public boolean isEnableBold() {
        return this.enableBold;
    }

    public CliWriter newLine() {
        try {
            reader.printNewline();
            return this;
        } catch (final IOException $ex) {
            throw new IllegalStateException($ex);
        }
    }

    
    public void setEnableBold(final boolean enableBold) {
        this.enableBold = enableBold;
    }

    public CliWriter setIndent(int indent) {
        this.indent = indent;
        return this;
    }

    @java.lang.Override
    
    public java.lang.String toString() {
        return "CliWriter(terminal=" + this.getTerminal() + ", reader=" + this.getReader() + ", enableBold="
                + this.isEnableBold() + ", indent=" + this.getIndent() + ")";
    }

    public CliWriter write(String message) {
        return write(message, Context.INFO);
    }

    public CliWriter write(String message, Context context) {
        try {
            String marker = "";
            if (indent == 0) {
                marker = "==> ";
            }
            if (indent > 0) {
                marker = "  > ";
            }
            if (indent >= 0) {
                message = Strings.repeat("  ", indent) + marker + message;
            }
            if (indent <= 0) {
                ANSIBuffer buffer = new ANSIBuffer();
                if (enableBold) {
                    buffer.bold(message);
                } else {
                    buffer.append(message);
                }
                message = buffer.toString();
            }
            switch (context) {
            case INFO:
                reader.printString(new ANSIBuffer().append(message).toString());
                break;
            case SUCCESS:
                reader.printString(new ANSIBuffer().green(message).toString());
                break;
            case FAILURE:
                reader.printString(new ANSIBuffer().red(message).toString());
                break;
            }
            reader.printNewline();
            return this;
        } catch (final IOException $ex) {
            throw new IllegalStateException($ex);
        }
    }

    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof CliWriter;
    }
}
