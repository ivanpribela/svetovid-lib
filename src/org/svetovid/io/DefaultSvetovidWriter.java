package org.svetovid.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

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
