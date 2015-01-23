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

/**
 * This interface provides methods that simplify inputing data for beginner
 * programmers. Exception handling is not necessary as all operations are
 * returning default values on any errors. If necessary, the last raised
 * exception can be retrieved using {@link getLastException()} method.
 */
public interface SvetovidReader {

    /**
     * Returns the currently used pattern for recognizing whitespace. This
     * pattern is used to separate tokens when reading form the underlying
     * source. For more on patterns see {@link java.util.regex.Pattern}.
     *
     * @return the pattern currently used to recognize whitespace.
     *
     * @see java.util.regex.Pattern
     */
    public Pattern getWhitespace();

    /**
     * Sets the pattern used to recognize whitespace. This
     * pattern is used to separate tokens when reading form the underlying
     * source. For more on patterns see {@link java.util.regex.Pattern}.
     *
     * @param whitespace
     *            the pattern to use recognize whitespace
     *
     * @see java.util.regex.Pattern
     */
    public void setWhitespace(Pattern whitespace);

    /**
     * Returns the exception raised in the last operation; if the operation was
     * successful and no exception was raised, returns {@code null}.
     *
     * @return the exception raised in the last operation or {@code null} it the
     *         operation was successful.
     */
    public IOException getLastException();

    /**
     * Checks whether this reader has data to be read.
     *
     * @return {@code true} if this reader has more data to be read;
     *         {@code false} otherwise.
     */
    public boolean isEmpty();

    /**
     * Closes this writer and releases any resources associated with the
     * underlying source. The general contract of {@code close} is that it
     * closes the input source. A closed source cannot perform input operations
     * and cannot be reopened.
     */
    public void close();

    /**
     * Reads one token and converts it to a boolean value.
     *
     * @return the {@code boolean} value read.
     */
    public boolean readBool();

    /**
     * Reads one token and converts it to a byte value.
     *
     * @return the {@code byte} value read.
     *
     * @exception NumberFormatException
     *                if the token is not a parsable byte.
     */
    public byte readByte() throws NumberFormatException;

    /**
     * Reads one token and converts it to a short integer value.
     *
     * @return the {@code short} value read.
     *
     * @exception NumberFormatException
     *                if the token is not a parsable short.
     */
    public short readShort() throws NumberFormatException;

    /**
     * Reads one token and converts it to an integer value.
     *
     * @return the {@code int} value read.
     *
     * @exception NumberFormatException
     *                if the token is not a parsable int.
     */
    public int readInt() throws NumberFormatException;

    /**
     * Reads one token and converts it to a long integer value.
     *
     * @return the {@code long} value read.
     *
     * @exception NumberFormatException
     *                if the token is not a parsable long.
     */
    public long readLong() throws NumberFormatException;

    /**
     * Reads one token and converts it to a floating-point value.
     *
     * @return the {@code float} value read.
     *
     * @exception NumberFormatException
     *                if the token is not a parsable float.
     */
    public float readFloat() throws NumberFormatException;

    /**
     * Reads one token and converts it to a double-precision floating-point
     * value.
     *
     * @return the {@code double} value read.
     *
     * @exception NumberFormatException
     *                if the token is not a parsable double.
     */
    public double readDouble() throws NumberFormatException;

    /**
     * Reads one token and converts it to a character value.
     *
     * @return the {@code char} value read.
     *
     * @exception NumberFormatException
     *                if the token is not a parsable character.
     */
    public char readChar() throws NumberFormatException;

    /**
     * Reads one token and returns it as a string value.
     *
     * @return the {@code String} value read.
     */
    public String readString();

    /**
     * Reads one token and converts it to a boolean value.
     *
     * @return the {@code Boolean} value read.
     */
    public Boolean readBoolBoxed();

    /**
     * Reads one token and converts it to a byte value.
     *
     * @return the {@code Byte} value read.
     *
     * @exception NumberFormatException
     *                if the token is not a parsable byte.
     */
    public Byte readByteBoxed();

    /**
     * Reads one token and converts it to a short integer value.
     *
     * @return the {@code Short} value read.
     *
     * @exception NumberFormatException
     *                if the token is not a parsable short.
     */
    public Short readShortBoxed();

    /**
     * Reads one token and converts it to an integer value.
     *
     * @return the {@code Integer} value read.
     *
     * @exception NumberFormatException
     *                if the token is not a parsable int.
     */
    public Integer readIntBoxed();

    /**
     * Reads one token and converts it to a long integer value.
     *
     * @return the {@code Long} value read.
     *
     * @exception NumberFormatException
     *                if the token is not a parsable long.
     */
    public Long readLongBoxed();

    /**
     * Reads one token and converts it to a floating-point value.
     *
     * @return the {@code Float} value read.
     *
     * @exception NumberFormatException
     *                if the token is not a parsable float.
     */
    public Float readFloatBoxed();

    /**
     * Reads one token and converts it to a double-precision floating-point
     * value.
     *
     * @return the {@code Double} value read.
     *
     * @exception NumberFormatException
     *                if the token is not a parsable double.
     */
    public Double readDoubleBoxed();

