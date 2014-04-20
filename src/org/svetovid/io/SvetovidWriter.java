package org.svetovid.io;

import java.io.IOException;

public interface SvetovidWriter {

    public String getWhitespace();
    public void setWhitespace(String whitespace);

    public boolean getAutoFlush();
    public void setAutoFlush(boolean autoFlush);

    public IOException getLastException();

    public void close();

    public void write(boolean value);
    public void write(byte value);
    public void write(short value);
    public void write(int value);
    public void write(long value);
    public void write(float value);
    public void write(double value);
    public void write(char value);
    public void write(String value);
    public void write(Object value);
    public void write();
    public void writebf();

    public void writeln(boolean value);
    public void writeln(byte value);
    public void writeln(short value);
    public void writeln(int value);
    public void writeln(long value);
    public void writeln(float value);
    public void writeln(double value);
    public void writeln(char value);
    public void writeln(String value);
    public void writeln(Object value);
    public void writeln();

    public void writeln(boolean... value);
    public void writeln(byte... value);
    public void writeln(short... value);
    public void writeln(int... value);
    public void writeln(long... value);
    public void writeln(float... value);
    public void writeln(double... value);
    public void writeln(char... value);

    public void writeln(Boolean... value);
    public void writeln(Byte... value);
    public void writeln(Short... value);
    public void writeln(Integer... value);
    public void writeln(Long... value);
    public void writeln(Float... value);
    public void writeln(Double... value);
    public void writeln(Character... value);
    public void writeln(String... value);
    public void writeln(Object... value);

    public void writeln(boolean[][] value);
    public void writeln(byte[][] value);
    public void writeln(short[][] value);
    public void writeln(int[][] value);
    public void writeln(long[][] value);
    public void writeln(float[][] value);
    public void writeln(double[][] value);
    public void writeln(char[][] value);

    public void writeln(Boolean[][] value);
    public void writeln(Byte[][] value);
    public void writeln(Short[][] value);
    public void writeln(Integer[][] value);
    public void writeln(Long[][] value);
    public void writeln(Float[][] value);
    public void writeln(Double[][] value);
    public void writeln(Character[][] value);
    public void writeln(String[][] value);
    public void writeln(Object[][] value);

}
