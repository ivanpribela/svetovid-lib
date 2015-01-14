package org.svetovid.io;

import java.io.IOException;

/**
 * This interface provides methods that simplify outputting data for beginner
 * programmers. Exception handling is not necessary as all operations are
 * returning default values on any errors. If necessary, the last raised
 * exception can be retrieved using {@link getLastException()} method.
 */
public interface SvetovidWriter {

    /**
     * Returns the currently used whitespace. This whitespace is written by
     * methods like {@link write()} and {@link writeln(Object[])}.
     *
     * @return the string currently used as whitespace.
     */
    public String getWhitespace();

    /**
     * Sets the string used as whitespace. This whitespace is written by methods
     * like {@link write()} and {@link writeln(Object[])}.
     *
     * @param whitespace
     *            the string to use as whitespace
     */
    public void setWhitespace(String whitespace);

    /**
     * Returns whether this writer automatically flushes the underlying output
     * stream and forces any buffered output bytes to be written out after every
     * operation by calling {@link writebf()}.
     */
    public boolean getAutoFlush();

    /**
     * Configures whether this writer should automatically flush the underlying
     * output stream and force any buffered output bytes to be written out after
     * every operation by calling {@link writebf()}.
     *
     * @param autoFlush
     *            if {@code true} this writer will call {@link writebf()} after
     *            every operation
     */
    public void setAutoFlush(boolean autoFlush);

    /**
     * Returns the exception raised in the last operation; if the operation was
     * successful and no exception was raised, returns {@code null}.
     *
     * @return the exception raised in the last operation or {@code null} it the
     *         operation was successful.
     */
    public IOException getLastException();

    /**
     * Closes this writer and releases any resources associated with the
     * underlying stream. The general contract of {@code close} is that it
     * closes the output stream. A closed stream cannot perform output
     * operations and cannot be reopened.
     */
    public void close();

    /**
     * Writes a boolean value as a human readable string.
     *
     * @param value
     *            The {@code boolean} value to be written
     */
    public void write(boolean value);

    /**
     * Writes a byte value as a human readable string.
     *
     * @param value
     *            The {@code byte} value to be written
     */
    public void write(byte value);

    /**
     * Writes a short integer value as a human readable string.
     *
     * @param value
     *            The {@code short} value to be written
     */
    public void write(short value);

    /**
     * Writes an integer value as a human readable string.
     *
     * @param value
     *            The {@code integer} value to be written
     */
    public void write(int value);

    /**
     * Writes a long integer value as a human readable string.
     *
     * @param value
     *            The {@code long} value to be written
     */
    public void write(long value);

    /**
     * Writes a floating-point value as a human readable string.
     *
     * @param value
     *            The {@code float} value to be written
     */
    public void write(float value);

    /**
     * Writes a double-precision floating-point value as a human readable
     * string.
     *
     * @param value
     *            The {@code double} value to be written
     */
    public void write(double value);

    /**
     * Writes a character value as a human readable string.
     *
     * @param value
     *            The {@code character} value to be written
     */
    public void write(char value);

    /**
     * Writes a string. If the argument is {@code null} then the string
     * {@code "null"} is printed.
     *
     * @param value
     *            The {@code String} value to be written
     */
    public void write(String value);

    /**
     * Writes an object as a human readable string.
     *
     * @param value
     *            The {@code Object} to be written
     */
    public void write(Object value);

    /**
     * Writes a whitespace.
     */
    public void write();

    /**
     * Writes any buffered data to the underlying output stream and then flushes
     * that stream.
     */
    public void writebf();

    /**
     * Writes a boolean value and then terminates the line. This method behaves
     * as though it invokes {@link #write(boolean)} and then {@link #writeln()}.
     *
     * @param value
     *            The {@code boolean} value to be written
     */
    public void writeln(boolean value);

    /**
     * Writes a byte value and then terminates the line. This method behaves as
     * though it invokes {@link #write(byte)} and then {@link #writeln()}.
     *
     * @param value
     *            The {@code byte} value to be written
     */
    public void writeln(byte value);

