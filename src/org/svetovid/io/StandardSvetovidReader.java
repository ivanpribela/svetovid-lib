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

import org.svetovid.Svetovid;

public final class StandardSvetovidReader extends DefaultSvetovidReader {

    public StandardSvetovidReader() {
        super(new StandardInputStreamProxy());
    }

    protected boolean readFromNewLine = false;

    public boolean getReadFromNewLine() {
        return readFromNewLine;
    }

    public void setReadFromNewLine(boolean readFromNewLine) {
        this.readFromNewLine = readFromNewLine;
    }

    protected void prompt(String prompt) {
        Svetovid.out.print(prompt);
        if (readFromNewLine) {
            Svetovid.out.println();
        } else {
            Svetovid.out.print();
        }
        Svetovid.out.printbf();
    }

    public boolean readBool(String prompt){
        prompt(prompt);
        return readBool();
    }

    public byte readByte(String prompt) throws NumberFormatException {
        prompt(prompt);
        return readByte();
    }

    public short readShort(String prompt) throws NumberFormatException {
        prompt(prompt);
        return readShort();
    }

    public int readInt(String prompt) throws NumberFormatException {
        prompt(prompt);
        return readInt();
    }

    public long readLong(String prompt) throws NumberFormatException {
        prompt(prompt);
        return readLong();
    }

    public float readFloat(String prompt) throws NumberFormatException {
        prompt(prompt);
        return readFloat();
    }

    public double readDouble(String prompt) throws NumberFormatException {
        prompt(prompt);
        return readDouble();
    }

    public char readChar(String prompt) throws NumberFormatException {
        prompt(prompt);
        return readChar();
    }

    public String readString(String prompt) {
        prompt(prompt);
        return readString();
    }

    public Boolean readBoolBoxed(String prompt) {
        prompt(prompt);
        return readBoolBoxed();
    }

    public Byte readByteBoxed(String prompt) {
        prompt(prompt);
        return readByteBoxed();
    }

    public Short readShortBoxed(String prompt) {
        prompt(prompt);
        return readShortBoxed();
    }

    public Integer readIntBoxed(String prompt) {
        prompt(prompt);
        return readIntBoxed();
    }

    public Long readLongBoxed(String prompt) {
        prompt(prompt);
        return readLongBoxed();
    }

    public Float readFloatBoxed(String prompt) {
        prompt(prompt);
        return readFloatBoxed();
    }

    public Double readDoubleBoxed(String prompt) {
        prompt(prompt);
        return readDoubleBoxed();
    }

    public Character readCharBoxed(String prompt) {
        prompt(prompt);
        return readCharBoxed();
    }

    public boolean[] readBoolLine(String prompt) {
        prompt(prompt);
        return readBoolLine();
    }

    public byte[] readByteLine(String prompt) throws NumberFormatException {
        prompt(prompt);
        return readByteLine();
    }

    public short[] readShortLine(String prompt) throws NumberFormatException {
        prompt(prompt);
        return readShortLine();
    }

    public int[] readIntLine(String prompt) throws NumberFormatException {
        prompt(prompt);
        return readIntLine();
    }

    public long[] readLongLine(String prompt) throws NumberFormatException {
        prompt(prompt);
        return readLongLine();
    }

    public float[] readFloatLine(String prompt) throws NumberFormatException {
        prompt(prompt);
        return readFloatLine();
    }

    public double[] readDoubleLine(String prompt) throws NumberFormatException {
        prompt(prompt);
        return readDoubleLine();
    }

    public char[] readCharLine(String prompt) throws NumberFormatException {
        prompt(prompt);
        return readCharLine();
    }

    public String[] readStringLine(String prompt) {
        prompt(prompt);
        return readStringLine();
    }

    public Boolean[] readBoolLineBoxed(String prompt) {
        prompt(prompt);
        return readBoolLineBoxed();
    }

    public Byte[] readByteLineBoxed(String prompt) {
        prompt(prompt);
        return readByteLineBoxed();
    }

    public Short[] readShortLineBoxed(String prompt) {
        prompt(prompt);
        return readShortLineBoxed();
    }

    public Integer[] readIntLineBoxed(String prompt) {
        prompt(prompt);
        return readIntLineBoxed();
    }

    public Long[] readLongLineBoxed(String prompt) {
        prompt(prompt);
        return readLongLineBoxed();
    }

    public Float[] readFloatLineBoxed(String prompt) {
        prompt(prompt);
        return readFloatLineBoxed();
    }

    public Double[] readDoubleLineBoxed(String prompt) {
        prompt(prompt);
        return readDoubleLineBoxed();
    }

    public Character[] readCharLineBoxed(String prompt) {
        prompt(prompt);
        return readCharLineBoxed();
    }

    public String readLine(String prompt) {
        prompt(prompt);
        return readLine();
    }

    public String[] readAllLines(String prompt) {
        prompt(prompt);
        return readAllLines();
    }

    public String readAll(String prompt) {
        prompt(prompt);
        return readAll();
    }

    public boolean[][] readBoolMatrix(String prompt) {
        prompt(prompt);
        return readBoolMatrix();
    }

    public byte[][] readByteMatrix(String prompt) throws NumberFormatException {
        prompt(prompt);
        return readByteMatrix();
    }

    public short[][] readShortMatrix(String prompt) throws NumberFormatException {
        prompt(prompt);
        return readShortMatrix();
    }

    public int[][] readIntMatrix(String prompt) throws NumberFormatException {
        prompt(prompt);
        return readIntMatrix();
    }

    public long[][] readLongMatrix(String prompt) throws NumberFormatException {
        prompt(prompt);
        return readLongMatrix();
    }

    public float[][] readFloatMatrix(String prompt) throws NumberFormatException {
        prompt(prompt);
        return readFloatMatrix();
    }

    public double[][] readDoubleMatrix(String prompt) throws NumberFormatException {
        prompt(prompt);
        return readDoubleMatrix();
    }

    public char[][] readCharMatrix(String prompt) throws NumberFormatException {
        prompt(prompt);
        return readCharMatrix();
    }

    public String[][] readStringMatrix(String prompt) {
        prompt(prompt);
        return readStringMatrix();
    }

    public Boolean[][] readBoolMatrixBoxed(String prompt) {
        prompt(prompt);
        return readBoolMatrixBoxed();
    }

    public Byte[][] readByteMatrixBoxed(String prompt) {
        prompt(prompt);
        return readByteMatrixBoxed();
    }

    public Short[][] readShortMatrixBoxed(String prompt) {
        prompt(prompt);
        return readShortMatrixBoxed();
    }

    public Integer[][] readIntMatrixBoxed(String prompt) {
        prompt(prompt);
        return readIntMatrixBoxed();
    }

    public Long[][] readLongMatrixBoxed(String prompt) {
        prompt(prompt);
        return readLongMatrixBoxed();
    }

    public Float[][] readFloatMatrixBoxed(String prompt) {
        prompt(prompt);
        return readFloatMatrixBoxed();
    }

    public Double[][] readDoubleMatrixBoxed(String prompt) {
        prompt(prompt);
        return readDoubleMatrixBoxed();
    }

    public Character[][] readCharMatrixBoxed(String prompt) {
        prompt(prompt);
        return readCharMatrixBoxed();
    }
}
