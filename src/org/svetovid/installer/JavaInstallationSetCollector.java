package org.svetovid.installer;

import java.util.Set;
import java.util.TreeSet;

public class JavaInstallationSetCollector implements Collector<JavaInstallation> {

    private Set<JavaInstallation> set = new TreeSet<>();

    @Override
    public void collect(JavaInstallation installation) {
        set.add(installation);
    }

    public Set<JavaInstallation> getCollected() {
        return set;
    }
}
