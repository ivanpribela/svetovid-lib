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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import org.svetovid.Svetovid;

/**
 * This class provides a most commonly used implementation for the
 * SvetovidReader interface.
 *
 * @author Ivan Pribela
 *
 * @see AbstractSvetovidReader
 * @see SvetovidReader
 */
public class DefaultSvetovidReader extends AbstractSvetovidReader {

    protected BufferedReader reader;

    /**
     * Creates a new {@link SvetovidReader} that uses the specified reader for
     * input.
     *
     * @param in
     *            the reader to use for input
     */
    public DefaultSvetovidReader(BufferedReader in) {
        if (in == null) {
            throw new IllegalArgumentException("in");
        }
        reader = in;
    }

    /**
     * Creates a new {@link SvetovidReader} that uses the specified reader for
     * input.
     *
     * @param in
     *            the reader to use for input
     */
    public DefaultSvetovidReader(Reader in) {
        reader = new BufferedReader(in);
    }

    /**
     * Creates a new {@link SvetovidReader} that uses the specified input stream
     * for input.
     *
     * @param in
     *            the input stream to use for input
     */
    public DefaultSvetovidReader(InputStream in) {
        try {
            reader = new BufferedReader(new InputStreamReader(in, Svetovid.CHARSET_NAME));
        } catch (UnsupportedEncodingException e) {
            reader = new BufferedReader(new InputStreamReader(in));
        }
    }

    /**
     * Creates a new {@link SvetovidReader} that uses the specified string for
     * input.
     *
     * @param in
     *            the string to use for input
     */
    public DefaultSvetovidReader(String in) {
        reader = new BufferedReader(new StringReader(in));
    }

    @Override
    public void close() throws SvetovidIOException {
        super.close();
        try {
            reader.close();
            lastException = null;
        } catch (IOException e) {
            wrapUpIOException(e);
        }
    }

    @Override
    protected String doReadLine() throws IOException {
        return reader.readLine();
    }
}
