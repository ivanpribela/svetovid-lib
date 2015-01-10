package org.svetovid.io;

import java.io.IOException;

import org.svetovid.Svetovid;

public abstract class AbstractSvetovidWriter implements SvetovidWriter {

    protected String whitespace = Svetovid.WHITESPACE;

    @Override
    public String getWhitespace() {
        return whitespace;
    }

    @Override
    public void setWhitespace(String whitespace) {
        this.whitespace = whitespace;
    }

    protected boolean autoFlush = Svetovid.AUTO_FLUSH;

    @Override
    public boolean getAutoFlush() {
        return autoFlush;
    }

    @Override
    public void setAutoFlush(boolean autoFlush) {
        this.autoFlush = autoFlush;
    }

    protected IOException exception;

    @Override
    public IOException getLastException() {
        return exception;
    }

    @Override
    public void close() {
        Svetovid.removeOut(this);
    }

    @Override
    public void write(boolean value) {
        write(Boolean.toString(value));
    }

    @Override
    public void write(byte value) {
        write(Byte.toString(value));
    }

    @Override
    public void write(short value) {
        write(Short.toString(value));
    }

    @Override
    public void write(int value) {
        write(Integer.toString(value));
    }

    @Override
    public void write(long value) {
        write(Long.toString(value));
    }

    @Override
    public void write(float value) {
        write(Float.toString(value));
    }

    @Override
    public void write(double value) {
        write(Double.toString(value));
    }

    @Override
    public void write(char value) {
        write(Character.toString(value));
    }

    @Override
    public void write(String value) {
        try {
            doWrite(value);
            if (autoFlush) {
                writebf();
            }
        } catch (IOException e) {
            exception = e;
        }
    }

    protected abstract void doWrite(String value) throws IOException;

    @Override
    public void write(Object value) {
        write(String.valueOf(value));
    }

    @Override
    public void write() {
        write(whitespace);
    }

    @Override
    public void writebf() {
        try {
            doFlush();
            exception = null;
        } catch (IOException e) {
            exception = e;
        }
    }

    protected abstract void doFlush() throws IOException;

    @Override
    public void writeln(boolean value) {
        writeln(Boolean.toString(value));
    }

    @Override
    public void writeln(byte value) {
        writeln(Byte.toString(value));
    }

    @Override
    public void writeln(short value) {
        writeln(Short.toString(value));
    }

    @Override
    public void writeln(int value) {
        writeln(Integer.toString(value));
    }

    @Override
    public void writeln(long value) {
        writeln(Long.toString(value));
    }

    @Override
    public void writeln(float value) {
        writeln(Float.toString(value));
    }

    @Override
    public void writeln(double value) {
        writeln(Double.toString(value));
    }

    @Override
    public void writeln(char value) {
        writeln(Character.toString(value));
    }

    @Override
    public void writeln(String value) {
        try {
            doWriteln(value);
            exception = null;
        } catch (IOException e) {
            exception = e;
        }
    }

    protected abstract void doWriteln(String value) throws IOException;

    @Override
    public void writeln(Object value) {
        writeln(String.valueOf(value));
    }

    @Override
    public void writeln() {
        writeln("");
    }

    @Override
    public void writeln(boolean... value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(value[0]);
        for (int i = 1; i < value.length; i++) {
            builder.append(whitespace);
            builder.append(value[i]);
        }
        writeln(builder.toString());
    }

    @Override
    public void writeln(byte... value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(value[0]);
        for (int i = 1; i < value.length; i++) {
            builder.append(whitespace);
            builder.append(value[i]);
        }
        writeln(builder.toString());
    }

    @Override
    public void writeln(short... value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(value[0]);
        for (int i = 1; i < value.length; i++) {
            builder.append(whitespace);
            builder.append(value[i]);
        }
        writeln(builder.toString());
    }

