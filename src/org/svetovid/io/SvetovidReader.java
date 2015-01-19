/*
 * Copyright 2015 Ivan Pribela
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
