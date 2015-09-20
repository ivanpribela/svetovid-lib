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

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.svetovid.io.SvetovidProcess;
import org.svetovid.util.CompoundList;

public class SvetovidJvmProcessBuilder extends SvetovidProcessBuilder {

    private List<String> executable = new ArrayList<>(1);
    {
        executable.add("java");
    }

    private List<String> classpath;
    private List<String> commandClasspath = new ArrayList<>();
    private List<String> extDirs;
    private List<String> commandExtDirs = new ArrayList<>();
    private List<String> endorsedDirs;
    private List<String> commandEndorsedDirs = new ArrayList<>();
    private List<String> libraryDirs;
    private List<String> commandLibraryDirs = new ArrayList<>();
    private Map<String, String> systemProperties = new HashMap<>();
    private List<String> commandSystemProperties = new ArrayList<>();
    private CompoundList<String> wholeCommand = new CompoundList<>(executable, commandClasspath, commandExtDirs, commandEndorsedDirs, commandLibraryDirs, commandSystemProperties, new ArrayList<>(), null);

    public SvetovidJvmProcessBuilder() {
        super();
        super.command(wholeCommand);
    }

    public SvetovidJvmProcessBuilder(List<String> command) {
        this();
        command(command);
    }

    public SvetovidJvmProcessBuilder(String... command) {
        this();
        command(command);
    }

    public SvetovidJvmProcessBuilder(Path directory) {
        super(directory);
        super.command(wholeCommand);
    }

    public SvetovidJvmProcessBuilder(Path directory, List<String> command) {
        this(directory);
        command(command);
    }

    public SvetovidJvmProcessBuilder(Path directory, String... command) {
        this(directory);
        command(command);
    }

    public List<String> classpath() {
        return classpath;
    }

    public SvetovidJvmProcessBuilder classpath(String classpathSegment) {
        this.classpath.add(classpathSegment);
        if (commandClasspath.size() == 0) {
            commandClasspath.add("-cp");
            commandClasspath.add(classpathSegment);
        } else {
            String cp = commandClasspath.get(1);
            cp = cp + File.pathSeparator + classpathSegment;
            commandClasspath.set(1, cp);
        }
        return this;
    }

    public SvetovidJvmProcessBuilder classpath(List<String> classpath) {
        this.classpath = classpath;
        commandClasspath.clear();
        if (classpath != null) {
            String cp = "";
            for (String classpathSegment : classpath) {
                cp = cp + File.pathSeparator + classpathSegment;
            }
            cp = cp.substring(File.pathSeparator.length());
            commandClasspath.add("-cp");
            commandClasspath.add(cp);
        }
        return this;
    }

    public SvetovidJvmProcessBuilder classpath(String... classpath) {
        List<String> list = new ArrayList<>(classpath.length);
        for (String arg : classpath) {
            list.add(arg);
        }
        return classpath(list);
    }

    public List<String> extDirs() {
        return extDirs;
    }

    public SvetovidJvmProcessBuilder extDirs(List<String> extDirs) {
        this.extDirs = extDirs;
        commandExtDirs.clear();
        if (extDirs != null) {
            String eds = "";
            for (String extDir : extDirs) {
                eds = eds + File.pathSeparator + extDir;
            }
            eds = eds.substring(File.pathSeparator.length());
            commandExtDirs.add("-Djava.ext.dirs=" + eds);
        }
        return this;
    }

    public SvetovidJvmProcessBuilder extDirs(String... extDirs) {
        List<String> list = new ArrayList<>(extDirs.length);
        for (String arg : extDirs) {
            list.add(arg);
        }
        return extDirs(list);
    }

    public List<String> endorsedDirs() {
        return endorsedDirs;
    }

    public SvetovidJvmProcessBuilder endorsedDirs(List<String> endorsedDirs) {
        this.endorsedDirs = endorsedDirs;
        commandEndorsedDirs.clear();
        if (endorsedDirs != null) {
            String eds = "";
            for (String extDir : endorsedDirs) {
                eds = eds + File.pathSeparator + extDir;
            }
            eds = eds.substring(File.pathSeparator.length());
            commandEndorsedDirs.add("-Djava.endorsed.dirs=" + eds);
        }
        return this;
    }

    public SvetovidJvmProcessBuilder endorsedDirs(String... endorsedDirs) {
        List<String> list = new ArrayList<>(endorsedDirs.length);
        for (String arg : endorsedDirs) {
            list.add(arg);
        }
        return endorsedDirs(list);
    }

