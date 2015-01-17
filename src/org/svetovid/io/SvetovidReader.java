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
     * Reads one token and converts it to a byte value.
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
     * Reads one token and converts it to a byte value.
     *
     * @return the {@code Character} value read.
     *
     * @exception NumberFormatException
     *                if the token is not a parsable character.
     */
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
