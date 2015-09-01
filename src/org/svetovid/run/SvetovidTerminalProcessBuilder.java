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

import java.lang.ProcessBuilder.Redirect;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.svetovid.util.CompoundList;
import org.svetovid.util.OperatingSystem;
import org.svetovid.util.OperatingSystemFamily;

public class SvetovidTerminalProcessBuilder extends SvetovidProcessBuilder {

    private static final List<String> SHELL = new ArrayList<>(2);
    static {
        if (OperatingSystem.CURRENT.getFamily() == OperatingSystemFamily.WINDOWS) {
            SHELL.add(System.getenv("ComSpec"));
            SHELL.add("/C");
        } else {
            SHELL.add("sh");
            SHELL.add("-c");
        }
    }

    private CompoundList<String> wholeCommand = new CompoundList<>(SHELL, null);

    public SvetovidTerminalProcessBuilder() {
        super();
        super.command(wholeCommand);
    }

    public SvetovidTerminalProcessBuilder(List<String> command) {
        this();
        command(command);
    }

    public SvetovidTerminalProcessBuilder(String... command) {
        this();
        command(command);
    }

    public SvetovidTerminalProcessBuilder(Path directory) {
        super(directory);
        super.command(wholeCommand);
    }

    public SvetovidTerminalProcessBuilder(Path directory, List<String> command) {
        this(directory);
        command(command);
    }

    public SvetovidTerminalProcessBuilder(Path directory, String... command) {
        this(directory);
        command(command);
    }

    @Override
    public List<String> command() {
        return wholeCommand.getSublist(1);
    }

    @Override
    public SvetovidTerminalProcessBuilder command(List<String> command) {
        wholeCommand.setSublist(1, command);
        return this;
    }

    @Override
    public SvetovidTerminalProcessBuilder command(String... command) {
        List<String> list = new ArrayList<>(command.length);
        for (String arg : command) {
            list.add(arg);
        }
        return command(list);
    }

    @Override
    public SvetovidTerminalProcessBuilder environment(String key, String value) {
        super.environment(key, value);
        return this;
    }

    @Override
    public SvetovidTerminalProcessBuilder environmentRemove(String key) {
        super.environmentRemove(key);
        return this;
    }

    @Override
    public SvetovidTerminalProcessBuilder directory(Path directory) {
        super.directory(directory);
        return this;
    }

    @Override
    public SvetovidTerminalProcessBuilder redirectInput(Redirect source) {
        super.redirectInput(source);
        return this;
    }

    @Override
    public SvetovidTerminalProcessBuilder redirectOutput(Redirect destination) {
        super.redirectOutput(destination);
        return this;
    }

    @Override
    public SvetovidTerminalProcessBuilder redirectError(Redirect destination) {
        super.redirectError(destination);
        return this;
    }

    @Override
    public SvetovidTerminalProcessBuilder redirectInput(Path file) {
        super.redirectInput(file);
        return this;
    }

    @Override
    public SvetovidTerminalProcessBuilder redirectOutput(Path file) {
        super.redirectOutput(file);
        return this;
    }

    @Override
    public SvetovidTerminalProcessBuilder redirectError(Path file) {
        super.redirectError(file);
        return this;
    }

    @Override
    public SvetovidTerminalProcessBuilder inheritIO() {
        super.inheritIO();
        return this;
    }

    @Override
    public SvetovidTerminalProcessBuilder redirectErrorStream(boolean redirectErrorStream) {
        super.redirectErrorStream(redirectErrorStream);
        return this;
    }
}