    public List<String> libraryDirs() {
        return libraryDirs;
    }

    public SvetovidJvmProcessBuilder libraryDirs(List<String> libraryDirs) {
        this.libraryDirs = libraryDirs;
        commandLibraryDirs.clear();
        if (libraryDirs != null) {
            String lds = "";
            for (String extDir : libraryDirs) {
                lds = lds + File.pathSeparator + extDir;
            }
            lds = lds.substring(File.pathSeparator.length());
            commandLibraryDirs.add("-Djava.library.path=" + lds);
        }
        return this;
    }

    public SvetovidJvmProcessBuilder libraryDirs(String... libraryDirs) {
        List<String> list = new ArrayList<>(libraryDirs.length);
        for (String arg : libraryDirs) {
            list.add(arg);
        }
        return extDirs(list);
    }

    public Map<String, String> systemProperties() {
        return systemProperties;
    }

    public SvetovidJvmProcessBuilder systemProperties(String key, String value) {
        systemProperties.put(key, value);
        return this;
    }

    public SvetovidJvmProcessBuilder systemProperties(String key) {
        systemProperties.put(key, null);
        return this;
    }

    public SvetovidJvmProcessBuilder systemPropertiesRemove(String key) {
        systemProperties.remove(key);
        return this;
    }

    public List<String> jvmArguments() {
        return wholeCommand.getSublist(6);
    }

    public SvetovidJvmProcessBuilder jvmArguments(String argument) {
        jvmArguments().add(argument);
        return this;
    }

    public SvetovidJvmProcessBuilder jvmArguments(List<String> arguments) {
        wholeCommand.setSublist(6, arguments);
        return this;
    }

    public SvetovidJvmProcessBuilder jvmArguments(String... arguments) {
        List<String> list = new ArrayList<>(arguments.length);
        for (String arg : arguments) {
            list.add(arg);
        }
        return jvmArguments(list);
    }

    @Override
    public List<String> command() {
        return wholeCommand.getSublist(7);
    }

    @Override
    public SvetovidJvmProcessBuilder command(List<String> command) {
        wholeCommand.setSublist(7, command);
        return this;
    }

    @Override
    public SvetovidJvmProcessBuilder command(String... command) {
        List<String> list = new ArrayList<>(command.length);
        for (String arg : command) {
            list.add(arg);
        }
        return command(list);
    }

    @Override
    public SvetovidJvmProcessBuilder environment(String key, String value) {
        super.environment(key, value);
        return this;
    }

    @Override
    public SvetovidJvmProcessBuilder environmentRemove(String key) {
        super.environmentRemove(key);
        return this;
    }

    @Override
    public SvetovidJvmProcessBuilder directory(Path directory) {
        super.directory(directory);
        return this;
    }

    @Override
    public SvetovidJvmProcessBuilder redirectInput(Redirect source) {
        super.redirectInput(source);
        return this;
    }

    @Override
    public SvetovidJvmProcessBuilder redirectOutput(Redirect destination) {
        super.redirectOutput(destination);
        return this;
    }

    @Override
    public SvetovidJvmProcessBuilder redirectError(Redirect destination) {
        super.redirectError(destination);
        return this;
    }

    @Override
    public SvetovidJvmProcessBuilder redirectInput(Path file) {
        super.redirectInput(file);
        return this;
    }

    @Override
    public SvetovidJvmProcessBuilder redirectOutput(Path file) {
        super.redirectOutput(file);
        return this;
    }

    @Override
    public SvetovidJvmProcessBuilder redirectError(Path file) {
        super.redirectError(file);
        return this;
    }

    @Override
    public SvetovidJvmProcessBuilder inheritIO() {
        super.inheritIO();
        return this;
    }

    @Override
    public SvetovidJvmProcessBuilder redirectErrorStream(boolean redirectErrorStream) {
        super.redirectErrorStream(redirectErrorStream);
        return this;
    }

    @Override
    public SvetovidProcess start() throws IOException {
        commandSystemProperties.clear();
        for (Map.Entry<String, String> systemProperty : systemProperties.entrySet()) {
            if (systemProperty.getValue() == null) {
                commandSystemProperties.add("-D" + systemProperty.getKey());
            } else {
                commandSystemProperties.add("-D" + systemProperty.getKey() + "=" + systemProperty.getValue());
            }
        }
        return super.start();
    }
}