    /**
     * Writes a short integer value and then terminates the line. This method
     * behaves as though it invokes {@link #write(short)} and then
     * {@link #writeln()}.
     *
     * @param value
     *            The {@code short} value to be written
     */
    public void writeln(short value);

    /**
     * Writes an integer value and then terminates the line. This method behaves
     * as though it invokes {@link #write(int)} and then {@link #writeln()}.
     *
     * @param value
     *            The {@code integer} value to be written
     */
    public void writeln(int value);

    /**
     * Writes a long integer value and then terminates the line. This method
     * behaves as though it invokes {@link #write(long)} and then
     * {@link #writeln()}.
     *
     * @param value
     *            The {@code long} value to be written
     */
    public void writeln(long value);

    /**
     * Writes a floating-point value and then terminates the line. This method
     * behaves as though it invokes {@link #write(float)} and then
     * {@link #writeln()}. {@link #writeln()}.
     *
     * @param value
     *            The {@code float} value to be written
     */
    public void writeln(float value);

    /**
     * Writes a double-precision floating-point value and then terminates the
     * line. This method behaves as though it invokes {@link #write(double)} and
     * then {@link #writeln()}.
     *
     * @param value
     *            The {@code double} value to be written
     */
    public void writeln(double value);

    /**
     * Writes a character value and then terminates the line. This method
     * behaves as though it invokes {@link #write(char)} and then
     * {@link #writeln()}.
     *
     * @param value
     *            The {@code character} value to be written
     */
    public void writeln(char value);

    /**
     * Writes a string and then terminates the line. This method behaves as
     * though it invokes {@link #write(String)} and then {@link #writeln()}.
     *
     * @param value
     *            The {@code String} value to be written
     */
    public void writeln(String value);

    /**
     * Writes an object and then terminates the line. This method behaves as
     * though it invokes {@link #write(Object)} and then {@link #writeln()}.
     *
     * @param value
     *            The {@code Object} to be written
     */
    public void writeln(Object value);

    /**
     * Writes a line separator as defined by the {@code line.separator} system
     * property.
     */
    public void writeln();

    /**
     * Writes all given boolean values in sequence separated by whitespace and
     * then terminates the line. This method behaves as though it invokes
     * {@link #write(boolean)} for each of the given values invoking
     * {@link #write()} inbetween and {@link #writeln()} at the end.
     *
     * @param values
     *            The {@code boolean} values to be written
     */
    public void writeln(boolean... values);

    /**
     * Writes all given byte values in sequence separated by whitespace and then
     * terminates the line. This method behaves as though it invokes
     * {@link #write(byte)} for each of the given values invoking
     * {@link #write()} inbetween and {@link #writeln()} at the end.
     *
     * @param values
     *            The {@code byte} values to be written
     */
    public void writeln(byte... values);

    /**
     * Writes all given short integer values in sequence separated by whitespace
     * and then terminates the line. This method behaves as though it invokes
     * {@link #write(short)} for each of the given values invoking
     * {@link #write()} inbetween and {@link #writeln()} at the end.
     *
     * @param values
     *            The {@code short} values to be written
     */
    public void writeln(short... values);

    /**
     * Writes all given integer values in sequence separated by whitespace and
     * then terminates the line. This method behaves as though it invokes
     * {@link #write(int)} for each of the given values invoking
     * {@link #write()} inbetween and {@link #writeln()} at the end.
     *
     * @param values
     *            The {@code int} values to be written
     */
    public void writeln(int... values);

    /**
     * Writes all given long integer values in sequence separated by whitespace
     * and then terminates the line. This method behaves as though it invokes
     * {@link #write(long)} for each of the given values invoking
     * {@link #write()} inbetween and {@link #writeln()} at the end.
     *
     * @param values
     *            The {@code long} values to be written
     */
    public void writeln(long... values);

