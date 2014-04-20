package org.svetovid.io;

public class StandardSvetovidWriter extends DefaultSvetovidWriter {

    public StandardSvetovidWriter() {
        super(new StandardOutputStreamProxy());
    }
}
