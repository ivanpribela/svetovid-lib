package org.svetovid.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.svetovid.Svetovid;

public class DefaultSvetovidReader extends AbstractSvetovidReader {

    protected BufferedReader reader;

    public DefaultSvetovidReader(InputStream in) {
        try {
            reader = new BufferedReader(new InputStreamReader(in, Svetovid.CHARSET_NAME));
        } catch (UnsupportedEncodingException e) {
            reader = new BufferedReader(new InputStreamReader(in));
        }
    }

    @Override
    public void close() {
        super.close();
        try {
            reader.close();
            exception = null;
        } catch (IOException e) {
            exception = e;
        }
    }

    @Override
    protected String doReadLine() throws IOException {
        return reader.readLine();
    }
}
