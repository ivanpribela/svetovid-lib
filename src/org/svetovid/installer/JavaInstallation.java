package org.svetovid.installer;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class JavaInstallation implements Comparable<JavaInstallation> {

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

    @Override
    public int hashCode() {
        if (location == null) {
            return 0;
        }
        return location.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof JavaInstallation)) {
            return false;
        }
        Path thatLocation = ((JavaInstallation) obj).location;
        if (this.location == thatLocation) {
            return true;
        }
        if (this.location == null) {
            return false;
        }
        return this.location.equals(thatLocation);
    }

    @Override
    public int compareTo(JavaInstallation that) {
        if ((this.location == null) && (that.location == null)) {
            return 0;
        }
        if (this.location == null) {
            return -1;
        }
        if (that.location == null) {
            return 1;
        }
        return this.location.compareTo(that.location);
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
