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

package org.svetovid.demo;

import org.svetovid.Svetovid;
import org.svetovid.util.JsonHelper;

public class LibraryVersions {

    public static void main(String[] args) {

        // Get release info from GitHub
        String uri = "https://api.github.com/repos/ivanpribela/svetovid-lib/releases";
        Object data = Svetovid.in(uri).readObject();

        // Print
        String libraryName = "Svetovid library";
        Svetovid.out.println(libraryName);
        Svetovid.out.println(libraryName.replaceAll(".", "="));
        Svetovid.out.println();

        // Print available versions
        for (Object version : JsonHelper.getArray(data, ".")) {

            // Extract the data
            String name = JsonHelper.getString(version, "name");
            String url =  JsonHelper.getString(version, "html_url");

            // Print the information
            Svetovid.out.println(name);
            Svetovid.out.println(name.replaceAll(".", "-"));
            Svetovid.out.println("URL:", url);

            // Print available files
            for (Object asset : JsonHelper.getArray(version, "assets")) {
                String file = JsonHelper.getString(asset, "name");
                String download = JsonHelper.getString(asset, "browser_download_url");
                Svetovid.out.println("(" + file + ")\t" + download);
            }
            Svetovid.out.println();

        }

    }
}
