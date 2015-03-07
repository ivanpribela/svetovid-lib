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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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

    @Override
    public void printObject(Object value) throws SvetovidIOException {
        StringBuilder builder = new StringBuilder();
        appendObject(builder, "", true, value);
        println(builder.toString());
    }

    protected final String LINE_SEPARATOR = System
            .getProperty("line.separator");
    protected final String INDENT = "  ";
    protected final String LITERAL_NULL = "null";
    protected final String LITERAL_TRUE = "true";
    protected final String LITERAL_FALSE = "false";
    protected final String STRING_QUOTE = "\"";
    protected final String BEGIN_OBJECT = "{" + LINE_SEPARATOR;
    protected final String END_OBJECT = "}";
    protected final String BEGIN_ARRAY = "[" + LINE_SEPARATOR;
    protected final String END_ARRAY = "]";
    protected final String NAME_SEPARATOR = ": ";
    protected final String VALUE_SEPARATOR = "," + LINE_SEPARATOR;

    protected void appendObject(StringBuilder builder, String prefix,
            boolean printPrefix, Object value) {
        if (value == null) {
            if (printPrefix) {
                builder.append(prefix);
            }
            builder.append(LITERAL_NULL);
        } else if (value instanceof Boolean) {
            if ((Boolean) value) {
                if (printPrefix) {
                    builder.append(prefix);
                }
                builder.append(LITERAL_TRUE);
            } else {
                if (printPrefix) {
                    builder.append(prefix);
                }
                builder.append(LITERAL_FALSE);
            }
        } else if (value instanceof Number) {
            if (printPrefix) {
                builder.append(prefix);
            }
            builder.append(((Number) value).toString());
        } else if (value instanceof String) {
            if (printPrefix) {
                builder.append(prefix);
            }
            builder.append(STRING_QUOTE);
            String string = (String) value;
            for (int i = 0; i < string.length(); i++) {
                char ch = string.charAt(i);
                switch (ch) {
                case '\"':
                    builder.append("\\\"");
                    break;
                case '\\':
                    builder.append("\\\\");
                    break;
                case '\b':
                    builder.append("\\b");
                    break;
                case '\f':
                    builder.append("\\f");
                    break;
                case '\n':
                    builder.append("\\n");
                    break;
                case '\r':
                    builder.append("\\r");
                    break;
                case '\t':
                    builder.append("\\t");
                    break;
                default:
                    if (ch < 32) {
                        builder.append("\\u00");
                        String escape = Integer.toHexString(ch);
                        if (escape.length() == 1) {
                            builder.append('0');
                        }
                        builder.append(escape);
                    } else {
                        builder.append(ch);
                    }
                }
            }
            builder.append(STRING_QUOTE);
        } else if (value instanceof Iterable) {
            if (printPrefix) {
                builder.append(prefix);
            }
            builder.append(BEGIN_ARRAY);
            Iterator<?> iterator = ((List<?>) value).iterator();
            if (iterator.hasNext()) {
                Object object = iterator.next();
                appendObject(builder, prefix + INDENT, true, object);
                while (iterator.hasNext()) {
                    object = iterator.next();
                    builder.append(VALUE_SEPARATOR);
                    appendObject(builder, prefix + INDENT, true, object);
                }
            }
            builder.append(LINE_SEPARATOR);
            builder.append(prefix);
            builder.append(END_ARRAY);
        } else if (value instanceof boolean[]) {
            if (printPrefix) {
                builder.append(prefix);
            }
            builder.append(BEGIN_ARRAY);
            boolean[] array = (boolean[]) value;
            if (array.length > 0) {
                Object object = array[0];
                appendObject(builder, prefix + INDENT, true, object);
                for (int i = 1; i < array.length; i++) {
                    object = array[i];
                    builder.append(VALUE_SEPARATOR);
                    appendObject(builder, prefix + INDENT, true, object);
                }
            }
            builder.append(LINE_SEPARATOR);
            builder.append(prefix);
            builder.append(END_ARRAY);
        } else if (value instanceof byte[]) {
            if (printPrefix) {
                builder.append(prefix);
            }
            builder.append(BEGIN_ARRAY);
            byte[] array = (byte[]) value;
            if (array.length > 0) {
                Object object = array[0];
                appendObject(builder, prefix + INDENT, true, object);
                for (int i = 1; i < array.length; i++) {
                    object = array[i];
                    builder.append(VALUE_SEPARATOR);
                    appendObject(builder, prefix + INDENT, true, object);
                }
            }
            builder.append(LINE_SEPARATOR);
            builder.append(prefix);
            builder.append(END_ARRAY);
        } else if (value instanceof short[]) {
            if (printPrefix) {
                builder.append(prefix);
            }
            builder.append(BEGIN_ARRAY);
            short[] array = (short[]) value;
            if (array.length > 0) {
                Object object = array[0];
                appendObject(builder, prefix + INDENT, true, object);
                for (int i = 1; i < array.length; i++) {
                    object = array[i];
                    builder.append(VALUE_SEPARATOR);
                    appendObject(builder, prefix + INDENT, true, object);
                }
            }
            builder.append(LINE_SEPARATOR);
            builder.append(prefix);
            builder.append(END_ARRAY);
        } else if (value instanceof int[]) {
            if (printPrefix) {
                builder.append(prefix);
            }
            builder.append(BEGIN_ARRAY);
            int[] array = (int[]) value;
            if (array.length > 0) {
                Object object = array[0];
                appendObject(builder, prefix + INDENT, true, object);
                for (int i = 1; i < array.length; i++) {
                    object = array[i];
                    builder.append(VALUE_SEPARATOR);
                    appendObject(builder, prefix + INDENT, true, object);
                }
            }
            builder.append(LINE_SEPARATOR);
            builder.append(prefix);
            builder.append(END_ARRAY);
        } else if (value instanceof long[]) {
            if (printPrefix) {
                builder.append(prefix);
            }
            builder.append(BEGIN_ARRAY);
            long[] array = (long[]) value;
            if (array.length > 0) {
                Object object = array[0];
                appendObject(builder, prefix + INDENT, true, object);
                for (int i = 1; i < array.length; i++) {
                    object = array[i];
                    builder.append(VALUE_SEPARATOR);
                    appendObject(builder, prefix + INDENT, true, object);
                }
            }
            builder.append(LINE_SEPARATOR);
            builder.append(prefix);
            builder.append(END_ARRAY);
        } else if (value instanceof float[]) {
            if (printPrefix) {
                builder.append(prefix);
            }
            builder.append(BEGIN_ARRAY);
            float[] array = (float[]) value;
            if (array.length > 0) {
                Object object = array[0];
                appendObject(builder, prefix + INDENT, true, object);
                for (int i = 1; i < array.length; i++) {
                    object = array[i];
                    builder.append(VALUE_SEPARATOR);
                    appendObject(builder, prefix + INDENT, true, object);
                }
            }
            builder.append(LINE_SEPARATOR);
            builder.append(prefix);
            builder.append(END_ARRAY);
        } else if (value instanceof double[]) {
            if (printPrefix) {
                builder.append(prefix);
            }
            builder.append(BEGIN_ARRAY);
            double[] array = (double[]) value;
            if (array.length > 0) {
                Object object = array[0];
                appendObject(builder, prefix + INDENT, true, object);
                for (int i = 1; i < array.length; i++) {
                    object = array[i];
                    builder.append(VALUE_SEPARATOR);
                    appendObject(builder, prefix + INDENT, true, object);
                }
            }
            builder.append(LINE_SEPARATOR);
            builder.append(prefix);
            builder.append(END_ARRAY);
        } else if (value instanceof char[]) {
            if (printPrefix) {
                builder.append(prefix);
            }
            builder.append(BEGIN_ARRAY);
            char[] array = (char[]) value;
            if (array.length > 0) {
                Object object = array[0];
                appendObject(builder, prefix + INDENT, true, object);
                for (int i = 1; i < array.length; i++) {
                    object = array[i];
                    builder.append(VALUE_SEPARATOR);
                    appendObject(builder, prefix + INDENT, true, object);
                }
            }
            builder.append(LINE_SEPARATOR);
            builder.append(prefix);
            builder.append(END_ARRAY);
        } else if (value instanceof Object[]) {
            if (printPrefix) {
                builder.append(prefix);
            }
            builder.append(BEGIN_ARRAY);
            Object[] array = (Object[]) value;
            if (array.length > 0) {
                Object object = array[0];
                appendObject(builder, prefix + INDENT, true, object);
                for (int i = 1; i < array.length; i++) {
                    object = array[i];
                    builder.append(VALUE_SEPARATOR);
                    appendObject(builder, prefix + INDENT, true, object);
                }
            }
            builder.append(LINE_SEPARATOR);
            builder.append(prefix);
            builder.append(END_ARRAY);
        } else if (value instanceof Map) {
            if (printPrefix) {
                builder.append(prefix);
            }
            builder.append(BEGIN_OBJECT);
            @SuppressWarnings("unchecked")
            Map<Object, Object> map = (Map<Object, Object>) value;
            Iterator<Entry<Object, Object>> iterator = map.entrySet().iterator();
            if (iterator.hasNext()) {
                Entry<Object, Object> object = iterator.next();
                String name = object.getKey().toString();
                Object val = object.getValue();
                appendObject(builder, prefix + INDENT, true, name);
                builder.append(NAME_SEPARATOR);
                appendObject(builder, prefix + INDENT, false, val);
                while (iterator.hasNext()) {
                    object = iterator.next();
                    name = object.getKey().toString();
                    val = object.getValue();
                    builder.append(VALUE_SEPARATOR);
                    appendObject(builder, prefix + INDENT, true, name);
                    builder.append(NAME_SEPARATOR);
                    appendObject(builder, prefix + INDENT, false, val);
                }
            }
            builder.append(LINE_SEPARATOR);
            builder.append(prefix);
            builder.append(END_OBJECT);
        } else {
            appendObject(builder, prefix, printPrefix, value.toString());
        }
    }
}
