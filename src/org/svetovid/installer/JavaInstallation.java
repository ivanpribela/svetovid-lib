package org.svetovid.installer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.svetovid.Svetovid;
import org.svetovid.io.SvetovidProcess;
import org.svetovid.run.SvetovidProcessBuilder;
import org.svetovid.util.Version;

public final class JavaInstallation implements Comparable<JavaInstallation> {

    public static final String LIB_FILE_NAME = "svetovid-lib.jar";

    private Path location;
    private Path binLocation;
    private Path libLocation;

    private String jdkVersion;
    private String jreVersion;
    private String libVersion;

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

    @Override
    public String toString() {
        if (location == null) {
            return "";
        }
        if (jdkVersion != null) {
            return "JDK " + jdkVersion;
        }
        if (jreVersion != null) {
            return "JRE " + jreVersion;
        }
        return "???";
    }

    private void initialize() {
        if (location == null) {
            return;
        }
        binLocation = libLocation = null;
        jdkVersion = jreVersion = libVersion = null;
        if (!Files.isDirectory(location)) {
            return;
        }
        binLocation = location.resolve("bin");
        if (!Files.isDirectory(binLocation)) {
            return;
        }
        Path binary = binLocation.resolve("javac");
        SvetovidProcess process = exec(binLocation, binary.toString(), "-version");
        if (process != null) {
            jdkVersion = process.err.readLine();
            jdkVersion = jdkVersion.substring(jdkVersion.indexOf(' ') + 1);
        }
        binary = binLocation.resolve("java");
        process = exec(binLocation, binary.toString(), "-version");
        if (process != null) {
            jreVersion = process.err.readLine();
            jreVersion = jreVersion.substring(jreVersion.indexOf('"') + 1, jreVersion.length() - 1);
        }
        libLocation = location.resolve("jre/lib/ext");
        if (!Files.isDirectory(libLocation)) {
            libLocation = location.resolve("lib/ext");
        }
        if (!Files.isDirectory(libLocation)) {
            return;
        }
        Path libFile = libLocation.resolve(LIB_FILE_NAME);
        if (!Files.isRegularFile(libFile)) {
            return;
        }
        try {
            ZipFile zip = new ZipFile(libFile.toString());
            try {
                ZipEntry entry = zip.getEntry("version.properties");
                if (entry != null) {
                    InputStream stream = zip.getInputStream(entry);
                    Properties properties = new Properties();
                    properties.load(stream);
                    libVersion = properties.getProperty("version");
                }
            } finally {
                zip.close();
            }
        } catch (ZipException e) {
            // Do nothing
        } catch (IOException e) {
            // Do Nothing
        }
    }

    protected static SvetovidProcess exec(String... command) {
        return exec(null, command);
    }

