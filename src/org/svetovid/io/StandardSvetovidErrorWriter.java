package org.svetovid.io;

public class StandardSvetovidErrorWriter extends DefaultSvetovidWriter {

    public StandardSvetovidErrorWriter() {
        super(new StandardErrorStreamProxy());
    }
}
