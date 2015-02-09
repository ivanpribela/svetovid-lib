package org.svetovid.run;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import org.svetovid.io.SvetovidProcess;

public class SvetovidProcessBuilder {

    private ProcessBuilder builder;

    public SvetovidProcessBuilder() {
        builder = new ProcessBuilder();
    }

    public SvetovidProcessBuilder(List<String> command) {
        builder = new ProcessBuilder(command);
    }

    public SvetovidProcessBuilder(String... command) {
        builder = new ProcessBuilder(command);
    }

    public SvetovidProcessBuilder(Path directory) {
        this();
        directory(directory);
    }

    public SvetovidProcessBuilder(Path directory, List<String> command) {
        this(command);
        directory(directory);
    }

    public SvetovidProcessBuilder(Path directory, String... command) {
        this(command);
        directory(directory);
    }

    public List<String> command() {
        return builder.command();
    }

    public SvetovidProcessBuilder command(List<String> command) {
        builder.command(command);
        return this;
    }

    public SvetovidProcessBuilder command(String... command) {
        builder.command(command);
        return this;
    }

    public Map<String, String> environment() {
        return builder.environment();
    }

    public SvetovidProcessBuilder environment(String key, String value) {
        builder.environment().put(key, value);
        return this;
    }

    public SvetovidProcessBuilder environmentRemove(String key) {
        builder.environment().remove(key);
        return this;
    }

    public Path directory() {
        return builder.directory().toPath();
    }

    public SvetovidProcessBuilder directory(Path directory) {
        builder.directory(directory == null ? null : directory.toFile());
        return this;
    }

    public Redirect redirectInput() {
        return builder.redirectInput();
    }

    public Redirect redirectOutput() {
        return builder.redirectOutput();
    }

    public Redirect redirectError() {
        return builder.redirectError();
    }

    public SvetovidProcessBuilder redirectInput(Redirect source) {
        builder.redirectInput(source);
        return this;
    }

    public SvetovidProcessBuilder redirectOutput(Redirect destination) {
        builder.redirectOutput(destination);
        return this;
    }

    public SvetovidProcessBuilder redirectError(Redirect destination) {
        builder.redirectError(destination);
        return this;
    }

    public SvetovidProcessBuilder redirectInput(Path file) {
        builder.redirectInput(file.toFile());
        return this;
    }

    public SvetovidProcessBuilder redirectOutput(Path file) {
        builder.redirectOutput(file.toFile());
        return this;
    }

    public SvetovidProcessBuilder redirectError(Path file) {
        builder.redirectError(file.toFile());
        return this;
    }

    public SvetovidProcessBuilder inheritIO() {
        builder.inheritIO();
        return this;
    }

    public boolean redirectErrorStream() {
        return builder.redirectErrorStream();
    }

    public SvetovidProcessBuilder redirectErrorStream(boolean redirectErrorStream) {
        builder.redirectErrorStream(redirectErrorStream);
        return this;
    }

    public SvetovidProcess start() throws IOException {
        Process process = builder.start();
        return new SvetovidProcess(process);
    }
}
