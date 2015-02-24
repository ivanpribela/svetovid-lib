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

/**
 * This interface provides methods that simplify outputting data for beginner
 * programmers. Exception handling is not necessary as it can be turned on or
 * off by using {@link #setThrowingExceptions(boolean)}. Even when the exception
 * throwing is turned off, if necessary, the last raised exception can be
 * retrieved using {@link #getLastException()} method.
 */
public interface SvetovidWriter {

    /**
     * Returns the currently used whitespace. This whitespace is written by
     * methods like {@link #print()} and {@link #println(Object[])}.
     *
     * @return the string currently used as whitespace.
     */
    public String getWhitespace();

    /**
     * Sets the string used as whitespace. This whitespace is written by methods
     * like {@link #print()} and {@link #println(Object[])}.
     *
     * @param whitespace
     *            the string to use as whitespace
     */
    public void setWhitespace(String whitespace);

    /**
     * Returns whether this writer automatically flushes the underlying output
     * stream and forces any buffered output bytes to be written out after every
     * operation by calling {@link #printbf()}.
     *
     * @return {@code true} if this writer automatically flushes the underlying
     *         output stream; {@code false} otherwise.
     */
    public boolean getAutoFlush();

    /**
     * Configures whether this writer should automatically flush the underlying
     * output stream and force any buffered output bytes to be written out after
     * every operation by calling {@link #printbf()}.
     *
     * @param autoFlush
     *            if {@code true} this writer will call {@link #printbf()} after
     *            every operation
     */
    public void setAutoFlush(boolean autoFlush);

    /**
     * Returns the indicator whether this writer will throw exceptions on I/O
     * operation errors or just return default values.
     *
     * @return {@code true} if this writer throws exceptions on failed I/O
     *         operations; {@code false} otherwise.
     */
    public boolean isThrowingExceptions();

