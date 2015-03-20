package org.svetovid.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.svetovid.io.SvetovidFormatException;
import org.svetovid.io.SvetovidJsonPathException;

public class JsonHelper {

    private final JsonType type;
    private final Object object;

    public JsonHelper(Object object) {
        this.object = object;
        this.type = getType(object);
    }

    public JsonType getType() {
        return type;
    }

    public Boolean asBoolean() {
        return asBoolean(object);
    }

    public Number asNumber() {
        return asNumber(object);
    }

    public String asString() {
        return asString(object);
    }

    public Iterable<?> asArray() {
        return asArray(object);
    }

    public Map<String, Object> asObject() {
        return asObject(object);
    }

    public static JsonType getType(Object object) {
        if (object == null) {
            return JsonType.NULL;
        }
        if (object instanceof Boolean) {
            return JsonType.BOOLEAN;
        }
        if (object instanceof Number) {
            return JsonType.NUMBER;
        }
        if (object instanceof String) {
            return JsonType.STRING;
        }
        if (object instanceof Iterable) {
            return JsonType.ARRAY;
        }
        if (object instanceof Map) {
            return JsonType.OBJECT;
        }
        if (object instanceof boolean[]) {
            return JsonType.ARRAY;
        }
        if (object instanceof byte[]) {
            return JsonType.ARRAY;
        }
        if (object instanceof short[]) {
            return JsonType.ARRAY;
        }
        if (object instanceof int[]) {
            return JsonType.ARRAY;
        }
        if (object instanceof long[]) {
            return JsonType.ARRAY;
        }
        if (object instanceof float[]) {
            return JsonType.ARRAY;
        }
        if (object instanceof double[]) {
            return JsonType.ARRAY;
        }
        if (object instanceof char[]) {
            return JsonType.ARRAY;
        }
        if (object instanceof Object[]) {
            return JsonType.ARRAY;
        }
        return JsonType.UNKNOWN;
    }

    public static Boolean asBoolean(Object object) {
        if (object == null) {
            return null;
        }
        try {
            return (Boolean) object;
        } catch (ClassCastException e) {
            throw e;
        }
    }

    public static Number asNumber(Object object) {
        if (object == null) {
            return null;
        }
        try {
            return (Number) object;
        } catch (ClassCastException e) {
            throw e;
        }
    }

    public static String asString(Object object) {
        if (object == null) {
            return null;
        }
        try {
            return (String) object;
        } catch (ClassCastException e) {
            throw e;
        }
    }

    public static Iterable<?> asArray(Object object) {
        if (object == null) {
            return null;
        }
        ClassCastException ex;
        try {
            @SuppressWarnings("unchecked")
            Iterable<Object> array = (Iterable<Object>) object;
            return array;
        } catch (ClassCastException e) {
            ex = e;
        }
        if (object instanceof boolean[]) {
            boolean[] array = (boolean[]) object;
            return new IterableBooleanArray(array);
        }
        if (object instanceof byte[]) {
            byte[] array = (byte[]) object;
            return new IterableByteArray(array);
        }
        if (object instanceof short[]) {
            short[] array = (short[]) object;
            return new IterableShortArray(array);
        }
        if (object instanceof int[]) {
            int[] array = (int[]) object;
            return new IterableIntegerArray(array);
        }
        if (object instanceof long[]) {
            long[] array = (long[]) object;
            return new IterableLongArray(array);
        }
        if (object instanceof float[]) {
            float[] array = (float[]) object;
            return new IterableFloatArray(array);
        }
        if (object instanceof double[]) {
            double[] array = (double[]) object;
            return new IterableDoubleArray(array);
        }
        if (object instanceof char[]) {
            char[] array = (char[]) object;
            return new IterableCharacterArray(array);
        }
        if (object instanceof Object[]) {
            Object[] array = (Object[]) object;
            return new IterableObjectArray(array);
        }
        throw ex;
    }

    public static Map<String, Object> asObject(Object object) {
        if (object == null) {
            return null;
        }
        try {
            @SuppressWarnings("unchecked")
            Map<String, Object> map = (Map<String, Object>) object;
            return map;
        } catch (ClassCastException e) {
            throw e;
        }
    }

    private static class IterableBooleanArray implements Iterable<Boolean> {

        private boolean[] array;

        public IterableBooleanArray(boolean[] array) {
            this.array = array;
        }

        @Override
        public Iterator<Boolean> iterator() {
            return new BooleanArrayIterator(array);
        }
    }

    private static class IterableByteArray implements Iterable<Byte> {

