package homeWork39.lib;

import homeWork39.model.Reader;

import java.util.Iterator;
import java.util.List;

public class MyLinkedListReader<T> implements Iterable<T> {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 100;

    public MyLinkedListReader() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && array[currentIndex] != null;
            }

            @Override
            public T next() {
                return (T) array[currentIndex++];
            }
        };
    }

    public void add(T element) {
        if (size < DEFAULT_CAPACITY) {
            array[size] = element;
            size++;
        } else {
            // Метод увеличения массива или генерации ошибки при переполнении
        }
    }

    public void remove(T element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[size - 1] = null;
            size--;
        } else {
            // Метод обработки, если элемент не найден
        }
    }

    public boolean isEmpty() {
        return size == 0;
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

    public T[] toArray(List<T> items) {
        T[] array = (T[]) new Object[items.size()];

        for (int i = 0; i < items.size(); i++) {
            array[i] = items.get(i);
        }

        return array;
    }
}