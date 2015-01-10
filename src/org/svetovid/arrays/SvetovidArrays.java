package org.svetovid.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class SvetovidArrays {

    // TODO Add method variants for boolean, byte, short, int, float, double and char

    // TODO empty()

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

    public static boolean isSameLength(boolean[] array1, boolean[] array2) {
        return length(array1) == length(array2);
    }
    
    public static boolean isSameLength(byte[] array1, byte[] array2) {
        return length(array1) == length(array2);
    }
    
    public static boolean isSameLength(short[] array1, boolean[] array2) {
        return length(array1) == length(array2);
    }
    
    public static boolean isSameLength(int[] array1, boolean[] array2) {
        return length(array1) == length(array2);
    }
    
    public static boolean isSameLength(long[] array1, long[] array2) {
        return length(array1) == length(array2);
    }
    
    public static boolean isSameLength(float[] array1, float[] array2) {
        return length(array1) == length(array2);
    }
    
    public static boolean isSameLength(double[] array1, double[] array2) {
        return length(array1) == length(array2);
    }
    
    public static boolean isSameLength(char[] array1, char[] array2) {
        return length(array1) == length(array2);
    }
    
    public static <T> boolean isSameLength(T[] array1, T[] array2) {
        return length(array1) == length(array2);
    }

    public static boolean[] toArray(boolean... items) {
        return items;
    }

    // TODO equal

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

    public static boolean[] remove(boolean[] array, int... indices) throws IndexOutOfBoundsException {
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

    public static byte[] remove(byte[] array, int... indices) throws IndexOutOfBoundsException {
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

    public static short[] remove(short[] array, int... indices) throws IndexOutOfBoundsException {
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

    public static int[] remove(int[] array, int... indices) throws IndexOutOfBoundsException {
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

    public static long[] remove(long[] array, int... indices) throws IndexOutOfBoundsException {
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

    public static float[] remove(float[] array, int... indices) throws IndexOutOfBoundsException {
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

    public static double[] remove(double[] array, int... indices) throws IndexOutOfBoundsException {
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

    public static char[] remove(char[] array, int... indices) throws IndexOutOfBoundsException {
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

    public static <T> T[] remove(T[] array, int... indices) throws IndexOutOfBoundsException {
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

    // TODO remove(array, elements...)

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
        Random random = new Random(); // TODO externalize
        for (int i = beginIndex; i < endIndex; i++) {
            int index = random.nextInt(i + 1);
            long tmp = array[index];
            array[index] = array[i];
            array[i] = tmp;
        }
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
        Random random = new Random(); // TODO externalize
        int index = random.nextInt(array.length);
        long result = array[index];
        return result;
    }

    // TODO add methods like:
    // TODO fill
    // TODO contains
    // TODO indexof(startindex?)
    // TODO lastindexof(startindex?) + tolerance for double
    // TODO allIndicesof() + tolerance for double

    // TODO toString(nullstring?)
    // TODO hashCode
    // TODO equals
    // TODO compare(comparator?)
    // TODO issamelength

    // TODO nulltoempty

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
