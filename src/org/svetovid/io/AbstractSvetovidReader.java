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

import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.svetovid.Svetovid;

/**
 * This class provides default implementations for the {@link SvetovidReader}
 * interface. Standard behaviors of all methods are defined here. The developer
 * need only subclass this abstract class and define the {@link #doReadLine()}
 * method.
 *
 * @author Ivan Pribela
 *
 * @see SvetovidReader
 * @see #doReadLine()
 */
public abstract class AbstractSvetovidReader implements SvetovidReader {

    protected Pattern whitespace = Svetovid.WHITESPACE_PATTERN;

    @Override
    public Pattern getWhitespace() {
        return whitespace;
    }

    @Override
    public void setWhitespace(Pattern whitespace) {
        this.whitespace = whitespace;
    }

    protected boolean throwingExceptions = Svetovid.THROW_EXCEPTIONS;
    protected Throwable lastException;

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
        SvetovidIOException exception = new SvetovidIOException("Input", e);
        lastException = exception;
        if (throwingExceptions) {
            throw exception;
        }
    }

    @Override
    public boolean isEmpty() {
        line = readLine();
        return line == null;
    }

    @Override
    public boolean hasMore() {
        return !isEmpty();
    }

    @Override
    public void close() throws SvetovidIOException {
        lastException = null;
        line = null;
        Svetovid.removeIn(this);
    }

    @Override
    public boolean readBool() throws SvetovidFormatException,
            SvetovidIOException {
        String token = readString();
        try {
            if (token == null) {
                throw new NullPointerException();
            }
            lastException = null;
            return parseBool(token);
        } catch (NullPointerException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Boolean.class, token, e);
            lastException = exception;
            throw exception;
        } catch (NumberFormatException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Boolean.class, token, e);
            lastException = exception;
            throw exception;
        }
    }

    protected boolean parseBool(String string) throws NumberFormatException {
        if (string == null) {
            throw new NumberFormatException("null");
        }
        if (string.length() == 0) {
            throw new NumberFormatException(
                    "For input string: \"" + string + "\"");
        }
        if ("true".equals(string)) {
            return true;
        }
        if ("t".equals(string)) {
            return true;
        }
        if ("false".equals(string)) {
            return false;
        }
        if ("f".equals(string)) {
            return false;
        }
        throw new NumberFormatException("For input string: \"" + string + "\"");
    }

    @Override
    public byte readByte() throws SvetovidFormatException, SvetovidIOException {
        String token = readString();
        try {
            if (token == null) {
                throw new NullPointerException();
            }
            lastException = null;
            return Byte.parseByte(token);
        } catch (NullPointerException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Byte.class, token, e);
            lastException = exception;
            throw exception;
        } catch (NumberFormatException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Byte.class, token, e);
            lastException = exception;
            throw exception;
        }
    }

    @Override
    public short readShort() throws SvetovidFormatException,
            SvetovidIOException {
        String token = readString();
        try {
            if (token == null) {
                throw new NullPointerException();
            }
            lastException = null;
            return Short.parseShort(token);
        } catch (NullPointerException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Short.class, token, e);
            lastException = exception;
            throw exception;
        } catch (NumberFormatException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Short.class, token, e);
            lastException = exception;
            throw exception;
        }
    }

    @Override
    public int readInt() throws SvetovidFormatException, SvetovidIOException {
        String token = readString();
        try {
            if (token == null) {
                throw new NullPointerException();
            }
            lastException = null;
            return Integer.parseInt(token);
        } catch (NullPointerException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Integer.class, token, e);
            lastException = exception;
            throw exception;
        } catch (NumberFormatException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Integer.class, token, e);
            lastException = exception;
            throw exception;
        }
    }

    @Override
    public long readLong() throws SvetovidFormatException, SvetovidIOException {
        String token = readString();
        try {
            if (token == null) {
                throw new NullPointerException();
            }
            lastException = null;
            return Long.parseLong(token);
        } catch (NullPointerException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Long.class, token, e);
            lastException = exception;
            throw exception;
        } catch (NumberFormatException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Long.class, token, e);
            lastException = exception;
            throw exception;
        }
    }

    @Override
    public float readFloat() throws SvetovidFormatException,
            SvetovidIOException {
        String token = readString();
        try {
            if (token == null) {
                throw new NullPointerException();
            }
            lastException = null;
            return Float.parseFloat(token);
        } catch (NullPointerException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Float.class, token, e);
            lastException = exception;
            throw exception;
        } catch (NumberFormatException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Float.class, token, e);
            lastException = exception;
            throw exception;
        }
    }

    @Override
    public double readDouble() throws SvetovidFormatException,
            SvetovidIOException {
        String token = readString();
        try {
            if (token == null) {
                throw new NullPointerException();
            }
            lastException = null;
            return Double.parseDouble(token);
        } catch (NullPointerException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Double.class, token, e);
            lastException = exception;
            throw exception;
        } catch (NumberFormatException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Double.class, token, e);
            lastException = exception;
            throw exception;
        }
    }

    @Override
    public char readChar() throws SvetovidFormatException, SvetovidIOException {
        String token = readString();
        try {
            if (token == null) {
                throw new NullPointerException();
            }
            lastException = null;
            return parseChar(token);
        } catch (NullPointerException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Character.class, token, e);
            lastException = exception;
            throw exception;
        } catch (NumberFormatException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Character.class, token, e);
            lastException = exception;
            throw exception;
        }
    }

    protected char parseChar(String string) throws NumberFormatException {
        if (string == null) {
            throw new NumberFormatException("null");
        }
        if (string.length() == 0) {
            throw new NumberFormatException(
                    "For input string: \"" + string + "\"");
        }
        if (string.length() == 1) {
            return string.charAt(0);
        }
        if ("\\b".equals(string)) { // Backspace
            return '\b';
        }
        if ("\\t".equals(string)) { // Tab
            return '\t';
        }
        if ("\\n".equals(string)) { // Line feed
            return '\n';
        }
        if ("\\f".equals(string)) { // Form feed
            return '\f';
        }
        if ("\\r".equals(string)) { // Carriage return
            return '\r';
        }
        if ("\\\"".equals(string)) { // Double quote
            return '\"';
        }
        if ("\\\'".equals(string)) { // Single quote
            return '\'';
        }
        if ("\\\\".equals(string)) { // Backslash
            return '\\';
        }
        if ((string.length() == 6) && string.startsWith("\\u")) { // Unicode
            try {
                int unicode = Integer.parseInt(string.substring(2), 16);
                return (char) unicode;
            } catch (final NumberFormatException e) {
                throw e;
            }
        }
        throw new NumberFormatException("For input string: \"" + string + "\"");
    }

    @Override
    public String readString() throws SvetovidIOException {
        String token = null;
        do {
            token = readLine();
            if (token == null) {
                return null;
            }
            String[] split = getWhitespace().split(token, 2);
            if (split.length > 0) {
                token = split[0];
            } else {
                token = null;
            }
            if (split.length == 2) {
                line = split[1];
            }
        } while ((token == null) || ("".equals(token)));
        return token;
    }

    @Override
    public Boolean readBoolBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        String token = readString();
        try {
            if (token == null) {
                throw new NullPointerException();
            }
            lastException = null;
            return parseBool(token);
        } catch (NullPointerException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Boolean.class, token, e);
            lastException = exception;
            if (throwingExceptions) {
                throw exception;
            }
            return null;
        } catch (NumberFormatException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Boolean.class, token, e);
            lastException = exception;
            if (throwingExceptions) {
                throw exception;
            }
            return null;
        }
    }

    @Override
    public Byte readByteBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        String token = readString();
        try {
            if (token == null) {
                throw new NullPointerException();
            }
            lastException = null;
            return Byte.parseByte(token);
        } catch (NullPointerException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Byte.class, token, e);
            lastException = exception;
            if (throwingExceptions) {
                throw exception;
            }
            return null;
        } catch (NumberFormatException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Byte.class, token, e);
            lastException = exception;
            if (throwingExceptions) {
                throw exception;
            }
            return null;
        }
    }

    @Override
    public Short readShortBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        String token = readString();
        try {
            if (token == null) {
                throw new NullPointerException();
            }
            lastException = null;
            return Short.parseShort(token);
        } catch (NullPointerException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Short.class, token, e);
            lastException = exception;
            if (throwingExceptions) {
                throw exception;
            }
            return null;
        } catch (NumberFormatException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Short.class, token, e);
            lastException = exception;
            if (throwingExceptions) {
                throw exception;
            }
            return null;
        }
    }

    @Override
    public Integer readIntBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        String token = readString();
        try {
            if (token == null) {
                throw new NullPointerException();
            }
            lastException = null;
            return Integer.parseInt(token);
        } catch (NullPointerException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Integer.class, token, e);
            lastException = exception;
            if (throwingExceptions) {
                throw exception;
            }
            return null;
        } catch (NumberFormatException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Integer.class, token, e);
            lastException = exception;
            if (throwingExceptions) {
                throw exception;
            }
            return null;
        }
    }

    @Override
    public Long readLongBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        String token = readString();
        try {
            if (token == null) {
                throw new NullPointerException();
            }
            lastException = null;
            return Long.parseLong(token);
        } catch (NullPointerException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Long.class, token, e);
            lastException = exception;
            if (throwingExceptions) {
                throw exception;
            }
            return null;
        } catch (NumberFormatException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Long.class, token, e);
            lastException = exception;
            if (throwingExceptions) {
                throw exception;
            }
            return null;
        }
    }

    @Override
    public Float readFloatBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        String token = readString();
        try {
            if (token == null) {
                throw new NullPointerException();
            }
            lastException = null;
            return Float.parseFloat(token);
        } catch (NullPointerException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Float.class, token, e);
            lastException = exception;
            if (throwingExceptions) {
                throw exception;
            }
            return null;
        } catch (NumberFormatException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Float.class, token, e);
            lastException = exception;
            if (throwingExceptions) {
                throw exception;
            }
            return null;
        }
    }

    @Override
    public Double readDoubleBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        String token = readString();
        try {
            if (token == null) {
                throw new NullPointerException();
            }
            lastException = null;
            return Double.parseDouble(token);
        } catch (NullPointerException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Double.class, token, e);
            lastException = exception;
            if (throwingExceptions) {
                throw exception;
            }
            return null;
        } catch (NumberFormatException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Double.class, token, e);
            lastException = exception;
            if (throwingExceptions) {
                throw exception;
            }
            return null;
        }
    }

    @Override
    public Character readCharBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        String token = readString();
        try {
            if (token == null) {
                throw new NullPointerException();
            }
            lastException = null;
            return parseChar(token);
        } catch (NullPointerException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Character.class, token, e);
            lastException = exception;
            if (throwingExceptions) {
                throw exception;
            }
            return null;
        } catch (NumberFormatException e) {
            SvetovidFormatException exception =
                    new SvetovidFormatException(Character.class, token, e);
            lastException = exception;
            if (throwingExceptions) {
                throw exception;
            }
            return null;
        }
    }

    @Override
    public boolean[] readBoolArray() throws SvetovidFormatException,
            SvetovidIOException {
        String[] tokens = readStringArray();
        if (tokens == null) {
            return null;
        }
        boolean[] values = new boolean[tokens.length];
        List<SvetovidFormatException> exceptions = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                if (tokens[i] == null) {
                    throw new NullPointerException();
                }
                values[i] = parseBool(tokens[i]);
            } catch (NullPointerException e) {
                exceptions.add(new SvetovidFormatException(
                        Boolean.class, tokens[i], e));
            } catch (NumberFormatException e) {
                exceptions.add(new SvetovidFormatException(
                        Boolean.class, tokens[i], e));
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            return values;
        }
        SvetovidFormatException exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        throw exception;
    }

    @Override
    public byte[] readByteArray() throws SvetovidFormatException,
            SvetovidIOException {
        String[] tokens = readStringArray();
        if (tokens == null) {
            return null;
        }
        byte[] values = new byte[tokens.length];
        List<SvetovidFormatException> exceptions = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                if (tokens[i] == null) {
                    throw new NullPointerException();
                }
                values[i] = Byte.parseByte(tokens[i]);
            } catch (NullPointerException e) {
                exceptions.add(new SvetovidFormatException(
                        Byte.class, tokens[i], e));
            } catch (NumberFormatException e) {
                exceptions.add(new SvetovidFormatException(
                        Byte.class, tokens[i], e));
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            return values;
        }
        SvetovidFormatException exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        throw exception;
    }

    @Override
    public short[] readShortArray() throws SvetovidFormatException,
            SvetovidIOException {
        String[] tokens = readStringArray();
        if (tokens == null) {
            return null;
        }
        short[] values = new short[tokens.length];
        List<SvetovidFormatException> exceptions = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                if (tokens[i] == null) {
                    throw new NullPointerException();
                }
                values[i] = Short.parseShort(tokens[i]);
            } catch (NullPointerException e) {
                exceptions.add(new SvetovidFormatException(
                        Short.class, tokens[i], e));
            } catch (NumberFormatException e) {
                exceptions.add(new SvetovidFormatException(
                        Short.class, tokens[i], e));
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            return values;
        }
        SvetovidFormatException exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        throw exception;
    }

    @Override
    public int[] readIntArray() throws SvetovidFormatException,
            SvetovidIOException {
        String[] tokens = readStringArray();
        if (tokens == null) {
            return null;
        }
        int[] values = new int[tokens.length];
        List<SvetovidFormatException> exceptions = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                if (tokens[i] == null) {
                    throw new NullPointerException();
                }
                values[i] = Integer.parseInt(tokens[i]);
            } catch (NullPointerException e) {
                exceptions.add(new SvetovidFormatException(
                        Integer.class, tokens[i], e));
            } catch (NumberFormatException e) {
                exceptions.add(new SvetovidFormatException(
                        Integer.class, tokens[i], e));
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            return values;
        }
        SvetovidFormatException exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        throw exception;
    }

    @Override
    public long[] readLongArray() throws SvetovidFormatException,
            SvetovidIOException {
        String[] tokens = readStringArray();
        if (tokens == null) {
            return null;
        }
        long[] values = new long[tokens.length];
        List<SvetovidFormatException> exceptions = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                if (tokens[i] == null) {
                    throw new NullPointerException();
                }
                values[i] = Long.parseLong(tokens[i]);
            } catch (NullPointerException e) {
                exceptions.add(new SvetovidFormatException(
                        Long.class, tokens[i], e));
            } catch (NumberFormatException e) {
                exceptions.add(new SvetovidFormatException(
                        Long.class, tokens[i], e));
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            return values;
        }
        SvetovidFormatException exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        throw exception;
    }

    @Override
    public float[] readFloatArray() throws SvetovidFormatException,
            SvetovidIOException {
        String[] tokens = readStringArray();
        if (tokens == null) {
            return null;
        }
        float[] values = new float[tokens.length];
        List<SvetovidFormatException> exceptions = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                if (tokens[i] == null) {
                    throw new NullPointerException();
                }
                values[i] = Float.parseFloat(tokens[i]);
            } catch (NullPointerException e) {
                exceptions.add(new SvetovidFormatException(
                        Float.class, tokens[i], e));
            } catch (NumberFormatException e) {
                exceptions.add(new SvetovidFormatException(
                        Float.class, tokens[i], e));
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            return values;
        }
        SvetovidFormatException exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        throw exception;
    }

    @Override
    public double[] readDoubleArray() throws SvetovidFormatException,
            SvetovidIOException {
        String[] tokens = readStringArray();
        if (tokens == null) {
            return null;
        }
        double[] values = new double[tokens.length];
        List<SvetovidFormatException> exceptions = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                if (tokens[i] == null) {
                    throw new NullPointerException();
                }
                values[i] = Double.parseDouble(tokens[i]);
            } catch (NullPointerException e) {
                exceptions.add(new SvetovidFormatException(
                        Double.class, tokens[i], e));
            } catch (NumberFormatException e) {
                exceptions.add(new SvetovidFormatException(
                        Double.class, tokens[i], e));
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            return values;
        }
        SvetovidFormatException exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        throw exception;
    }

    @Override
    public char[] readCharArray() throws SvetovidFormatException,
            SvetovidIOException {
        String[] tokens = readStringArray();
        if (tokens == null) {
            return null;
        }
        char[] values = new char[tokens.length];
        List<SvetovidFormatException> exceptions = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                if (tokens[i] == null) {
                    throw new NullPointerException();
                }
                values[i] = parseChar(tokens[i]);
            } catch (NullPointerException e) {
                exceptions.add(new SvetovidFormatException(
                        Character.class, tokens[i], e));
            } catch (NumberFormatException e) {
                exceptions.add(new SvetovidFormatException(
                        Character.class, tokens[i], e));
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            return values;
        }
        SvetovidFormatException exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        throw exception;
    }

    @Override
    public String[] readStringArray() throws SvetovidFormatException,
            SvetovidIOException {
        String line = readLine();
        if (line == null) {
            return null;
        }
        String[] tokens = whitespace.split(line, 0);
        int n = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].length() > 0) {
                tokens[n] = tokens[i];
                n++;
            }
        }
        if (tokens.length == n) {
            return tokens;
        }
        String[] result = new String[n];
        System.arraycopy(tokens, 0, result, 0, n);
        return result;
    }

    @Override
    public Boolean[] readBoolArrayBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        String[] tokens = readStringArray();
        if (tokens == null) {
            return null;
        }
        Boolean[] values = new Boolean[tokens.length];
        List<SvetovidFormatException> exceptions = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                if (tokens[i] == null) {
                    throw new NullPointerException();
                }
                values[i] = Boolean.parseBoolean(tokens[i]);
            } catch (NullPointerException e) {
                SvetovidFormatException exception = new SvetovidFormatException(
                        Boolean.class, tokens[i], e);
                exceptions.add(exception);
                values[i] = null;
            } catch (NumberFormatException e) {
                SvetovidFormatException exception = new SvetovidFormatException(
                        Boolean.class, tokens[i], e);
                exceptions.add(exception);
                values[i] = null;
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            return values;
        }
        SvetovidFormatException exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (throwingExceptions) {
            throw exception;
        }
        return values;
    }

    @Override
    public Byte[] readByteArrayBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        String[] tokens = readStringArray();
        if (tokens == null) {
            return null;
        }
        Byte[] values = new Byte[tokens.length];
        List<SvetovidFormatException> exceptions = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                if (tokens[i] == null) {
                    throw new NullPointerException();
                }
                values[i] = Byte.parseByte(tokens[i]);
            } catch (NullPointerException e) {
                SvetovidFormatException exception =
                        new SvetovidFormatException(Byte.class, tokens[i], e);
                exceptions.add(exception);
                values[i] = null;
            } catch (NumberFormatException e) {
                SvetovidFormatException exception =
                        new SvetovidFormatException(Byte.class, tokens[i], e);
                exceptions.add(exception);
                values[i] = null;
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            return values;
        }
        SvetovidFormatException exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (throwingExceptions) {
            throw exception;
        }
        return values;
    }

    @Override
    public Short[] readShortArrayBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        String[] tokens = readStringArray();
        if (tokens == null) {
            return null;
        }
        Short[] values = new Short[tokens.length];
        List<SvetovidFormatException> exceptions = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                if (tokens[i] == null) {
                    throw new NullPointerException();
                }
                values[i] = Short.parseShort(tokens[i]);
            } catch (NullPointerException e) {
                SvetovidFormatException exception =
                        new SvetovidFormatException(Short.class, tokens[i], e);
                exceptions.add(exception);
                values[i] = null;
            } catch (NumberFormatException e) {
                SvetovidFormatException exception =
                        new SvetovidFormatException(Short.class, tokens[i], e);
                exceptions.add(exception);
                values[i] = null;
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            return values;
        }
        SvetovidFormatException exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (throwingExceptions) {
            throw exception;
        }
        return values;
    }

    @Override
    public Integer[] readIntArrayBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        String[] tokens = readStringArray();
        if (tokens == null) {
            return null;
        }
        Integer[] values = new Integer[tokens.length];
        List<SvetovidFormatException> exceptions = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                if (tokens[i] == null) {
                    throw new NullPointerException();
                }
                values[i] = Integer.parseInt(tokens[i]);
            } catch (NullPointerException e) {
                SvetovidFormatException exception = new SvetovidFormatException(
                        Integer.class, tokens[i], e);
                exceptions.add(exception);
                values[i] = null;
            } catch (NumberFormatException e) {
                SvetovidFormatException exception = new SvetovidFormatException(
                        Integer.class, tokens[i], e);
                exceptions.add(exception);
                values[i] = null;
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            return values;
        }
        SvetovidFormatException exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (throwingExceptions) {
            throw exception;
        }
        return values;
    }

    @Override
    public Long[] readLongArrayBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        String[] tokens = readStringArray();
        if (tokens == null) {
            return null;
        }
        Long[] values = new Long[tokens.length];
        List<SvetovidFormatException> exceptions = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                if (tokens[i] == null) {
                    throw new NullPointerException();
                }
                values[i] = Long.parseLong(tokens[i]);
            } catch (NullPointerException e) {
                SvetovidFormatException exception =
                        new SvetovidFormatException(Long.class, tokens[i], e);
                exceptions.add(exception);
                values[i] = null;
            } catch (NumberFormatException e) {
                SvetovidFormatException exception =
                        new SvetovidFormatException(Long.class, tokens[i], e);
                exceptions.add(exception);
                values[i] = null;
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            return values;
        }
        SvetovidFormatException exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (throwingExceptions) {
            throw exception;
        }
        return values;
    }

    @Override
    public Float[] readFloatArrayBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        String[] tokens = readStringArray();
        if (tokens == null) {
            return null;
        }
        Float[] values = new Float[tokens.length];
        List<SvetovidFormatException> exceptions = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                if (tokens[i] == null) {
                    throw new NullPointerException();
                }
                values[i] = Float.parseFloat(tokens[i]);
            } catch (NullPointerException e) {
                SvetovidFormatException exception =
                        new SvetovidFormatException(Float.class, tokens[i], e);
                exceptions.add(exception);
                values[i] = null;
            } catch (NumberFormatException e) {
                SvetovidFormatException exception =
                        new SvetovidFormatException(Float.class, tokens[i], e);
                exceptions.add(exception);
                values[i] = null;
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            return values;
        }
        SvetovidFormatException exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (throwingExceptions) {
            throw exception;
        }
        return values;
    }

    @Override
    public Double[] readDoubleArrayBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        String[] tokens = readStringArray();
        if (tokens == null) {
            return null;
        }
        Double[] values = new Double[tokens.length];
        List<SvetovidFormatException> exceptions = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                if (tokens[i] == null) {
                    throw new NullPointerException();
                }
                values[i] = Double.parseDouble(tokens[i]);
            } catch (NullPointerException e) {
                SvetovidFormatException exception =
                        new SvetovidFormatException(Double.class, tokens[i], e);
                exceptions.add(exception);
                values[i] = null;
            } catch (NumberFormatException e) {
                SvetovidFormatException exception =
                        new SvetovidFormatException(Double.class, tokens[i], e);
                exceptions.add(exception);
                values[i] = null;
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            return values;
        }
        SvetovidFormatException exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (throwingExceptions) {
            throw exception;
        }
        return values;
    }

    @Override
    public Character[] readCharArrayBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        String[] tokens = readStringArray();
        if (tokens == null) {
            return null;
        }
        Character[] values = new Character[tokens.length];
        List<SvetovidFormatException> exceptions = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                if (tokens[i] == null) {
                    throw new NullPointerException();
                }
                values[i] = parseChar(tokens[i]);
            } catch (NullPointerException e) {
                SvetovidFormatException exception = new SvetovidFormatException(
                        Character.class, tokens[i], e);
                exceptions.add(exception);
                values[i] = null;
            } catch (NumberFormatException e) {
                SvetovidFormatException exception = new SvetovidFormatException(
                        Character.class, tokens[i], e);
                exceptions.add(exception);
                values[i] = null;
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            return values;
        }
        SvetovidFormatException exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (throwingExceptions) {
            throw exception;
        }
        return values;
    }

    protected String line = null;

    @Override
    public String readLine() throws SvetovidIOException {
        if (line != null) {
            String oldLine = line;
            line = null;
            lastException = null;
            return oldLine;
        }
        try {
            lastException = null;
            return doReadLine();
        } catch (IOException e) {
            wrapUpIOException(e);
            return null;
        }
    }

    protected abstract String doReadLine() throws IOException;

    @Override
    public String[] readAllLines() throws SvetovidIOException {
        List<String> lines = new ArrayList<>();
        String line = readLine();
        while (line != null) {
            lines.add(line);
            line = readLine();
        }
        String[] result = new String[lines.size()];
        result = lines.toArray(result);
        return result;
    }

    @Override
    public String readAll() throws SvetovidIOException {
        StringBuilder lines = new StringBuilder();
        String line = readLine();
        while (line != null) {
            lines.append(line);
            line = readLine();
            if (line != null) {
                lines.append('\n');
            }
        }
        return lines.toString();
    }

    @Override
    public boolean[][] readBoolMatrix() throws SvetovidFormatException,
            SvetovidIOException {
        List<boolean[]> rows = new ArrayList<>();
        List<Throwable> exceptions = new ArrayList<>();
        boolean[] row;
        try {
            row = readBoolArray();
            if (row.length == 0) {
                row = null;
            }
        } catch (SvetovidFormatException e) {
            row = new boolean[0];
        } catch (SvetovidIOException e) {
            throw e;
        }
        if (lastException != null) {
            Throwable[] suppressed = lastException.getSuppressed();
            if ((lastException instanceof SvetovidFormatException)
                    && (suppressed.length != 0)) {
                for (Throwable s : suppressed) {
                    exceptions.add(s);
                }
            } else {
                exceptions.add(lastException);
            }
        }
        while (row != null) {
            rows.add(row);
            try {
                row = readBoolArray();
                if (row.length == 0) {
                    row = null;
                }
            } catch (SvetovidFormatException e) {
                row = new boolean[0];
            } catch (SvetovidIOException e) {
                throw e;
            }
            if (lastException != null) {
                Throwable[] suppressed = lastException.getSuppressed();
                if ((lastException instanceof SvetovidFormatException)
                        && (suppressed.length != 0)) {
                    for (Throwable s : suppressed) {
                        exceptions.add(s);
                    }
                } else {
                    exceptions.add(lastException);
                }
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            boolean[][] values = new boolean[rows.size()][];
            values = rows.toArray(values);
            return values;
        }
        Throwable exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (exception instanceof RuntimeException) {
            throw (RuntimeException) exception;
        }
        boolean[][] values = new boolean[rows.size()][];
        values = rows.toArray(values);
        return values;
    }

    @Override
    public byte[][] readByteMatrix() throws SvetovidFormatException,
            SvetovidIOException {
        List<byte[]> rows = new ArrayList<>();
        List<Throwable> exceptions = new ArrayList<>();
        byte[] row;
        try {
            row = readByteArray();
            if (row.length == 0) {
                row = null;
            }
        } catch (SvetovidFormatException e) {
            row = new byte[0];
        } catch (SvetovidIOException e) {
            throw e;
        }
        if (lastException != null) {
            Throwable[] suppressed = lastException.getSuppressed();
            if ((lastException instanceof SvetovidFormatException)
                    && (suppressed.length != 0)) {
                for (Throwable s : suppressed) {
                    exceptions.add(s);
                }
            } else {
                exceptions.add(lastException);
            }
        }
        while (row != null) {
            rows.add(row);
            try {
                row = readByteArray();
                if (row.length == 0) {
                    row = null;
                }
            } catch (SvetovidFormatException e) {
                row = new byte[0];
            } catch (SvetovidIOException e) {
                throw e;
            }
            if (lastException != null) {
                Throwable[] suppressed = lastException.getSuppressed();
                if ((lastException instanceof SvetovidFormatException)
                        && (suppressed.length != 0)) {
                    for (Throwable s : suppressed) {
                        exceptions.add(s);
                    }
                } else {
                    exceptions.add(lastException);
                }
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            byte[][] values = new byte[rows.size()][];
            values = rows.toArray(values);
            return values;
        }
        Throwable exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (exception instanceof RuntimeException) {
            throw (RuntimeException) exception;
        }
        byte[][] values = new byte[rows.size()][];
        values = rows.toArray(values);
        return values;
    }

    @Override
    public short[][] readShortMatrix() throws SvetovidFormatException,
            SvetovidIOException {
        List<short[]> rows = new ArrayList<>();
        List<Throwable> exceptions = new ArrayList<>();
        short[] row;
        try {
            row = readShortArray();
            if (row.length == 0) {
                row = null;
            }
        } catch (SvetovidFormatException e) {
            row = new short[0];
        } catch (SvetovidIOException e) {
            throw e;
        }
        if (lastException != null) {
            Throwable[] suppressed = lastException.getSuppressed();
            if ((lastException instanceof SvetovidFormatException)
                    && (suppressed.length != 0)) {
                for (Throwable s : suppressed) {
                    exceptions.add(s);
                }
            } else {
                exceptions.add(lastException);
            }
        }
        while (row != null) {
            rows.add(row);
            try {
                row = readShortArray();
                if (row.length == 0) {
                    row = null;
                }
            } catch (SvetovidFormatException e) {
                row = new short[0];
            } catch (SvetovidIOException e) {
                throw e;
            }
            if (lastException != null) {
                Throwable[] suppressed = lastException.getSuppressed();
                if ((lastException instanceof SvetovidFormatException)
                        && (suppressed.length != 0)) {
                    for (Throwable s : suppressed) {
                        exceptions.add(s);
                    }
                } else {
                    exceptions.add(lastException);
                }
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            short[][] values = new short[rows.size()][];
            values = rows.toArray(values);
            return values;
        }
        Throwable exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (exception instanceof RuntimeException) {
            throw (RuntimeException) exception;
        }
        short[][] values = new short[rows.size()][];
        values = rows.toArray(values);
        return values;
    }

    @Override
    public int[][] readIntMatrix() throws SvetovidFormatException,
            SvetovidIOException {
        List<int[]> rows = new ArrayList<>();
        List<Throwable> exceptions = new ArrayList<>();
        int[] row;
        try {
            row = readIntArray();
            if (row.length == 0) {
                row = null;
            }
        } catch (SvetovidFormatException e) {
            row = new int[0];
        } catch (SvetovidIOException e) {
            throw e;
        }
        if (lastException != null) {
            Throwable[] suppressed = lastException.getSuppressed();
            if ((lastException instanceof SvetovidFormatException)
                    && (suppressed.length != 0)) {
                for (Throwable s : suppressed) {
                    exceptions.add(s);
                }
            } else {
                exceptions.add(lastException);
            }
        }
        while (row != null) {
            rows.add(row);
            try {
                row = readIntArray();
                if (row.length == 0) {
                    row = null;
                }
            } catch (SvetovidFormatException e) {
                row = new int[0];
            } catch (SvetovidIOException e) {
                throw e;
            }
            if (lastException != null) {
                Throwable[] suppressed = lastException.getSuppressed();
                if ((lastException instanceof SvetovidFormatException)
                        && (suppressed.length != 0)) {
                    for (Throwable s : suppressed) {
                        exceptions.add(s);
                    }
                } else {
                    exceptions.add(lastException);
                }
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            int[][] values = new int[rows.size()][];
            values = rows.toArray(values);
            return values;
        }
        Throwable exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (exception instanceof RuntimeException) {
            throw (RuntimeException) exception;
        }
        int[][] values = new int[rows.size()][];
        values = rows.toArray(values);
        return values;
    }

    @Override
    public long[][] readLongMatrix() throws SvetovidFormatException,
            SvetovidIOException {
        List<long[]> rows = new ArrayList<>();
        List<Throwable> exceptions = new ArrayList<>();
        long[] row;
        try {
            row = readLongArray();
            if (row.length == 0) {
                row = null;
            }
        } catch (SvetovidFormatException e) {
            row = new long[0];
        } catch (SvetovidIOException e) {
            throw e;
        }
        if (lastException != null) {
            Throwable[] suppressed = lastException.getSuppressed();
            if ((lastException instanceof SvetovidFormatException)
                    && (suppressed.length != 0)) {
                for (Throwable s : suppressed) {
                    exceptions.add(s);
                }
            } else {
                exceptions.add(lastException);
            }
        }
        while (row != null) {
            rows.add(row);
            try {
                row = readLongArray();
                if (row.length == 0) {
                    row = null;
                }
            } catch (SvetovidFormatException e) {
                row = new long[0];
            } catch (SvetovidIOException e) {
                throw e;
            }
            if (lastException != null) {
                Throwable[] suppressed = lastException.getSuppressed();
                if ((lastException instanceof SvetovidFormatException)
                        && (suppressed.length != 0)) {
                    for (Throwable s : suppressed) {
                        exceptions.add(s);
                    }
                } else {
                    exceptions.add(lastException);
                }
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            long[][] values = new long[rows.size()][];
            values = rows.toArray(values);
            return values;
        }
        Throwable exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (exception instanceof RuntimeException) {
            throw (RuntimeException) exception;
        }
        long[][] values = new long[rows.size()][];
        values = rows.toArray(values);
        return values;
    }

    @Override
    public float[][] readFloatMatrix() throws SvetovidFormatException,
            SvetovidIOException {
        List<float[]> rows = new ArrayList<>();
        List<Throwable> exceptions = new ArrayList<>();
        float[] row;
        try {
            row = readFloatArray();
            if (row.length == 0) {
                row = null;
            }
        } catch (SvetovidFormatException e) {
            row = new float[0];
        } catch (SvetovidIOException e) {
            throw e;
        }
        if (lastException != null) {
            Throwable[] suppressed = lastException.getSuppressed();
            if ((lastException instanceof SvetovidFormatException)
                    && (suppressed.length != 0)) {
                for (Throwable s : suppressed) {
                    exceptions.add(s);
                }
            } else {
                exceptions.add(lastException);
            }
        }
        while (row != null) {
            rows.add(row);
            try {
                row = readFloatArray();
                if (row.length == 0) {
                    row = null;
                }
            } catch (SvetovidFormatException e) {
                row = new float[0];
            } catch (SvetovidIOException e) {
                throw e;
            }
            if (lastException != null) {
                Throwable[] suppressed = lastException.getSuppressed();
                if ((lastException instanceof SvetovidFormatException)
                        && (suppressed.length != 0)) {
                    for (Throwable s : suppressed) {
                        exceptions.add(s);
                    }
                } else {
                    exceptions.add(lastException);
                }
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            float[][] values = new float[rows.size()][];
            values = rows.toArray(values);
            return values;
        }
        Throwable exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (exception instanceof RuntimeException) {
            throw (RuntimeException) exception;
        }
        float[][] values = new float[rows.size()][];
        values = rows.toArray(values);
        return values;
    }

    @Override
    public double[][] readDoubleMatrix() throws SvetovidFormatException,
            SvetovidIOException {
        List<double[]> rows = new ArrayList<>();
        List<Throwable> exceptions = new ArrayList<>();
        double[] row;
        try {
            row = readDoubleArray();
            if (row.length == 0) {
                row = null;
            }
        } catch (SvetovidFormatException e) {
            row = new double[0];
        } catch (SvetovidIOException e) {
            throw e;
        }
        if (lastException != null) {
            Throwable[] suppressed = lastException.getSuppressed();
            if ((lastException instanceof SvetovidFormatException)
                    && (suppressed.length != 0)) {
                for (Throwable s : suppressed) {
                    exceptions.add(s);
                }
            } else {
                exceptions.add(lastException);
            }
        }
        while (row != null) {
            rows.add(row);
            try {
                row = readDoubleArray();
                if (row.length == 0) {
                    row = null;
                }
            } catch (SvetovidFormatException e) {
                row = new double[0];
            } catch (SvetovidIOException e) {
                throw e;
            }
            if (lastException != null) {
                Throwable[] suppressed = lastException.getSuppressed();
                if ((lastException instanceof SvetovidFormatException)
                        && (suppressed.length != 0)) {
                    for (Throwable s : suppressed) {
                        exceptions.add(s);
                    }
                } else {
                    exceptions.add(lastException);
                }
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            double[][] values = new double[rows.size()][];
            values = rows.toArray(values);
            return values;
        }
        Throwable exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (exception instanceof RuntimeException) {
            throw (RuntimeException) exception;
        }
        double[][] values = new double[rows.size()][];
        values = rows.toArray(values);
        return values;
    }

    @Override
    public char[][] readCharMatrix() throws SvetovidFormatException,
            SvetovidIOException {
        List<char[]> rows = new ArrayList<>();
        List<Throwable> exceptions = new ArrayList<>();
        char[] row;
        try {
            row = readCharArray();
            if (row.length == 0) {
                row = null;
            }
        } catch (SvetovidFormatException e) {
            row = new char[0];
        } catch (SvetovidIOException e) {
            throw e;
        }
        if (lastException != null) {
            Throwable[] suppressed = lastException.getSuppressed();
            if ((lastException instanceof SvetovidFormatException)
                    && (suppressed.length != 0)) {
                for (Throwable s : suppressed) {
                    exceptions.add(s);
                }
            } else {
                exceptions.add(lastException);
            }
        }
        while (row != null) {
            rows.add(row);
            try {
                row = readCharArray();
                if (row.length == 0) {
                    row = null;
                }
            } catch (SvetovidFormatException e) {
                row = new char[0];
            } catch (SvetovidIOException e) {
                throw e;
            }
            if (lastException != null) {
                Throwable[] suppressed = lastException.getSuppressed();
                if ((lastException instanceof SvetovidFormatException)
                        && (suppressed.length != 0)) {
                    for (Throwable s : suppressed) {
                        exceptions.add(s);
                    }
                } else {
                    exceptions.add(lastException);
                }
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            char[][] values = new char[rows.size()][];
            values = rows.toArray(values);
            return values;
        }
        Throwable exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (exception instanceof RuntimeException) {
            throw (RuntimeException) exception;
        }
        char[][] values = new char[rows.size()][];
        values = rows.toArray(values);
        return values;
    }

    @Override
    public String[][] readStringMatrix() throws SvetovidIOException {
        List<String[]> rows = new ArrayList<>();
        List<Throwable> exceptions = new ArrayList<>();
        String[] row;
        try {
            row = readStringArray();
            if (row.length == 0) {
                row = null;
            }
        } catch (SvetovidIOException e) {
            throw e;
        }
        if (lastException != null) {
            exceptions.add(lastException);
        }
        while (row != null) {
            rows.add(row);
            try {
                row = readStringArray();
                if (row.length == 0) {
                    row = null;
                }
            } catch (SvetovidIOException e) {
                throw e;
            }
            if (lastException != null) {
                exceptions.add(lastException);
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            String[][] values = new String[rows.size()][];
            values = rows.toArray(values);
            return values;
        }
        Throwable exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (exception instanceof RuntimeException) {
            throw (RuntimeException) exception;
        }
        String[][] values = new String[rows.size()][];
        values = rows.toArray(values);
        return values;
    }

    @Override
    public Boolean[][] readBoolMatrixBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        List<Boolean[]> rows = new ArrayList<>();
        List<Throwable> exceptions = new ArrayList<>();
        Boolean[] row;
        try {
            row = readBoolArrayBoxed();
            if (row.length == 0) {
                row = null;
            }
        } catch (SvetovidFormatException e) {
            row = new Boolean[0];
        } catch (SvetovidIOException e) {
            throw e;
        }
        if (lastException != null) {
            Throwable[] suppressed = lastException.getSuppressed();
            if ((lastException instanceof SvetovidFormatException)
                    && (suppressed.length != 0)) {
                for (Throwable s : suppressed) {
                    exceptions.add(s);
                }
            } else {
                exceptions.add(lastException);
            }
        }
        while (row != null) {
            rows.add(row);
            try {
                row = readBoolArrayBoxed();
                if (row.length == 0) {
                    row = null;
                }
            } catch (SvetovidFormatException e) {
                row = new Boolean[0];
            } catch (SvetovidIOException e) {
                throw e;
            }
            if (lastException != null) {
                Throwable[] suppressed = lastException.getSuppressed();
                if ((lastException instanceof SvetovidFormatException)
                        && (suppressed.length != 0)) {
                    for (Throwable s : suppressed) {
                        exceptions.add(s);
                    }
                } else {
                    exceptions.add(lastException);
                }
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            Boolean[][] values = new Boolean[rows.size()][];
            values = rows.toArray(values);
            return values;
        }
        Throwable exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (throwingExceptions) {
            if (exception instanceof RuntimeException) {
                throw (RuntimeException) exception;
            }
        }
        Boolean[][] values = new Boolean[rows.size()][];
        values = rows.toArray(values);
        return values;
    }

    @Override
    public Byte[][] readByteMatrixBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        List<Byte[]> rows = new ArrayList<>();
        List<Throwable> exceptions = new ArrayList<>();
        Byte[] row;
        try {
            row = readByteArrayBoxed();
            if (row.length == 0) {
                row = null;
            }
        } catch (SvetovidFormatException e) {
            row = new Byte[0];
        } catch (SvetovidIOException e) {
            throw e;
        }
        if (lastException != null) {
            Throwable[] suppressed = lastException.getSuppressed();
            if ((lastException instanceof SvetovidFormatException)
                    && (suppressed.length != 0)) {
                for (Throwable s : suppressed) {
                    exceptions.add(s);
                }
            } else {
                exceptions.add(lastException);
            }
        }
        while (row != null) {
            rows.add(row);
            try {
                row = readByteArrayBoxed();
                if (row.length == 0) {
                    row = null;
                }
            } catch (SvetovidFormatException e) {
                row = new Byte[0];
            } catch (SvetovidIOException e) {
                throw e;
            }
            if (lastException != null) {
                Throwable[] suppressed = lastException.getSuppressed();
                if ((lastException instanceof SvetovidFormatException)
                        && (suppressed.length != 0)) {
                    for (Throwable s : suppressed) {
                        exceptions.add(s);
                    }
                } else {
                    exceptions.add(lastException);
                }
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            Byte[][] values = new Byte[rows.size()][];
            values = rows.toArray(values);
            return values;
        }
        Throwable exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (throwingExceptions) {
            if (exception instanceof RuntimeException) {
                throw (RuntimeException) exception;
            }
        }
        Byte[][] values = new Byte[rows.size()][];
        values = rows.toArray(values);
        return values;
    }

    @Override
    public Short[][] readShortMatrixBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        List<Short[]> rows = new ArrayList<>();
        List<Throwable> exceptions = new ArrayList<>();
        Short[] row;
        try {
            row = readShortArrayBoxed();
            if (row.length == 0) {
                row = null;
            }
        } catch (SvetovidFormatException e) {
            row = new Short[0];
        } catch (SvetovidIOException e) {
            throw e;
        }
        if (lastException != null) {
            Throwable[] suppressed = lastException.getSuppressed();
            if ((lastException instanceof SvetovidFormatException)
                    && (suppressed.length != 0)) {
                for (Throwable s : suppressed) {
                    exceptions.add(s);
                }
            } else {
                exceptions.add(lastException);
            }
        }
        while (row != null) {
            rows.add(row);
            try {
                row = readShortArrayBoxed();
                if (row.length == 0) {
                    row = null;
                }
            } catch (SvetovidFormatException e) {
                row = new Short[0];
            } catch (SvetovidIOException e) {
                throw e;
            }
            if (lastException != null) {
                Throwable[] suppressed = lastException.getSuppressed();
                if ((lastException instanceof SvetovidFormatException)
                        && (suppressed.length != 0)) {
                    for (Throwable s : suppressed) {
                        exceptions.add(s);
                    }
                } else {
                    exceptions.add(lastException);
                }
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            Short[][] values = new Short[rows.size()][];
            values = rows.toArray(values);
            return values;
        }
        Throwable exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (throwingExceptions) {
            if (exception instanceof RuntimeException) {
                throw (RuntimeException) exception;
            }
        }
        Short[][] values = new Short[rows.size()][];
        values = rows.toArray(values);
        return values;
    }

    @Override
    public Integer[][] readIntMatrixBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        List<Integer[]> rows = new ArrayList<>();
        List<Throwable> exceptions = new ArrayList<>();
        Integer[] row;
        try {
            row = readIntArrayBoxed();
            if (row.length == 0) {
                row = null;
            }
        } catch (SvetovidFormatException e) {
            row = new Integer[0];
        } catch (SvetovidIOException e) {
            throw e;
        }
        if (lastException != null) {
            Throwable[] suppressed = lastException.getSuppressed();
            if ((lastException instanceof SvetovidFormatException)
                    && (suppressed.length != 0)) {
                for (Throwable s : suppressed) {
                    exceptions.add(s);
                }
            } else {
                exceptions.add(lastException);
            }
        }
        while (row != null) {
            rows.add(row);
            try {
                row = readIntArrayBoxed();
                if (row.length == 0) {
                    row = null;
                }
            } catch (SvetovidFormatException e) {
                row = new Integer[0];
            } catch (SvetovidIOException e) {
                throw e;
            }
            if (lastException != null) {
                Throwable[] suppressed = lastException.getSuppressed();
                if ((lastException instanceof SvetovidFormatException)
                        && (suppressed.length != 0)) {
                    for (Throwable s : suppressed) {
                        exceptions.add(s);
                    }
                } else {
                    exceptions.add(lastException);
                }
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            Integer[][] values = new Integer[rows.size()][];
            values = rows.toArray(values);
            return values;
        }
        Throwable exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (throwingExceptions) {
            if (exception instanceof RuntimeException) {
                throw (RuntimeException) exception;
            }
        }
        Integer[][] values = new Integer[rows.size()][];
        values = rows.toArray(values);
        return values;
    }

    @Override
    public Long[][] readLongMatrixBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        List<Long[]> rows = new ArrayList<>();
        List<Throwable> exceptions = new ArrayList<>();
        Long[] row;
        try {
            row = readLongArrayBoxed();
            if (row.length == 0) {
                row = null;
            }
        } catch (SvetovidFormatException e) {
            row = new Long[0];
        } catch (SvetovidIOException e) {
            throw e;
        }
        if (lastException != null) {
            Throwable[] suppressed = lastException.getSuppressed();
            if ((lastException instanceof SvetovidFormatException)
                    && (suppressed.length != 0)) {
                for (Throwable s : suppressed) {
                    exceptions.add(s);
                }
            } else {
                exceptions.add(lastException);
            }
        }
        while (row != null) {
            rows.add(row);
            try {
                row = readLongArrayBoxed();
                if (row.length == 0) {
                    row = null;
                }
            } catch (SvetovidFormatException e) {
                row = new Long[0];
            } catch (SvetovidIOException e) {
                throw e;
            }
            if (lastException != null) {
                Throwable[] suppressed = lastException.getSuppressed();
                if ((lastException instanceof SvetovidFormatException)
                        && (suppressed.length != 0)) {
                    for (Throwable s : suppressed) {
                        exceptions.add(s);
                    }
                } else {
                    exceptions.add(lastException);
                }
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            Long[][] values = new Long[rows.size()][];
            values = rows.toArray(values);
            return values;
        }
        Throwable exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (throwingExceptions) {
            if (exception instanceof RuntimeException) {
                throw (RuntimeException) exception;
            }
        }
        Long[][] values = new Long[rows.size()][];
        values = rows.toArray(values);
        return values;
    }

    @Override
    public Float[][] readFloatMatrixBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        List<Float[]> rows = new ArrayList<>();
        List<Throwable> exceptions = new ArrayList<>();
        Float[] row;
        try {
            row = readFloatArrayBoxed();
            if (row.length == 0) {
                row = null;
            }
        } catch (SvetovidFormatException e) {
            row = new Float[0];
        } catch (SvetovidIOException e) {
            throw e;
        }
        if (lastException != null) {
            Throwable[] suppressed = lastException.getSuppressed();
            if ((lastException instanceof SvetovidFormatException)
                    && (suppressed.length != 0)) {
                for (Throwable s : suppressed) {
                    exceptions.add(s);
                }
            } else {
                exceptions.add(lastException);
            }
        }
        while (row != null) {
            rows.add(row);
            try {
                row = readFloatArrayBoxed();
                if (row.length == 0) {
                    row = null;
                }
            } catch (SvetovidFormatException e) {
                row = new Float[0];
            } catch (SvetovidIOException e) {
                throw e;
            }
            if (lastException != null) {
                Throwable[] suppressed = lastException.getSuppressed();
                if ((lastException instanceof SvetovidFormatException)
                        && (suppressed.length != 0)) {
                    for (Throwable s : suppressed) {
                        exceptions.add(s);
                    }
                } else {
                    exceptions.add(lastException);
                }
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            Float[][] values = new Float[rows.size()][];
            values = rows.toArray(values);
            return values;
        }
        Throwable exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (throwingExceptions) {
            if (exception instanceof RuntimeException) {
                throw (RuntimeException) exception;
            }
        }
        Float[][] values = new Float[rows.size()][];
        values = rows.toArray(values);
        return values;
    }

    @Override
    public Double[][] readDoubleMatrixBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        List<Double[]> rows = new ArrayList<>();
        List<Throwable> exceptions = new ArrayList<>();
        Double[] row;
        try {
            row = readDoubleArrayBoxed();
            if (row.length == 0) {
                row = null;
            }
        } catch (SvetovidFormatException e) {
            row = new Double[0];
        } catch (SvetovidIOException e) {
            throw e;
        }
        if (lastException != null) {
            Throwable[] suppressed = lastException.getSuppressed();
            if ((lastException instanceof SvetovidFormatException)
                    && (suppressed.length != 0)) {
                for (Throwable s : suppressed) {
                    exceptions.add(s);
                }
            } else {
                exceptions.add(lastException);
            }
        }
        while (row != null) {
            rows.add(row);
            try {
                row = readDoubleArrayBoxed();
                if (row.length == 0) {
                    row = null;
                }
            } catch (SvetovidFormatException e) {
                row = new Double[0];
            } catch (SvetovidIOException e) {
                throw e;
            }
            if (lastException != null) {
                Throwable[] suppressed = lastException.getSuppressed();
                if ((lastException instanceof SvetovidFormatException)
                        && (suppressed.length != 0)) {
                    for (Throwable s : suppressed) {
                        exceptions.add(s);
                    }
                } else {
                    exceptions.add(lastException);
                }
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            Double[][] values = new Double[rows.size()][];
            values = rows.toArray(values);
            return values;
        }
        Throwable exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (throwingExceptions) {
            if (exception instanceof RuntimeException) {
                throw (RuntimeException) exception;
            }
        }
        Double[][] values = new Double[rows.size()][];
        values = rows.toArray(values);
        return values;
    }

    @Override
    public Character[][] readCharMatrixBoxed() throws SvetovidFormatException,
            SvetovidIOException {
        List<Character[]> rows = new ArrayList<>();
        List<Throwable> exceptions = new ArrayList<>();
        Character[] row;
        try {
            row = readCharArrayBoxed();
            if (row.length == 0) {
                row = null;
            }
        } catch (SvetovidFormatException e) {
            row = new Character[0];
        } catch (SvetovidIOException e) {
            throw e;
        }
        if (lastException != null) {
            Throwable[] suppressed = lastException.getSuppressed();
            if ((lastException instanceof SvetovidFormatException)
                    && (suppressed.length != 0)) {
                for (Throwable s : suppressed) {
                    exceptions.add(s);
                }
            } else {
                exceptions.add(lastException);
            }
        }
        while (row != null) {
            rows.add(row);
            try {
                row = readCharArrayBoxed();
                if (row.length == 0) {
                    row = null;
                }
            } catch (SvetovidFormatException e) {
                row = new Character[0];
            } catch (SvetovidIOException e) {
                throw e;
            }
            if (lastException != null) {
                Throwable[] suppressed = lastException.getSuppressed();
                if ((lastException instanceof SvetovidFormatException)
                        && (suppressed.length != 0)) {
                    for (Throwable s : suppressed) {
                        exceptions.add(s);
                    }
                } else {
                    exceptions.add(lastException);
                }
            }
        }
        int exceptionCount = exceptions.size();
        if (exceptionCount == 0) {
            lastException = null;
            Character[][] values = new Character[rows.size()][];
            values = rows.toArray(values);
            return values;
        }
        Throwable exception;
        if (exceptionCount == 1) {
            exception = exceptions.get(0);
        } else {
            exception = new SvetovidFormatException(exceptions);
        }
        lastException = exception;
        if (throwingExceptions) {
            if (exception instanceof RuntimeException) {
                throw (RuntimeException) exception;
            }
        }
        Character[][] values = new Character[rows.size()][];
        values = rows.toArray(values);
        return values;
    }

    @Override
    public Object readObject() throws SvetovidFormatException,
            SvetovidIOException {
        nextToken();
        Object object = nextValue();
        return object;
    }

    protected char nextChar() throws SvetovidIOException, EOFException {
        String token = readLine();
        if (token == null) {
            throw new EOFException();
        }
        if (token.isEmpty()) {
            return '\n';
        }
        line = token.substring(1);
        return token.charAt(0);
    }

    protected void returnChar(char ch) {
        if (line != null) {
            line = ch + line;
        }
    }

    protected boolean isCharWhitespace(char ch) {
        switch (ch) {
        case ' ':
        case '\t':
        case '\n':
        case '\r':
            return true;
        default:
            return false;
        }
    }

    protected boolean isCharWhitespaceOrSymbol(char ch) {
        switch (ch) {
        case '{':
        case '}':
        case '[':
        case ']':
        case ':':
        case ',':
            return true;
        default:
            return isCharWhitespace(ch);
        }
    }

    protected boolean isCharInNumber(char ch) {
        switch (ch) {
        case '+':
        case '-':
        case '.':
        case 'e':
        case 'E':
            return true;
        default:
            return (ch >= '0') && (ch <= '9');
        }
    }

    protected enum TokenType {
        BEGIN_OBJECT, END_OBJECT,
        BEGIN_ARRAY, END_ARRAY,
        NAME_SEPARATOR, VALUE_SEPARATOR,
        STRING, NUMBER, LITERAL,
        EOF;
    }

    protected TokenType tokenType;
    protected String tokenContent;

    protected void nextToken() throws SvetovidIOException {
        try {
            char ch;
            do {
                ch = nextChar();
            } while (isCharWhitespace(ch));
            if (ch == '{') {
                tokenType = TokenType.BEGIN_OBJECT;
                tokenContent = "{";
                return;
            }
            if (ch == '}') {
                tokenType = TokenType.END_OBJECT;
                tokenContent = "}";
                return;
            }
            if (ch == '[') {
                tokenType = TokenType.BEGIN_ARRAY;
                tokenContent = "[";
                return;
            }
            if (ch == ']') {
                tokenType = TokenType.END_ARRAY;
                tokenContent = "]";
                return;
            }
            if (ch == ':') {
                tokenType = TokenType.NAME_SEPARATOR;
                tokenContent = ":";
                return;
            }
            if (ch == ',') {
                tokenType = TokenType.VALUE_SEPARATOR;
                tokenContent = ",";
                return;
            }
            if (ch == '"') {
                char quote = ch;
                tokenType = TokenType.STRING;
                StringBuilder builder = new StringBuilder();
                builder.append(ch);
                do {
                    ch = nextChar();
                    if (ch == '\\') {
                        ch = nextChar();
                        switch (ch) {
                        case '"':
                            ch = '"';
                            break;
                        case '\'':
                            ch = '\'';
                            break;
                        case '\\':
                            ch = '\\';
                            break;
                        case '/':
                            ch = '/';
                            break;
                        case 'b':
                            ch = '\b';
                            break;
                        case 'f':
                            ch = '\f';
                            break;
                        case 'n':
                            ch = '\n';
                            break;
                        case 'r':
                            ch = '\r';
                            break;
                        case 't':
                            ch = '\t';
                            break;
                        case 'u':
                            String codeString = "" + nextChar()
                                                   + nextChar()
                                                   + nextChar()
                                                   + (ch = nextChar());
                            try {
                                int codeValue = Integer
                                        .parseInt(codeString, 16);
                                ch = (char) codeValue;
                            } catch (NumberFormatException e) {
                                codeString = codeString.substring(0, 3);
                                builder.append("\\u");
                                builder.append(codeString);
                            }
                            break;
                        default:
                            builder.append('\\');
                        }
                    }
                    builder.append(ch);
                } while (ch != quote);
                tokenContent = builder.toString();
                return;
            }
            boolean isNumber = true;
            StringBuilder builder = new StringBuilder();
            while (!isCharWhitespaceOrSymbol(ch)) {
                builder.append(ch);
                isNumber = isNumber && isCharInNumber(ch);
                ch = nextChar();
            }
            returnChar(ch);
            if (isNumber) {
                tokenType = TokenType.NUMBER;
            } else {
                tokenType = TokenType.LITERAL;
            }
            tokenContent = builder.toString();
        } catch (EOFException e) {
            tokenType = TokenType.EOF;
            tokenContent = null;
        }
    }

    // true | false | null
    protected Boolean nextLiteral() throws SvetovidFormatException {
        if (tokenType != TokenType.LITERAL) {
            throw new SvetovidFormatException("Json.Literal",
                    tokenContent, null);
        }
        switch (tokenContent) {
        case "true":
            return true;
        case "false":
            return false;
        case "null":
            return null;
        }
        throw new SvetovidFormatException("Json.Literal", tokenContent, null);
    }

    // number
    protected Number nextNumber() throws SvetovidFormatException {
        if (tokenType != TokenType.NUMBER) {
            throw new SvetovidFormatException("Json.Number",
                    tokenContent, null);
        }
        try {
            return Byte.parseByte(tokenContent);
        } catch (NumberFormatException e) {
            // Try next
        }
        try {
            return Short.parseShort(tokenContent);
        } catch (NumberFormatException e) {
            // Try next
        }
        try {
            return Integer.parseInt(tokenContent);
        } catch (NumberFormatException e) {
            // Try next
        }
        try {
            return Long.parseLong(tokenContent);
        } catch (NumberFormatException e) {
            // Try next
        }
        try {
            return Float.parseFloat(tokenContent);
        } catch (NumberFormatException e) {
            // Try next
        }
        try {
            return Double.parseDouble(tokenContent);
        } catch (NumberFormatException e) {
            // Try next
        }
        try {
            return new BigInteger(tokenContent);
        } catch (NumberFormatException e) {
            // Try next
        }
        try {
            return new BigDecimal(tokenContent);
        } catch (NumberFormatException e) {
            // Try next
        }
        throw new SvetovidFormatException("Json.Number",
                tokenContent, null);
    }

    // "string"
    protected String nextString() throws SvetovidFormatException {
        if (tokenType != TokenType.STRING) {
            throw new SvetovidFormatException("Json.String",
                    tokenContent, null);
        }
        return tokenContent.substring(1, tokenContent.length() - 1);
    }

    // [value, value, value... ]
    protected List<Object> nextArray() throws SvetovidFormatException,
            SvetovidIOException {
        if (tokenType != TokenType.BEGIN_ARRAY) {
            throw new SvetovidFormatException("Json.Array",
                    tokenContent, null);
        }
        nextToken();
        List<Object> array = new ArrayList<>();
        if (tokenType != TokenType.END_ARRAY) {
            array.add(nextValue());
            nextToken();
            while (tokenType != TokenType.END_ARRAY) {
                if (tokenType != TokenType.VALUE_SEPARATOR) {
                    throw new SvetovidFormatException("Json.Value",
                            tokenContent, null);
                }
                nextToken();
                array.add(nextValue());
                nextToken();
            }
        }
        return array;
    }

    // {pair, pair, pair... }
    protected Map<String, Object> readNextObject()
            throws SvetovidFormatException, SvetovidIOException {
        if (tokenType != TokenType.BEGIN_OBJECT) {
            throw new SvetovidFormatException("Json.Object",
                    tokenContent, null);
        }
        nextToken();
        Map<String, Object> map = new LinkedHashMap<>();
        if (tokenType != TokenType.END_OBJECT) {
            Entry<String, Object> pair = nextPair();
            map.put(pair.getKey(), pair.getValue());
            nextToken();
            while (tokenType != TokenType.END_OBJECT) {
                if (tokenType != TokenType.VALUE_SEPARATOR) {
                    throw new SvetovidFormatException("Json.Value",
                            tokenContent, null);
                }
                nextToken();
                pair = nextPair();
                map.put(pair.getKey(), pair.getValue());
                nextToken();
            }
        }
        return map;
    }

    // name : value
    protected Map.Entry<String, Object> nextPair()
            throws SvetovidFormatException, SvetovidIOException {
        String name = nextString();
        nextToken();
        if (tokenType != TokenType.NAME_SEPARATOR) {
            throw new SvetovidFormatException("Json.Member",
                    tokenContent, null);
        }
        nextToken();
        Object value = nextValue();
        return new AbstractMap.SimpleImmutableEntry<>(name, value);
    }

    // literal | number | string | array | object
    protected Object nextValue() throws SvetovidFormatException,
            SvetovidIOException {
        switch (tokenType) {
        case LITERAL:
            return nextLiteral();
        case NUMBER:
            return nextNumber();
        case STRING:
            return nextString();
        case BEGIN_ARRAY:
            return nextArray();
        case BEGIN_OBJECT:
            return readNextObject();
        default:
            throw new SvetovidFormatException("Json.Any", tokenContent, null);
        }
    }
}
