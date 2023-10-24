package lesson_35.myArrayList;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T>, Iterable<T> {
    private T[] array;
    private int cursor;
    static final int MULTIPLIER = 2;

    public MyArrayList() {
        array = (T[]) new Object[10];
    }

    public MyArrayList(int sizeDefault) {
        array = (T[]) new Object[sizeDefault];
    }

    @Override
    public void add(T value) {
        if (cursor == array.length - 1) {
            expandArray();
        }
        array[cursor++] = value;
    }

    @Override
    public void addAll(T... values) {
        for (T value : values) {
            add(value);
        }
    }

    private void expandArray() {
        T[] newArray = (T[]) new Object[array.length * MULTIPLIER];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public int length() {
        return cursor;
    }

    @Override
    public int size() {
        return cursor;
    }

    @Override
    public int indexOf(T value) {
        for (int i = 0; i < cursor; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        for (int i = cursor - 1; i >= 0; i--) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    @Override
    public boolean remove(T value) {
        int index = indexOf(value);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= cursor) {
            throw new IndexOutOfBoundsException("Индекс за пределами");
        }
        T value = array[index];
        System.arraycopy(array, index + 1, array, index, cursor - index - 1);
        array[cursor - 1] = null;
        cursor--;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return cursor == 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= cursor) {
            throw new IndexOutOfBoundsException("Индекс за пределами");
        }
        return array[index];
    }

    @Override
    public T[] toArray() {
        T[] result = (T[]) new Object[cursor];
        System.arraycopy(array, 0, result, 0, cursor);
        return result;
    }

    public void trim() {
        array = toArray();
    }

    public T removeByIndex(int index) {
        if (index < 0 || index >= cursor) {
            throw new IndexOutOfBoundsException("Индекс за пределами");
        }
        T value = array[index];

        System.arraycopy(array, index + 1, array, index, cursor - index - 1);
        array[cursor - 1] = null;
        cursor--;

        return value;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < cursor; i++) {
            result.append(array[i]);
            if (i < cursor - 1) {
                result.append(", ");
            } else {
                result.append("]");
            }
        }
        return result.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }
    private class MyArrayListIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < cursor;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new RuntimeException("Такого элемента не существует");
            }
            return array[currentIndex++];
        }
    }
}