    /**
     * Writes all given floating-point values in sequence separated by
     * whitespace and then terminates the line. This method behaves as though it
     * invokes {@link #write(float)} for each of the given values invoking
     * {@link #write()} inbetween and {@link #writeln()} at the end.
     *
     * @param values
     *            The {@code float} values to be written
     */
    public void writeln(float... values);

    /**
     * Writes all given double-precision floating-point values in sequence
     * separated by whitespace and then terminates the line. This method behaves
     * as though it invokes {@link #write(double)} for each of the given values
     * invoking {@link #write()} inbetween and {@link #writeln()} at the end.
     *
     * @param values
     *            The {@code double} values to be written
     */
    public void writeln(double... values);

    /**
     * Writes all given character values in sequence separated by whitespace and
     * then terminates the line. This method behaves as though it invokes
     * {@link #write(char)} for each of the given values invoking
     * {@link #write()} inbetween and {@link #writeln()} at the end.
     *
     * @param values
     *            The {@code char} values to be written
     */
    public void writeln(char... values);

    /**
     * Writes all given boolean values in sequence separated by whitespace and
     * then terminates the line. This method behaves as though it invokes
     * {@link #writeln(Object[])}.
     *
     * @param values
     *            The {@code Boolean} values to be written
     */
    public void writeln(Boolean... values);

    /**
     * Writes all given bute values in sequence separated by whitespace and then
     * terminates the line. This method behaves as though it invokes
     * {@link #writeln(Object[])}.
     *
     * @param values
     *            The {@code Byte} values to be written
     */
    public void writeln(Byte... values);

    /**
     * Writes all given short integer values in sequence separated by whitespace
     * and then terminates the line. This method behaves as though it invokes
     * {@link #writeln(Object[])}.
     *
     * @param values
     *            The {@code Short} values to be written
     */
    public void writeln(Short... values);

    /**
     * Writes all given integer values in sequence separated by whitespace and
     * then terminates the line. This method behaves as though it invokes
     * {@link #writeln(Object[])}.
     *
     * @param values
     *            The {@code Ineger} values to be written
     */
    public void writeln(Integer... values);

    /**
     * Writes all given long integer values in sequence separated by whitespace
     * and then terminates the line. This method behaves as though it invokes
     * {@link #writeln(Object[])}.
     *
     * @param values
     *            The {@code Long} values to be written
     */
    public void writeln(Long... values);

    /**
     * Writes all given floating-point values in sequence separated by
     * whitespace and then terminates the line. This method behaves as though it
     * invokes {@link #writeln(Object[])}.
     *
     * @param values
     *            The {@code Float} values to be written
     */
    public void writeln(Float... values);

    /**
     * Writes all given double-precision floating-point values in sequence
     * separated by whitespace and then terminates the line. This method behaves
     * as though it invokes {@link #writeln(Object[])}.
     *
     * @param values
     *            The {@code Double} values to be written
     */
    public void writeln(Double... values);

    /**
     * Writes all given character values in sequence separated by whitespace and
     * then terminates the line. This method behaves as though it invokes
     * {@link #writeln(Object[])}.
     *
     * @param values
     *            The {@code Character} values to be written
     */
    public void writeln(Character... values);

    /**
     * Writes all given string values in sequence separated by whitespace and
     * then terminates the line. This method behaves as though it invokes
     * {@link #write(String)} for each of the given values invoking
     * {@link #write()} inbetween and {@link #writeln()} at the end.
     *
     * @param values
     *            The {@code String} values to be written
     */
    public void writeln(String... values);

    /**
     * Writes all given objects in sequence separated by whitespace and then
     * terminates the line. This method behaves as though it invokes
     * {@link #write(Object)} for each of the given values invoking
     * {@link #write()} inbetween and {@link #writeln()} at the end.
     *
     * @param values
     *            The {@code Object} values to be written
     */
    public void writeln(Object... values);

    /**
     * Writes the given boolean matrix row by row, each in the separate line,
     * with the individual elements separated by whitespace.
     *
     * @param values
     *            The {@code boolean} matrix to be written
     */
    public void writeln(boolean[][] values);

