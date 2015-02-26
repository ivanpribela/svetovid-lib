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

import org.svetovid.Svetovid;

/**
 * This class provides default implementations for the {@link SvetovidWriter}
 * interface. Standard behaviors of all methods are defined here. The developer
 * need only subclass this abstract class and define the
 * {@link #doPrint(String)}, {@link #doPrintln(String)} and {@link #doFlush()}
 * methods.
 *
 * @author Ivan Pribela
 *
 * @see SvetovidWriter
 * @see #doPrint(String)
 * @see #doPrintln(String)
 * @see #doFlush()
 */
public abstract class AbstractSvetovidWriter implements SvetovidWriter {

    protected String whitespace = Svetovid.WHITESPACE;

    @Override
    public String getWhitespace() {
        return whitespace;
    }

    @Override
    public void setWhitespace(String whitespace) {
        this.whitespace = whitespace;
    }

    protected boolean autoFlush = Svetovid.AUTO_FLUSH;

    @Override
    public boolean getAutoFlush() {
        return autoFlush;
    }

    @Override
    public void setAutoFlush(boolean autoFlush) {
        this.autoFlush = autoFlush;
    }

    protected boolean throwingExceptions = Svetovid.THROW_EXCEPTIONS;
    protected SvetovidIOException lastException;

    @Override
    public boolean isThrowingExceptions() {
        return throwingExceptions;
    }

    @Override
    public void setThrowingExceptions(boolean shouldThrow) {
        throwingExceptions = shouldThrow;
    }

    @Override
    public Throwable getLastException() {
        return lastException;
    }

    protected void wrapUpIOException(IOException e) throws SvetovidException {
        SvetovidIOException exception = new SvetovidIOException("Output", e);
        lastException = exception;
        if (throwingExceptions) {
            throw exception;
        }
    }

    @Override
    public void close() throws SvetovidIOException {
        lastException = null;
        Svetovid.removeOut(this);
    }

    @Override
    public void print(boolean value) throws SvetovidIOException {
        print(Boolean.toString(value));
    }

    @Override
    public void print(byte value) throws SvetovidIOException {
        print(Byte.toString(value));
    }

    @Override
    public void print(short value) throws SvetovidIOException {
        print(Short.toString(value));
    }

    @Override
    public void print(int value) throws SvetovidIOException {
        print(Integer.toString(value));
    }

    @Override
    public void print(long value) throws SvetovidIOException {
        print(Long.toString(value));
    }

    @Override
    public void print(float value) throws SvetovidIOException {
        print(Float.toString(value));
    }

    @Override
    public void print(double value) throws SvetovidIOException {
        print(Double.toString(value));
    }

    @Override
    public void print(char value) throws SvetovidIOException {
        print(Character.toString(value));
    }

    @Override
    public void print(String value) throws SvetovidIOException {
        try {
            doPrint(value);
            lastException = null;
            if (autoFlush) {
                printbf();
            }
        } catch (IOException e) {
            wrapUpIOException(e);
        }
    }

    protected abstract void doPrint(String value) throws IOException;

    @Override
    public void print(Object value) throws SvetovidIOException {
        print(String.valueOf(value));
    }

    @Override
    public void print() throws SvetovidIOException {
        print(whitespace);
    }

    @Override
    public void printbf() throws SvetovidIOException {
        try {
            doFlush();
            lastException = null;
        } catch (IOException e) {
            wrapUpIOException(e);
        }
    }

    protected abstract void doFlush() throws IOException;

    @Override
    public void println(boolean value) throws SvetovidIOException {
        println(Boolean.toString(value));
    }

    @Override
    public void println(byte value) throws SvetovidIOException {
        println(Byte.toString(value));
    }

    @Override
    public void println(short value) throws SvetovidIOException {
        println(Short.toString(value));
    }

    @Override
    public void println(int value) throws SvetovidIOException {
        println(Integer.toString(value));
    }

    @Override
    public void println(long value) throws SvetovidIOException {
        println(Long.toString(value));
    }

    @Override
    public void println(float value) throws SvetovidIOException {
        println(Float.toString(value));
    }

    @Override
    public void println(double value) throws SvetovidIOException {
        println(Double.toString(value));
    }

    @Override
    public void println(char value) throws SvetovidIOException {
        println(Character.toString(value));
    }

    @Override
    public void println(String value) throws SvetovidIOException {
        try {
            doPrintln(value);
            lastException = null;
            if (autoFlush) {
                printbf();
            }
        } catch (IOException e) {
            wrapUpIOException(e);
        }
    }

    protected abstract void doPrintln(String value) throws IOException;

    @Override
    public void println(Object value) throws SvetovidIOException {
        println(String.valueOf(value));
    }

