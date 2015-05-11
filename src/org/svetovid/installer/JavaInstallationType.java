package org.svetovid.installer;

public enum JavaInstallationType {

    /**
     * Java Development Kit installation.
     */
    JDK,

    /**
     * Java Runtime Environment installation.
     */
    JRE,

    /**
     * Unknown Java installation.
     */
    UNKNOWN,

    /**
     * Synthetic, represents all Java Installations on the machine
     */
    ALL;
}
