package org.svetovid.util;

public class Version implements Comparable<Version> {

    private String major;
    private String minor;
    private String micro;
    private String prerelease;
    private String build;

    public Version(String versionString) {
        parse(versionString);
    }

    private void parse(String string) {

        // Check for null
        if (string == null) {
            throw new IllegalArgumentException();
        }

        // Init
        int index;
        String part;

        // Remove leading 'v' if present
        if (string.startsWith("v")) {
            string = string.substring(1);
        }

        // Build
        index = string.indexOf('+');
        if (index != -1) {
            build = string.substring(index + 1);
            string = string.substring(0, index);
        } else {
            build = "";
        }

        // Prerelease
        index = string.indexOf('-');
        if (index != -1) {
            prerelease = string.substring(index + 1);
            string = string.substring(0, index);
        } else {
            prerelease = "";
        }

        // Major
        index = string.indexOf('.');
        if (index != -1) {
            part = string.substring(0, index);
            string = string.substring(index + 1);
        } else {
            part = string;
            string = "";
        }
        if (part.isEmpty()) {
            major = "0";
        } else {
            major = part;
        }

        // Minor
        index = string.indexOf('.');
        if (index != -1) {
            part = string.substring(0, index);
            string = string.substring(index + 1);
        } else {
            part = string;
            string = "";
        }
        if (part.isEmpty()) {
            minor = "0";
        } else {
            minor = part;
        }

        // Patch
        if (string.isEmpty()) {
            micro = "0";
        } else {
            micro = string;
        }
    }

    public String getMajor() {
        return major;
    }

    public String getMinor() {
        return minor;
    }

    public String getMicro() {
        return micro;
    }

    public String getPrerelease() {
        return prerelease;
    }

    public String getBuild() {
        return build;
    }

    @Override
    public String toString() {
        String string = major + "." + minor + "." + micro;
        if (!"".equals(prerelease)) {
            string = string + "-" + prerelease;
        }
        if (!"".equals(build)) {
            string = string + "+" + build;
        }
        return string;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Version)) {
            return false;
        }
        return compareTo((Version) obj) == 0;
    }

    @Override
    public int compareTo(Version that) {
        int result = comparePart(this.major, that.major);
        if (result == 0) {
            result = 2 * comparePart(this.minor, that.minor);
        }
        if (result == 0) {
            result = 3 * comparePart(this.micro, that.micro);
        }
        if (result == 0) {
            if (this.prerelease.isEmpty() && that.prerelease.isEmpty()) {
                result = 0;
            } else if (this.prerelease.isEmpty()) {
                result = 4;
            } else if (that.prerelease.isEmpty()) {
                result = -4;
            } else {
                String[] thisIdents = this.prerelease.split("\\.");
                String[] thatIdents = that.prerelease.split("\\.");
                int count = Math.min(thisIdents.length, thatIdents.length);
                for (int i = 0; i < count; i++) {
                    result = (i + 4) * comparePart(thisIdents[i], thatIdents[i]);
                    if (result != 0) {
                        break;
                    }
                }
                if (result == 0) {
                    if (count < thisIdents.length) {
                        result = count + 4;
                    } else if (count < thatIdents.length) {
                        result = -count - 4;
                    }
                }
            }
        }
        return result;
    }

    protected int comparePart(String a, String b) {
        boolean aEmpty = (a == null) || a.isEmpty();
        boolean bEmpty = (b == null) || b.isEmpty();
        if (aEmpty && bEmpty) {
            return 0;
        }
        if (aEmpty) {
            return 1;
        }
        if (bEmpty) {
            return -1;
        }
        Integer aValue = aEmpty ? null : getPartValue(a);
        Integer bValue = bEmpty ? null : getPartValue(b);
        if (aValue == null && bValue == null) {
            return a.compareTo(b);
        }
        if (aValue == null) {
            return 1;
        }
        if (bValue == null) {
            return -1;
        }
        return Integer.compare(aValue, bValue);
    }

    protected Integer getPartValue(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