    /**
     * Reads one token and converts it to a character value.
     *
     * @return the {@code Character} value read.
     *
     * @exception NumberFormatException
     *                if the token is not a parsable character.
     */
    public Character readCharBoxed();

    /**
     * Reads one line, separates it into tokens and converts them to boolean
     * values.
     *
     * @return an array of {@code boolean} values read.
     *
     * @exception NumberFormatException
     *                if one of the tokens is not a parsable boolean.
     */
    public boolean[] readBoolLine();

    /**
     * Reads one line, separates it into tokens and converts them to byte
     * values.
     *
     * @return an array of {@code byte} values read.
     *
     * @exception NumberFormatException
     *                if one of the tokens is not a parsable byte.
     */
    public byte[] readByteLine() throws NumberFormatException;

    /**
     * Reads one line, separates it into tokens and converts them to short
     * integer values.
     *
     * @return an array of {@code short} values read.
     *
     * @exception NumberFormatException
     *                if one of the tokens is not a parsable short.
     */
    public short[] readShortLine() throws NumberFormatException;

    /**
     * Reads one line, separates it into tokens and converts them to integer
     * values.
     *
     * @return an array of {@code int} values read.
     *
     * @exception NumberFormatException
     *                if one of the tokens is not a parsable integer.
     */
    public int[] readIntLine() throws NumberFormatException;

    /**
     * Reads one line, separates it into tokens and converts them to long
     * integer values.
     *
     * @return an array of {@code long} values read.
     *
     * @exception NumberFormatException
     *                if one of the tokens is not a parsable long.
     */
    public long[] readLongLine() throws NumberFormatException;

    /**
     * Reads one line, separates it into tokens and converts them to
     * floating-point values.
     *
     * @return an array of {@code float} values read.
     *
     * @exception NumberFormatException
     *                if one of the tokens is not a parsable float.
     */
    public float[] readFloatLine() throws NumberFormatException;

    /**
     * Reads one line, separates it into tokens and converts them to
     * double-precision floating-point values.
     *
     * @return an array of {@code double} values read.
     *
     * @exception NumberFormatException
     *                if one of the tokens is not a parsable double.
     */
    public double[] readDoubleLine() throws NumberFormatException;

    /**
     * Reads one line, separates it into tokens and converts them to character
     * values.
     *
     * @return an array of {@code char} values read.
     *
     * @exception NumberFormatException
     *                if one of the tokens is not a parsable character.
     */
    public char[] readCharLine() throws NumberFormatException;

    /**
     * Reads one line, separates it into tokens and returns them as string
     * values.
     *
     * @return an array of {@code String} values read.
     */
    public String[] readStringLine();

    /**
     * Reads one line, separates it into tokens and converts them to boolean
     * values.
     *
     * @return an array of {@code Boolean} values read.
     */
    public Boolean[] readBoolLineBoxed();

    /**
     * Reads one line, separates it into tokens and converts them to byte
     * values.
     *
     * @return an array of {@code Byte} values read.
     *
     * @exception NumberFormatException
     *                if one of the tokens is not a parsable byte.
     */
    public Byte[] readByteLineBoxed();

    /**
     * Reads one line, separates it into tokens and converts them to short
     * integer values.
     *
     * @return an array of {@code Short} values read.
     *
     * @exception NumberFormatException
     *                if one of the tokens is not a parsable short.
     */
    public Short[] readShortLineBoxed();

    /**
     * Reads one line, separates it into tokens and converts them to integer
     * values.
     *
     * @return an array of {@code Integer} values read.
     *
     * @exception NumberFormatException
     *                if one of the tokens is not a parsable integer.
     */
    public Integer[] readIntLineBoxed();

    /**
     * Reads one line, separates it into tokens and converts them to long
     * integer values.
     *
     * @return an array of {@code Long} values read.
     *
     * @exception NumberFormatException
     *                if one of the tokens is not a parsable long.
     */
    public Long[] readLongLineBoxed();

    /**
     * Reads one line, separates it into tokens and converts them to
     * floating-point values.
     *
     * @return an array of {@code Float} values read.
     *
     * @exception NumberFormatException
     *                if one of the tokens is not a parsable float.
     */
    public Float[] readFloatLineBoxed();

    /**
     * Reads one line, separates it into tokens and converts them to
     * double-precision floating-point values.
     *
     * @return an array of {@code Double} values read.
     *
     * @exception NumberFormatException
     *                if one of the tokens is not a parsable double.
     */
    public Double[] readDoubleLineBoxed();

    /**
     * Reads one line, separates it into tokens and converts them to character
     * values.
     *
     * @return an array of {@code Character} values read.
     *
     * @exception NumberFormatException
     *                if one of the tokens is not a parsable character.
     */
    public Character[] readCharLineBoxed();

    /**
     * Reads a line of text and returns it as a string. A line is considered to
     * be terminated by any one of a line feed ('\n'), a carriage return ('\r'),
     * or a carriage return followed immediately by a line feed.
     *
     * @return A {@code String} containing the contents of the line, not
     *         including any line-termination characters, or null if the end of
     *         the source has been reached.
     */
    public String readLine();

