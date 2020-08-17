package org.svetovid.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class SvetovidArrays {

    public static final int INDEX_NOT_FOUND = -1;

    public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final short[] EMPTY_SHORT_ARRAY = new short[0];
    public static final int[] EMPTY_INT_ARRAY = new int[0];
    public static final long[] EMPTY_LONG_ARRAY = new long[0];
    public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
    public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
    public static final char[] EMPTY_CHAR_ARRAY = new char[0];
    public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];

    @SuppressWarnings("unchecked")
    public static <T> T[] empty() {
        return (T[]) EMPTY_OBJECT_ARRAY;
    }

    public static boolean[] nullToEmpty(boolean[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        return array;
    }

    public static byte[] nullToEmpty(byte[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        return array;
    }

    public static short[] nullToEmpty(short[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        return array;
    }

    public static int[] nullToEmpty(int[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        return array;
    }

    public static long[] nullToEmpty(long[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_LONG_ARRAY;
        }
        return array;
    }

    public static float[] nullToEmpty(float[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        return array;
    }

    public static double[] nullToEmpty(double[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        return array;
    }

    public static char[] nullToEmpty(char[] array) {
        if (array == null || array.length == 0) {
            return EMPTY_CHAR_ARRAY;
        }
        return array;
    }

    public static <T> T[] nullToEmpty(T[] array) {
        if (array == null || array.length == 0) {
            return empty();
        }
        return array;
    }

    public static boolean isEmpty(boolean[] array) {
        return (array == null) || (array.length == 0);
    }

    public static boolean isEmpty(byte[] array) {
        return (array == null) || (array.length == 0);
    }

    public static boolean isEmpty(short[] array) {
        return (array == null) || (array.length == 0);
    }

    public static boolean isEmpty(int[] array) {
        return (array == null) || (array.length == 0);
    }

    public static boolean isEmpty(long[] array) {
        return (array == null) || (array.length == 0);
    }

    public static boolean isEmpty(float[] array) {
        return (array == null) || (array.length == 0);
    }

    public static boolean isEmpty(double[] array) {
        return (array == null) || (array.length == 0);
    }

    public static boolean isEmpty(char[] array) {
        return (array == null) || (array.length == 0);
    }

    public static <T> boolean isEmpty(T[] array) {
        return (array == null) || (array.length == 0);
    }

    public static boolean isNonempty(boolean[] array) {
        return (array != null) && (array.length > 0);
    }

    public static boolean isNonempty(byte[] array) {
        return (array != null) && (array.length > 0);
    }

    public static boolean isNonempty(short[] array) {
        return (array != null) && (array.length > 0);
    }

    public static boolean isNonempty(int[] array) {
        return (array != null) && (array.length > 0);
    }

    public static boolean isNonempty(long[] array) {
        return (array != null) && (array.length > 0);
    }

    public static boolean isNonempty(float[] array) {
        return (array != null) && (array.length > 0);
    }

    public static boolean isNonempty(double[] array) {
        return (array != null) && (array.length > 0);
    }

    public static boolean isNonempty(char[] array) {
        return (array != null) && (array.length > 0);
    }

    public static <T> boolean isNonempty(T[] array) {
        return (array != null) && (array.length > 0);
    }

    public static int length(boolean[] array) {
        if (array == null) {
            return 0;
        }
        return array.length;
    }

    public static int length(byte[] array) {
        if (array == null) {
            return 0;
        }
        return array.length;
    }

    public static int length(short[] array) {
        if (array == null) {
            return 0;
        }
        return array.length;
    }

    public static int length(int[] array) {
        if (array == null) {
            return 0;
        }
        return array.length;
    }

    public static int length(long[] array) {
        if (array == null) {
            return 0;
        }
        return array.length;
    }

    public static int length(float[] array) {
        if (array == null) {
            return 0;
        }
        return array.length;
    }

    public static int length(double[] array) {
        if (array == null) {
            return 0;
        }
        return array.length;
    }

    public static int length(char[] array) {
        if (array == null) {
            return 0;
        }
        return array.length;
    }

    public static <T> int length(T[] array) {
        if (array == null) {
            return 0;
        }
        return array.length;
    }

    public static boolean sameLength(boolean[] array1, boolean[] array2) {
        return length(array1) == length(array2);
    }

    public static boolean sameLength(byte[] array1, byte[] array2) {
        return length(array1) == length(array2);
    }

    public static boolean sameLength(short[] array1, short[] array2) {
        return length(array1) == length(array2);
    }

    public static boolean sameLength(int[] array1, int[] array2) {
        return length(array1) == length(array2);
    }

    public static boolean sameLength(long[] array1, long[] array2) {
        return length(array1) == length(array2);
    }

    public static boolean sameLength(float[] array1, float[] array2) {
        return length(array1) == length(array2);
    }

    public static boolean sameLength(double[] array1, double[] array2) {
        return length(array1) == length(array2);
    }

    public static boolean sameLength(char[] array1, char[] array2) {
        return length(array1) == length(array2);
    }

    public static <T> boolean sameLength(T[] array1, T[] array2) {
        return length(array1) == length(array2);
    }

    public static boolean equals(boolean[] array1, boolean[] array2) {
        return Arrays.equals(array1, array2);
    }

    public static boolean equals(byte[] array1, byte[] array2) {
        return Arrays.equals(array1, array2);
    }

    public static boolean equals(short[] array1, short[] array2) {
        return Arrays.equals(array1, array2);
    }

    public static boolean equals(int[] array1, int[] array2) {
        return Arrays.equals(array1, array2);
    }

    public static boolean equals(long[] array1, long[] array2) {
        return Arrays.equals(array1, array2);
    }

    public static boolean equals(float[] array1, float[] array2) {
        return Arrays.equals(array1, array2);
    }

    public static boolean equals(double[] array1, double[] array2) {
        return Arrays.equals(array1, array2);
    }

    public static boolean equals(char[] array1, char[] array2) {
        return Arrays.equals(array1, array2);
    }

    public static <T> boolean equals(T[] array1, T[] array2) {
        return Arrays.equals(array1, array2);
    }

    public static <T> String toString(boolean[] array, String prefix, String suffix, String infix, String nullString) {
        if (array == null) {
            return nullString;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(prefix);
        if (array.length > 0) {
            builder.append(array[0]);
            for (int i = 1; i < array.length; i++) {
                builder.append(infix);
                builder.append(array[i]);
            }
        }
        builder.append(suffix);
        return builder.toString();
    }

    public static <T> String toString(byte[] array, String prefix, String suffix, String infix, String nullString) {
        if (array == null) {
            return nullString;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(prefix);
        if (array.length > 0) {
            builder.append(array[0]);
            for (int i = 1; i < array.length; i++) {
                builder.append(infix);
                builder.append(array[i]);
            }
        }
        builder.append(suffix);
        return builder.toString();
    }

    public static <T> String toString(short[] array, String prefix, String suffix, String infix, String nullString) {
        if (array == null) {
            return nullString;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(prefix);
        if (array.length > 0) {
            builder.append(array[0]);
            for (int i = 1; i < array.length; i++) {
                builder.append(infix);
                builder.append(array[i]);
            }
        }
        builder.append(suffix);
        return builder.toString();
    }

    public static <T> String toString(int[] array, String prefix, String suffix, String infix, String nullString) {
        if (array == null) {
            return nullString;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(prefix);
        if (array.length > 0) {
            builder.append(array[0]);
            for (int i = 1; i < array.length; i++) {
                builder.append(infix);
                builder.append(array[i]);
            }
        }
        builder.append(suffix);
        return builder.toString();
    }

    public static <T> String toString(long[] array, String prefix, String suffix, String infix, String nullString) {
        if (array == null) {
            return nullString;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(prefix);
        if (array.length > 0) {
            builder.append(array[0]);
            for (int i = 1; i < array.length; i++) {
                builder.append(infix);
                builder.append(array[i]);
            }
        }
        builder.append(suffix);
        return builder.toString();
    }

    public static <T> String toString(float[] array, String prefix, String suffix, String infix, String nullString) {
        if (array == null) {
            return nullString;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(prefix);
        if (array.length > 0) {
            builder.append(array[0]);
            for (int i = 1; i < array.length; i++) {
                builder.append(infix);
                builder.append(array[i]);
            }
        }
        builder.append(suffix);
        return builder.toString();
    }

    public static <T> String toString(double[] array, String prefix, String suffix, String infix, String nullString) {
        if (array == null) {
            return nullString;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(prefix);
        if (array.length > 0) {
            builder.append(array[0]);
            for (int i = 1; i < array.length; i++) {
                builder.append(infix);
                builder.append(array[i]);
            }
        }
        builder.append(suffix);
        return builder.toString();
    }

    public static <T> String toString(char[] array, String prefix, String suffix, String infix, String nullString) {
        if (array == null) {
            return nullString;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(prefix);
        if (array.length > 0) {
            builder.append(array[0]);
            for (int i = 1; i < array.length; i++) {
                builder.append(infix);
                builder.append(array[i]);
            }
        }
        builder.append(suffix);
        return builder.toString();
    }

    public static <T> String toString(T[] array, String prefix, String suffix, String infix, String nullString) {
        if (array == null) {
            return nullString;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(prefix);
        if (array.length > 0) {
            builder.append(String.valueOf(array[0].toString()));
            for (int i = 1; i < array.length; i++) {
                builder.append(infix);
                builder.append(String.valueOf(array[i].toString()));
            }
        }
        builder.append(suffix);
        return builder.toString();
    }

    public static boolean[] toArray(boolean... items) {
        return items;
    }

    public static byte[] toArray(byte... items) {
        return items;
    }

    public static short[] toArray(short... items) {
        return items;
    }

    public static int[] toArray(int... items) {
        return items;
    }

    public static long[] toArray(long... items) {
        return items;
    }

    public static float[] toArray(float... items) {
        return items;
    }

    public static double[] toArray(double... items) {
        return items;
    }

    public static char[] toArray(char... items) {
        return items;
    }

    @SafeVarargs
    public static <T> T[] toArray(T... items) {
        return items;
    }

    @SuppressWarnings("unchecked")
	public static <T> T[] toArray(Collection<T> items) {
        if (items == null) {
            return null;
        }
        Object[] array = items.toArray();
        return (T[]) array;
    }

    public static List<Boolean> toList(boolean... items) {
        Boolean[] boxed = box(items);
        return Arrays.asList(boxed);
    }

    public static List<Byte> toList(byte... items) {
        Byte[] boxed = box(items);
        return Arrays.asList(boxed);
    }

    public static List<Short> toList(short... items) {
        Short[] boxed = box(items);
        return Arrays.asList(boxed);
    }

    public static List<Integer> toList(int... items) {
        Integer[] boxed = box(items);
        return Arrays.asList(boxed);
    }

    public static List<Long> toList(long... items) {
        Long[] boxed = box(items);
        return Arrays.asList(boxed);
    }

    public static List<Float> toList(float... items) {
        Float[] boxed = box(items);
        return Arrays.asList(boxed);
    }

    public static List<Double> toList(double... items) {
        Double[] boxed = box(items);
        return Arrays.asList(boxed);
    }

    public static List<Character> toList(char... items) {
        Character[] boxed = box(items);
        return Arrays.asList(boxed);
    }

    @SafeVarargs
	public static <T> List<T> toList(T... items) {
        return Arrays.asList(items);
    }

    public static boolean[] copy(boolean[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }

    public static byte[] copy(byte[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }

    public static short[] copy(short[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }

    public static int[] copy(int[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }

    public static long[] copy(long[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }

    public static float[] copy(float[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }

    public static double[] copy(double[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }

    public static char[] copy(char[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }

    public static <T> T[] copy(T[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }

    public static boolean[] fill(boolean[] array, boolean value) {
        if (array == null) {
            return null;
        }
        Arrays.fill(array, value);
        return array;
    }

    public static byte[] fill(byte[] array, byte value) {
        if (array == null) {
            return null;
        }
        Arrays.fill(array, value);
        return array;
    }

    public static short[] fill(short[] array, short value) {
        if (array == null) {
            return null;
        }
        Arrays.fill(array, value);
        return array;
    }

    public static int[] fill(int[] array, int value) {
        if (array == null) {
            return null;
        }
        Arrays.fill(array, value);
        return array;
    }

    public static long[] fill(long[] array, long value) {
        if (array == null) {
            return null;
        }
        Arrays.fill(array, value);
        return array;
    }

    public static float[] fill(float[] array, float value) {
        if (array == null) {
            return null;
        }
        Arrays.fill(array, value);
        return array;
    }

    public static double[] fill(double[] array, double value) {
        if (array == null) {
            return null;
        }
        Arrays.fill(array, value);
        return array;
    }

    public static char[] fill(char[] array, char value) {
        if (array == null) {
            return null;
        }
        Arrays.fill(array, value);
        return array;
    }

    public static <T> T[] fill(T[] array, T value) {
        if (array == null) {
            return null;
        }
        Arrays.fill(array, value);
        return array;
    }

    public static boolean[] fill(boolean[] array, int beginIndex, int endIndex, boolean value) {
        if (array == null) {
            return null;
        }
        Arrays.fill(array, beginIndex, endIndex, value);
        return array;
    }

    public static byte[] fill(byte[] array, int beginIndex, int endIndex, byte value) {
        if (array == null) {
            return null;
        }
        Arrays.fill(array, beginIndex, endIndex, value);
        return array;
    }

    public static short[] fill(short[] array, int beginIndex, int endIndex, short value) {
        if (array == null) {
            return null;
        }
        Arrays.fill(array, beginIndex, endIndex, value);
        return array;
    }

    public static int[] fill(int[] array, int beginIndex, int endIndex, int value) {
        if (array == null) {
            return null;
        }
        Arrays.fill(array, beginIndex, endIndex, value);
        return array;
    }

    public static long[] fill(long[] array, int beginIndex, int endIndex, long value) {
        if (array == null) {
            return null;
        }
        Arrays.fill(array, beginIndex, endIndex, value);
        return array;
    }

    public static float[] fill(float[] array, int beginIndex, int endIndex, float value) {
        if (array == null) {
            return null;
        }
        Arrays.fill(array, beginIndex, endIndex, value);
        return array;
    }

    public static double[] fill(double[] array, int beginIndex, int endIndex, double value) {
        if (array == null) {
            return null;
        }
        Arrays.fill(array, beginIndex, endIndex, value);
        return array;
    }

    public static char[] fill(char[] array, int beginIndex, int endIndex, char value) {
        if (array == null) {
            return null;
        }
        Arrays.fill(array, beginIndex, endIndex, value);
        return array;
    }

    public static <T> T[] fill(T[] array, int beginIndex, int endIndex, T value) {
        if (array == null) {
            return null;
        }
        Arrays.fill(array, beginIndex, endIndex, value);
        return array;
    }

    public static boolean[] add(boolean[] array, boolean... elements) {
        if (array == null) {
            return copy(elements);
        }
        if (elements == null) {
            return copy(array);
        }
        boolean[] result = new boolean[array.length + elements.length];
        System.arraycopy(array, 0, result, 0, array.length);
        System.arraycopy(elements, 0, result, array.length, elements.length);
        return result;
    }

    public static byte[] add(byte[] array, byte... elements) {
        if (array == null) {
            return copy(elements);
        }
        if (elements == null) {
            return copy(array);
        }
        byte[] result = new byte[array.length + elements.length];
        System.arraycopy(array, 0, result, 0, array.length);
        System.arraycopy(elements, 0, result, array.length, elements.length);
        return result;
    }

    public static short[] add(short[] array, short... elements) {
        if (array == null) {
            return copy(elements);
        }
        if (elements == null) {
            return copy(array);
        }
        short[] result = new short[array.length + elements.length];
        System.arraycopy(array, 0, result, 0, array.length);
        System.arraycopy(elements, 0, result, array.length, elements.length);
        return result;
    }

    public static int[] add(int[] array, int... elements) {
        if (array == null) {
            return copy(elements);
        }
        if (elements == null) {
            return copy(array);
        }
        int[] result = new int[array.length + elements.length];
        System.arraycopy(array, 0, result, 0, array.length);
        System.arraycopy(elements, 0, result, array.length, elements.length);
        return result;
    }

    public static long[] add(long[] array, long... elements) {
        if (array == null) {
            return copy(elements);
        }
        if (elements == null) {
            return copy(array);
        }
        long[] result = new long[array.length + elements.length];
        System.arraycopy(array, 0, result, 0, array.length);
        System.arraycopy(elements, 0, result, array.length, elements.length);
        return result;
    }

    public static float[] add(float[] array, float... elements) {
        if (array == null) {
            return copy(elements);
        }
        if (elements == null) {
            return copy(array);
        }
        float[] result = new float[array.length + elements.length];
        System.arraycopy(array, 0, result, 0, array.length);
        System.arraycopy(elements, 0, result, array.length, elements.length);
        return result;
    }

    public static double[] add(double[] array, double... elements) {
        if (array == null) {
            return copy(elements);
        }
        if (elements == null) {
            return copy(array);
        }
        double[] result = new double[array.length + elements.length];
        System.arraycopy(array, 0, result, 0, array.length);
        System.arraycopy(elements, 0, result, array.length, elements.length);
        return result;
    }

    public static char[] add(char[] array, char... elements) {
        if (array == null) {
            return copy(elements);
        }
        if (elements == null) {
            return copy(array);
        }
        char[] result = new char[array.length + elements.length];
        System.arraycopy(array, 0, result, 0, array.length);
        System.arraycopy(elements, 0, result, array.length, elements.length);
        return result;
    }

    @SafeVarargs
    public static <T> T[] add(T[] array, T... elements) {
        if (array == null) {
            return copy(elements);
        }
        if (elements == null) {
            return copy(array);
        }
        Class<?> type = array.getClass().getComponentType();
        @SuppressWarnings("unchecked")
        T[] result = (T[]) Array.newInstance(type, array.length + elements.length);
        System.arraycopy(array, 0, result, 0, array.length);
        System.arraycopy(elements, 0, result, array.length, elements.length);
        return result;
    }


    public static boolean[] insert(boolean[] array, int index, boolean... elements) throws IndexOutOfBoundsException {
        if (array == null) {
            return copy(elements);
        }
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (index > array.length) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (elements == null) {
            return copy(array);
        }
        boolean[] result = new boolean[array.length + elements.length];
        System.arraycopy(array, 0, result, 0, index);
        System.arraycopy(elements, 0, result, index, elements.length);
        System.arraycopy(array, index, result, index + elements.length, array.length - index);
        return result;
    }

    public static byte[] insert(byte[] array, int index, byte... elements) throws IndexOutOfBoundsException {
        if (array == null) {
            return copy(elements);
        }
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (index > array.length) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (elements == null) {
            return copy(array);
        }
        byte[] result = new byte[array.length + elements.length];
        System.arraycopy(array, 0, result, 0, index);
        System.arraycopy(elements, 0, result, index, elements.length);
        System.arraycopy(array, index, result, index + elements.length, array.length - index);
        return result;
    }

    public static short[] insert(short[] array, int index, short... elements) throws IndexOutOfBoundsException {
        if (array == null) {
            return copy(elements);
        }
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (index > array.length) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (elements == null) {
            return copy(array);
        }
        short[] result = new short[array.length + elements.length];
        System.arraycopy(array, 0, result, 0, index);
        System.arraycopy(elements, 0, result, index, elements.length);
        System.arraycopy(array, index, result, index + elements.length, array.length - index);
        return result;
    }

    public static int[] insert(int[] array, int index, int... elements) throws IndexOutOfBoundsException {
        if (array == null) {
            return copy(elements);
        }
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (index > array.length) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (elements == null) {
            return copy(array);
        }
        int[] result = new int[array.length + elements.length];
        System.arraycopy(array, 0, result, 0, index);
        System.arraycopy(elements, 0, result, index, elements.length);
        System.arraycopy(array, index, result, index + elements.length, array.length - index);
        return result;
    }

    public static long[] insert(long[] array, int index, long... elements) throws IndexOutOfBoundsException {
        if (array == null) {
            return copy(elements);
        }
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (index > array.length) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (elements == null) {
            return copy(array);
        }
        long[] result = new long[array.length + elements.length];
        System.arraycopy(array, 0, result, 0, index);
        System.arraycopy(elements, 0, result, index, elements.length);
        System.arraycopy(array, index, result, index + elements.length, array.length - index);
        return result;
    }

    public static float[] insert(float[] array, int index, float... elements) throws IndexOutOfBoundsException {
        if (array == null) {
            return copy(elements);
        }
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (index > array.length) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (elements == null) {
            return copy(array);
        }
        float[] result = new float[array.length + elements.length];
        System.arraycopy(array, 0, result, 0, index);
        System.arraycopy(elements, 0, result, index, elements.length);
        System.arraycopy(array, index, result, index + elements.length, array.length - index);
        return result;
    }

    public static double[] insert(double[] array, int index, double... elements) throws IndexOutOfBoundsException {
        if (array == null) {
            return copy(elements);
        }
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (index > array.length) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (elements == null) {
            return copy(array);
        }
        double[] result = new double[array.length + elements.length];
        System.arraycopy(array, 0, result, 0, index);
        System.arraycopy(elements, 0, result, index, elements.length);
        System.arraycopy(array, index, result, index + elements.length, array.length - index);
        return result;
    }

    public static char[] insert(char[] array, int index, char... elements) throws IndexOutOfBoundsException {
        if (array == null) {
            return copy(elements);
        }
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (index > array.length) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (elements == null) {
            return copy(array);
        }
        char[] result = new char[array.length + elements.length];
        System.arraycopy(array, 0, result, 0, index);
        System.arraycopy(elements, 0, result, index, elements.length);
        System.arraycopy(array, index, result, index + elements.length, array.length - index);
        return result;
    }

    @SafeVarargs
    public static <T> T[] insert(T[] array, int index, T... elements) throws IndexOutOfBoundsException {
        if (array == null) {
            return copy(elements);
        }
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (index > array.length) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (elements == null) {
            return copy(array);
        }
        Class<?> type = array.getClass().getComponentType();
        @SuppressWarnings("unchecked")
        T[] result = (T[]) Array.newInstance(type, array.length + elements.length);
        System.arraycopy(array, 0, result, 0, index);
        System.arraycopy(elements, 0, result, index, elements.length);
        System.arraycopy(array, index, result, index + elements.length, array.length - index);
        return result;
    }

    public static boolean[] removeIndices(boolean[] array, int... indices) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        Arrays.sort(indices);
        if (indices[0] < 0) {
            throw new ArrayIndexOutOfBoundsException(indices[0]);
        }
        int length = indices.length;
        if (indices[length - 1] > array.length) {
            throw new ArrayIndexOutOfBoundsException(indices[length - 1]);
        }
        boolean[] result = new boolean[array.length - length];
        for (int i = 0, j = 0, k = 0; k < array.length; k++) {
            if ((j < length) && (k == indices[j])) {
                j++;
            } else {
                result[i] = array[k];
                i++;
            }
        }
        return result;
    }

    public static byte[] removeIndices(byte[] array, int... indices) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        Arrays.sort(indices);
        if (indices[0] < 0) {
            throw new ArrayIndexOutOfBoundsException(indices[0]);
        }
        int length = indices.length;
        if (indices[length - 1] > array.length) {
            throw new ArrayIndexOutOfBoundsException(indices[length - 1]);
        }
        byte[] result = new byte[array.length - length];
        for (int i = 0, j = 0, k = 0; k < array.length; k++) {
            if ((j < length) && (k == indices[j])) {
                j++;
            } else {
                result[i] = array[k];
                i++;
            }
        }
        return result;
    }

    public static short[] removeIndices(short[] array, int... indices) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        Arrays.sort(indices);
        if (indices[0] < 0) {
            throw new ArrayIndexOutOfBoundsException(indices[0]);
        }
        int length = indices.length;
        if (indices[length - 1] > array.length) {
            throw new ArrayIndexOutOfBoundsException(indices[length - 1]);
        }
        short[] result = new short[array.length - length];
        for (int i = 0, j = 0, k = 0; k < array.length; k++) {
            if ((j < length) && (k == indices[j])) {
                j++;
            } else {
                result[i] = array[k];
                i++;
            }
        }
        return result;
    }

    public static int[] removeIndices(int[] array, int... indices) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        Arrays.sort(indices);
        if (indices[0] < 0) {
            throw new ArrayIndexOutOfBoundsException(indices[0]);
        }
        int length = indices.length;
        if (indices[length - 1] > array.length) {
            throw new ArrayIndexOutOfBoundsException(indices[length - 1]);
        }
        int[] result = new int[array.length - length];
        for (int i = 0, j = 0, k = 0; k < array.length; k++) {
            if ((j < length) && (k == indices[j])) {
                j++;
            } else {
                result[i] = array[k];
                i++;
            }
        }
        return result;
    }

    public static long[] removeIndices(long[] array, int... indices) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        Arrays.sort(indices);
        if (indices[0] < 0) {
            throw new ArrayIndexOutOfBoundsException(indices[0]);
        }
        int length = indices.length;
        if (indices[length - 1] > array.length) {
            throw new ArrayIndexOutOfBoundsException(indices[length - 1]);
        }
        long[] result = new long[array.length - length];
        for (int i = 0, j = 0, k = 0; k < array.length; k++) {
            if ((j < length) && (k == indices[j])) {
                j++;
            } else {
                result[i] = array[k];
                i++;
            }
        }
        return result;
    }

    public static float[] removeIndices(float[] array, int... indices) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        Arrays.sort(indices);
        if (indices[0] < 0) {
            throw new ArrayIndexOutOfBoundsException(indices[0]);
        }
        int length = indices.length;
        if (indices[length - 1] > array.length) {
            throw new ArrayIndexOutOfBoundsException(indices[length - 1]);
        }
        float[] result = new float[array.length - length];
        for (int i = 0, j = 0, k = 0; k < array.length; k++) {
            if ((j < length) && (k == indices[j])) {
                j++;
            } else {
                result[i] = array[k];
                i++;
            }
        }
        return result;
    }

    public static double[] removeIndices(double[] array, int... indices) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        Arrays.sort(indices);
        if (indices[0] < 0) {
            throw new ArrayIndexOutOfBoundsException(indices[0]);
        }
        int length = indices.length;
        if (indices[length - 1] > array.length) {
            throw new ArrayIndexOutOfBoundsException(indices[length - 1]);
        }
        double[] result = new double[array.length - length];
        for (int i = 0, j = 0, k = 0; k < array.length; k++) {
            if ((j < length) && (k == indices[j])) {
                j++;
            } else {
                result[i] = array[k];
                i++;
            }
        }
        return result;
    }

    public static char[] removeIndices(char[] array, int... indices) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        Arrays.sort(indices);
        if (indices[0] < 0) {
            throw new ArrayIndexOutOfBoundsException(indices[0]);
        }
        int length = indices.length;
        if (indices[length - 1] > array.length) {
            throw new ArrayIndexOutOfBoundsException(indices[length - 1]);
        }
        char[] result = new char[array.length - length];
        for (int i = 0, j = 0, k = 0; k < array.length; k++) {
            if ((j < length) && (k == indices[j])) {
                j++;
            } else {
                result[i] = array[k];
                i++;
            }
        }
        return result;
    }

    public static <T> T[] removeIndices(T[] array, int... indices) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        Arrays.sort(indices);
        if (indices[0] < 0) {
            throw new ArrayIndexOutOfBoundsException(indices[0]);
        }
        int length = indices.length;
        if (indices[length - 1] > array.length) {
            throw new ArrayIndexOutOfBoundsException(indices[length - 1]);
        }
        Class<?> type = array.getClass().getComponentType();
        @SuppressWarnings("unchecked")
        T[] result = (T[]) Array.newInstance(type, array.length - length);
        for (int i = 0, j = 0, k = 0; k < array.length; k++) {
            if ((j < length) && (k == indices[j])) {
                j++;
            } else {
                result[i] = array[k];
                i++;
            }
        }
        return result;
    }

    public static boolean[] remove(boolean[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        boolean[] result = new boolean[array.length - length];
        System.arraycopy(array, 0, result, 0, beginIndex);
        System.arraycopy(array, endIndex, result, beginIndex, array.length - endIndex);
        return result;
    }

    public static byte[] remove(byte[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        byte[] result = new byte[array.length - length];
        System.arraycopy(array, 0, result, 0, beginIndex);
        System.arraycopy(array, endIndex, result, beginIndex, array.length - endIndex);
        return result;
    }

    public static short[] remove(short[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        short[] result = new short[array.length - length];
        System.arraycopy(array, 0, result, 0, beginIndex);
        System.arraycopy(array, endIndex, result, beginIndex, array.length - endIndex);
        return result;
    }

    public static int[] remove(int[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int[] result = new int[array.length - length];
        System.arraycopy(array, 0, result, 0, beginIndex);
        System.arraycopy(array, endIndex, result, beginIndex, array.length - endIndex);
        return result;
    }

    public static long[] remove(long[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        long[] result = new long[array.length - length];
        System.arraycopy(array, 0, result, 0, beginIndex);
        System.arraycopy(array, endIndex, result, beginIndex, array.length - endIndex);
        return result;
    }

    public static float[] remove(float[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        float[] result = new float[array.length - length];
        System.arraycopy(array, 0, result, 0, beginIndex);
        System.arraycopy(array, endIndex, result, beginIndex, array.length - endIndex);
        return result;
    }

    public static double[] remove(double[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        double[] result = new double[array.length - length];
        System.arraycopy(array, 0, result, 0, beginIndex);
        System.arraycopy(array, endIndex, result, beginIndex, array.length - endIndex);
        return result;
    }

    public static char[] remove(char[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        char[] result = new char[array.length - length];
        System.arraycopy(array, 0, result, 0, beginIndex);
        System.arraycopy(array, endIndex, result, beginIndex, array.length - endIndex);
        return result;
    }

    public static <T> T[] remove(T[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        Class<?> type = array.getClass().getComponentType();
        @SuppressWarnings("unchecked")
        T[] result = (T[]) Array.newInstance(type, array.length - length);
        System.arraycopy(array, 0, result, 0, beginIndex);
        System.arraycopy(array, endIndex, result, beginIndex, array.length - endIndex);
        return result;
    }

	public static boolean[] remove(boolean[] array, boolean... elements) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        int length = array.length;
        boolean[] temp = new boolean[length];
        int j = 0;
        for (int i = 0; i < length; i++) {
        	boolean remove = false;
        	for (int k = 0; k < elements.length; k++) {
        		remove = remove || array[i] == elements[k];
        	}
        	if (!remove) {
        		temp[j] = array[i];
                j++;
            }
        }
        boolean[] result = new boolean[j];
        System.arraycopy(temp, 0, result, 0, j);
        return result;
    }

	public static byte[] remove(byte[] array, byte... elements) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        int length = array.length;
        byte[] temp = new byte[length];
        int j = 0;
        for (int i = 0; i < length; i++) {
        	boolean remove = false;
        	for (int k = 0; k < elements.length; k++) {
        		remove = remove || array[i] == elements[k];
        	}
        	if (!remove) {
        		temp[j] = array[i];
                j++;
            }
        }
        byte[] result = new byte[j];
        System.arraycopy(temp, 0, result, 0, j);
        return result;
    }

	public static short[] remove(short[] array, short... elements) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        int length = array.length;
        short[] temp = new short[length];
        int j = 0;
        for (int i = 0; i < length; i++) {
        	boolean remove = false;
        	for (int k = 0; k < elements.length; k++) {
        		remove = remove || array[i] == elements[k];
        	}
        	if (!remove) {
        		temp[j] = array[i];
                j++;
            }
        }
        short[] result = new short[j];
        System.arraycopy(temp, 0, result, 0, j);
        return result;
    }

	public static int[] remove(int[] array, int... elements) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        int length = array.length;
        int[] temp = new int[length];
        int j = 0;
        for (int i = 0; i < length; i++) {
        	boolean remove = false;
        	for (int k = 0; k < elements.length; k++) {
        		remove = remove || array[i] == elements[k];
        	}
        	if (!remove) {
        		temp[j] = array[i];
                j++;
            }
        }
        int[] result = new int[j];
        System.arraycopy(temp, 0, result, 0, j);
        return result;
    }

	public static long[] remove(long[] array, long... elements) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        int length = array.length;
        long[] temp = new long[length];
        int j = 0;
        for (int i = 0; i < length; i++) {
        	boolean remove = false;
        	for (int k = 0; k < elements.length; k++) {
        		remove = remove || array[i] == elements[k];
        	}
        	if (!remove) {
        		temp[j] = array[i];
                j++;
            }
        }
        long[] result = new long[j];
        System.arraycopy(temp, 0, result, 0, j);
        return result;
    }

	public static float[] remove(float[] array, float... elements) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        int length = array.length;
        float[] temp = new float[length];
        int j = 0;
        for (int i = 0; i < length; i++) {
        	boolean remove = false;
        	for (int k = 0; k < elements.length; k++) {
        		remove = remove || array[i] == elements[k];
        	}
        	if (!remove) {
        		temp[j] = array[i];
                j++;
            }
        }
        float[] result = new float[j];
        System.arraycopy(temp, 0, result, 0, j);
        return result;
    }

	public static double[] remove(double[] array, double... elements) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        int length = array.length;
        double[] temp = new double[length];
        int j = 0;
        for (int i = 0; i < length; i++) {
        	boolean remove = false;
        	for (int k = 0; k < elements.length; k++) {
        		remove = remove || array[i] == elements[k];
        	}
        	if (!remove) {
        		temp[j] = array[i];
                j++;
            }
        }
        double[] result = new double[j];
        System.arraycopy(temp, 0, result, 0, j);
        return result;
    }

	public static char[] remove(char[] array, char... elements) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        int length = array.length;
        char[] temp = new char[length];
        int j = 0;
        for (int i = 0; i < length; i++) {
        	boolean remove = false;
        	for (int k = 0; k < elements.length; k++) {
        		remove = remove || array[i] == elements[k];
        	}
        	if (!remove) {
        		temp[j] = array[i];
                j++;
            }
        }
        char[] result = new char[j];
        System.arraycopy(temp, 0, result, 0, j);
        return result;
    }

    @SafeVarargs
	public static <T> T[] remove(T[] array, T... elements) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        int length = array.length;
        Class<?> type = array.getClass().getComponentType();
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) Array.newInstance(type, length);
        int j = 0;
        for (int i = 0; i < length; i++) {
        	boolean remove = false;
        	for (int k = 0; k < elements.length; k++) {
        		remove = remove || Objects.equals(array[i], elements[k]);
        	}
        	if (!remove) {
        		temp[j] = array[i];
                j++;
            }
        }
        @SuppressWarnings("unchecked")
        T[] result = (T[]) Array.newInstance(type, j);
        System.arraycopy(temp, 0, result, 0, j);
        return result;
    }

    public static boolean[] resize(boolean[] array, int size, boolean value) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (size < 0) {
            throw new ArrayIndexOutOfBoundsException(size);
        }
        boolean[] result = new boolean[size];
        if (size < array.length) {
            System.arraycopy(array, 0, result, 0, size);
        } else {
            System.arraycopy(array, 0, result, 0, array.length);
            Arrays.fill(result, array.length, size, value);
        }
        return result;
    }

    public static byte[] resize(byte[] array, int size, byte value) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (size < 0) {
            throw new ArrayIndexOutOfBoundsException(size);
        }
        byte[] result = new byte[size];
        if (size < array.length) {
            System.arraycopy(array, 0, result, 0, size);
        } else {
            System.arraycopy(array, 0, result, 0, array.length);
            Arrays.fill(result, array.length, size, value);
        }
        return result;
    }

    public static short[] resize(short[] array, int size, short value) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (size < 0) {
            throw new ArrayIndexOutOfBoundsException(size);
        }
        short[] result = new short[size];
        if (size < array.length) {
            System.arraycopy(array, 0, result, 0, size);
        } else {
            System.arraycopy(array, 0, result, 0, array.length);
            Arrays.fill(result, array.length, size, value);
        }
        return result;
    }

    public static int[] resize(int[] array, int size, int value) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (size < 0) {
            throw new ArrayIndexOutOfBoundsException(size);
        }
        int[] result = new int[size];
        if (size < array.length) {
            System.arraycopy(array, 0, result, 0, size);
        } else {
            System.arraycopy(array, 0, result, 0, array.length);
            Arrays.fill(result, array.length, size, value);
        }
        return result;
    }

    public static long[] resize(long[] array, int size, long value) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (size < 0) {
            throw new ArrayIndexOutOfBoundsException(size);
        }
        long[] result = new long[size];
        if (size < array.length) {
            System.arraycopy(array, 0, result, 0, size);
        } else {
            System.arraycopy(array, 0, result, 0, array.length);
            Arrays.fill(result, array.length, size, value);
        }
        return result;
    }

    public static float[] resize(float[] array, int size, float value) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (size < 0) {
            throw new ArrayIndexOutOfBoundsException(size);
        }
        float[] result = new float[size];
        if (size < array.length) {
            System.arraycopy(array, 0, result, 0, size);
        } else {
            System.arraycopy(array, 0, result, 0, array.length);
            Arrays.fill(result, array.length, size, value);
        }
        return result;
    }

    public static double[] resize(double[] array, int size, double value) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (size < 0) {
            throw new ArrayIndexOutOfBoundsException(size);
        }
        double[] result = new double[size];
        if (size < array.length) {
            System.arraycopy(array, 0, result, 0, size);
        } else {
            System.arraycopy(array, 0, result, 0, array.length);
            Arrays.fill(result, array.length, size, value);
        }
        return result;
    }

    public static char[] resize(char[] array, int size, char value) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (size < 0) {
            throw new ArrayIndexOutOfBoundsException(size);
        }
        char[] result = new char[size];
        if (size < array.length) {
            System.arraycopy(array, 0, result, 0, size);
        } else {
            System.arraycopy(array, 0, result, 0, array.length);
            Arrays.fill(result, array.length, size, value);
        }
        return result;
    }

    public static <T> T[] resize(T[] array, int size, T value) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (size < 0) {
            throw new ArrayIndexOutOfBoundsException(size);
        }
        Class<?> type = array.getClass().getComponentType();
        @SuppressWarnings("unchecked")
        T[] result = (T[]) Array.newInstance(type, size);
        if (size < array.length) {
            System.arraycopy(array, 0, result, 0, size);
        } else {
            System.arraycopy(array, 0, result, 0, array.length);
            Arrays.fill(result, array.length, size, value);
        }
        return result;
    }

    public static boolean[] subarray(boolean[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        boolean[] result = new boolean[length];
        System.arraycopy(array, beginIndex, result, 0, length);
        return result;
    }

    public static byte[] subarray(byte[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        byte[] result = new byte[length];
        System.arraycopy(array, beginIndex, result, 0, length);
        return result;
    }

    public static short[] subarray(short[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        short[] result = new short[length];
        System.arraycopy(array, beginIndex, result, 0, length);
        return result;
    }

    public static int[] subarray(int[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int[] result = new int[length];
        System.arraycopy(array, beginIndex, result, 0, length);
        return result;
    }

    public static long[] subarray(long[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        long[] result = new long[length];
        System.arraycopy(array, beginIndex, result, 0, length);
        return result;
    }

    public static float[] subarray(float[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        float[] result = new float[length];
        System.arraycopy(array, beginIndex, result, 0, length);
        return result;
    }

    public static double[] subarray(double[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        double[] result = new double[length];
        System.arraycopy(array, beginIndex, result, 0, length);
        return result;
    }

    public static char[] subarray(char[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        char[] result = new char[length];
        System.arraycopy(array, beginIndex, result, 0, length);
        return result;
    }

    public static <T> T[] subarray(T[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        Class<?> type = array.getClass().getComponentType();
        @SuppressWarnings("unchecked")
        T[] result = (T[]) Array.newInstance(type, length);
        System.arraycopy(array, beginIndex, result, 0, length);
        return result;
    }

    public static boolean[][] split(boolean[] array, int... indices) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if ((indices == null) || (indices.length == 0)) {
            return new boolean[][] { array };
        }
        int[] newIndices = new int[indices.length + 2];
        System.arraycopy(indices, 0, newIndices, 1, indices.length);
        newIndices[0] = 0;
        newIndices[indices.length + 1] = array.length;
        indices = newIndices;
        boolean[][] result = new boolean[indices.length - 1][];
        for (int i = 0; i < indices.length - 1; i++) {
            result[i] = subarray(array, indices[i], indices[i + 1]);
        }
        return result;
    }

    public static byte[][] split(byte[] array, int... indices) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if ((indices == null) || (indices.length == 0)) {
            return new byte[][] { array };
        }
        int[] newIndices = new int[indices.length + 2];
        System.arraycopy(indices, 0, newIndices, 1, indices.length);
        newIndices[0] = 0;
        newIndices[indices.length + 1] = array.length;
        indices = newIndices;
        byte[][] result = new byte[indices.length - 1][];
        for (int i = 0; i < indices.length - 1; i++) {
            result[i] = subarray(array, indices[i], indices[i + 1]);
        }
        return result;
    }

    public static short[][] split(short[] array, int... indices) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if ((indices == null) || (indices.length == 0)) {
            return new short[][] { array };
        }
        int[] newIndices = new int[indices.length + 2];
        System.arraycopy(indices, 0, newIndices, 1, indices.length);
        newIndices[0] = 0;
        newIndices[indices.length + 1] = array.length;
        indices = newIndices;
        short[][] result = new short[indices.length - 1][];
        for (int i = 0; i < indices.length - 1; i++) {
            result[i] = subarray(array, indices[i], indices[i + 1]);
        }
        return result;
    }

    public static int[][] split(int[] array, int... indices) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if ((indices == null) || (indices.length == 0)) {
            return new int[][] { array };
        }
        int[] newIndices = new int[indices.length + 2];
        System.arraycopy(indices, 0, newIndices, 1, indices.length);
        newIndices[0] = 0;
        newIndices[indices.length + 1] = array.length;
        indices = newIndices;
        int[][] result = new int[indices.length - 1][];
        for (int i = 0; i < indices.length - 1; i++) {
            result[i] = subarray(array, indices[i], indices[i + 1]);
        }
        return result;
    }

    public static long[][] split(long[] array, int... indices) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if ((indices == null) || (indices.length == 0)) {
            return new long[][] { array };
        }
        int[] newIndices = new int[indices.length + 2];
        System.arraycopy(indices, 0, newIndices, 1, indices.length);
        newIndices[0] = 0;
        newIndices[indices.length + 1] = array.length;
        indices = newIndices;
        long[][] result = new long[indices.length - 1][];
        for (int i = 0; i < indices.length - 1; i++) {
            result[i] = subarray(array, indices[i], indices[i + 1]);
        }
        return result;
    }

    public static float[][] split(float[] array, int... indices) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if ((indices == null) || (indices.length == 0)) {
            return new float[][] { array };
        }
        int[] newIndices = new int[indices.length + 2];
        System.arraycopy(indices, 0, newIndices, 1, indices.length);
        newIndices[0] = 0;
        newIndices[indices.length + 1] = array.length;
        indices = newIndices;
        float[][] result = new float[indices.length - 1][];
        for (int i = 0; i < indices.length - 1; i++) {
            result[i] = subarray(array, indices[i], indices[i + 1]);
        }
        return result;
    }

    public static double[][] split(double[] array, int... indices) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if ((indices == null) || (indices.length == 0)) {
            return new double[][] { array };
        }
        int[] newIndices = new int[indices.length + 2];
        System.arraycopy(indices, 0, newIndices, 1, indices.length);
        newIndices[0] = 0;
        newIndices[indices.length + 1] = array.length;
        indices = newIndices;
        double[][] result = new double[indices.length - 1][];
        for (int i = 0; i < indices.length - 1; i++) {
            result[i] = subarray(array, indices[i], indices[i + 1]);
        }
        return result;
    }

    public static char[][] split(char[] array, int... indices) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if ((indices == null) || (indices.length == 0)) {
            return new char[][] { array };
        }
        int[] newIndices = new int[indices.length + 2];
        System.arraycopy(indices, 0, newIndices, 1, indices.length);
        newIndices[0] = 0;
        newIndices[indices.length + 1] = array.length;
        indices = newIndices;
        char[][] result = new char[indices.length - 1][];
        for (int i = 0; i < indices.length - 1; i++) {
            result[i] = subarray(array, indices[i], indices[i + 1]);
        }
        return result;
    }

    public static <T> T[][] split(T[] array, int... indices) throws IndexOutOfBoundsException {
        if (array == null) {
            return null;
        }
        if ((indices == null) || (indices.length == 0)) {
            Class<?> type = array.getClass().getComponentType();
            @SuppressWarnings("unchecked")
            T[][] result = (T[][]) Array.newInstance(type, 1);
            result[0] = array;
            return result;
        }
        int[] newIndices = new int[indices.length + 2];
        System.arraycopy(indices, 0, newIndices, 1, indices.length);
        newIndices[0] = 0;
        newIndices[indices.length + 1] = array.length;
        indices = newIndices;
        Class<?> type = array.getClass().getComponentType();
        @SuppressWarnings("unchecked")
        T[][] result = (T[][]) Array.newInstance(type, indices.length - 1);
        for (int i = 0; i < indices.length - 1; i++) {
            result[i] = subarray(array, indices[i], indices[i + 1]);
        }
        return result;
    }

    // TODO split(array, element)

    public static boolean[] join(boolean[][]... arrays) {
        if (arrays == null) {
            return null;
        }
        int size = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != null) {
                size = size + arrays[i].length;
            }
        }
        boolean[] result = new boolean[size];
        int index = 0;
        for (int i = 0; i < arrays.length; i++) {
            System.arraycopy(arrays[i], 0, result, index, arrays[i].length);
            index = index + arrays[i].length;
        }
        return result;
    }

    public static byte[] join(byte[][]... arrays) {
        if (arrays == null) {
            return null;
        }
        int size = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != null) {
                size = size + arrays[i].length;
            }
        }
        byte[] result = new byte[size];
        int index = 0;
        for (int i = 0; i < arrays.length; i++) {
            System.arraycopy(arrays[i], 0, result, index, arrays[i].length);
            index = index + arrays[i].length;
        }
        return result;
    }

    public static short[] join(short[][]... arrays) {
        if (arrays == null) {
            return null;
        }
        int size = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != null) {
                size = size + arrays[i].length;
            }
        }
        short[] result = new short[size];
        int index = 0;
        for (int i = 0; i < arrays.length; i++) {
            System.arraycopy(arrays[i], 0, result, index, arrays[i].length);
            index = index + arrays[i].length;
        }
        return result;
    }

    public static int[] join(int[][]... arrays) {
        if (arrays == null) {
            return null;
        }
        int size = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != null) {
                size = size + arrays[i].length;
            }
        }
        int[] result = new int[size];
        int index = 0;
        for (int i = 0; i < arrays.length; i++) {
            System.arraycopy(arrays[i], 0, result, index, arrays[i].length);
            index = index + arrays[i].length;
        }
        return result;
    }

    public static long[] join(long[][]... arrays) {
        if (arrays == null) {
            return null;
        }
        int size = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != null) {
                size = size + arrays[i].length;
            }
        }
        long[] result = new long[size];
        int index = 0;
        for (int i = 0; i < arrays.length; i++) {
            System.arraycopy(arrays[i], 0, result, index, arrays[i].length);
            index = index + arrays[i].length;
        }
        return result;
    }

    public static float[] join(float[][]... arrays) {
        if (arrays == null) {
            return null;
        }
        int size = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != null) {
                size = size + arrays[i].length;
            }
        }
        float[] result = new float[size];
        int index = 0;
        for (int i = 0; i < arrays.length; i++) {
            System.arraycopy(arrays[i], 0, result, index, arrays[i].length);
            index = index + arrays[i].length;
        }
        return result;
    }

    public static double[] join(double[][]... arrays) {
        if (arrays == null) {
            return null;
        }
        int size = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != null) {
                size = size + arrays[i].length;
            }
        }
        double[] result = new double[size];
        int index = 0;
        for (int i = 0; i < arrays.length; i++) {
            System.arraycopy(arrays[i], 0, result, index, arrays[i].length);
            index = index + arrays[i].length;
        }
        return result;
    }

    public static char[] join(char[][]... arrays) {
        if (arrays == null) {
            return null;
        }
        int size = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != null) {
                size = size + arrays[i].length;
            }
        }
        char[] result = new char[size];
        int index = 0;
        for (int i = 0; i < arrays.length; i++) {
            System.arraycopy(arrays[i], 0, result, index, arrays[i].length);
            index = index + arrays[i].length;
        }
        return result;
    }

    @SafeVarargs
    public static <T> T[] join(T[][]... arrays) {
        if (arrays == null) {
            return null;
        }
        int size = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != null) {
                size = size + arrays[i].length;
            }
        }
        Class<?> type = arrays.getClass().getComponentType().getComponentType();
        @SuppressWarnings("unchecked")
        T[] result = (T[]) Array.newInstance(type, size);
        int index = 0;
        for (int i = 0; i < arrays.length; i++) {
            System.arraycopy(arrays[i], 0, result, index, arrays[i].length);
            index = index + arrays[i].length;
        }
        return result;
    }

    public static void reverse(boolean[] array) {
        reverse(array, 0, array.length);
    }

    public static void reverse(byte[] array) {
        reverse(array, 0, array.length);
    }

    public static void reverse(short[] array) {
        reverse(array, 0, array.length);
    }

    public static void reverse(int[] array) {
        reverse(array, 0, array.length);
    }

    public static void reverse(long[] array) {
        reverse(array, 0, array.length);
    }

    public static void reverse(float[] array) {
        reverse(array, 0, array.length);
    }

    public static void reverse(double[] array) {
        reverse(array, 0, array.length);
    }

    public static void reverse(char[] array) {
        reverse(array, 0, array.length);
    }

    public static <T> void reverse(T[] array) {
        reverse(array, 0, array.length);
    }

    public static void reverse(boolean[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int i = beginIndex;
        int j = endIndex - 1;
        while (j > i) {
            boolean tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
    }

    public static void reverse(byte[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int i = beginIndex;
        int j = endIndex - 1;
        while (j > i) {
            byte tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
    }

    public static void reverse(short[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int i = beginIndex;
        int j = endIndex - 1;
        while (j > i) {
            short tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
    }

    public static void reverse(int[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int i = beginIndex;
        int j = endIndex - 1;
        while (j > i) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
    }

    public static void reverse(long[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int i = beginIndex;
        int j = endIndex - 1;
        while (j > i) {
            long tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
    }

    public static void reverse(float[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int i = beginIndex;
        int j = endIndex - 1;
        while (j > i) {
            float tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
    }

    public static void reverse(double[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int i = beginIndex;
        int j = endIndex - 1;
        while (j > i) {
            double tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
    }

    public static void reverse(char[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int i = beginIndex;
        int j = endIndex - 1;
        while (j > i) {
            char tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
    }

    public static <T> void reverse(T[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int i = beginIndex;
        int j = endIndex - 1;
        while (j > i) {
            T tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
    }

    public static void sort(boolean[] array) {
        sort(array, 0, array.length);
    }

    public static void sort(byte[] array) {
        sort(array, 0, array.length);
    }

    public static void sort(short[] array) {
        sort(array, 0, array.length);
    }

    public static void sort(int[] array) {
        sort(array, 0, array.length);
    }

    public static void sort(long[] array) {
        sort(array, 0, array.length);
    }

    public static void sort(float[] array) {
        sort(array, 0, array.length);
    }

    public static void sort(double[] array) {
        sort(array, 0, array.length);
    }

    public static void sort(char[] array) {
        sort(array, 0, array.length);
    }

    public static <T extends Comparable<? super T>> void sort(T[] array) {
        sort(array, 0, array.length);
    }

    public static <T> void sort(T[] array, Comparator<T> comparator) {
        sort(array, 0, array.length, comparator);
    }

    public static void sort(boolean[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int falseCount = 0;
        for (int i = beginIndex; i < endIndex; i++) {
            if (!array[i]) {
                falseCount++;
            }
        }
        if (falseCount > 0) {
            Arrays.fill(array, beginIndex, beginIndex + falseCount, false);
            Arrays.fill(array, beginIndex + falseCount, endIndex, false);
        }
    }

    public static void sort(byte[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        Arrays.parallelSort(array, beginIndex, endIndex);
    }

    public static void sort(short[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        Arrays.parallelSort(array, beginIndex, endIndex);
    }

    public static void sort(int[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        Arrays.parallelSort(array, beginIndex, endIndex);
    }

    public static void sort(long[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        Arrays.parallelSort(array, beginIndex, endIndex);
    }

    public static void sort(float[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        Arrays.parallelSort(array, beginIndex, endIndex);
    }

    public static void sort(double[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        Arrays.parallelSort(array, beginIndex, endIndex);
    }

    public static void sort(char[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        Arrays.parallelSort(array, beginIndex, endIndex);
    }

    public static <T extends Comparable<? super T>> void sort(T[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        Arrays.parallelSort(array, beginIndex, endIndex);
    }

    public static <T> void sort(T[] array, int beginIndex, int endIndex, Comparator<T> comparator) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        Arrays.parallelSort(array, beginIndex, endIndex, comparator);
    }

    private static int nextInt(int bound) {
        return (int) (bound * Math.random());
    }

    public static void randomize(boolean[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        for (int i = beginIndex; i < endIndex; i++) {
            int index = nextInt(i + 1);
            boolean tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
    }

    public static void randomize(byte[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        for (int i = beginIndex; i < endIndex; i++) {
            int index = nextInt(i + 1);
            byte tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
    }

    public static void randomize(short[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        for (int i = beginIndex; i < endIndex; i++) {
            int index = nextInt(i + 1);
            short tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
    }

    public static void randomize(int[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        for (int i = beginIndex; i < endIndex; i++) {
            int index = nextInt(i + 1);
            int tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
    }

    public static void randomize(long[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        for (int i = beginIndex; i < endIndex; i++) {
            int index = nextInt(i + 1);
            long tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
    }

    public static void randomize(float[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        for (int i = beginIndex; i < endIndex; i++) {
            int index = nextInt(i + 1);
            float tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
    }

    public static void randomize(double[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        for (int i = beginIndex; i < endIndex; i++) {
            int index = nextInt(i + 1);
            double tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
    }

    public static void randomize(char[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        for (int i = beginIndex; i < endIndex; i++) {
            int index = nextInt(i + 1);
            char tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
    }

    public static <T> void randomize(T[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        for (int i = beginIndex; i < endIndex; i++) {
            int index = nextInt(i + 1);
            T tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
    }

    public static void randomize(boolean[] array, int beginIndex, int endIndex, Random random) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        for (int i = beginIndex; i < endIndex; i++) {
            int index = random.nextInt(i + 1);
            boolean tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
    }

    public static void randomize(byte[] array, int beginIndex, int endIndex, Random random) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        for (int i = beginIndex; i < endIndex; i++) {
            int index = random.nextInt(i + 1);
            byte tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
    }

    public static void randomize(short[] array, int beginIndex, int endIndex, Random random) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        for (int i = beginIndex; i < endIndex; i++) {
            int index = random.nextInt(i + 1);
            short tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
    }

    public static void randomize(int[] array, int beginIndex, int endIndex, Random random) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        for (int i = beginIndex; i < endIndex; i++) {
            int index = random.nextInt(i + 1);
            int tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
    }

    public static void randomize(long[] array, int beginIndex, int endIndex, Random random) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        for (int i = beginIndex; i < endIndex; i++) {
            int index = random.nextInt(i + 1);
            long tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
    }

    public static void randomize(float[] array, int beginIndex, int endIndex, Random random) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        for (int i = beginIndex; i < endIndex; i++) {
            int index = random.nextInt(i + 1);
            float tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
    }

    public static void randomize(double[] array, int beginIndex, int endIndex, Random random) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        for (int i = beginIndex; i < endIndex; i++) {
            int index = random.nextInt(i + 1);
            double tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
    }

    public static void randomize(char[] array, int beginIndex, int endIndex, Random random) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        for (int i = beginIndex; i < endIndex; i++) {
            int index = random.nextInt(i + 1);
            char tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
    }

    public static <T> void randomize(T[] array, int beginIndex, int endIndex, Random random) throws IndexOutOfBoundsException {
        if (array == null) {
            return;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        for (int i = beginIndex; i < endIndex; i++) {
            int index = random.nextInt(i + 1);
            T tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
    }

    public static boolean pick(boolean[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int index = nextInt(array.length);
        boolean result = array[index];
        return result;
    }

    public static byte pick(byte[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int index = nextInt(array.length);
        byte result = array[index];
        return result;
    }

    public static short pick(short[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int index = nextInt(array.length);
        short result = array[index];
        return result;
    }

    public static int pick(int[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int index = nextInt(array.length);
        int result = array[index];
        return result;
    }

    public static long pick(long[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int index = nextInt(array.length);
        long result = array[index];
        return result;
    }

    public static float pick(float[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int index = nextInt(array.length);
        float result = array[index];
        return result;
    }

    public static double pick(double[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int index = nextInt(array.length);
        double result = array[index];
        return result;
    }

    public static char pick(char[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int index = nextInt(array.length);
        char result = array[index];
        return result;
    }

    public static <T> T pick(T[] array, int beginIndex, int endIndex) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int index = nextInt(array.length);
        T result = array[index];
        return result;
    }

    public static boolean pick(boolean[] array, int beginIndex, int endIndex, Random random) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int index = random.nextInt(array.length);
        boolean result = array[index];
        return result;
    }

    public static byte pick(byte[] array, int beginIndex, int endIndex, Random random) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int index = random.nextInt(array.length);
        byte result = array[index];
        return result;
    }

    public static short pick(short[] array, int beginIndex, int endIndex, Random random) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int index = random.nextInt(array.length);
        short result = array[index];
        return result;
    }

    public static int pick(int[] array, int beginIndex, int endIndex, Random random) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int index = random.nextInt(array.length);
        int result = array[index];
        return result;
    }

    public static long pick(long[] array, int beginIndex, int endIndex, Random random) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int index = random.nextInt(array.length);
        long result = array[index];
        return result;
    }

    public static float pick(float[] array, int beginIndex, int endIndex, Random random) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int index = random.nextInt(array.length);
        float result = array[index];
        return result;
    }

    public static double pick(double[] array, int beginIndex, int endIndex, Random random) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int index = random.nextInt(array.length);
        double result = array[index];
        return result;
    }

    public static char pick(char[] array, int beginIndex, int endIndex, Random random) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int index = random.nextInt(array.length);
        char result = array[index];
        return result;
    }

    public static <T> T pick(T[] array, int beginIndex, int endIndex, Random random) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        if (endIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        int length = endIndex - beginIndex;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException(length);
        }
        int index = random.nextInt(array.length);
        T result = array[index];
        return result;
    }

    public static int indexOf(boolean[] array, boolean valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    public static int indexOf(byte[] array, byte valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    public static int indexOf(short[] array, short valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    public static int indexOf(int[] array, int valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    public static int indexOf(long[] array, long valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    public static int indexOf(float[] array, float valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    public static int indexOf(float[] array, float valueToFind, float tolerance) {
        return indexOf(array, valueToFind, 0, tolerance);
    }

    public static int indexOf(double[] array, double valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    public static int indexOf(double[] array, double valueToFind, double tolerance) {
        return indexOf(array, valueToFind, 0, tolerance);
    }

    public static int indexOf(char[] array, char valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    public static <T> int indexOf(T[] array, T valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    public static int indexOf(boolean[] array, boolean valueToFind, int beginIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        for (int i = beginIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int indexOf(byte[] array, byte valueToFind, int beginIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        for (int i = beginIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int indexOf(short[] array, short valueToFind, int beginIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        for (int i = beginIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int indexOf(int[] array, int valueToFind, int beginIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        for (int i = beginIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int indexOf(long[] array, long valueToFind, int beginIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        for (int i = beginIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int indexOf(float[] array, float valueToFind, int beginIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        for (int i = beginIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int indexOf(float[] array, float valueToFind, int beginIndex, float tolerance) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        final double min = valueToFind - tolerance;
        final double max = valueToFind + tolerance;
        for (int i = beginIndex; i < array.length; i++) {
            if ((min <= array[i]) && (max >= array[i])) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int indexOf(double[] array, double valueToFind, int beginIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        for (int i = beginIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int indexOf(double[] array, double valueToFind, int beginIndex, double tolerance) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        final double min = valueToFind - tolerance;
        final double max = valueToFind + tolerance;
        for (int i = beginIndex; i < array.length; i++) {
            if ((min <= array[i]) && (max >= array[i])) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int indexOf(char[] array, char valueToFind, int beginIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        for (int i = beginIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static <T> int indexOf(T[] array, T valueToFind, int beginIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        for (int i = beginIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(boolean[] array, boolean valueToFind) {
        return lastIndexOf(array, valueToFind, array.length - 1);
    }

    public static int lastIndexOf(byte[] array, byte valueToFind) {
        return lastIndexOf(array, valueToFind, array.length - 1);
    }

    public static int lastIndexOf(short[] array, short valueToFind) {
        return lastIndexOf(array, valueToFind, array.length - 1);
    }

    public static int lastIndexOf(int[] array, int valueToFind) {
        return lastIndexOf(array, valueToFind, array.length - 1);
    }

    public static int lastIndexOf(long[] array, long valueToFind) {
        return lastIndexOf(array, valueToFind, array.length - 1);
    }

    public static int lastIndexOf(float[] array, float valueToFind) {
        return lastIndexOf(array, valueToFind, array.length - 1);
    }

    public static int lastIndexOf(float[] array, float valueToFind, float tolerance) {
        return lastIndexOf(array, valueToFind, array.length - 1, tolerance);
    }

    public static int lastIndexOf(double[] array, double valueToFind) {
        return lastIndexOf(array, valueToFind, array.length - 1);
    }

    public static int lastIndexOf(double[] array, double valueToFind, double tolerance) {
        return lastIndexOf(array, valueToFind, array.length - 1, tolerance);
    }

    public static int lastIndexOf(char[] array, char valueToFind) {
        return lastIndexOf(array, valueToFind, array.length - 1);
    }

    public static <T> int lastIndexOf(T[] array, T valueToFind) {
        return lastIndexOf(array, valueToFind, array.length - 1);
    }

    public static int lastIndexOf(boolean[] array, boolean valueToFind, int beginIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        } else if (beginIndex >= array.length) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        for (int i = beginIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(byte[] array, byte valueToFind, int beginIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        } else if (beginIndex >= array.length) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        for (int i = beginIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(short[] array, short valueToFind, int beginIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        } else if (beginIndex >= array.length) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        for (int i = beginIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(int[] array, int valueToFind, int beginIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        } else if (beginIndex >= array.length) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        for (int i = beginIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(long[] array, long valueToFind, int beginIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        } else if (beginIndex >= array.length) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        for (int i = beginIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(float[] array, float valueToFind, int beginIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        } else if (beginIndex >= array.length) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        for (int i = beginIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(float[] array, float valueToFind, int beginIndex, float tolerance) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        } else if (beginIndex >= array.length) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        double min = valueToFind - tolerance;
        double max = valueToFind + tolerance;
        for (int i = beginIndex; i >= 0; i--) {
            if ((min <= array[i]) && (max >= array[i])) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(double[] array, double valueToFind, int beginIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        } else if (beginIndex >= array.length) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        for (int i = beginIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(double[] array, double valueToFind, int beginIndex, double tolerance) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        } else if (beginIndex >= array.length) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        double min = valueToFind - tolerance;
        double max = valueToFind + tolerance;
        for (int i = beginIndex; i >= 0; i--) {
            if ((min <= array[i]) && (max >= array[i])) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(char[] array, char valueToFind, int beginIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        } else if (beginIndex >= array.length) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        for (int i = beginIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static <T> int lastIndexOf(T[] array, T valueToFind, int beginIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (beginIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        } else if (beginIndex >= array.length) {
            throw new ArrayIndexOutOfBoundsException(beginIndex);
        }
        for (int i = beginIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static boolean contains(boolean[] array, boolean valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    public static boolean contains(byte[] array, byte valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    public static boolean contains(short[] array, short valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    public static boolean contains(int[] array, int valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    public static boolean contains(long[] array, long valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    public static boolean contains(float[] array, float valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    public static boolean contains(float[] array, float valueToFind, float tolerance) {
        return indexOf(array, valueToFind, tolerance) != INDEX_NOT_FOUND;
    }

    public static boolean contains(double[] array, double valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    public static boolean contains(double[] array, double valueToFind, double tolerance) {
        return indexOf(array, valueToFind, tolerance) != INDEX_NOT_FOUND;
    }

    public static boolean contains(char[] array, char valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    public static <T> boolean contains(T[] array, T valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    public static int[] allIndicesOf(boolean[] array, boolean valueToFind) {
        if (array == null) {
            return EMPTY_INT_ARRAY;
        }
        int[] indices = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (valueToFind == array[i]) {
                indices[j] = i;
                j++;
            }
        }
        if (j < indices.length) {
            indices = resize(indices, j, 0);
        }
        return indices;
    }

    public static int[] allIndicesOf(byte[] array, byte valueToFind) {
        if (array == null) {
            return EMPTY_INT_ARRAY;
        }
        int[] indices = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (valueToFind == array[i]) {
                indices[j] = i;
                j++;
            }
        }
        if (j < indices.length) {
            indices = resize(indices, j, 0);
        }
        return indices;
    }

    public static int[] allIndicesOf(short[] array, short valueToFind) {
        if (array == null) {
            return EMPTY_INT_ARRAY;
        }
        int[] indices = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (valueToFind == array[i]) {
                indices[j] = i;
                j++;
            }
        }
        if (j < indices.length) {
            indices = resize(indices, j, 0);
        }
        return indices;
    }

    public static int[] allIndicesOf(int[] array, int valueToFind) {
        if (array == null) {
            return EMPTY_INT_ARRAY;
        }
        int[] indices = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (valueToFind == array[i]) {
                indices[j] = i;
                j++;
            }
        }
        if (j < indices.length) {
            indices = resize(indices, j, 0);
        }
        return indices;
    }

    public static int[] allIndicesOf(long[] array, long valueToFind) {
        if (array == null) {
            return EMPTY_INT_ARRAY;
        }
        int[] indices = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (valueToFind == array[i]) {
                indices[j] = i;
                j++;
            }
        }
        if (j < indices.length) {
            indices = resize(indices, j, 0);
        }
        return indices;
    }

    public static int[] allIndicesOf(float[] array, float valueToFind) {
        if (array == null) {
            return EMPTY_INT_ARRAY;
        }
        int[] indices = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (valueToFind == array[i]) {
                indices[j] = i;
                j++;
            }
        }
        if (j < indices.length) {
            indices = resize(indices, j, 0);
        }
        return indices;
    }

    public static int[] allIndicesOf(float[] array, float valueToFind, float tolerance) {
        if (array == null) {
            return EMPTY_INT_ARRAY;
        }
        final double min = valueToFind - tolerance;
        final double max = valueToFind + tolerance;
        int[] indices = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if ((min <= array[i]) && (max >= array[i])) {
                indices[j] = i;
                j++;
            }
        }
        if (j < indices.length) {
            indices = resize(indices, j, 0);
        }
        return indices;
    }

    public static int[] allIndicesOf(double[] array, double valueToFind) {
        if (array == null) {
            return EMPTY_INT_ARRAY;
        }
        int[] indices = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (valueToFind == array[i]) {
                indices[j] = i;
                j++;
            }
        }
        if (j < indices.length) {
            indices = resize(indices, j, 0);
        }
        return indices;
    }

    public static int[] allIndicesOf(double[] array, double valueToFind, double tolerance) {
        if (array == null) {
            return EMPTY_INT_ARRAY;
        }
        final double min = valueToFind - tolerance;
        final double max = valueToFind + tolerance;
        int[] indices = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if ((min <= array[i]) && (max >= array[i])) {
                indices[j] = i;
                j++;
            }
        }
        if (j < indices.length) {
            indices = resize(indices, j, 0);
        }
        return indices;
    }

    public static int[] allIndicesOf(char[] array, char valueToFind) {
        if (array == null) {
            return EMPTY_INT_ARRAY;
        }
        int[] indices = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (valueToFind == array[i]) {
                indices[j] = i;
                j++;
            }
        }
        if (j < indices.length) {
            indices = resize(indices, j, 0);
        }
        return indices;
    }

    public static <T> int[] allIndicesOf(T[] array, T valueToFind) {
        if (array == null) {
            return EMPTY_INT_ARRAY;
        }
        int[] indices = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (valueToFind == array[i]) {
                indices[j] = i;
                j++;
            }
        }
        if (j < indices.length) {
            indices = resize(indices, j, 0);
        }
        return indices;
    }

    // TODO add methods like:
    // TODO hashCode
    // TODO compare(comparator?)

    public static Boolean[] box(boolean[] array) {
        Boolean[] result = new Boolean[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static Byte[] box(byte[] array) {
        Byte[] result = new Byte[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static Short[] box(short[] array) {
        Short[] result = new Short[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static Integer[] box(int[] array) {
        Integer[] result = new Integer[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static Long[] box(long[] array) {
        Long[] result = new Long[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static Float[] box(float[] array) {
        Float[] result = new Float[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static Double[] box(double[] array) {
        Double[] result = new Double[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static Character[] box(char[] array) {
        Character[] result = new Character[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static boolean[] unbox(Boolean[] array) {
        boolean[] result = new boolean[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static boolean[] unbox(Boolean[] array, boolean nullValue) {
        boolean[] result = new boolean[array.length];
        for (int i = 0; i < result.length; i++) {
            if (array[i] == null) {
                result[i] = nullValue;
            } else {
                result[i] = array[i];
            }
        }
        return result;
    }

    public static byte[] unbox(Byte[] array) {
        byte[] result = new byte[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static byte[] unbox(Byte[] array, byte nullValue) {
        byte[] result = new byte[array.length];
        for (int i = 0; i < result.length; i++) {
            if (array[i] == null) {
                result[i] = nullValue;
            } else {
                result[i] = array[i];
            }
        }
        return result;
    }

    public static short[] unbox(Short[] array) {
        short[] result = new short[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static short[] unbox(Short[] array, short nullValue) {
        short[] result = new short[array.length];
        for (int i = 0; i < result.length; i++) {
            if (array[i] == null) {
                result[i] = nullValue;
            } else {
                result[i] = array[i];
            }
        }
        return result;
    }

    public static int[] unbox(Integer[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static int[] unbox(Integer[] array, int nullValue) {
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            if (array[i] == null) {
                result[i] = nullValue;
            } else {
                result[i] = array[i];
            }
        }
        return result;
    }

    public static long[] unbox(Long[] array) {
        long[] result = new long[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static long[] unbox(Long[] array, long nullValue) {
        long[] result = new long[array.length];
        for (int i = 0; i < result.length; i++) {
            if (array[i] == null) {
                result[i] = nullValue;
            } else {
                result[i] = array[i];
            }
        }
        return result;
    }

    public static float[] unbox(Float[] array) {
        float[] result = new float[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static float[] unbox(Float[] array, float nullValue) {
        float[] result = new float[array.length];
        for (int i = 0; i < result.length; i++) {
            if (array[i] == null) {
                result[i] = nullValue;
            } else {
                result[i] = array[i];
            }
        }
        return result;
    }

    public static double[] unbox(Double[] array) {
        double[] result = new double[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static double[] unbox(Double[] array, double nullValue) {
        double[] result = new double[array.length];
        for (int i = 0; i < result.length; i++) {
            if (array[i] == null) {
                result[i] = nullValue;
            } else {
                result[i] = array[i];
            }
        }
        return result;
    }

    public static char[] unbox(Character[] array) {
        char[] result = new char[array.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }

    public static char[] unbox(Character[] array, char nullValue) {
        char[] result = new char[array.length];
        for (int i = 0; i < result.length; i++) {
            if (array[i] == null) {
                result[i] = nullValue;
            } else {
                result[i] = array[i];
            }
        }
        return result;
    }
}
