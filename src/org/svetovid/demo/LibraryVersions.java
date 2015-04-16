package org.svetovid.demo;

import org.svetovid.Svetovid;
import org.svetovid.util.JsonHelper;

public class LibraryVersions {

    public static void main(String[] args) {

        // Get release info from GitHub
        String uri = "https://api.github.com/repos/ivanpribela/svetovid-lib/releases";
        Object data = Svetovid.in(uri).readObject();
        Svetovid.err.printObject(data);

    }
}
