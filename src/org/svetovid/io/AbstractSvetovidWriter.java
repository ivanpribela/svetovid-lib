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

    protected IOException exception;

    @Override
    public IOException getLastException() {
        return exception;
    }

    @Override
    public void close() {
        Svetovid.removeOut(this);
    }

    @Override
    public void print(boolean value) {
        print(Boolean.toString(value));
    }

    @Override
    public void print(byte value) {
        print(Byte.toString(value));
    }

    @Override
    public void print(short value) {
        print(Short.toString(value));
    }

    @Override
    public void print(int value) {
        print(Integer.toString(value));
    }

    @Override
    public void print(long value) {
        print(Long.toString(value));
    }

    @Override
    public void print(float value) {
        print(Float.toString(value));
    }

    @Override
    public void print(double value) {
        print(Double.toString(value));
    }

    @Override
    public void print(char value) {
        print(Character.toString(value));
    }

    @Override
    public void print(String value) {
        try {
            doPrint(value);
            if (autoFlush) {
                printbf();
            }
        } catch (IOException e) {
            exception = e;
        }
    }

    protected abstract void doPrint(String value) throws IOException;

    @Override
    public void print(Object value) {
        print(String.valueOf(value));
    }

    @Override
    public void print() {
        print(whitespace);
    }

    @Override
    public void printbf() {
        try {
            doFlush();
            exception = null;
        } catch (IOException e) {
            exception = e;
        }
    }

    protected abstract void doFlush() throws IOException;

    @Override
    public void println(boolean value) {
        println(Boolean.toString(value));
    }

    @Override
    public void println(byte value) {
        println(Byte.toString(value));
    }

    @Override
    public void println(short value) {
        println(Short.toString(value));
    }

    @Override
    public void println(int value) {
        println(Integer.toString(value));
    }

    @Override
    public void println(long value) {
        println(Long.toString(value));
    }

    @Override
    public void println(float value) {
        println(Float.toString(value));
    }

    @Override
    public void println(double value) {
        println(Double.toString(value));
    }

    @Override
    public void println(char value) {
        println(Character.toString(value));
    }

    @Override
    public void println(String value) {
        try {
            doPrintln(value);
            if (autoFlush) {
                printbf();
            }
            exception = null;
        } catch (IOException e) {
            exception = e;
        }
    }

    protected abstract void doPrintln(String value) throws IOException;

    @Override
    public void println(Object value) {
        println(String.valueOf(value));
    }

    @Override
    public void println() {
        println("");
    }

    @Override
    public void println(boolean... value) {
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
    public void println(byte... value) {
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
    public void println(short... value) {
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
    public void println(int... value) {
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
    public void println(long... value) {
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
    public void println(float... value) {
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
    public void println(double... value) {
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
    public void println(char... value) {
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
    public void println(Boolean... value) {
        println((Object[]) value);
    }

    @Override
    public void println(Byte... value) {
        println((Object[]) value);
    }

    @Override
    public void println(Short... value) {
        println((Object[]) value);
    }

    @Override
    public void println(Integer... value) {
        println((Object[]) value);
    }

    @Override
    public void println(Long... value) {
        println((Object[]) value);
    }

    @Override
    public void println(Float... value) {
        println((Object[]) value);
    }

    @Override
    public void println(Double... value) {
        println((Object[]) value);
    }

    @Override
    public void println(Character... value) {
        println((Object[]) value);
    }

    @Override
    public void println(String... value) {
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
    public void println(Object... value) {
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
    public void println(boolean[][] value) {
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
    public void println(byte[][] value) {
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
    public void println(short[][] value) {
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
    public void println(int[][] value) {
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
    public void println(long[][] value) {
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
    public void println(float[][] value) {
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
    public void println(double[][] value) {
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
    public void println(char[][] value) {
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
    public void println(Boolean[][] value) {
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
    public void println(Byte[][] value) {
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
    public void println(Short[][] value) {
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
    public void println(Integer[][] value) {
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
    public void println(Long[][] value) {
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
    public void println(Float[][] value) {
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
    public void println(Double[][] value) {
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
    public void println(Character[][] value) {
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
    public void println(String[][] value) {
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
    public void println(Object[][] value) {
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