        private byte[] array;

        public IterableByteArray(byte[] array) {
            this.array = array;
        }

        @Override
        public Iterator<Byte> iterator() {
            return new ByteArrayIterator(array);
        }
    }

    private static class IterableShortArray implements Iterable<Short> {

        private short[] array;

        public IterableShortArray(short[] array) {
            this.array = array;
        }

        @Override
        public Iterator<Short> iterator() {
            return new ShortArrayIterator(array);
        }
    }

    private static class IterableIntegerArray implements Iterable<Integer> {

        private int[] array;

        public IterableIntegerArray(int[] array) {
            this.array = array;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new IntegerArrayIterator(array);
        }
    }

    private static class IterableLongArray implements Iterable<Long> {

        private long[] array;

        public IterableLongArray(long[] array) {
            this.array = array;
        }

        @Override
        public Iterator<Long> iterator() {
            return new LongArrayIterator(array);
        }
    }

    private static class IterableFloatArray implements Iterable<Float> {

        private float[] array;

        public IterableFloatArray(float[] array) {
            this.array = array;
        }

        @Override
        public Iterator<Float> iterator() {
            return new FloatArrayIterator(array);
        }
    }

    private static class IterableDoubleArray implements Iterable<Double> {

        private double[] array;

        public IterableDoubleArray(double[] array) {
            this.array = array;
        }

        @Override
        public Iterator<Double> iterator() {
            return new DoubleArrayIterator(array);
        }
    }

    private static class IterableCharacterArray implements Iterable<Character> {

        private char[] array;

        public IterableCharacterArray(char[] array) {
            this.array = array;
        }

        @Override
        public Iterator<Character> iterator() {
            return new CharacterArrayIterator(array);
        }
    }

    private static class IterableObjectArray implements Iterable<Object> {

        private Object[] array;

        public IterableObjectArray(Object[] array) {
            this.array = array;
        }

        @Override
        public Iterator<Object> iterator() {
            return new ObjectArrayIterator(array);
        }
    }

    private static class BooleanArrayIterator implements Iterator<Boolean> {

        private boolean[] array;
        private int pos;

        public BooleanArrayIterator(boolean[] array) {
            this.array = array;
            this.pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos < array.length;
        }

        @Override
        public Boolean next() {
            return array[pos++];
        }
    }

    private static class ByteArrayIterator implements Iterator<Byte> {

        private byte[] array;
        private int pos;

        public ByteArrayIterator(byte[] array) {
            this.array = array;
            this.pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos < array.length;
        }

        @Override
        public Byte next() {
            return array[pos++];
        }
    }

    private static class ShortArrayIterator implements Iterator<Short> {

        private short[] array;
        private int pos;

        public ShortArrayIterator(short[] array) {
            this.array = array;
            this.pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos < array.length;
        }

        @Override
        public Short next() {
            return array[pos++];
        }
    }

    private static class IntegerArrayIterator implements Iterator<Integer> {

        private int[] array;
        private int pos;

        public IntegerArrayIterator(int[] array) {
            this.array = array;
            this.pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos < array.length;
        }

        @Override
        public Integer next() {
            return array[pos++];
        }
    }

    private static class LongArrayIterator implements Iterator<Long> {

        private long[] array;
        private int pos;

        public LongArrayIterator(long[] array) {
            this.array = array;
            this.pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos < array.length;
        }

        @Override
        public Long next() {
            return array[pos++];
        }
    }

    private static class FloatArrayIterator implements Iterator<Float> {

        private float[] array;
        private int pos;

        public FloatArrayIterator(float[] array) {
            this.array = array;
            this.pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos < array.length;
        }

        @Override
        public Float next() {
            return array[pos++];
        }
    }

    private static class DoubleArrayIterator implements Iterator<Double> {

        private double[] array;
        private int pos;

        public DoubleArrayIterator(double[] array) {
            this.array = array;
            this.pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos < array.length;
        }

        @Override
        public Double next() {
            return array[pos++];
        }
    }

    private static class CharacterArrayIterator implements Iterator<Character> {

        private char[] array;
        private int pos;

        public CharacterArrayIterator(char[] array) {
            this.array = array;
            this.pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos < array.length;
        }

        @Override
        public Character next() {
            return array[pos++];
        }
    }

    private static class ObjectArrayIterator implements Iterator<Object> {

        private Object[] array;
        private int pos;

        public ObjectArrayIterator(Object[] array) {
            this.array = array;
            this.pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos < array.length;
        }

        @Override
        public Object next() {
            return array[pos++];
        }
    }
}
