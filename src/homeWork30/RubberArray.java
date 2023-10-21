package homeWork30;


import java.util.Random;


public class RubberArray<T> {
    private T[] array;
    private int cursor;
    static final int MULTIPLIER = 2;

    Random random = new Random();

    @SuppressWarnings("unchecked")
    public RubberArray() {
        array = (T[]) new Object[10];
    }


    public RubberArray(int sizeDefault) {
        array = (T[]) new Object[sizeDefault];
    }

    public void add(T number) {
        if (cursor == array.length - 1) {
            expandArray();
        }
        array[cursor++] = number;
    }

    public void add(T... values) {
        for (T value : values) {
            add(value);
        }
    }


    private void expandArray() {
        T[] newArray = (T[]) new Object[array.length * MULTIPLIER];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

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

    public int length() {
        return cursor;
    }

    public int indexOf(T number) {
        for (int i = 0; i < cursor; i++) {
            if (array[i].equals(number)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T number) {
        for (int i = cursor - 1; i >= 0; i--) {
            if (array[i].equals(number)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    public boolean remove(T value) {
        int index = indexOf(value);
        if (index >= 0) {
            removeByIndex(index);
            return true;
        }
        return false;
    }

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
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        T value = array[index];

        System.arraycopy(array, index + 1, array, index, cursor - index - 1);
        array[cursor - 1] = null;
        cursor--;

        return value;
    }
}
