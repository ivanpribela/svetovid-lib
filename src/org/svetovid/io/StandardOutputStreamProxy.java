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