    /**
     * Configures whether this writer should throw exceptions on I/O operation
     * errors or just return default values.
     *
     * @param shouldThrow
     *            {@code true} if this writer should throw exceptions on failed
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
     * Closes this writer and releases any resources associated with the
     * underlying stream. The general contract of {@code close} is that it
     * closes the output stream. A closed stream cannot perform output
     * operations and cannot be reopened.
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void close() throws SvetovidIOException;

    /**
     * Prints a boolean value as a human readable string.
     *
     * @param value
     *            The {@code boolean} value to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void print(boolean value) throws SvetovidIOException;

    /**
     * Prints a byte value as a human readable string.
     *
     * @param value
     *            The {@code byte} value to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void print(byte value) throws SvetovidIOException;

    /**
     * Prints a short integer value as a human readable string.
     *
     * @param value
     *            The {@code short} value to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void print(short value) throws SvetovidIOException;

    /**
     * Prints an integer value as a human readable string.
     *
     * @param value
     *            The {@code integer} value to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void print(int value) throws SvetovidIOException;

    /**
     * Prints a long integer value as a human readable string.
     *
     * @param value
     *            The {@code long} value to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void print(long value) throws SvetovidIOException;

    /**
     * Prints a floating-point value as a human readable string.
     *
     * @param value
     *            The {@code float} value to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void print(float value) throws SvetovidIOException;

    /**
     * Prints a double-precision floating-point value as a human readable
     * string.
     *
     * @param value
     *            The {@code double} value to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void print(double value) throws SvetovidIOException;

    /**
     * Prints a character value as a human readable string.
     *
     * @param value
     *            The {@code character} value to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void print(char value) throws SvetovidIOException;

    /**
     * Prints a string. If the argument is {@code null} then the string
     * {@code "null"} is printed.
     *
     * @param value
     *            The {@code String} value to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void print(String value) throws SvetovidIOException;

    /**
     * Prints an object as a human readable string.
     *
     * @param value
     *            The {@code Object} to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void print(Object value) throws SvetovidIOException;

    /**
     * Prints a whitespace.
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void print() throws SvetovidIOException;

    /**
     * Prints any buffered data to the underlying output stream and then flushes
     * that stream.
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void printbf() throws SvetovidIOException;

    /**
     * Prints a boolean value and then terminates the line. This method behaves
     * as though it invokes {@link #print(boolean)} and then {@link #println()}.
     *
     * @param value
     *            The {@code boolean} value to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(boolean value) throws SvetovidIOException;

    /**
     * Prints a byte value and then terminates the line. This method behaves as
     * though it invokes {@link #print(byte)} and then {@link #println()}.
     *
     * @param value
     *            The {@code byte} value to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(byte value) throws SvetovidIOException;

    /**
     * Prints a short integer value and then terminates the line. This method
     * behaves as though it invokes {@link #print(short)} and then
     * {@link #println()}.
     *
     * @param value
     *            The {@code short} value to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(short value) throws SvetovidIOException;

    /**
     * Prints an integer value and then terminates the line. This method behaves
     * as though it invokes {@link #print(int)} and then {@link #println()}.
     *
     * @param value
     *            The {@code integer} value to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(int value) throws SvetovidIOException;

    /**
     * Prints a long integer value and then terminates the line. This method
     * behaves as though it invokes {@link #print(long)} and then
     * {@link #println()}.
     *
     * @param value
     *            The {@code long} value to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(long value) throws SvetovidIOException;

    /**
     * Prints a floating-point value and then terminates the line. This method
     * behaves as though it invokes {@link #print(float)} and then
     * {@link #println()}. {@link #println()}.
     *
     * @param value
     *            The {@code float} value to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(float value) throws SvetovidIOException;

    /**
     * Prints a double-precision floating-point value and then terminates the
     * line. This method behaves as though it invokes {@link #print(double)} and
     * then {@link #println()}.
     *
     * @param value
     *            The {@code double} value to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(double value) throws SvetovidIOException;

    /**
     * Prints a character value and then terminates the line. This method
     * behaves as though it invokes {@link #print(char)} and then
     * {@link #println()}.
     *
     * @param value
     *            The {@code character} value to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(char value) throws SvetovidIOException;

    /**
     * Prints a string and then terminates the line. This method behaves as
     * though it invokes {@link #print(String)} and then {@link #println()}.
     *
     * @param value
     *            The {@code String} value to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(String value) throws SvetovidIOException;

    /**
     * Prints an object and then terminates the line. This method behaves as
     * though it invokes {@link #print(Object)} and then {@link #println()}.
     *
     * @param value
     *            The {@code Object} to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(Object value) throws SvetovidIOException;

    /**
     * Prints a line separator as defined by the {@code line.separator} system
     * property.
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println() throws SvetovidIOException;

    /**
     * Prints all given boolean values in sequence separated by whitespace and
     * then terminates the line. This method behaves as though it invokes
     * {@link #print(boolean)} for each of the given values invoking
     * {@link #print()} in-between and {@link #println()} at the end.
     *
     * @param values
     *            The {@code boolean} values to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(boolean... values) throws SvetovidIOException;

    /**
     * Prints all given byte values in sequence separated by whitespace and then
     * terminates the line. This method behaves as though it invokes
     * {@link #print(byte)} for each of the given values invoking
     * {@link #print()} in-between and {@link #println()} at the end.
     *
     * @param values
     *            The {@code byte} values to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(byte... values) throws SvetovidIOException;

    /**
     * Prints all given short integer values in sequence separated by whitespace
     * and then terminates the line. This method behaves as though it invokes
     * {@link #print(short)} for each of the given values invoking
     * {@link #print()} in-between and {@link #println()} at the end.
     *
     * @param values
     *            The {@code short} values to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(short... values) throws SvetovidIOException;

    /**
     * Prints all given integer values in sequence separated by whitespace and
     * then terminates the line. This method behaves as though it invokes
     * {@link #print(int)} for each of the given values invoking
     * {@link #print()} in-between and {@link #println()} at the end.
     *
     * @param values
     *            The {@code int} values to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(int... values) throws SvetovidIOException;

    /**
     * Prints all given long integer values in sequence separated by whitespace
     * and then terminates the line. This method behaves as though it invokes
     * {@link #print(long)} for each of the given values invoking
     * {@link #print()} in-between and {@link #println()} at the end.
     *
     * @param values
     *            The {@code long} values to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(long... values) throws SvetovidIOException;

    /**
     * Prints all given floating-point values in sequence separated by
     * whitespace and then terminates the line. This method behaves as though it
     * invokes {@link #print(float)} for each of the given values invoking
     * {@link #print()} in-between and {@link #println()} at the end.
     *
     * @param values
     *            The {@code float} values to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(float... values) throws SvetovidIOException;

    /**
     * Prints all given double-precision floating-point values in sequence
     * separated by whitespace and then terminates the line. This method behaves
     * as though it invokes {@link #print(double)} for each of the given values
     * invoking {@link #print()} in-between and {@link #println()} at the end.
     *
     * @param values
     *            The {@code double} values to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(double... values) throws SvetovidIOException;

    /**
     * Prints all given character values in sequence separated by whitespace and
     * then terminates the line. This method behaves as though it invokes
     * {@link #print(char)} for each of the given values invoking
     * {@link #print()} in-between and {@link #println()} at the end.
     *
     * @param values
     *            The {@code char} values to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(char... values) throws SvetovidIOException;

    /**
     * Prints all given boolean values in sequence separated by whitespace and
     * then terminates the line. This method behaves as though it invokes
     * {@link #println(Object[])}.
     *
     * @param values
     *            The {@code Boolean} values to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(Boolean... values) throws SvetovidIOException;

    /**
     * Prints all given byte values in sequence separated by whitespace and then
     * terminates the line. This method behaves as though it invokes
     * {@link #println(Object[])}.
     *
     * @param values
     *            The {@code Byte} values to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(Byte... values) throws SvetovidIOException;

    /**
     * Prints all given short integer values in sequence separated by whitespace
     * and then terminates the line. This method behaves as though it invokes
     * {@link #println(Object[])}.
     *
     * @param values
     *            The {@code Short} values to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(Short... values) throws SvetovidIOException;

    /**
     * Prints all given integer values in sequence separated by whitespace and
     * then terminates the line. This method behaves as though it invokes
     * {@link #println(Object[])}.
     *
     * @param values
     *            The {@code Integer} values to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(Integer... values) throws SvetovidIOException;

    /**
     * Prints all given long integer values in sequence separated by whitespace
     * and then terminates the line. This method behaves as though it invokes
     * {@link #println(Object[])}.
     *
     * @param values
     *            The {@code Long} values to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(Long... values) throws SvetovidIOException;

    /**
     * Prints all given floating-point values in sequence separated by
     * whitespace and then terminates the line. This method behaves as though it
     * invokes {@link #println(Object[])}.
     *
     * @param values
     *            The {@code Float} values to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(Float... values) throws SvetovidIOException;

    /**
     * Prints all given double-precision floating-point values in sequence
     * separated by whitespace and then terminates the line. This method behaves
     * as though it invokes {@link #println(Object[])}.
     *
     * @param values
     *            The {@code Double} values to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(Double... values) throws SvetovidIOException;

    /**
     * Prints all given character values in sequence separated by whitespace and
     * then terminates the line. This method behaves as though it invokes
     * {@link #println(Object[])}.
     *
     * @param values
     *            The {@code Character} values to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(Character... values) throws SvetovidIOException;

    /**
     * Prints all given string values in sequence separated by whitespace and
     * then terminates the line. This method behaves as though it invokes
     * {@link #print(String)} for each of the given values invoking
     * {@link #print()} in-between and {@link #println()} at the end.
     *
     * @param values
     *            The {@code String} values to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(String... values) throws SvetovidIOException;

    /**
     * Prints all given objects in sequence separated by whitespace and then
     * terminates the line. This method behaves as though it invokes
     * {@link #print(Object)} for each of the given values invoking
     * {@link #print()} in-between and {@link #println()} at the end.
     *
     * @param values
     *            The {@code Object} values to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(Object... values) throws SvetovidIOException;

    /**
     * Prints the given boolean matrix row by row, each in the separate line,
     * with the individual elements separated by whitespace.
     *
     * @param value
     *            The {@code boolean} matrix to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(boolean[][] value) throws SvetovidIOException;

    /**
     * Prints the given byte matrix row by row, each in the separate line, with
     * the individual elements separated by whitespace.
     *
     * @param value
     *            The {@code byte} matrix to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(byte[][] value) throws SvetovidIOException;

    /**
     * Prints the given short integer matrix row by row, each in the separate
     * line, with the individual elements separated by whitespace.
     *
     * @param value
     *            The {@code short} matrix to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(short[][] value) throws SvetovidIOException;

    /**
     * Prints the given integer matrix row by row, each in the separate line,
     * with the individual elements separated by whitespace.
     *
     * @param value
     *            The {@code int} matrix to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(int[][] value) throws SvetovidIOException;

    /**
     * Prints the given long integer matrix row by row, each in the separate
     * line, with the individual elements separated by whitespace.
     *
     * @param value
     *            The {@code long} matrix to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(long[][] value) throws SvetovidIOException;

    /**
     * Prints the given floating-point matrix row by row, each in the separate
     * line, with the individual elements separated by whitespace.
     *
     * @param value
     *            The {@code float} matrix to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(float[][] value) throws SvetovidIOException;

    /**
     * Prints the given double-precision floating-point matrix row by row, each
     * in the separate line, with the individual elements separated by
     * whitespace.
     *
     * @param value
     *            The {@code double} matrix to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(double[][] value) throws SvetovidIOException;

    /**
     * Prints the given character matrix row by row, each in the separate line,
     * with the individual elements separated by whitespace.
     *
     * @param value
     *            The {@code char} matrix to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(char[][] value) throws SvetovidIOException;

    /**
     * Prints the given boolean matrix row by row, each in the separate line,
     * with the individual elements separated by whitespace.
     *
     * @param value
     *            The {@code Boolean} matrix to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(Boolean[][] value) throws SvetovidIOException;

    /**
     * Prints the given byte matrix row by row, each in the separate line, with
     * the individual elements separated by whitespace.
     *
     * @param value
     *            The {@code Byte} matrix to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(Byte[][] value) throws SvetovidIOException;

    /**
     * Prints the given short integer matrix row by row, each in the separate
     * line, with the individual elements separated by whitespace.
     *
     * @param value
     *            The {@code Short} matrix to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(Short[][] value) throws SvetovidIOException;

    /**
     * Prints the given integer matrix row by row, each in the separate line,
     * with the individual elements separated by whitespace.
     *
     * @param value
     *            The {@code Integer} matrix to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(Integer[][] value) throws SvetovidIOException;

    /**
     * Prints the given long integer matrix row by row, each in the separate
     * line, with the individual elements separated by whitespace.
     *
     * @param value
     *            The {@code Long} matrix to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(Long[][] value) throws SvetovidIOException;

    /**
     * Prints the given floating-point matrix row by row, each in the separate
     * line, with the individual elements separated by whitespace.
     *
     * @param value
     *            The {@code Float} matrix to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(Float[][] value) throws SvetovidIOException;

    /**
     * Prints the given double-precision floating-point matrix row by row, each
     * in the separate line, with the individual elements separated by
     * whitespace.
     *
     * @param value
     *            The {@code Double} matrix to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(Double[][] value) throws SvetovidIOException;

    /**
     * Prints the given character matrix row by row, each in the separate line,
     * with the individual elements separated by whitespace.
     *
     * @param value
     *            The {@code Character} matrix to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(Character[][] value) throws SvetovidIOException;

    /**
     * Prints the given string matrix row by row, each in the separate line,
     * with the individual elements separated by whitespace.
     *
     * @param value
     *            The {@code String} matrix to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(String[][] value) throws SvetovidIOException;

    /**
     * Prints the given object matrix row by row, each in the separate line,
     * with the individual elements separated by whitespace.
     *
     * @param value
     *            The {@code Object} matrix to be written
     *
     * @throws SvetovidIOException
     *             if an error occurred during the operation.
     */
    public void println(Object[][] value) throws SvetovidIOException;

}
