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

import java.util.regex.Pattern;

import org.svetovid.SvetovidFormatException;

/**
 * This interface provides methods that simplify reading the program input data
 * for beginner programmers. Exception handling is not necessary as when it is
 * turned off by {@link #setThrowingExceptions(boolean)} many operations are
 * returning default values on any errors. If necessary, the last raised
 * exception can be retrieved using {@link #getLastException()} method.
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
     * Sets the pattern used to recognize whitespace. This pattern is used to
     * separate tokens when reading form the underlying source. For more on
     * patterns see {@link java.util.regex.Pattern}.
     *
     * @param whitespace
     *            the pattern to use recognize whitespace
     *
     * @see java.util.regex.Pattern
     */
    public void setWhitespace(Pattern whitespace);

    /**
     * Returns the indicator whether this reader will throw exceptions on I/O
     * operation errors or just return default values.
     *
     * @return {@code true} if this reader throws exceptions on failed I/O
     *         operations; {@code false} otherwise.
     */
    public boolean isThrowingExceptions();

    /**
     * Configures whether this reader should throw exceptions on I/O operation
     * errors or just return default values.
     *
     * @param shouldThrow
     *            {@code true} if this reader should throw exceptions on failed
     *            I/O operations in the future; {@code false} if it should
     *            return default values.
     */
    public void setThrowingExceptions(boolean shouldThrow);

    /**
     * Returns the exception raised in the last operation; if the operation was
     * successful and no exception was raised, returns {@code null}.
     *
     * @return the exception raised in the last operation or {@code null} it the
     *         operation was successful.
     */
    public Throwable getLastException();

    /**
     * Checks whether this reader has no more data to be read.
     *
     * @return {@code true} if this reader has no more data to be read;
     *         {@code false} otherwise.
     */
    public boolean isEmpty();

    /**
     * Checks whether this reader has data to be read.
     *
     * @return {@code true} if this reader has data to be read; {@code false}
     *         otherwise.
     */
    public boolean hasMore();

    /**
     * Closes this reader and releases any resources associated with the
     * underlying source. The general contract of {@code close} is that it
     * closes the input source. A closed source cannot perform input operations
     * and cannot be reopened.
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void close() throws SvetovidIOException;

    /**
     * Reads one token and converts it to a boolean value.
     *
     * @return the {@code boolean} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable boolean.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public boolean readBool() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one token and converts it to a byte value.
     *
     * @return the {@code byte} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable byte.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public byte readByte() throws SvetovidFormatException, SvetovidIOException;

    /**
     * Reads one token and converts it to a short integer value.
     *
     * @return the {@code short} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable short.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public short readShort() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one token and converts it to an integer value.
     *
     * @return the {@code int} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable int.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public int readInt() throws SvetovidFormatException, SvetovidIOException;

    /**
     * Reads one token and converts it to a long integer value.
     *
     * @return the {@code long} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable long.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public long readLong() throws SvetovidFormatException, SvetovidIOException;

    /**
     * Reads one token and converts it to a floating-point value.
     *
     * @return the {@code float} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable float.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public float readFloat() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one token and converts it to a double-precision floating-point
     * value.
     *
     * @return the {@code double} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable double.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public double readDouble() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one token and converts it to a character value.
     *
     * @return the {@code char} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable char.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public char readChar() throws SvetovidFormatException, SvetovidIOException;

    /**
     * Reads one token and returns it as a string value.
     *
     * @return the {@code String} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is {@code null}.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public String readToken() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one token and converts it to a boolean value.
     *
     * @return the {@code Boolean} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable boolean.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Boolean readBoolBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one token and converts it to a byte value.
     *
     * @return the {@code Byte} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable byte.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Byte readByteBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one token and converts it to a short integer value.
     *
     * @return the {@code Short} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable short.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Short readShortBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one token and converts it to an integer value.
     *
     * @return the {@code Integer} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable int.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Integer readIntBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one token and converts it to a long integer value.
     *
     * @return the {@code Long} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable long.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Long readLongBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one token and converts it to a floating-point value.
     *
     * @return the {@code Float} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable float.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Float readFloatBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one token and converts it to a double-precision floating-point
     * value.
     *
     * @return the {@code Double} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable double.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Double readDoubleBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one token and converts it to a character value.
     *
     * @return the {@code Character} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable character.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Character readCharBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one line, separates it into tokens and converts them to boolean
     * values.
     *
     * @return an array of {@code boolean} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable boolean.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public boolean[] readBoolArray() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one line, separates it into tokens and converts them to byte
     * values.
     *
     * @return an array of {@code byte} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable byte.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public byte[] readByteArray() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one line, separates it into tokens and converts them to short
     * integer values.
     *
     * @return an array of {@code short} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable short.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public short[] readShortArray() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one line, separates it into tokens and converts them to integer
     * values.
     *
     * @return an array of {@code int} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable integer.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public int[] readIntArray() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one line, separates it into tokens and converts them to long
     * integer values.
     *
     * @return an array of {@code long} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable long.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public long[] readLongArray() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one line, separates it into tokens and converts them to
     * floating-point values.
     *
     * @return an array of {@code float} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable float.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public float[] readFloatArray() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one line, separates it into tokens and converts them to
     * double-precision floating-point values.
     *
     * @return an array of {@code double} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable double.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public double[] readDoubleArray() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one line, separates it into tokens and converts them to character
     * values.
     *
     * @return an array of {@code char} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable character.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public char[] readCharArray() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one line, separates it into tokens and returns them as string
     * values.
     *
     * @return an array of {@code String} values read.
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public String[] readTokenArray() throws SvetovidIOException;

    /**
     * Reads one line, separates it into tokens and converts them to boolean
     * values.
     *
     * @return an array of {@code Boolean} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable boolean.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Boolean[] readBoolArrayBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one line, separates it into tokens and converts them to byte
     * values.
     *
     * @return an array of {@code Byte} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable byte.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Byte[] readByteArrayBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one line, separates it into tokens and converts them to short
     * integer values.
     *
     * @return an array of {@code Short} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable short.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Short[] readShortArrayBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one line, separates it into tokens and converts them to integer
     * values.
     *
     * @return an array of {@code Integer} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable integer.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Integer[] readIntArrayBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one line, separates it into tokens and converts them to long
     * integer values.
     *
     * @return an array of {@code Long} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable long.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Long[] readLongArrayBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one line, separates it into tokens and converts them to
     * floating-point values.
     *
     * @return an array of {@code Float} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable float.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Float[] readFloatArrayBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one line, separates it into tokens and converts them to
     * double-precision floating-point values.
     *
     * @return an array of {@code Double} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable double.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Double[] readDoubleArrayBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads one line, separates it into tokens and converts them to character
     * values.
     *
     * @return an array of {@code Character} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable character.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Character[] readCharArrayBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads a line of text and returns it as a string. A line is considered to
     * be terminated by any one of a line feed ('\n'), a carriage return ('\r'),
     * or a carriage return followed immediately by a line feed.
     *
     * @return A {@code String} containing the contents of the line, not
     *         including any line-termination characters, or null if the end of
     *         the source has been reached.
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public String readLine() throws SvetovidIOException;

    /**
     * Read all remaining lines and returns them as an array of strings. A line
     * is considered to be terminated by any one of a line feed ('\n'), a
     * carriage return ('\r'), or a carriage return followed immediately by a
     * line feed.
     *
     * @return A {@code String} array containing the contents of the remaining
     *         lines, not including any line-termination characters, or an empty
     *         array if the end of the source has been reached.
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public String[] readAllLines() throws SvetovidIOException;

    /**
     * Reads all remaining content and returns it as a string.
     *
     * @return A {@code String} containing all the remaining contents of the
     *         source, or null if the end of the source has been reached.
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public String readAll() throws SvetovidIOException;

    /**
     * Reads multiple lines and converts the data to a boolean matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached.
     *
     * @return a matrix of {@code boolean} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable boolean.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public boolean[][] readBoolMatrix() throws SvetovidFormatException,
            SvetovidIOException;;

    /**
     * Reads multiple lines and converts the data to a byte matrix. The matrix
     * is read row by row until an empty row is found or the end of input is
     * reached.
     *
     * @return a matrix of {@code byte} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable byte.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public byte[][] readByteMatrix() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads multiple lines and converts the data to a shot integer matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached.
     *
     * @return a matrix of {@code short} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable short.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public short[][] readShortMatrix() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads multiple lines and converts the data to an integer matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached.
     *
     * @return a matrix of {@code int} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable integer.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public int[][] readIntMatrix() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads multiple lines and converts the data to a long integer matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached.
     *
     * @return a matrix of {@code long} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable long.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public long[][] readLongMatrix() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads multiple lines and converts the data to a floating-point matrix.
     * The matrix is read row by row until an empty row is found or the end of
     * input is reached.
     *
     * @return a matrix of {@code float} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable float.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public float[][] readFloatMatrix() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads multiple lines and converts the data to a double-precision
     * floating-point matrix. The matrix is read row by row until an empty row
     * is found or the end of input is reached.
     *
     * @return a matrix of {@code double} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable double.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public double[][] readDoubleMatrix() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads multiple lines and converts the data to a character matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached.
     *
     * @return a matrix of {@code char} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable character.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public char[][] readCharMatrix() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads multiple lines and converts the data to a string matrix. The matrix
     * is read row by row until an empty row is found or the end of input is
     * reached.
     *
     * @return a matrix of {@code String} values read.
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public String[][] readTokenMatrix() throws SvetovidIOException;

    /**
     * Reads multiple lines and converts the data to a boolean matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached.
     *
     * @return a matrix of {@code Boolean} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable boolean.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Boolean[][] readBoolMatrixBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads multiple lines and converts the data to a byte matrix. The matrix
     * is read row by row until an empty row is found or the end of input is
     * reached.
     *
     * @return a matrix of {@code Byte} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable byte.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Byte[][] readByteMatrixBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads multiple lines and converts the data to a shot integer matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached.
     *
     * @return a matrix of {@code Short} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable short.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Short[][] readShortMatrixBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads multiple lines and converts the data to an integer matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached.
     *
     * @return a matrix of {@code Integer} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable integer.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Integer[][] readIntMatrixBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads multiple lines and converts the data to a long integer matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached.
     *
     * @return a matrix of {@code Long} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable long.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Long[][] readLongMatrixBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads multiple lines and converts the data to a floating-point matrix.
     * The matrix is read row by row until an empty row is found or the end of
     * input is reached.
     *
     * @return a matrix of {@code Float} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable float.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Float[][] readFloatMatrixBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads multiple lines and converts the data to a double-precision
     * floating-point matrix. The matrix is read row by row until an empty row
     * is found or the end of input is reached.
     *
     * @return a matrix of {@code Double} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable double.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Double[][] readDoubleMatrixBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads multiple lines and converts the data to a character matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached.
     *
     * @return a matrix of {@code Character} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable character.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Character[][] readCharMatrixBoxed() throws SvetovidFormatException,
            SvetovidIOException;

    /**
     * Reads a JSON (JavaScript Object Notation) formatted object.
     *
     * <p>
     * The object is converted to Java types using the following rules:
     * <ul>
     *
     * <li>literal {@code null} is converted to Java {@code null},</li>
     *
     * <li>literals {@code true} and {@code false} are converted to
     * {@link Boolean#TRUE} and {@link Boolean#FALSE} respectively,</li>
     *
     * <li>numbers are converted to an instance of the first numeric type from
     * the following list that can hold the value read: {@link Byte},
     * {@link Short}, {@link Integer}, {@link Long}, {@link Float},
     * {@link Double}, {@link java.math.BigInteger},
     * {@link java.math.BigDecimal},</li>
     *
     * <li>strings are converted to {@link String} values,
     *
     * <li>arrays are converted to {@link java.util.List}s containing the held
     * values in the same order
     *
     * <li>and objects are converted to {@link java.util.Map}s that can be
     * iterated in the order in which its members were defined. Each member's
     * value is registered in the map under its name.
     *
     * </ul>
     *
     * @return a Java Object parsed form the JSON format according to the above
     *         rules.
     *
     * @throws SvetovidFormatException
     *             if the object to be read is not in the JSON format.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Object readObject() throws SvetovidFormatException,
            SvetovidIOException;

}
