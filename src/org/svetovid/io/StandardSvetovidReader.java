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
import org.svetovid.SvetovidFormatException;

/**
 * This class provides an implementation of the {@link SvetovidReader} interface
 * that reads all input from the "standard" input (see {@link System#in}).
 *
 * <p>
 * Besides the implementation of the methods in the {@link SvetovidReader}
 * interface, this class provides additional overloaded methods that write the
 * given prompt string to the "standard" output before reading the requested
 * data form the "standard" input.
 *
 * @author Ivan Pribela
 *
 * @see System#in
 * @see SvetovidReader
 */
public class StandardSvetovidReader extends DefaultSvetovidReader {

    /**
     * Creates a new reader that reads all the input from the "standard" input.
     */
    public StandardSvetovidReader() {
        super(new StandardInputStreamProxy());
    }

    protected boolean readFromNewLine = System.getProperty("svetovid.readFromNewLine") != null;

    /**
     * Returns the indicator whether this reader will read input data from a new
     * line or immediately after the displayed prompt message.
     *
     * @return {@code true} if this reader reads data from a new line after the
     *         displayed prompt message; {@code false} if the data is read
     *         immediately after the prompt.
     */
    public boolean getReadFromNewLine() {
        return readFromNewLine;
    }

    /**
     * Configures whether this reader should read input data from a new line or
     * immediately after the displayed prompt.
     *
     * @param readFromNewLine
     *            {@code true} if this reader should read input data from a new
     *            line or {@code false} if it should do it immediately after the
     *            displayed prompt.
     */
    public void setReadFromNewLine(boolean readFromNewLine) {
        this.readFromNewLine = readFromNewLine;
    }

    protected void prompt(String prompt) throws SvetovidIOException {
        try {
            Svetovid.out.print(prompt);
            if (Svetovid.out.lastException != null) {
                throw Svetovid.out.lastException;
            }
            if (readFromNewLine) {
                Svetovid.out.println();
            } else {
                Svetovid.out.print();
            }
            if (Svetovid.out.lastException != null) {
                throw Svetovid.out.lastException;
            }
            Svetovid.out.printbf();
            if (Svetovid.out.lastException != null) {
                throw Svetovid.out.lastException;
            }
            lastException = null;
        } catch (SvetovidIOException e) {
            lastException = e;
            if (throwingExceptions) {
                throw e;
            }
        }
    }

