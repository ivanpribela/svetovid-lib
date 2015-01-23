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

package org.svetovid.io;

import java.io.IOException;
import java.io.InputStream;

public class StandardInputStreamProxy extends InputStream {

    public int read() throws IOException {
        return System.in.read();
    }

    public int read(byte[] b) throws IOException {
        return System.in.read(b);
    }

    public int read(byte[] b, int off, int len) throws IOException {
        return System.in.read(b, off, len);
    }

    public long skip(long n) throws IOException {
        return System.in.skip(n);
    }

    public int available() throws IOException {
        return System.in.available();
    }

    public boolean markSupported() {
        return System.in.markSupported();
    }

    public void mark(int readlimit) {
        System.in.mark(readlimit);
    }

    public void reset() throws IOException {
        System.in.reset();
    }

    public void close() throws IOException {
        System.in.close();
    }

    public String toString() {
        return System.in.toString();
    }

    public int hashCode() {
        return System.in.hashCode();
    }

    public boolean equals(Object obj) {
        return (obj != null) && (getClass().equals(obj.getClass()));
    }
}
