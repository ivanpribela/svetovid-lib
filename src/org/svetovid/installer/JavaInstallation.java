package org.svetovid.installer;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class JavaInstallation {

    private Path location;
    private Path binLocation;
    private Path libLocation;

    private JavaInstallation() {
        this.location = null;
        String[] extdirs = System.getProperty("java.ext.dirs").split(File.pathSeparator);
        if (extdirs.length > 1) {
            libLocation = Paths.get(extdirs[1]);
        }
    }

    private JavaInstallation(Path location) {
        this.location = location;
        initialize();
    }

    private void initialize() {
        if (location == null) {
            return;
        }
        binLocation = libLocation = null;
        if (!Files.isDirectory(location)) {
            return;
        }
        binLocation = location.resolve("bin");
        if (!Files.isDirectory(binLocation)) {
            return;
        }
        libLocation = location.resolve("jre/lib/ext");
        if (!Files.isDirectory(libLocation)) {
            libLocation = location.resolve("lib/ext");
        }
        if (!Files.isDirectory(libLocation)) {
            return;
        }
    }

    public Path getLocation() {
        return location;
    }

    public Path getBinLocation() {
        return binLocation;
    }

    public Path getLibLocation() {
        return libLocation;
    }
}