    /**
     * Reads one token and converts it to a boolean value. Before reading any
     * data the specified prompt message is displayed to the user on the
     * "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return the {@code boolean} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable boolean.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public boolean readBool(String prompt) throws SvetovidFormatException,
            SvetovidIOException {
        prompt(prompt);
        return readBool();
    }

    /**
     * Reads one token and converts it to a byte value. Before reading any data
     * the specified prompt message is displayed to the user on the "standard"
     * output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return the {@code byte} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable byte.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public byte readByte(String prompt) throws SvetovidFormatException,
            SvetovidIOException {
        prompt(prompt);
        return readByte();
    }

    /**
     * Reads one token and converts it to a short integer value. Before reading
     * any data the specified prompt message is displayed to the user on the
     * "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return the {@code short} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable short.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public short readShort(String prompt) throws SvetovidFormatException,
            SvetovidIOException {
        prompt(prompt);
        return readShort();
    }

    /**
     * Reads one token and converts it to an integer value. Before reading any
     * data the specified prompt message is displayed to the user on the
     * "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return the {@code int} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable int.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public int readInt(String prompt) throws SvetovidFormatException,
            SvetovidIOException {
        prompt(prompt);
        return readInt();
    }

    /**
     * Reads one token and converts it to a long integer value. Before reading
     * any data the specified prompt message is displayed to the user on the
     * "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return the {@code long} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable long.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public long readLong(String prompt) throws SvetovidFormatException,
            SvetovidIOException {
        prompt(prompt);
        return readLong();
    }

    /**
     * Reads one token and converts it to a floating-point value. Before reading
     * any data the specified prompt message is displayed to the user on the
     * "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return the {@code float} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable float.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public float readFloat(String prompt) throws SvetovidFormatException,
            SvetovidIOException {
        prompt(prompt);
        return readFloat();
    }

    /**
     * Reads one token and converts it to a double-precision floating-point
     * value. Before reading any data the specified prompt message is displayed
     * to the user on the "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return the {@code double} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable double.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public double readDouble(String prompt) throws SvetovidFormatException,
            SvetovidIOException {
        prompt(prompt);
        return readDouble();
    }

    /**
     * Reads one token and converts it to a character value. Before reading any
     * data the specified prompt message is displayed to the user on the
     * "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return the {@code char} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable char.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public char readChar(String prompt) throws SvetovidFormatException,
            SvetovidIOException {
        prompt(prompt);
        return readChar();
    }

    /**
     * Reads one token and returns it as a string value. Before reading any data
     * the specified prompt message is displayed to the user on the "standard"
     * output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return the {@code String} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is {@code null}.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public String readToken(String prompt) throws SvetovidIOException {
        prompt(prompt);
        return readToken();
    }

    /**
     * Reads one token and converts it to a boolean value. Before reading any
     * data the specified prompt message is displayed to the user on the
     * "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return the {@code Boolean} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable boolean.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Boolean readBoolBoxed(String prompt) throws SvetovidFormatException,
            SvetovidIOException {
        prompt(prompt);
        return readBoolBoxed();
    }

    /**
     * Reads one token and converts it to a byte value. Before reading any data
     * the specified prompt message is displayed to the user on the "standard"
     * output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return the {@code Byte} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable byte.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Byte readByteBoxed(String prompt) throws SvetovidFormatException,
            SvetovidIOException {
        prompt(prompt);
        return readByteBoxed();
    }

    /**
     * Reads one token and converts it to a short integer value. Before reading
     * any data the specified prompt message is displayed to the user on the
     * "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return the {@code Short} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable short.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Short readShortBoxed(String prompt) throws SvetovidFormatException,
            SvetovidIOException {
        prompt(prompt);
        return readShortBoxed();
    }

    /**
     * Reads one token and converts it to an integer value. Before reading any
     * data the specified prompt message is displayed to the user on the
     * "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return the {@code Integer} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable int.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Integer readIntBoxed(String prompt) throws SvetovidFormatException,
            SvetovidIOException {
        prompt(prompt);
        return readIntBoxed();
    }

    /**
     * Reads one token and converts it to a long integer value. Before reading
     * any data the specified prompt message is displayed to the user on the
     * "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return the {@code Long} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable long.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Long readLongBoxed(String prompt) throws SvetovidFormatException,
            SvetovidIOException {
        prompt(prompt);
        return readLongBoxed();
    }

    /**
     * Reads one token and converts it to a floating-point value. Before reading
     * any data the specified prompt message is displayed to the user on the
     * "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return the {@code Float} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable float.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Float readFloatBoxed(String prompt) throws SvetovidFormatException,
            SvetovidIOException {
        prompt(prompt);
        return readFloatBoxed();
    }

    /**
     * Reads one token and converts it to a double-precision floating-point
     * value. Before reading any data the specified prompt message is displayed
     * to the user on the "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return the {@code Double} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable double.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Double readDoubleBoxed(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readDoubleBoxed();
    }

    /**
     * Reads one token and converts it to a character value. Before reading any
     * data the specified prompt message is displayed to the user on the
     * "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return the {@code Character} value read.
     *
     * @throws SvetovidFormatException
     *             if the token is not a parsable character.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Character readCharBoxed(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readCharBoxed();
    }

    /**
     * Reads one line, separates it into tokens and converts them to boolean
     * values. Before reading any data the specified prompt message is displayed
     * to the user on the "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return an array of {@code boolean} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable boolean.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public boolean[] readBoolArray(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readBoolArray();
    }

    /**
     * Reads one line, separates it into tokens and converts them to byte
     * values. Before reading any data the specified prompt message is displayed
     * to the user on the "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return an array of {@code byte} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable byte.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public byte[] readByteArray(String prompt) throws SvetovidFormatException,
            SvetovidIOException {
        prompt(prompt);
        return readByteArray();
    }

    /**
     * Reads one line, separates it into tokens and converts them to short
     * integer values. Before reading any data the specified prompt message is
     * displayed to the user on the "standard" output using {@link Svetovid#out}
     * .
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return an array of {@code short} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable short.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public short[] readShortArray(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readShortArray();
    }

    /**
     * Reads one line, separates it into tokens and converts them to integer
     * values. Before reading any data the specified prompt message is displayed
     * to the user on the "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return an array of {@code int} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable integer.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public int[] readIntArray(String prompt) throws SvetovidFormatException,
            SvetovidIOException {
        prompt(prompt);
        return readIntArray();
    }

    /**
     * Reads one line, separates it into tokens and converts them to long
     * integer values. Before reading any data the specified prompt message is
     * displayed to the user on the "standard" output using {@link Svetovid#out}
     * .
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return an array of {@code long} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable long.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public long[] readLongArray(String prompt) throws SvetovidFormatException,
            SvetovidIOException {
        prompt(prompt);
        return readLongArray();
    }

    /**
     * Reads one line, separates it into tokens and converts them to
     * floating-point values. Before reading any data the specified prompt
     * message is displayed to the user on the "standard" output using
     * {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return an array of {@code float} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable float.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public float[] readFloatArray(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readFloatArray();
    }

    /**
     * Reads one line, separates it into tokens and converts them to
     * double-precision floating-point values. Before reading any data the
     * specified prompt message is displayed to the user on the "standard"
     * output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return an array of {@code double} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable double.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public double[] readDoubleArray(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readDoubleArray();
    }

    /**
     * Reads one line, separates it into tokens and converts them to character
     * values. Before reading any data the specified prompt message is displayed
     * to the user on the "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return an array of {@code char} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable character.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public char[] readCharArray(String prompt) throws SvetovidFormatException,
            SvetovidIOException {
        prompt(prompt);
        return readCharArray();
    }

    /**
     * Reads one line, separates it into tokens and returns them as string
     * values. Before reading any data the specified prompt message is displayed
     * to the user on the "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return an array of {@code String} values read.
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public String[] readTokenArray(String prompt) throws SvetovidIOException {
        prompt(prompt);
        return readTokenArray();
    }

    /**
     * Reads one line, separates it into tokens and converts them to boolean
     * values. Before reading any data the specified prompt message is displayed
     * to the user on the "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return an array of {@code Boolean} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable boolean.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Boolean[] readBoolArrayBoxed(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readBoolArrayBoxed();
    }

    /**
     * Reads one line, separates it into tokens and converts them to byte
     * values. Before reading any data the specified prompt message is displayed
     * to the user on the "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return an array of {@code Byte} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable byte.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Byte[] readByteArrayBoxed(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readByteArrayBoxed();
    }

    /**
     * Reads one line, separates it into tokens and converts them to short
     * integer values. Before reading any data the specified prompt message is
     * displayed to the user on the "standard" output using {@link Svetovid#out}
     * .
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return an array of {@code Short} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable short.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Short[] readShortArrayBoxed(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readShortArrayBoxed();
    }

    /**
     * Reads one line, separates it into tokens and converts them to integer
     * values. Before reading any data the specified prompt message is displayed
     * to the user on the "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return an array of {@code Integer} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable integer.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Integer[] readIntArrayBoxed(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readIntArrayBoxed();
    }

    /**
     * Reads one line, separates it into tokens and converts them to long
     * integer values. Before reading any data the specified prompt message is
     * displayed to the user on the "standard" output using {@link Svetovid#out}
     * .
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return an array of {@code Long} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable long.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Long[] readLongArrayBoxed(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readLongArrayBoxed();
    }

    /**
     * Reads one line, separates it into tokens and converts them to
     * floating-point values. Before reading any data the specified prompt
     * message is displayed to the user on the "standard" output using
     * {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return an array of {@code Float} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable float.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Float[] readFloatArrayBoxed(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readFloatArrayBoxed();
    }

    /**
     * Reads one line, separates it into tokens and converts them to
     * double-precision floating-point values. Before reading any data the
     * specified prompt message is displayed to the user on the "standard"
     * output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return an array of {@code Double} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable double.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Double[] readDoubleArrayBoxed(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readDoubleArrayBoxed();
    }

    /**
     * Reads one line, separates it into tokens and converts them to character
     * values. Before reading any data the specified prompt message is displayed
     * to the user on the "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return an array of {@code Character} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the tokens is not a parsable character.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Character[] readCharArrayBoxed(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readCharArrayBoxed();
    }

    /**
     * Reads a line of text and returns it as a string. Before reading any data
     * the specified prompt message is displayed to the user on the "standard"
     * output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return A {@code String} containing the contents of the line, not
     *         including any line-termination characters, or null if the end of
     *         the source has been reached.
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public String readLine(String prompt) throws SvetovidIOException {
        prompt(prompt);
        return readLine();
    }

    /**
	 * Reads a line of text and returns it as a string. Before reading any data the
	 * specified prompt message is displayed to the user on the "standard" output
	 * using {@link Svetovid#out}. If an empty string is read, the
	 * {@code defaultValue} is returned.
	 *
	 * @param prompt
	 *            the message to prompt to the user
	 * @param defaultValue
	 *            the value to return if nothing is entered
	 *
	 * @return A {@code String} containing the contents of the line, not including
	 *         any line-termination characters, null if the end of the source has
	 *         been reached, or {@code defaultValue} if the line was empty.
	 *
	 * @throws SvetovidIOException
	 *             if an error occurred during the operation.
	 */
    public String readLine(String prompt, String defaultValue) throws SvetovidIOException {
        prompt(prompt);
        String value = readLine();
        if (value != null && value.isEmpty()) {
        	value = defaultValue;
        }
        return value;
    }

