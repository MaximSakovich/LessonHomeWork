package lesson_30.rubberArray;

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

    @SuppressWarnings("unchecked")
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

    @SuppressWarnings("unchecked")
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

    @SuppressWarnings("unchecked")
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



/*
-+ 1. Динамическое изменение размера массива
-- 2. Добавление элемента (значения) в массив
-- 9. Добавлять в массив сразу несколько элементов
-- 3. Поиск значений в массиве
-- 3.1. Поиск последнего вхождения элемента
-- 4. Удаление элемента по значению из массива
-- 5. Удаление элемента по индексу из массива
6. Найти мин, макс, среднее, сумму элементов
-- 7. Количество элементов в массиве
-- 8. Строковое представление массива (для вывода в консоль, например)
-- 10. Добавить в массив Х случайных значений
-- 11. Добавить в массив Х случайных значений в диапазоне от 0 до У;
-- 12. Вернуть наш резиновый массив в виде обычного массива


 */


/*
        int[] ints = new int[1000];
        int[] ints1 = {1, 2, 3, 4, 5};
        int number = 100;
        // добавь значение number в конец массива
        // {1, 2, 3, 4, 5, 100};
        // удаление элемента по значение (5) -> {1, 2, 3, 4, 100};

        // добавь в массив 6,7,8,9 -> {1, 2, 3, 4, 100, 6, 7, 8, 9};


        for (int i = 0; i < ints.length; i++) {

*/