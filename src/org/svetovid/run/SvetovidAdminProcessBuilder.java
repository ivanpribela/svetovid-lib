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

import org.svetovid.io.SvetovidProcess;
import org.svetovid.util.CompoundList;
import org.svetovid.util.OperatingSystem;
import org.svetovid.util.OperatingSystemFamily;

public class SvetovidAdminProcessBuilder extends SvetovidProcessBuilder {

    private static final List<String> EXECUTABLE = new ArrayList<>(1);
    static {
        if (OperatingSystem.CURRENT.getFamily() == OperatingSystemFamily.WINDOWS) {
            EXECUTABLE.add("elevate"); // Relies on elevate.exe being installed
        } else {
            EXECUTABLE.add("sudo"); // Relies on sudo being installed
        }
    }

    private static Boolean isAdmin = null;

    public static Boolean isAdmin() {
        if (isAdmin != null) {
            return isAdmin;
        }
        SvetovidTerminalProcessBuilder builder = new SvetovidTerminalProcessBuilder();
        if (OperatingSystem.CURRENT.getFamily() == OperatingSystemFamily.WINDOWS) {
            builder.command("NET FILE");
        } else {
            builder.command("if [[ $EUID -ne 0 ]]; then exit 1; fi");
        }
        try {
            SvetovidProcess process = builder.start();
            int code = process.waitFor();
            isAdmin = code == 0;
        } catch (IOException e) {
            isAdmin = null;
        } catch (InterruptedException e) {
            isAdmin = null;
        }
        return isAdmin;
    }

    private CompoundList<String> wholeCommand = new CompoundList<String>(EXECUTABLE, null);

    private void fixCommandIfAdmin() {
        if (isAdmin()) {
            wholeCommand.setSublist(0, null);
        } else {
            wholeCommand.setSublist(0, EXECUTABLE);
        }
    }

    public SvetovidAdminProcessBuilder() {
        super();
        fixCommandIfAdmin();
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
        fixCommandIfAdmin();
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

    @Override
    public SvetovidProcess start() throws IOException {
        fixCommandIfAdmin();
        return super.start();
    }
}
