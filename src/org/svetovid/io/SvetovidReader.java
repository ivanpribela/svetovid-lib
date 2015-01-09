package org.svetovid.io;

import java.io.IOException;
import java.util.regex.Pattern;

public interface SvetovidReader {

    public Pattern getWhitespace();
    public void setWhitespace(Pattern whitespace);

    public IOException getLastException();

    public boolean isEmpty();
    public void close();

    public boolean readBool();
    public byte readByte() throws NumberFormatException;
    public short readShort() throws NumberFormatException;
    public int readInt() throws NumberFormatException;
    public long readLong() throws NumberFormatException;
    public float readFloat() throws NumberFormatException;
    public double readDouble() throws NumberFormatException;
    public char readChar() throws NumberFormatException;
    public String readString();

    public Boolean readBoolBoxed();
    public Byte readByteBoxed();
    public Short readShortBoxed();
    public Integer readIntBoxed();
    public Long readLongBoxed();
    public Float readFloatBoxed();
    public Double readDoubleBoxed();
    public Character readCharBoxed();

    public boolean[] readBoolLine();
    public byte[] readByteLine() throws NumberFormatException;
    public short[] readShortLine() throws NumberFormatException;
    public int[] readIntLine() throws NumberFormatException;
    public long[] readLongLine() throws NumberFormatException;
    public float[] readFloatLine() throws NumberFormatException;
    public double[] readDoubleLine() throws NumberFormatException;
    public char[] readCharLine() throws NumberFormatException;
    public String[] readStringLine();

    public Boolean[] readBoolLineBoxed();
    public Byte[] readByteLineBoxed();
    public Short[] readShortLineBoxed();
    public Integer[] readIntLineBoxed();
    public Long[] readLongLineBoxed();
    public Float[] readFloatLineBoxed();
    public Double[] readDoubleLineBoxed();
    public Character[] readCharLineBoxed();

    public String readLine();
    public String[] readAllLines();
    public String readAll();

    public boolean[][] readBoolMatrix();
    public byte[][] readByteMatrix() throws NumberFormatException;
    public short[][] readShortMatrix() throws NumberFormatException;
    public int[][] readIntMatrix() throws NumberFormatException;
    public long[][] readLongMatrix() throws NumberFormatException;
    public float[][] readFloatMatrix() throws NumberFormatException;
    public double[][] readDoubleMatrix() throws NumberFormatException;
    public char[][] readCharMatrix() throws NumberFormatException;
    public String[][] readStringMatrix();

    public Boolean[][] readBoolMatrixBoxed();
    public Byte[][] readByteMatrixBoxed();
    public Short[][] readShortMatrixBoxed();
    public Integer[][] readIntMatrixBoxed();
    public Long[][] readLongMatrixBoxed();
    public Float[][] readFloatMatrixBoxed();
    public Double[][] readDoubleMatrixBoxed();
    public Character[][] readCharMatrixBoxed();

}