    @Override
    public void writeln(int... value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(value[0]);
        for (int i = 1; i < value.length; i++) {
            builder.append(whitespace);
            builder.append(value[i]);
        }
        writeln(builder.toString());
    }

    @Override
    public void writeln(long... value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(value[0]);
        for (int i = 1; i < value.length; i++) {
            builder.append(whitespace);
            builder.append(value[i]);
        }
        writeln(builder.toString());
    }

    @Override
    public void writeln(float... value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(value[0]);
        for (int i = 1; i < value.length; i++) {
            builder.append(whitespace);
            builder.append(value[i]);
        }
        writeln(builder.toString());
    }

    @Override
    public void writeln(double... value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(value[0]);
        for (int i = 1; i < value.length; i++) {
            builder.append(whitespace);
            builder.append(value[i]);
        }
        writeln(builder.toString());
    }

    @Override
    public void writeln(char... value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(value[0]);
        for (int i = 1; i < value.length; i++) {
            builder.append(whitespace);
            builder.append(value[i]);
        }
        writeln(builder.toString());
    }

    @Override
    public void writeln(Boolean... value) {
        writeln((Object[]) value);
    }

    @Override
    public void writeln(Byte... value) {
        writeln((Object[]) value);
    }

    @Override
    public void writeln(Short... value) {
        writeln((Object[]) value);
    }

    @Override
    public void writeln(Integer... value) {
        writeln((Object[]) value);
    }

    @Override
    public void writeln(Long... value) {
        writeln((Object[]) value);
    }

    @Override
    public void writeln(Float... value) {
        writeln((Object[]) value);
    }

    @Override
    public void writeln(Double... value) {
        writeln((Object[]) value);
    }

    @Override
    public void writeln(Character... value) {
        writeln((Object[]) value);
    }

    @Override
    public void writeln(String... value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(value[0]);
        for (int i = 1; i < value.length; i++) {
            builder.append(whitespace);
            builder.append(value[i]);
        }
        writeln(builder.toString());
    }

    @Override
    public void writeln(Object... value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(value[0]);
        for (int i = 1; i < value.length; i++) {
            builder.append(whitespace);
            builder.append(value[i]);
        }
        writeln(builder.toString());
    }

    @Override
    public void writeln(boolean[][] value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            writeln(value[i]);
        }
    }

    @Override
    public void writeln(byte[][] value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            writeln(value[i]);
        }
    }

    @Override
    public void writeln(short[][] value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            writeln(value[i]);
        }
    }

    @Override
    public void writeln(int[][] value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            writeln(value[i]);
        }
    }

    @Override
    public void writeln(long[][] value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            writeln(value[i]);
        }
    }

    @Override
    public void writeln(float[][] value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            writeln(value[i]);
        }
    }

    @Override
    public void writeln(double[][] value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            writeln(value[i]);
        }
    }

    @Override
    public void writeln(char[][] value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            writeln(value[i]);
        }
    }

    @Override
    public void writeln(Boolean[][] value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            writeln(value[i]);
        }
    }

    @Override
    public void writeln(Byte[][] value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            writeln(value[i]);
        }
    }

    @Override
    public void writeln(Short[][] value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            writeln(value[i]);
        }
    }

    @Override
    public void writeln(Integer[][] value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            writeln(value[i]);
        }
    }

    @Override
    public void writeln(Long[][] value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            writeln(value[i]);
        }
    }

    @Override
    public void writeln(Float[][] value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            writeln(value[i]);
        }
    }

    @Override
    public void writeln(Double[][] value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            writeln(value[i]);
        }
    }

    @Override
    public void writeln(Character[][] value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            writeln(value[i]);
        }
    }

    @Override
    public void writeln(String[][] value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            writeln(value[i]);
        }
    }

    @Override
    public void writeln(Object[][] value) {
        if (value == null) {
            writeln((String) null);
            return;
        }
        if (value.length == 0) {
            writeln();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            writeln(value[i]);
        }
    }
}
