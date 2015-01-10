package org.svetovid.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class SvetovidArrays {

    // TODO Add method variants for boolean, byte, short, int, float, double and char

    // TODO empty()
    // TODO isEmpty()
    // TODO isNonempty()
    // TODO Length()

    public static long[] toArray(long... items) {
        return items;
    }

    @SafeVarargs
    public static <T> T[] toArray(T... items) {
        return items;
    }

    public static long[] copy(long[] array) {
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

    // TODO remove(array, indices...)
    // TODO remove(array, elements...)

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
