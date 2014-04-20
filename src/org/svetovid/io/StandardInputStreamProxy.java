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
