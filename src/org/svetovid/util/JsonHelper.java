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

package org.svetovid.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.svetovid.SvetovidFormatException;

/**
 * Helper class with many useful methods for manipulating JSON compatible
 * objects.
 *
 * @author Ivan Pribela
 */
public class JsonHelper {

    private final JsonType type;
    private final Object object;

    /**
     * Constructs a new {@code JsonHelper} wrapper for easier manipulation of
     * the given JSON compatible object.
     *
     * @param object
     *            the object to wrap
     */
    public JsonHelper(Object object) {
        this.object = object;
        this.type = getType(object);
    }

    /**
     * Returns the JSON type of this object.
     *
     * @return the JSON type of this object.
     */
    public JsonType getType() {
        return type;
    }

    /**
     * Returns a boolean value of this object.
     *
     * @return a boolean value of this object.
     *
     * @throws SvetovidJsonException
     *             if the object cannot be converted.
     */
    public Boolean asBoolean() {
        return asBoolean(object);
    }

    /**
     * Returns a numeric value of this object.
     *
     * @return a numeric value of this object.
     *
     * @throws SvetovidJsonException
     *             if the object cannot be converted.
     */
    public Number asNumber() {
        return asNumber(object);
    }

    /**
     * Returns a string value of this object.
     *
     * @return a string value of this object.
     *
     * @throws SvetovidJsonException
     *             if the object cannot be converted.
     */
    public String asString() {
        return asString(object);
    }

    /**
     * Returns an array value of this object.
     *
     * @return an array value of this object.
     *
     * @throws SvetovidJsonException
     *             if the object cannot be converted.
     */
    public Iterable<?> asArray() {
        return asArray(object);
    }

    /**
     * Returns an object value of this object.
     *
     * @return an object value of this object.
     *
     * @throws SvetovidJsonException
     *             if the object cannot be converted.
     */
    public Map<String, Object> asObject() {
        return asObject(object);
    }

    /**
     * Returns the JSON type to which the given object can be converted.
     *
     * @param object
     *            the object for which the type is determined
     *
     * @return JSON type of the given object.
     */
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

    /**
     * Returns the given object converted to a boolean value.
     *
     * @param object
     *            the object to convert
     *
     * @return a boolean value of the given object.
     *
     * @throws SvetovidJsonException
     *             if the object cannot be converted.
     */
    public static Boolean asBoolean(Object object)
            throws SvetovidJsonException {
        if (object == null) {
            return null;
        }
        try {
            return (Boolean) object;
        } catch (ClassCastException e) {
            throw new SvetovidJsonException(JsonType.BOOLEAN,
                    object.getClass(), e);
        }
    }

    /**
     * Returns the given object converted to a number value.
     *
     * @param object
     *            the object to convert
     *
     * @return a number value of the given object.
     *
     * @throws SvetovidJsonException
     *             if the object cannot be converted.
     */
    public static Number asNumber(Object object) throws SvetovidJsonException {
        if (object == null) {
            return null;
        }
        try {
            return (Number) object;
        } catch (ClassCastException e) {
            throw new SvetovidJsonException(JsonType.NULL,
                    object.getClass(), e);
        }
    }

    /**
     * Returns the given object converted to a string value.
     *
     * @param object
     *            the object to convert
     *
     * @return a string value of the given object.
     *
     * @throws SvetovidJsonException
     *             if the object cannot be converted.
     */
    public static String asString(Object object) throws SvetovidJsonException {
        if (object == null) {
            return null;
        }
        try {
            return (String) object;
        } catch (ClassCastException e) {
            throw new SvetovidJsonException(JsonType.STRING,
                    object.getClass(), e);
        }
    }

