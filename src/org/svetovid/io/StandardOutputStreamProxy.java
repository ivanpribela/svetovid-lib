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

/**
 * Instances of this class serve as proxies for the currently set-up standard
 * output stream (see {@link System#out}). If the standard output stream changes
 * (through {@link System#setOut(java.io.PrintStream)}) instances of this class
 * will forward the output to the new stream.
 *
 * <p>
 * All instances of this class are considered equal.
 *
 * @author Ivan Pribela
 *
 * @see System#out
 */
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
