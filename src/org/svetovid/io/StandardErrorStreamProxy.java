package org.svetovid.io;

import java.io.IOException;
import java.io.OutputStream;

public class StandardErrorStreamProxy extends OutputStream {

    public void write(int b) throws IOException {
        System.err.write(b);
    }

    public void write(byte[] b) throws IOException {
        System.err.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        System.err.write(b, off, len);
    }

    public void flush() throws IOException {
        System.err.flush();
    }

    public void close() throws IOException {
        System.err.close();
    }

    public String toString() {
        return System.err.toString();
    }

    public int hashCode() {
        return System.err.hashCode();
    }

    public boolean equals(Object obj) {
        return (obj != null) && (getClass().equals(obj.getClass()));
    }
}
