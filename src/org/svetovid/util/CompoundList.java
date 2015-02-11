package org.svetovid.util;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class CompoundList<E> extends AbstractList<E> {

    private List<List<E>> lists = new ArrayList<>();

    public CompoundList() {
    }

    @SafeVarargs
    public CompoundList(List<E>... lists) {
        for (List<E> list : lists) {
            this.lists.add(list);
        }
    }

    public List<E> getSublist(int index) {
        return lists.get(index);
    }

    public void setSublist(int index, List<E> list) {
        lists.set(index, list);
    }

    public int addSublist(List<E> list) {
        lists.add(list);
        return lists.size() - 1;
    }

    public int insertSublist(int index, List<E> list) {
        lists.add(index, list);
        return index;
    }

    public List<E> removeSublist(int index) {
        return lists.remove(index);
    }

    @Override
    public int size() {
        int size = 0;
        for (List<E> list : lists) {
            if (list == null) {
                continue;
            }
            size = size + list.size();
        }
        return size;
    }

    @Override
    public E get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        int totalSize = 0;
        for (List<E> list : lists) {
            if (list == null) {
                continue;
            }
            int size = list.size();
            if (index < size) {
                return list.get(index);
            }
            index = index - size;
            totalSize = totalSize + size;
        }
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + totalSize);
    }

    @Override
    public Object[] toArray() {
        Object[][] arrays = new Object[lists.size()][];
        int size = 0;
        for (int i = 0; i < lists.size(); i++) {
            List<E> list = lists.get(i);
            if (list == null) {
                continue;
            }
            arrays[i] = list.toArray();
            size = size + arrays[i].length;
        }
        Object[] array = new Object[size];
        int index = 0;
        for (Object[] arr : arrays) {
            System.arraycopy(arr, 0, array, index, arr.length);
            index = index + arr.length;
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        Object[] array = toArray();
        if (a.length < array.length) {
            return (T[]) array;
        }
        System.arraycopy(array, 0, a, 0, array.length);
        return a;
    }
}