    @Override
    public void println() throws SvetovidIOException {
        println("");
    }

    @Override
    public void println(boolean... value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(value[0]);
        for (int i = 1; i < value.length; i++) {
            builder.append(whitespace);
            builder.append(value[i]);
        }
        println(builder.toString());
    }

    @Override
    public void println(byte... value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(value[0]);
        for (int i = 1; i < value.length; i++) {
            builder.append(whitespace);
            builder.append(value[i]);
        }
        println(builder.toString());
    }

    @Override
    public void println(short... value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(value[0]);
        for (int i = 1; i < value.length; i++) {
            builder.append(whitespace);
            builder.append(value[i]);
        }
        println(builder.toString());
    }

    @Override
    public void println(int... value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(value[0]);
        for (int i = 1; i < value.length; i++) {
            builder.append(whitespace);
            builder.append(value[i]);
        }
        println(builder.toString());
    }

    @Override
    public void println(long... value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(value[0]);
        for (int i = 1; i < value.length; i++) {
            builder.append(whitespace);
            builder.append(value[i]);
        }
        println(builder.toString());
    }

    @Override
    public void println(float... value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(value[0]);
        for (int i = 1; i < value.length; i++) {
            builder.append(whitespace);
            builder.append(value[i]);
        }
        println(builder.toString());
    }

    @Override
    public void println(double... value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(value[0]);
        for (int i = 1; i < value.length; i++) {
            builder.append(whitespace);
            builder.append(value[i]);
        }
        println(builder.toString());
    }

    @Override
    public void println(char... value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(value[0]);
        for (int i = 1; i < value.length; i++) {
            builder.append(whitespace);
            builder.append(value[i]);
        }
        println(builder.toString());
    }

    @Override
    public void println(Boolean... value) throws SvetovidIOException {
        println((Object[]) value);
    }

    @Override
    public void println(Byte... value) throws SvetovidIOException {
        println((Object[]) value);
    }

    @Override
    public void println(Short... value) throws SvetovidIOException {
        println((Object[]) value);
    }

    @Override
    public void println(Integer... value) throws SvetovidIOException {
        println((Object[]) value);
    }

    @Override
    public void println(Long... value) throws SvetovidIOException {
        println((Object[]) value);
    }

    @Override
    public void println(Float... value) throws SvetovidIOException {
        println((Object[]) value);
    }

    @Override
    public void println(Double... value) throws SvetovidIOException {
        println((Object[]) value);
    }

    @Override
    public void println(Character... value) throws SvetovidIOException {
        println((Object[]) value);
    }

    @Override
    public void println(String... value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(value[0]);
        for (int i = 1; i < value.length; i++) {
            builder.append(whitespace);
            builder.append(value[i]);
        }
        println(builder.toString());
    }

    @Override
    public void println(Object... value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(value[0]);
        for (int i = 1; i < value.length; i++) {
            builder.append(whitespace);
            builder.append(value[i]);
        }
        println(builder.toString());
    }

    @Override
    public void println(boolean[][] value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            println(value[i]);
        }
    }

    @Override
    public void println(byte[][] value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            println(value[i]);
        }
    }

    @Override
    public void println(short[][] value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            println(value[i]);
        }
    }

    @Override
    public void println(int[][] value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            println(value[i]);
        }
    }

    @Override
    public void println(long[][] value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            println(value[i]);
        }
    }

    @Override
    public void println(float[][] value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            println(value[i]);
        }
    }

    @Override
    public void println(double[][] value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            println(value[i]);
        }
    }

    @Override
    public void println(char[][] value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            println(value[i]);
        }
    }

    @Override
    public void println(Boolean[][] value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            println(value[i]);
        }
    }

    @Override
    public void println(Byte[][] value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            println(value[i]);
        }
    }

    @Override
    public void println(Short[][] value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            println(value[i]);
        }
    }

    @Override
    public void println(Integer[][] value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            println(value[i]);
        }
    }

    @Override
    public void println(Long[][] value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            println(value[i]);
        }
    }

    @Override
    public void println(Float[][] value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            println(value[i]);
        }
    }

    @Override
    public void println(Double[][] value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            println(value[i]);
        }
    }

    @Override
    public void println(Character[][] value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            println(value[i]);
        }
    }

    @Override
    public void println(String[][] value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            println(value[i]);
        }
    }

    @Override
    public void println(Object[][] value) throws SvetovidIOException {
        if (value == null) {
            println((String) null);
            return;
        }
        if (value.length == 0) {
            println();
            return;
        }
        for (int i = 0; i < value.length; i++) {
            println(value[i]);
        }
    }
}
