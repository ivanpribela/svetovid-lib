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

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.svetovid.Svetovid;

public class DefaultSvetovidWriter extends AbstractSvetovidWriter {

    protected BufferedWriter writer;

    public DefaultSvetovidWriter(OutputStream out) {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(out, Svetovid.CHARSET_NAME));
        } catch (UnsupportedEncodingException e) {
            writer = new BufferedWriter(new OutputStreamWriter(out));
        }
    }

    @Override
    public void close() {
        super.close();
        try {
            writer.flush();
        } catch (IOException e) {
            // Do nothing
        }
        try {
            writer.close();
        } catch (IOException e) {
            // Do nothing
        }
    }

    @Override
    public void doWrite(String value) throws IOException {
        if (value == null) {
            value = "null";
        }
        writer.write(value, 0, value.length());
    }

    @Override
    public void doFlush() throws IOException {
        writer.flush();
    }

    @Override
    public void doWriteln(String value) throws IOException {
        doWrite(value);
        writer.newLine();
    }
}