    /**
     * Read all remaining lines and returns them as an array of strings. A line
     * is considered to be terminated by any one of a line feed ('\n'), a
     * carriage return ('\r'), or a carriage return followed immediately by a
     * line feed.
     *
     * @return A {@code String} array containing the contents of the remaining
     *         lines, not including any line-termination characters, or an empty
     *         array if the end of the source has been reached.
     */
    public String[] readAllLines();

    /**
     * Reads all remaining content and returns it as a string.
     *
     * @return A {@code String} containing all the remaining contents of the
     *         source, or null if the end of the source has been reached.
     */
    public String readAll();

    /**
     * Reads multiple lines and converts the data to a boolean matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached.
     *
     * @return a matrix of {@code boolean} values read.
     */
    public boolean[][] readBoolMatrix();

    /**
     * Reads multiple lines and converts the data to a byte matrix. The matrix
     * is read row by row until an empty row is found or the end of input is
     * reached.
     *
     * @return a matrix of {@code byte} values read.
     *
     * @exception NumberFormatException
     *                if one of the read values is not a parsable byte.
     */
    public byte[][] readByteMatrix() throws NumberFormatException;

    /**
     * Reads multiple lines and converts the data to a shot integer matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached.
     *
     * @return a matrix of {@code short} values read.
     *
     * @exception NumberFormatException
     *                if one of the read values is not a parsable short.
     */
    public short[][] readShortMatrix() throws NumberFormatException;

    /**
     * Reads multiple lines and converts the data to an integer matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached.
     *
     * @return a matrix of {@code int} values read.
     *
     * @exception NumberFormatException
     *                if one of the read values is not a parsable integer.
     */
    public int[][] readIntMatrix() throws NumberFormatException;

    /**
     * Reads multiple lines and converts the data to a long integer matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached.
     *
     * @return a matrix of {@code long} values read.
     *
     * @exception NumberFormatException
     *                if one of the read values is not a parsable long.
     */
    public long[][] readLongMatrix() throws NumberFormatException;

    /**
     * Reads multiple lines and converts the data to a floating-point matrix.
     * The matrix is read row by row until an empty row is found or the end of
     * input is reached.
     *
     * @return a matrix of {@code float} values read.
     *
     * @exception NumberFormatException
     *                if one of the read values is not a parsable float.
     */
    public float[][] readFloatMatrix() throws NumberFormatException;

    /**
     * Reads multiple lines and converts the data to a double-precision
     * floating-point matrix. The matrix is read row by row until an empty row
     * is found or the end of input is reached.
     *
     * @return a matrix of {@code double} values read.
     *
     * @exception NumberFormatException
     *                if one of the read values is not a parsable double.
     */
    public double[][] readDoubleMatrix() throws NumberFormatException;

    /**
     * Reads multiple lines and converts the data to a character matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached.
     *
     * @return a matrix of {@code char} values read.
     *
     * @exception NumberFormatException
     *                if one of the read values is not a parsable character.
     */
    public char[][] readCharMatrix() throws NumberFormatException;

    /**
     * Reads multiple lines and converts the data to a string matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached.
     *
     * @return a matrix of {@code String} values read.
     */
    public String[][] readStringMatrix();

    /**
     * Reads multiple lines and converts the data to a boolean matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached.
     *
     * @return a matrix of {@code Boolean} values read.
     */
    public Boolean[][] readBoolMatrixBoxed();

    /**
     * Reads multiple lines and converts the data to a byte matrix. The matrix
     * is read row by row until an empty row is found or the end of input is
     * reached.
     *
     * @return a matrix of {@code Byte} values read.
     */
    public Byte[][] readByteMatrixBoxed();

    /**
     * Reads multiple lines and converts the data to a shot integer matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached.
     *
     * @return a matrix of {@code Short} values read.
     */
    public Short[][] readShortMatrixBoxed();

    /**
     * Reads multiple lines and converts the data to an integer matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached.
     *
     * @return a matrix of {@code Integer} values read.
     */
    public Integer[][] readIntMatrixBoxed();

    /**
     * Reads multiple lines and converts the data to a long integer matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached.
     *
     * @return a matrix of {@code Long} values read.
     */
    public Long[][] readLongMatrixBoxed();

    /**
     * Reads multiple lines and converts the data to a floating-point matrix.
     * The matrix is read row by row until an empty row is found or the end of
     * input is reached.
     *
     * @return a matrix of {@code Float} values read.
     */
    public Float[][] readFloatMatrixBoxed();

    /**
     * Reads multiple lines and converts the data to a double-precision
     * floating-point matrix. The matrix is read row by row until an empty row
     * is found or the end of input is reached.
     *
     * @return a matrix of {@code Double} values read.
     */
    public Double[][] readDoubleMatrixBoxed();

    /**
     * Reads multiple lines and converts the data to a character matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached.
     *
     * @return a matrix of {@code Character} values read.
     */
    public Character[][] readCharMatrixBoxed();

}
