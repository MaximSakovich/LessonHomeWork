package lesson_35.myArrayList;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayListApp {
    public static void main(String[] args) {

        MyArrayList<Integer> ra = new MyArrayList<>();
        ra.addAll(10, -5, 16, 57, 25, 39, 44);
        System.out.println(ra);
        ra.remove(4);
        System.out.println(ra);

        MyArrayList<Integer> raInt = new MyArrayList<>();
        raInt.addAll(101, 234, 536, -10, 0, 13, 120, 56, 37, 18);
        System.out.println(raInt.toString());

        MyArrayList<String> raStr = new MyArrayList<>();
        raStr.addAll("Очень", "сложно", "!");
        System.out.println(raStr.toString());

        MyArrayList<Integer> myArrayList = new MyArrayList<>(8);
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(6);
        myArrayList.add(7);
        myArrayList.add(8);

       // int removedValue = myArrayList.removeByIndex(2);
       // System.out.println("Удаленное значение: " + removedValue);
       // System.out.println("Содержимое списка: " + myArrayList);

        System.out.println("Размер: " + myArrayList.size());
        System.out.println("Индекс числа 2: " + myArrayList.indexOf(2));
        System.out.println("Последний индекс числа 5: " + myArrayList.lastIndexOf(5));
        System.out.println("Содержит ли список число 3: " + myArrayList.contains(3));

        System.out.println("Представление в виде массива: " + Arrays.toString(myArrayList.toArray()));

        myArrayList.remove(1);
        System.out.println("После удаления элемента с индексом 1: " + Arrays.toString(myArrayList.toArray()));

        System.out.println("Пустой ли список: " + myArrayList.isEmpty());
        System.out.println("Элемент с индексом 0: " + myArrayList.get(0));


        // Пример использования цикла foreach для прохождения по элементам списка
        System.out.println("Использование цикла foreach:");
        for (Integer num : myArrayList) {
            System.out.println(num);
        }

        // Пример использования итератора для прохождения по элементам списка
        System.out.println("Использование итератора:");
        Iterator<Integer> iterator = myArrayList.iterator();
        while (iterator.hasNext()) {
            try {
                Integer nextElement = iterator.next();
                System.out.println(nextElement);
            } catch (RuntimeException e) {
                System.out.println("Обработка исключения: " + e.getMessage());
            }
        }
    }
}