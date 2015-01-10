package org.svetovid.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.svetovid.Svetovid;

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

    protected IOException exception;

    @Override
    public IOException getLastException() {
        return exception;
    }

    @Override
    public boolean isEmpty() {
        line = readLine();
        return line == null;
    }

    @Override
    public void close() {
        line = null;
        Svetovid.removeIn(this);
    }

    @Override
    public boolean readBool() {
        String token = readString();
        return Boolean.parseBoolean(token);
    }

    @Override
    public byte readByte() throws NumberFormatException {
        String token = readString();
        try {
            return Byte.parseByte(token);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    @Override
    public short readShort() throws NumberFormatException {
        String token = readString();
        try {
            return Short.parseShort(token);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    @Override
    public int readInt() throws NumberFormatException {
        String token = readString();
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    @Override
    public long readLong() throws NumberFormatException {
        String token = readString();
        try {
            return Long.parseLong(token);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    @Override
    public float readFloat() throws NumberFormatException {
        String token = readString();
        try {
            return Float.parseFloat(token);
        } catch (NumberFormatException e) {
            throw e;
        } catch (NullPointerException e) {
            throw new NumberFormatException("null");
        }
    }

    @Override
    public double readDouble() throws NumberFormatException {
        String token = readString();
        try {
            return Double.parseDouble(token);
        } catch (NumberFormatException e) {
            throw e;
        } catch (NullPointerException e) {
            throw new NumberFormatException("null");
        }
    }

    @Override
    public char readChar() throws NumberFormatException {
        String token = readString();
        try {
            return parseChar(token);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    protected char parseChar(String string) throws NumberFormatException {
        if (string == null) {
            throw new NumberFormatException();
        }
        if (string.length() == 0) {
            throw new NumberFormatException();
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
        throw new NumberFormatException();
    }

    @Override
    public String readString() {
        String token;
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
        } while (token == null);
        return token;
    }

    @Override
    public Boolean readBoolBoxed() {
        String token = readString();
        if (token == null) {
            return null;
        }
        return Boolean.parseBoolean(token);
    }

    @Override
    public Byte readByteBoxed() {
        String token = readString();
        try {
            return Byte.parseByte(token);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public Short readShortBoxed() {
        String token = readString();
        try {
            return Short.parseShort(token);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public Integer readIntBoxed() {
        String token = readString();
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public Long readLongBoxed() {
        String token = readString();
        try {
            return Long.parseLong(token);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public Float readFloatBoxed() {
        String token = readString();
        try {
            return Float.parseFloat(token);
        } catch (NumberFormatException e) {
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public Double readDoubleBoxed() {
        String token = readString();
        try {
            return Double.parseDouble(token);
        } catch (NumberFormatException e) {
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public Character readCharBoxed() {
        String token = readString();
        try {
            return parseChar(token);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public boolean[] readBoolLine() {
        String[] tokens = readStringLine();
        if (tokens == null) {
            return null;
        }
        boolean[] values = new boolean[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            values[i] = Boolean.parseBoolean(tokens[i]);
        }
        return values;
    }

    @Override
    public byte[] readByteLine() throws NumberFormatException {
        String[] tokens = readStringLine();
        if (tokens == null) {
            return null;
        }
        byte[] values = new byte[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            try {
                values[i] = Byte.parseByte(tokens[i]);
            } catch (NumberFormatException e) {
                throw e;
            }
        }
        return values;
    }

    @Override
    public short[] readShortLine() throws NumberFormatException {
        String[] tokens = readStringLine();
        if (tokens == null) {
            return null;
        }
        short[] values = new short[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            try {
                values[i] = Short.parseShort(tokens[i]);
            } catch (NumberFormatException e) {
                throw e;
            }
        }
        return values;
    }

    @Override
    public int[] readIntLine() throws NumberFormatException {
        String[] tokens = readStringLine();
        if (tokens == null) {
            return null;
        }
        int[] values = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            try {
                values[i] = Integer.parseInt(tokens[i]);
            } catch (NumberFormatException e) {
                throw e;
            }
        }
        return values;
    }

    @Override
    public long[] readLongLine() throws NumberFormatException {
        String[] tokens = readStringLine();
        if (tokens == null) {
            return null;
        }
        long[] values = new long[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            try {
                values[i] = Long.parseLong(tokens[i]);
            } catch (NumberFormatException e) {
                throw e;
            }
        }
        return values;
    }

    @Override
    public float[] readFloatLine() throws NumberFormatException {
        String[] tokens = readStringLine();
        if (tokens == null) {
            return null;
        }
        float[] values = new float[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            try {
                values[i] = Float.parseFloat(tokens[i]);
            } catch (NumberFormatException e) {
                throw e;
            } catch (NullPointerException e) {
                throw new NumberFormatException("null");
            }
        }
        return values;
    }

    @Override
    public double[] readDoubleLine() throws NumberFormatException {
        String[] tokens = readStringLine();
        if (tokens == null) {
            return null;
        }
        double[] values = new double[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            try {
                values[i] = Double.parseDouble(tokens[i]);
            } catch (NumberFormatException e) {
                throw e;
            } catch (NullPointerException e) {
                throw new NumberFormatException("null");
            }
        }
        return values;
    }

    @Override
    public char[] readCharLine() throws NumberFormatException {
        String[] tokens = readStringLine();
        if (tokens == null) {
            return null;
        }
        char[] values = new char[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            values[i] = parseChar(tokens[i]);
        }
        return values;
    }

    @Override
    public String[] readStringLine() {
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
    public Boolean[] readBoolLineBoxed() {
        String[] tokens = readStringLine();
        if (tokens == null) {
            return null;
        }
        Boolean[] values = new Boolean[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            try {
                values[i] = Boolean.parseBoolean(tokens[i]);
            } catch (NumberFormatException e) {
                values[i] = null;
            } catch (NullPointerException e) {
                values[i] = null;
            }
        }
        return values;
    }

    @Override
    public Byte[] readByteLineBoxed() {
        String[] tokens = readStringLine();
        if (tokens == null) {
            return null;
        }
        Byte[] values = new Byte[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            try {
                values[i] = Byte.parseByte(tokens[i]);
            } catch (NumberFormatException e) {
                values[i] = null;
            } catch (NullPointerException e) {
                values[i] = null;
            }
        }
        return values;
    }

    @Override
    public Short[] readShortLineBoxed() {
        String[] tokens = readStringLine();
        if (tokens == null) {
            return null;
        }
        Short[] values = new Short[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            try {
                values[i] = Short.parseShort(tokens[i]);
            } catch (NumberFormatException e) {
                values[i] = null;
            } catch (NullPointerException e) {
                values[i] = null;
            }
        }
        return values;
    }

    @Override
    public Integer[] readIntLineBoxed() {
        String[] tokens = readStringLine();
        if (tokens == null) {
            return null;
        }
        Integer[] values = new Integer[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            try {
                values[i] = Integer.parseInt(tokens[i]);
            } catch (NumberFormatException e) {
                values[i] = null;
            } catch (NullPointerException e) {
                values[i] = null;
            }
        }
        return values;
    }

    @Override
    public Long[] readLongLineBoxed() {
        String[] tokens = readStringLine();
        if (tokens == null) {
            return null;
        }
        Long[] values = new Long[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            try {
                values[i] = Long.parseLong(tokens[i]);
            } catch (NumberFormatException e) {
                values[i] = null;
            } catch (NullPointerException e) {
                values[i] = null;
            }
        }
        return values;
    }

    @Override
    public Float[] readFloatLineBoxed() {
        String[] tokens = readStringLine();
        if (tokens == null) {
            return null;
        }
        Float[] values = new Float[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            try {
                values[i] = Float.parseFloat(tokens[i]);
            } catch (NumberFormatException e) {
                values[i] = null;
            } catch (NullPointerException e) {
                values[i] = null;
            }
        }
        return values;
    }

    @Override
    public Double[] readDoubleLineBoxed() {
        String[] tokens = readStringLine();
        if (tokens == null) {
            return null;
        }
        Double[] values = new Double[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            try {
                values[i] = Double.parseDouble(tokens[i]);
            } catch (NumberFormatException e) {
                values[i] = null;
            } catch (NullPointerException e) {
                values[i] = null;
            }
        }
        return values;
    }

    @Override
    public Character[] readCharLineBoxed() {
        String[] tokens = readStringLine();
        if (tokens == null) {
            return null;
        }
        Character[] values = new Character[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            try {
                if (tokens[i].length() == 1) {
                    values[i] = tokens[i].charAt(0);
                } else {
                    values[i] = null;
                }
            } catch (NumberFormatException e) {
                values[i] = null;
            } catch (NullPointerException e) {
                values[i] = null;
            }
        }
        return values;
    }

    protected String line = null;

    @Override
    public String readLine() {
        if (line != null) {
            line = null;
            return line;
        }
        try {
            exception = null;
            return doReadLine();
        } catch (IOException e) {
            exception = e;
            return null;
        }
    }

    protected abstract String doReadLine() throws IOException;

    @Override
    public String[] readAllLines() {
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
    public String readAll() {
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
    public boolean[][] readBoolMatrix() {
        List<boolean[]> rows = new ArrayList<>();
        boolean[] row = readBoolLine();
        while ((row != null) && (row.length > 0)) {
            rows.add(row);
            row = readBoolLine();
        }
        boolean[][] result = new boolean[rows.size()][];
        result = rows.toArray(result);
        return result;
    }

    @Override
    public byte[][] readByteMatrix() throws NumberFormatException {
        List<byte[]> rows = new ArrayList<>();
        byte[] row = readByteLine();
        while ((row != null) && (row.length > 0)) {
            rows.add(row);
            row = readByteLine();
        }
        byte[][] result = new byte[rows.size()][];
        result = rows.toArray(result);
        return result;
    }

    @Override
    public short[][] readShortMatrix() throws NumberFormatException {
        List<short[]> rows = new ArrayList<>();
        short[] row = readShortLine();
        while ((row != null) && (row.length > 0)) {
            rows.add(row);
            row = readShortLine();
        }
        short[][] result = new short[rows.size()][];
        result = rows.toArray(result);
        return result;
    }

    @Override
    public int[][] readIntMatrix() throws NumberFormatException {
        List<int[]> rows = new ArrayList<>();
        int[] row = readIntLine();
        while ((row != null) && (row.length > 0)) {
            rows.add(row);
            row = readIntLine();
        }
        int[][] result = new int[rows.size()][];
        result = rows.toArray(result);
        return result;
    }

    @Override
    public long[][] readLongMatrix() throws NumberFormatException {
        List<long[]> rows = new ArrayList<>();
        long[] row = readLongLine();
        while ((row != null) && (row.length > 0)) {
            rows.add(row);
            row = readLongLine();
        }
        long[][] result = new long[rows.size()][];
        result = rows.toArray(result);
        return result;
    }

    @Override
    public float[][] readFloatMatrix() throws NumberFormatException {
        List<float[]> rows = new ArrayList<>();
        float[] row = readFloatLine();
        while ((row != null) && (row.length > 0)) {
            rows.add(row);
            row = readFloatLine();
        }
        float[][] result = new float[rows.size()][];
        result = rows.toArray(result);
        return result;
    }

    @Override
    public double[][] readDoubleMatrix() throws NumberFormatException {
        List<double[]> rows = new ArrayList<>();
        double[] row = readDoubleLine();
        while ((row != null) && (row.length > 0)) {
            rows.add(row);
            row = readDoubleLine();
        }
        double[][] result = new double[rows.size()][];
        result = rows.toArray(result);
        return result;
    }

    @Override
    public char[][] readCharMatrix() throws NumberFormatException {
        List<char[]> rows = new ArrayList<>();
        char[] row = readCharLine();
        while ((row != null) && (row.length > 0)) {
            rows.add(row);
            row = readCharLine();
        }
        char[][] result = new char[rows.size()][];
        result = rows.toArray(result);
        return result;
    }

    @Override
    public String[][] readStringMatrix() {
        List<String[]> rows = new ArrayList<>();
        String[] row = readStringLine();
        while ((row != null) && (row.length > 0)) {
            rows.add(row);
            row = readStringLine();
        }
        String[][] result = new String[rows.size()][];
        result = rows.toArray(result);
        return result;
    }

    @Override
    public Boolean[][] readBoolMatrixBoxed() {
        List<Boolean[]> rows = new ArrayList<>();
        Boolean[] row = readBoolLineBoxed();
        while ((row != null) && (row.length > 0)) {
            rows.add(row);
            row = readBoolLineBoxed();
        }
        Boolean[][] result = new Boolean[rows.size()][];
        result = rows.toArray(result);
        return result;
    }

    @Override
    public Byte[][] readByteMatrixBoxed() {
        List<Byte[]> rows = new ArrayList<>();
        Byte[] row = readByteLineBoxed();
        while ((row != null) && (row.length > 0)) {
            rows.add(row);
            row = readByteLineBoxed();
        }
        Byte[][] result = new Byte[rows.size()][];
        result = rows.toArray(result);
        return result;
    }

    @Override
    public Short[][] readShortMatrixBoxed() {
        List<Short[]> rows = new ArrayList<>();
        Short[] row = readShortLineBoxed();
        while ((row != null) && (row.length > 0)) {
            rows.add(row);
            row = readShortLineBoxed();
        }
        Short[][] result = new Short[rows.size()][];
        result = rows.toArray(result);
        return result;
    }

    @Override
    public Integer[][] readIntMatrixBoxed() {
        List<Integer[]> rows = new ArrayList<>();
        Integer[] row = readIntLineBoxed();
        while ((row != null) && (row.length > 0)) {
            rows.add(row);
            row = readIntLineBoxed();
        }
        Integer[][] result = new Integer[rows.size()][];
        result = rows.toArray(result);
        return result;
    }

    @Override
    public Long[][] readLongMatrixBoxed() {
        List<Long[]> rows = new ArrayList<>();
        Long[] row = readLongLineBoxed();
        while ((row != null) && (row.length > 0)) {
            rows.add(row);
            row = readLongLineBoxed();
        }
        Long[][] result = new Long[rows.size()][];
        result = rows.toArray(result);
        return result;
    }

    @Override
    public Float[][] readFloatMatrixBoxed() {
        List<Float[]> rows = new ArrayList<>();
        Float[] row = readFloatLineBoxed();
        while ((row != null) && (row.length > 0)) {
            rows.add(row);
            row = readFloatLineBoxed();
        }
        Float[][] result = new Float[rows.size()][];
        result = rows.toArray(result);
        return result;
    }

    @Override
    public Double[][] readDoubleMatrixBoxed() {
        List<Double[]> rows = new ArrayList<>();
        Double[] row = readDoubleLineBoxed();
        while ((row != null) && (row.length > 0)) {
            rows.add(row);
            row = readDoubleLineBoxed();
        }
        Double[][] result = new Double[rows.size()][];
        result = rows.toArray(result);
        return result;
    }

    @Override
    public Character[][] readCharMatrixBoxed() {
        List<Character[]> rows = new ArrayList<>();
        Character[] row = readCharLineBoxed();
        while ((row != null) && (row.length > 0)) {
            rows.add(row);
            row = readCharLineBoxed();
        }
        Character[][] result = new Character[rows.size()][];
        result = rows.toArray(result);
        return result;
    }
}
