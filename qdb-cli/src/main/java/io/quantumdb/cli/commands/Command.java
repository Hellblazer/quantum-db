// Generated by delombok at Thu Mar 11 18:53:10 PST 2021
package io.quantumdb.cli.commands;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Supplier;
import io.quantumdb.cli.utils.CliException;
import io.quantumdb.cli.utils.CliWriter;
import io.quantumdb.cli.utils.CliWriter.Context;
import io.quantumdb.cli.xml.ChangelogLoader;
import io.quantumdb.core.backends.Backend;
import io.quantumdb.core.versioning.ChangeSet;
import io.quantumdb.core.versioning.RefLog;
import io.quantumdb.core.versioning.State;
import io.quantumdb.core.versioning.Version;

public abstract class Command {
    public static class Identifier implements Comparable<Identifier> {
        private final String command;
        private final String description;

        
        public Identifier(final String command, final String description) {
            this.command = command;
            this.description = description;
        }

        @Override
        public int compareTo(Identifier o) {
            return command.compareTo(o.command);
        }

        @java.lang.Override
        
        public boolean equals(final java.lang.Object o) {
            if (o == this)
                return true;
            if (!(o instanceof Command.Identifier))
                return false;
            final Command.Identifier other = (Command.Identifier) o;
            if (!other.canEqual(this))
                return false;
            final java.lang.Object this$command = this.getCommand();
            final java.lang.Object other$command = other.getCommand();
            if (this$command == null ? other$command != null : !this$command.equals(other$command))
                return false;
            final java.lang.Object this$description = this.getDescription();
            final java.lang.Object other$description = other.getDescription();
            if (this$description == null ? other$description != null : !this$description.equals(other$description))
                return false;
            return true;
        }

        
        public String getCommand() {
            return this.command;
        }

        
        public String getDescription() {
            return this.description;
        }

        @java.lang.Override
        
        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final java.lang.Object $command = this.getCommand();
            result = result * PRIME + ($command == null ? 43 : $command.hashCode());
            final java.lang.Object $description = this.getDescription();
            result = result * PRIME + ($description == null ? 43 : $description.hashCode());
            return result;
        }

        @java.lang.Override
        
        public java.lang.String toString() {
            return "Command.Identifier(command=" + this.getCommand() + ", description=" + this.getDescription() + ")";
        }

        
        protected boolean canEqual(final java.lang.Object other) {
            return other instanceof Command.Identifier;
        }
    }

    
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Command.class);

    public abstract Identifier getIdentifier();

    public abstract void perform(CliWriter writer, List<String> arguments) throws IOException;

    <T> T getArgument(List<String> arguments, String key, Class<T> type) {
        return getArgument(arguments, key, type, () -> {
            throw new IllegalArgumentException("You must specify a value for \"" + key + "\"");
        });
    }

    @SuppressWarnings("unchecked")
    <T> T getArgument(List<String> arguments, String key, Class<T> type, Supplier<T> defaultValue) {
        String prefix = "--" + key + "=";
        String boolKey = "--" + key;
        for (int i = 0; i < arguments.size(); i++) {
            String argument = arguments.get(i);
            if (argument.startsWith(prefix)) {
                arguments.remove(i);
                String value = argument.substring(prefix.length());
                if (type.equals(int.class) || Integer.class.isAssignableFrom(type)) {
                    return (T) (Integer) Integer.parseInt(value);
                } else if (type.equals(long.class) || Long.class.isAssignableFrom(type)) {
                    return (T) (Long) Long.parseLong(value);
                } else if (type.equals(double.class) || Double.class.isAssignableFrom(type)) {
                    return (T) (Double) Double.parseDouble(value);
                } else if (type.equals(float.class) || Float.class.isAssignableFrom(type)) {
                    return (T) (Float) Float.parseFloat(value);
                } else if (type.equals(boolean.class) || Boolean.class.isAssignableFrom(type)) {
                    return (T) (Boolean) Boolean.parseBoolean(value);
                } else {
                    return (T) value;
                }
            } else if (argument.equals(boolKey)) {
                arguments.remove(i);
                if (type.equals(boolean.class) || Boolean.class.isAssignableFrom(type)) {
                    return (T) (Boolean) true;
                }
            }
        }
        if (defaultValue == null) {
            return null;
        }
        return defaultValue.get();
    }

    State loadState(Backend backend) {
        try {
            State state = backend.loadState();
            if (new File("changelog.xml").exists()) {
                new ChangelogLoader().load(state.getChangelog(), "changelog.xml");
            }
            return state;
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
            throw new CliException("Could not connect to the database.", e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new CliException("Could not read from changelog.xml file.", e);
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            throw new CliException(e.getMessage());
        }
    }

    void persistChanges(Backend backend, State state) {
        try {
            backend.persistState(state);
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
            throw new CliException("Could not initialize the database.", e);
        }
    }

    void writeDatabaseState(CliWriter writer, RefLog refLog, io.quantumdb.core.versioning.Changelog changelog) {
        writer.write("Database is operating at version(s):", Context.SUCCESS);
        writer.indent(1);
        for (Version version : refLog.getVersions()) {
            ChangeSet changeSet = version.getChangeSet();
            writer.write(version.getId() + ": " + changeSet.getDescription(), Context.SUCCESS);
        }
        if (refLog.getVersions().isEmpty()) {
            Version version = changelog.getRoot();
            ChangeSet changeSet = version.getChangeSet();
            writer.write(version.getId() + ": " + changeSet.getDescription(), Context.SUCCESS);
        }
        writer.indent(-1);
        writer.newLine();
    }
}
