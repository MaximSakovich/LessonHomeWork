package homeWork39.lib;


import java.util.Iterator;

public class MyArrayListBook<T> implements Iterable<T> {

    // private ArrayList<T> arrayList;
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 100;

    public MyArrayListBook() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                return (T) array[currentIndex++];
            }
        };
    }

    // Метод добавления элемента в массив
    public void add(T element) {
        if (size == array.length) {
            increaseCapacity();
        }
        array[size] = element;
        size++;
    }

    // Метод увеличивает емкость внутреннего массива вдвое.
    private void increaseCapacity() {
        int newCapacity = array.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    //Метод удаления элемента из массива
    public void remove(T element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            array[size - 1] = null;
            size--;
        } else {

        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        return (T) array[index];
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        array[index] = element;
    }

    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int size() {return size;
    }
}

