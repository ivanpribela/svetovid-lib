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

package org.svetovid.util;

import java.net.URL;

public class Release implements Comparable<Release> {

    private Version version;
    private URL url;

    public Release(Version version, URL url) {
        if (version == null) {
            throw new IllegalArgumentException("version");
        }
        this.version = version;
        if (url == null) {
            throw new IllegalArgumentException("url");
        }
        this.url = url;
    }

    public Version getVersion() {
        return version;
    }

    public URL getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return version + " [" + url + "]";
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
        if (!(obj instanceof Release)) {
            return false;
        }
        return compareTo((Release) obj) == 0;
    }

    @Override
    public int compareTo(Release that) {
        int result = this.version.compareTo(that.version);
        if (result == 0) {
            result = 2 * this.url.toString().compareTo(that.url.toString());
        }
        return result;
    }
}
