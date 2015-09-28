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
import java.io.Writer;

import org.svetovid.Svetovid;

/**
 * This class provides a most commonly used implementation for the
 * SvetovidWriter interface.
 *
 * @author Ivan Pribela
 *
 * @see AbstractSvetovidWriter
 * @see SvetovidWriter
 */
public class DefaultSvetovidWriter extends AbstractSvetovidWriter {

    protected BufferedWriter writer;

    /**
     * Creates a new {@link SvetovidWriter} that outputs to the specified
     * writer.
     *
     * @param out
     *            the writer to use for output
     */
    public DefaultSvetovidWriter(BufferedWriter out) {
        if (out == null) {
            throw new IllegalArgumentException("out");
        }
        writer = out;
    }

    /**
     * Creates a new {@link SvetovidWriter} that outputs to the specified
     * writer.
     *
     * @param out
     *            the writer to use for output
     */
    public DefaultSvetovidWriter(Writer out) {
        writer = new BufferedWriter(out);
    }

    /**
     * Creates a new {@link SvetovidWriter} that outputs to the specified output
     * stream.
     *
     * @param out
     *            the output stream to use for output
     */
    public DefaultSvetovidWriter(OutputStream out) {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(out, Svetovid.CHARSET_NAME));
        } catch (UnsupportedEncodingException e) {
            writer = new BufferedWriter(new OutputStreamWriter(out));
        }
    }

    @Override
    public void close() throws SvetovidIOException {
        super.close();
        try {
            writer.flush();
        } catch (IOException e) {
            wrapUpIOException(e);
        }
        try {
            writer.close();
        } catch (IOException e) {
            wrapUpIOException(e);
        }
    }

    @Override
    public void doPrint(String value) throws IOException {
        if (value == null) {
            value = Svetovid.NULL_STRING;
        }
        writer.write(value, 0, value.length());
    }

    @Override
    public void doFlush() throws IOException {
        writer.flush();
    }

    @Override
    public void doPrintln(String value) throws IOException {
        doPrint(value);
        writer.newLine();
    }
}
