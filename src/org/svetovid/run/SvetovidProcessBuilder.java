/*
 * Copyright 2015 Ivan Pribela
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.svetovid.run;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.svetovid.io.SvetovidProcess;

public class SvetovidProcessBuilder {

    protected ProcessBuilder builder;

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

    public List<String> effectiveCommand() {
        List<String> cmd = builder.command();
        cmd = new ArrayList<>(cmd);
        return cmd;
    }

    public SvetovidProcess start() throws IOException {
        Process process = builder.start();
        return new SvetovidProcess(process);
    }
}