    /**
     * Writes the given byte matrix row by row, each in the separate line, with
     * the individual elements separated by whitespace.
     *
     * @param values
     *            The {@code byte} matrix to be written
     */
    public void writeln(byte[][] values);

    /**
     * Writes the given short integer matrix row by row, each in the separate
     * line, with the individual elements separated by whitespace.
     *
     * @param values
     *            The {@code short} matrix to be written
     */
    public void writeln(short[][] values);

    /**
     * Writes the given integer matrix row by row, each in the separate line,
     * with the individual elements separated by whitespace.
     *
     * @param values
     *            The {@code int} matrix to be written
     */
    public void writeln(int[][] values);

    /**
     * Writes the given long integer matrix row by row, each in the separate
     * line, with the individual elements separated by whitespace.
     *
     * @param values
     *            The {@code long} matrix to be written
     */
    public void writeln(long[][] values);

    /**
     * Writes the given floating-point matrix row by row, each in the separate
     * line, with the individual elements separated by whitespace.
     *
     * @param values
     *            The {@code float} matrix to be written
     */
    public void writeln(float[][] values);

    /**
     * Writes the given double-precision floating-point matrix row by row, each
     * in the separate line, with the individual elements separated by
     * whitespace.
     *
     * @param values
     *            The {@code double} matrix to be written
     */
    public void writeln(double[][] values);

    /**
     * Writes the given character matrix row by row, each in the separate line,
     * with the individual elements separated by whitespace.
     *
     * @param values
     *            The {@code char} matrix to be written
     */
    public void writeln(char[][] values);

    /**
     * Writes the given boolean matrix row by row, each in the separate line,
     * with the individual elements separated by whitespace.
     *
     * @param values
     *            The {@code Boolean} matrix to be written
     */
    public void writeln(Boolean[][] values);

    /**
     * Writes the given byte matrix row by row, each in the separate line, with
     * the individual elements separated by whitespace.
     *
     * @param values
     *            The {@code Byte} matrix to be written
     */
    public void writeln(Byte[][] value);

    /**
     * Writes the given short integer matrix row by row, each in the separate
     * line, with the individual elements separated by whitespace.
     *
     * @param values
     *            The {@code Short} matrix to be written
     */
    public void writeln(Short[][] values);

    /**
     * Writes the given integer matrix row by row, each in the separate line,
     * with the individual elements separated by whitespace.
     *
     * @param values
     *            The {@code Integer} matrix to be written
     */
    public void writeln(Integer[][] values);

    /**
     * Writes the given long integer matrix row by row, each in the separate
     * line, with the individual elements separated by whitespace.
     *
     * @param values
     *            The {@code Long} matrix to be written
     */
    public void writeln(Long[][] values);

    /**
     * Writes the given floating-point matrix row by row, each in the separate
     * line, with the individual elements separated by whitespace.
     *
     * @param values
     *            The {@code Float} matrix to be written
     */
    public void writeln(Float[][] values);

    /**
     * Writes the given double-precision floating-point matrix row by row, each
     * in the separate line, with the individual elements separated by
     * whitespace.
     *
     * @param values
     *            The {@code Double} matrix to be written
     */
    public void writeln(Double[][] values);

    /**
     * Writes the given character matrix row by row, each in the separate line,
     * with the individual elements separated by whitespace.
     *
     * @param values
     *            The {@code Character} matrix to be written
     */
    public void writeln(Character[][] values);

    /**
     * Writes the given string matrix row by row, each in the separate line,
     * with the individual elements separated by whitespace.
     *
     * @param values
     *            The {@code String} matrix to be written
     */
    public void writeln(String[][] values);

    /**
     * Writes the given object matrix row by row, each in the separate line,
     * with the individual elements separated by whitespace.
     *
     * @param values
     *            The {@code Object} matrix to be written
     */
    public void writeln(Object[][] values);

}
