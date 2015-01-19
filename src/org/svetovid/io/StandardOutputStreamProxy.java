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
import java.io.OutputStream;

public class StandardOutputStreamProxy extends OutputStream {

    public void write(int b) throws IOException {
        System.out.write(b);
    }

    public void write(byte[] b) throws IOException {
        System.out.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        System.out.write(b, off, len);
    }

    public void flush() throws IOException {
        System.out.flush();
    }

    public void close() throws IOException {
        System.out.close();
    }

    public String toString() {
        return System.out.toString();
    }

    public int hashCode() {
        return System.out.hashCode();
    }

    public boolean equals(Object obj) {
        return (obj != null) && (getClass().equals(obj.getClass()));
    }
}