    /**
     * Returns the given object converted to a JSON array value.
     *
     * @param object
     *            the object to convert
     *
     * @return an array value of the given object.
     *
     * @throws SvetovidJsonException
     *             if the object cannot be converted.
     */
    public static Iterable<?> asArray(Object object)
            throws SvetovidJsonException {
        if (object == null) {
            return null;
        }
        ClassCastException ex;
        try {
            Iterable<?> array = (Iterable<?>) object;
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
        throw new SvetovidJsonException(JsonType.ARRAY, object.getClass(), ex);
    }

    /**
     * Returns the given object converted to an JSON object value.
     *
     * @param object
     *            the object to convert
     *
     * @return an object value of the given object.
     *
     * @throws SvetovidJsonException
     *             if the object cannot be converted.
     */
    public static Map<String, Object> asObject(Object object)
            throws SvetovidJsonException {
        if (object == null) {
            return null;
        }
        try {
            @SuppressWarnings("unchecked")
            Map<String, Object> map = (Map<String, Object>) object;
            return map;
        } catch (ClassCastException e) {
            throw new SvetovidJsonException(JsonType.OBJECT,
                    object.getClass(), e);
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

    /**
     * Returns a boolean value at the specified JSON path resolved on the given
     * object.
     *
     * @param object
     *            the object to apply the path to
     * @param path
     *            the path to follow
     *
     * @return the boolean value extracted from the given object using the given
     *         path.
     *
     * @throws SvetovidJsonException
     *             if the object cannot be converted.
     */
    public static Boolean getBoolean(Object object, String path)
            throws SvetovidJsonException {
        object = get(object, path);
        if (object == null) {
            return null;
        }
        try {
            return (Boolean) object;
        } catch (ClassCastException e) {
            throw new SvetovidJsonException(JsonType.BOOLEAN,
                    object.getClass(), path);
        }
    }

    /**
     * Returns a numeric value at the specified JSON path resolved on the given
     * object.
     *
     * @param object
     *            the object to apply the path to
     * @param path
     *            the path to follow
     *
     * @return the numeric value extracted from the given object using the given
     *         path.
     *
     * @throws SvetovidJsonException
     *             if the object cannot be converted.
     */
    public static Number getNumber(Object object, String path)
            throws SvetovidJsonException {
        object = get(object, path);
        if (object == null) {
            return null;
        }
        try {
            return (Number) object;
        } catch (ClassCastException e) {
            throw new SvetovidJsonException(JsonType.NUMBER,
                    object.getClass(), path);
        }
    }

    /**
     * Returns the raw object at the specified JSON path resolved on the given
     * object.
     *
     * @param object
     *            the object to apply the path to
     * @param path
     *            the path to follow
     *
     * @return the raw object extracted from the given object using the given
     *         path.
     *
     * @throws SvetovidFormatException
     *             if there was an error parsing the path.
     * @throws SvetovidJsonException
     *             if the array or object along the path cannot be converted.
     */
    public static Object get(Object object, String path) {
        return get(object, path, "");
    }

    private static Object get(Object object, String path, String resolved)
            throws SvetovidFormatException, SvetovidJsonException {

        // No path
        if (path == null) {
            return object;
        }

        // Remove the leading dot
        if (path.startsWith(".")) {
            path = path.substring(1);
        }

        // This object
        if (path.isEmpty()) {
            return object;
        }

        // Parse the path
        String[] pathSegments;

        // Array notation
        if (path.startsWith("[")) {
            pathSegments = path.substring(1).split("\\]", 2); // TODO Escape ] and ' characters?
            if (!pathSegments[0].startsWith("'")) {
                try {
                    int index = Integer.parseInt(pathSegments[0]);
                    resolved = resolved + "[" + pathSegments[0] + "]";
                    object = extractArrayElement(object, index, resolved);
                    return continueGet(object, pathSegments, resolved);
                } catch (NumberFormatException e) {
                    throw new SvetovidFormatException("Json.Number",
                            pathSegments[0], null);
                }
            }
            if (!pathSegments[0].endsWith("'")) {
                throw new SvetovidFormatException("Json.String",
                        pathSegments[0], null);
            }
            pathSegments[0] = pathSegments[0].substring(1,
                    pathSegments[0].length() - 1);
        } else {
            pathSegments = path.split("[\\.\\[]", 2);
            if ((pathSegments.length > 1) &&
                    (path.charAt(pathSegments[0].length()) == '[')) {
                pathSegments[1] = '[' + pathSegments[1];
            }
        }

        // Object member
        resolved = resolved + "." + pathSegments[0];
        object = extractObjectMember(object, pathSegments[0], resolved);
        return continueGet(object, pathSegments, resolved);

    }

    private static Object extractArrayElement(Object array, int index,
            String path) throws SvetovidJsonException {
        if (array instanceof List) {
            List<?> l = (List<?>) array;
            if ((index < 0) || (index >= l.size())) {
                throw new ArrayIndexOutOfBoundsException(index);
            }
            return l.get(index);
        }
        if (array instanceof Iterable) {
            if (index < 0) {
                throw new ArrayIndexOutOfBoundsException(index);
            }
            Iterator<?> iterator = ((Iterable<?>) array).iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                if (index == 0) {
                    return element;
                }
                index--;
            }
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (array instanceof boolean[]) {
            boolean[] a = (boolean[]) array;
            if ((index < 0) || (index >= a.length)) {
                throw new ArrayIndexOutOfBoundsException(index);
            }
            return a[index];
        }
        if (array instanceof byte[]) {
            byte[] a = (byte[]) array;
            if ((index < 0) || (index >= a.length)) {
                throw new ArrayIndexOutOfBoundsException(index);
            }
            return a[index];
        }
        if (array instanceof short[]) {
            short[] a = (short[]) array;
            if ((index < 0) || (index >= a.length)) {
                throw new ArrayIndexOutOfBoundsException(index);
            }
            return a[index];
        }
        if (array instanceof int[]) {
            int[] a = (int[]) array;
            if ((index < 0) || (index >= a.length)) {
                throw new ArrayIndexOutOfBoundsException(index);
            }
            return a[index];
        }
        if (array instanceof long[]) {
            long[] a = (long[]) array;
            if ((index < 0) || (index >= a.length)) {
                throw new ArrayIndexOutOfBoundsException(index);
            }
            return a[index];
        }
        if (array instanceof float[]) {
            float[] a = (float[]) array;
            if ((index < 0) || (index >= a.length)) {
                throw new ArrayIndexOutOfBoundsException(index);
            }
            return a[index];
        }
        if (array instanceof double[]) {
            double[] a = (double[]) array;
            if ((index < 0) || (index >= a.length)) {
                throw new ArrayIndexOutOfBoundsException(index);
            }
            return a[index];
        }
        if (array instanceof char[]) {
            char[] a = (char[]) array;
            if ((index < 0) || (index >= a.length)) {
                throw new ArrayIndexOutOfBoundsException(index);
            }
            return a[index];
        }
        if (array instanceof Object[]) {
            Object[] a = (Object[]) array;
            if ((index < 0) || (index >= a.length)) {
                throw new ArrayIndexOutOfBoundsException(index);
            }
            return a[index];
        }
        throw new SvetovidJsonException(JsonType.ARRAY, array.getClass(), path);
    }

    private static Object extractObjectMember(Object object, String member,
            String path) throws SvetovidJsonException {
        if (!(object instanceof Map)) {
            throw new SvetovidJsonException(JsonType.OBJECT, object.getClass(),
                    path);
        }
        @SuppressWarnings("unchecked")
        Map<String, Object> map = (Map<String, Object>) object;
        return map.get(member);

    }

    private static Object continueGet(Object object, String[] pathSegments,
            String resolved) throws SvetovidFormatException,
            SvetovidJsonException {
        if (pathSegments.length == 1) {
            return object;
        }
        return get(object, pathSegments[1], resolved);
    }
}
