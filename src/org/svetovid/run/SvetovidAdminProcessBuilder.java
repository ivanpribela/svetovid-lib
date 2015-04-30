package org.svetovid.run;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.svetovid.io.SvetovidProcess;
import org.svetovid.util.CompoundList;
import org.svetovid.util.OperatingSystem;
import org.svetovid.util.OperatingSystemFamily;

public class SvetovidAdminProcessBuilder extends SvetovidProcessBuilder {

    private static final List<String> EXECUTABLE = new ArrayList<>(1);

    private CompoundList<String> wholeCommand = new CompoundList<>(EXECUTABLE, null);

    public SvetovidAdminProcessBuilder() {
        super();
        super.command(wholeCommand);
    }

    public SvetovidAdminProcessBuilder(List<String> command) {
        this();
        command(command);
    }

    public SvetovidAdminProcessBuilder(String... command) {
        this();
        command(command);
    }

    public SvetovidAdminProcessBuilder(Path directory) {
        super(directory);
        super.command(wholeCommand);
    }

    public SvetovidAdminProcessBuilder(Path directory, List<String> command) {
        this(directory);
        command(command);
    }

    public SvetovidAdminProcessBuilder(Path directory, String... command) {
        this(directory);
        command(command);
    }

    @Override
    public List<String> command() {
        return wholeCommand.getSublist(1);
    }

    @Override
    public SvetovidAdminProcessBuilder command(List<String> command) {
        wholeCommand.setSublist(1, command);
        return this;
    }

    @Override
    public SvetovidAdminProcessBuilder command(String... command) {
        List<String> list = new ArrayList<>(command.length);
        for (String arg : command) {
            list.add(arg);
        }
        return command(list);
    }

    public SvetovidAdminProcessBuilder command(SvetovidProcessBuilder builder) {
        wholeCommand.setSublist(1, builder.builder.command());
        return this;
    }

    @Override
    public SvetovidAdminProcessBuilder environment(String key, String value) {
        super.environment(key, value);
        return this;
    }

    @Override
    public SvetovidAdminProcessBuilder environmentRemove(String key) {
        super.environmentRemove(key);
        return this;
    }

    @Override
    public SvetovidAdminProcessBuilder directory(Path directory) {
        super.directory(directory);
        return this;
    }

    @Override
    public SvetovidAdminProcessBuilder redirectInput(Redirect source) {
        super.redirectInput(source);
        return this;
    }

    @Override
    public SvetovidAdminProcessBuilder redirectOutput(Redirect destination) {
        super.redirectOutput(destination);
        return this;
    }

    @Override
    public SvetovidAdminProcessBuilder redirectError(Redirect destination) {
        super.redirectError(destination);
        return this;
    }

    @Override
    public SvetovidAdminProcessBuilder redirectInput(Path file) {
        super.redirectInput(file);
        return this;
    }

    @Override
    public SvetovidAdminProcessBuilder redirectOutput(Path file) {
        super.redirectOutput(file);
        return this;
    }

    @Override
    public SvetovidAdminProcessBuilder redirectError(Path file) {
        super.redirectError(file);
        return this;
    }

    @Override
    public SvetovidAdminProcessBuilder inheritIO() {
        super.inheritIO();
        return this;
    }

    @Override
    public SvetovidAdminProcessBuilder redirectErrorStream(boolean redirectErrorStream) {
        super.redirectErrorStream(redirectErrorStream);
        return this;
    }
}