    /**
     * Read all remaining lines and returns them as an array of strings. Before
     * reading any data the specified prompt message is displayed to the user on
     * the "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return A {@code String} array containing the contents of the remaining
     *         lines, not including any line-termination characters, or an empty
     *         array if the end of the source has been reached.
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public String[] readAllLines(String prompt) throws SvetovidIOException {
        prompt(prompt);
        return readAllLines();
    }

    /**
     * Reads all remaining content and returns it as a string. Before reading
     * any content the specified prompt message is displayed to the user on the
     * "standard" output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return A {@code String} containing all the remaining contents of the
     *         source, or null if the end of the source has been reached.
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public String readAll(String prompt) throws SvetovidIOException {
        prompt(prompt);
        return readAll();
    }

    /**
     * Reads multiple lines and converts the data to a boolean matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached. Before reading any data the specified prompt message is
     * displayed to the user on the "standard" output using {@link Svetovid#out}
     * .
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return a matrix of {@code boolean} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable boolean.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public boolean[][] readBoolMatrix(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readBoolMatrix();
    }

    /**
     * Reads multiple lines and converts the data to a byte matrix. The matrix
     * is read row by row until an empty row is found or the end of input is
     * reached. Before reading any data the specified prompt message is
     * displayed to the user on the "standard" output using {@link Svetovid#out}
     * .
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return a matrix of {@code byte} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable byte.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public byte[][] readByteMatrix(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readByteMatrix();
    }

    /**
     * Reads multiple lines and converts the data to a shot integer matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached. Before reading any data the specified prompt message is
     * displayed to the user on the "standard" output using {@link Svetovid#out}
     * .
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return a matrix of {@code short} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable short.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public short[][] readShortMatrix(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readShortMatrix();
    }

    /**
     * Reads multiple lines and converts the data to an integer matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached. Before reading any data the specified prompt message is
     * displayed to the user on the "standard" output using {@link Svetovid#out}
     * .
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return a matrix of {@code int} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable integer.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public int[][] readIntMatrix(String prompt) throws SvetovidFormatException,
            SvetovidIOException {
        prompt(prompt);
        return readIntMatrix();
    }

    /**
     * Reads multiple lines and converts the data to a long integer matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached. Before reading any data the specified prompt message is
     * displayed to the user on the "standard" output using {@link Svetovid#out}
     * .
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return a matrix of {@code long} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable long.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public long[][] readLongMatrix(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readLongMatrix();
    }

    /**
     * Reads multiple lines and converts the data to a floating-point matrix.
     * The matrix is read row by row until an empty row is found or the end of
     * input is reached. Before reading any data the specified prompt message is
     * displayed to the user on the "standard" output using {@link Svetovid#out}
     * .
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return a matrix of {@code float} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable float.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public float[][] readFloatMatrix(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readFloatMatrix();
    }

    /**
     * Reads multiple lines and converts the data to a double-precision
     * floating-point matrix. The matrix is read row by row until an empty row
     * is found or the end of input is reached. Before reading any data the
     * specified prompt message is displayed to the user on the "standard"
     * output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return a matrix of {@code double} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable double.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public double[][] readDoubleMatrix(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readDoubleMatrix();
    }

    /**
     * Reads multiple lines and converts the data to a character matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached. Before reading any data the specified prompt message is
     * displayed to the user on the "standard" output using {@link Svetovid#out}
     * .
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return a matrix of {@code char} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable character.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public char[][] readCharMatrix(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readCharMatrix();
    }

    /**
     * Reads multiple lines and converts the data to a string matrix. The matrix
     * is read row by row until an empty row is found or the end of input is
     * reached. Before reading any data the specified prompt message is
     * displayed to the user on the "standard" output using {@link Svetovid#out}
     * .
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return a matrix of {@code String} values read.
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public String[][] readTokenMatrix(String prompt)
            throws SvetovidIOException {
        prompt(prompt);
        return readTokenMatrix();
    }

    /**
     * Reads multiple lines and converts the data to a boolean matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached. Before reading any data the specified prompt message is
     * displayed to the user on the "standard" output using {@link Svetovid#out}
     * .
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return a matrix of {@code Boolean} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable boolean.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Boolean[][] readBoolMatrixBoxed(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readBoolMatrixBoxed();
    }

    /**
     * Reads multiple lines and converts the data to a byte matrix. The matrix
     * is read row by row until an empty row is found or the end of input is
     * reached. Before reading any data the specified prompt message is
     * displayed to the user on the "standard" output using {@link Svetovid#out}
     * .
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return a matrix of {@code Byte} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable byte.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Byte[][] readByteMatrixBoxed(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readByteMatrixBoxed();
    }

    /**
     * Reads multiple lines and converts the data to a shot integer matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached. Before reading any data the specified prompt message is
     * displayed to the user on the "standard" output using {@link Svetovid#out}
     * .
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return a matrix of {@code Short} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable short.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Short[][] readShortMatrixBoxed(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readShortMatrixBoxed();
    }

    /**
     * Reads multiple lines and converts the data to an integer matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached. Before reading any data the specified prompt message is
     * displayed to the user on the "standard" output using {@link Svetovid#out}
     * .
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return a matrix of {@code Integer} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable integer.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Integer[][] readIntMatrixBoxed(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readIntMatrixBoxed();
    }

    /**
     * Reads multiple lines and converts the data to a long integer matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached. Before reading any data the specified prompt message is
     * displayed to the user on the "standard" output using {@link Svetovid#out}
     * .
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return a matrix of {@code Long} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable long.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Long[][] readLongMatrixBoxed(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readLongMatrixBoxed();
    }

    /**
     * Reads multiple lines and converts the data to a floating-point matrix.
     * The matrix is read row by row until an empty row is found or the end of
     * input is reached. Before reading any data the specified prompt message is
     * displayed to the user on the "standard" output using {@link Svetovid#out}
     * .
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return a matrix of {@code Float} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable float.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Float[][] readFloatMatrixBoxed(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readFloatMatrixBoxed();
    }

    /**
     * Reads multiple lines and converts the data to a double-precision
     * floating-point matrix. The matrix is read row by row until an empty row
     * is found or the end of input is reached. Before reading any data the
     * specified prompt message is displayed to the user on the "standard"
     * output using {@link Svetovid#out}.
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return a matrix of {@code Double} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable double.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Double[][] readDoubleMatrixBoxed(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readDoubleMatrixBoxed();
    }

    /**
     * Reads multiple lines and converts the data to a character matrix. The
     * matrix is read row by row until an empty row is found or the end of input
     * is reached. Before reading any data the specified prompt message is
     * displayed to the user on the "standard" output using {@link Svetovid#out}
     * .
     *
     * @param prompt
     *            the message to prompt to the user
     *
     * @return a matrix of {@code Character} values read.
     *
     * @throws SvetovidFormatException
     *             if one of the read values is not a parsable character.
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public Character[][] readCharMatrixBoxed(String prompt)
            throws SvetovidFormatException, SvetovidIOException {
        prompt(prompt);
        return readCharMatrixBoxed();
    }
}