    protected static SvetovidProcess exec(Path directory, String... command) {
        SvetovidProcessBuilder builder = new SvetovidProcessBuilder(directory, command);
        try {
            return builder.start();
        } catch (IOException e) {
            return null;
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

    public String getJdkVersion() {
        return jdkVersion;
    }

    public String getJreVersion() {
        return jreVersion;
    }

    public String getLibVersion() {
        return libVersion;
    }

    public String getDetails() {
        String details = "";
        if (this == javaHomeInstallation) {
            details = details + " JAVA_HOME";
        }
        if (this == jreHomeInstallation) {
            details = details + " JRE_HOME";
        }
        if (this == pathInstallation) {
            details = details + " PATH";
        }
        if (!"".equals(details)) {
            details = details.substring(1);
        }
        return details;
    }

    public JavaInstallationType getType() {
        if (location == null) {
            return JavaInstallationType.ALL;
        }
        if (jdkVersion != null) {
            return JavaInstallationType.JDK;
        }
        if (jreVersion != null) {
            return JavaInstallationType.JRE;
        }
        return JavaInstallationType.UNKNOWN;
    }

    public JavaInstallationVersionType getVersionType() {
        if (libVersion == null) {
            return JavaInstallationVersionType.NONE;
        }
        Version current = Svetovid.getVersion();
        Version version = new Version(libVersion);
        int cmp = version.compareTo(current);
        if (cmp == 0) {
            return JavaInstallationVersionType.EQUAL;
        }
        if (cmp < 0) {
            return JavaInstallationVersionType.OLDER;
        } else {
            return JavaInstallationVersionType.NEWER;
        }
    }

    public void refresh() {
        initialize();
    }

    private static Map<String, JavaInstallation> map = new HashMap<>();
    private static JavaInstallation defaultInstallation = new JavaInstallation();
    private static JavaInstallation javaHomeInstallation = null;
    private static JavaInstallation jreHomeInstallation = null;
    private static JavaInstallation pathInstallation = null;

    private static JavaInstallation createJavaInstallation(String path) {
        Path location = Paths.get(path);
        return createJavaInstallation(location);
    }

    private static JavaInstallation createJavaInstallation(Path location) {
        String path = location.normalize().toString();
        JavaInstallation installation = map.get(path);
        if (installation == null) {
            installation = new JavaInstallation(location);
            map.put(path, installation);
        }
        return installation;
    }

    public static JavaInstallation getDefault() {
        return defaultInstallation;
    }

    public static void getFromEnvironment(Collector<JavaInstallation> collector) {
        String javaHome = "JAVA_HOME";
        String jreHome = "JRE_HOME";
        javaHome = System.getenv(javaHome);
        if (javaHome != null) {
            javaHomeInstallation = createJavaInstallation(javaHome);
            collector.collect(javaHomeInstallation);
        } else {
            javaHomeInstallation = null;
        }
        jreHome = System.getenv(jreHome);
        if (jreHome != null) {
            jreHomeInstallation = createJavaInstallation(jreHome);
            collector.collect(jreHomeInstallation);
        } else {
            jreHomeInstallation = null;
        }
    }

    public static void getFromPath(Collector<JavaInstallation> collector) {
        String path = "PATH";
        path = System.getenv(path);
        if (path != null) {
            String[] paths = path.split(File.pathSeparator);
            boolean first = true;
            for (String p : paths) {
                Path dir = Paths.get(p);
                if (testForJava(dir)) {
                    JavaInstallation installation = createJavaInstallation(dir.getParent());
                    if (first) {
                        pathInstallation = installation;
                    }
                    collector.collect(installation);
                    first = false;
                }
            }
        }
    }

    public static void getFromRegistry(Collector<JavaInstallation> collector) {
        String regKeyName = "HKEY_LOCAL_MACHINE\\Software\\JavaSoft\\";
        String regKeyName32 = "HKEY_LOCAL_MACHINE\\Software\\Wow6432Node\\JavaSoft\\";
        queryRegistry(regKeyName, collector);
        queryRegistry(regKeyName32, collector);
    }

    private static void queryRegistry(String rootKeyName, Collector<JavaInstallation> collector) {
        String regValueName = "JavaHome";
        String regValueType = "REG_SZ";
        SvetovidProcess process = exec("reg", "query", rootKeyName, "/s");
        if (process != null) {
            String line = process.out.readLine();
            while (line != null) {
                int index = line.indexOf(regValueName);
                if (index != -1) {
                    line = line.substring(index + regValueName.length()).trim();
                    index = line.indexOf(regValueType);
                    if (index != -1) {
                        line = line.substring(index + regValueType.length()).trim();
                        JavaInstallation installation = createJavaInstallation(line);
                        collector.collect(installation);
                    }
                }
                line = process.out.readLine();
            }
        }
    }

    public static void getFromFilesystem(Collector<JavaInstallation> installationCollector, Collector<Path> pathCollector) {
        Iterable<Path> roots = FileSystems.getDefault().getRootDirectories();
        for (Path root : roots) {
            getFromFilesystemRecursive(root, installationCollector, pathCollector);
        }
    }

    public static void getFromFilesystem(Path root, Collector<JavaInstallation> installationCollector, Collector<Path> pathCollector) {
        if (Files.isDirectory(root)) {
            getFromFilesystemRecursive(root, installationCollector, pathCollector);
        }
    }

    private static void getFromFilesystemRecursive(Path dir, Collector<JavaInstallation> installationCollector, Collector<Path> pathCollector) {
        try {
            Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    Objects.requireNonNull(dir);
                    Objects.requireNonNull(attrs);
                    if (testForJava(dir)) {
                        JavaInstallation installation = createJavaInstallation(dir.getParent());
                        installationCollector.collect(installation);
                    }
                    if (pathCollector != null) {
                        pathCollector.collect(dir);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            // Do nothing
        }
    }

    public static JavaInstallation getFromPath(String path) {
        JavaInstallation installation = createJavaInstallation(path);
        return installation;
    }

    private static boolean testForJava(Path dir) {
        if (!dir.endsWith("bin")) {
            return false;
        }
        if (Files.isRegularFile(dir.resolve("java"))) {
            return true;
        }
        if (Files.isRegularFile(dir.resolve("java.exe"))) {
            return true;
        }
        if (Files.isRegularFile(dir.resolve("javac"))) {
            return true;
        }
        if (Files.isRegularFile(dir.resolve("javac.exe"))) {
            return true;
        }
        return false;
    }

    public static void getFromAll(Collector<JavaInstallation> collector) {
        getFromEnvironment(collector);
        getFromPath(collector);
        getFromRegistry(collector);
        // TODO getFromRPM(collector);
        // TODO getFromAptGet(collector);
    }
}
