package homeWork45.Task2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* Task 2
Создайте два списка. Один на реализации ArrayList, второй на LinkedList.
Заполните их 1000 одинаковыми случайными значениями от 0 до 10_000.
Создайте 3 метода, принимающий список.
В первом методе - получение всех значений элементов списка по его индексу
Второй метод - вставка 1000 новых значений по случайному индексу
(диапазон индексов от 0 до размера списка)
Третий метод - удалить 1000 элементов по случайному индексу.
(диапазон от 0 до размера коллекции)
Все три метода должны возвращать время, затраченное на выполнение метода в миллисекундах.
Сравните для каждого из списка время выполнения каждого метода. И сравните время
последовательного выполнения всех трех методов.
*/
public class ListComparison {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Заполнение списков
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int randomValue = random.nextInt(10000);
            arrayList.add(randomValue);
            linkedList.add(randomValue);
        }

        // Метод 1: Получение всех значений элементов списка по его индексу
        long arrayListGetTime = getTimeInNanos(() -> accessByIndex(arrayList));
        long linkedListGetTime = getTimeInNanos(() -> accessByIndex(linkedList));
        System.out.println("Время выполнения метода доступа по индексу для ArrayList: " + arrayListGetTime + " ns");
        System.out.println("Время выполнения метода доступа по индексу для LinkedList: " + linkedListGetTime + " ns");

        // Метод 2: Вставка 1000 новых значений по случайному индексу
        long arrayListInsertTime = getTimeInNanos(() -> insertValues(arrayList));
        long linkedListInsertTime = getTimeInNanos(() -> insertValues(linkedList));
        System.out.println("Время выполнения метода вставки для ArrayList: " + arrayListInsertTime + " ns");
        System.out.println("Время выполнения метода вставки для LinkedList: " + linkedListInsertTime + " ns");

        // Метод 3: Удаление 1000 элементов по случайному индексу
        long arrayListRemoveTime = getTimeInNanos(() -> removeValues(arrayList));
        long linkedListRemoveTime = getTimeInNanos(() -> removeValues(linkedList));
        System.out.println("Время выполнения метода удаления для ArrayList: " + arrayListRemoveTime + " ns");
        System.out.println("Время выполнения метода удаления для LinkedList: " + linkedListRemoveTime + " ns");

        // Сравнение времени последовательного выполнения всех трех методов
        long arrayListSequentialTime = arrayListGetTime + arrayListInsertTime + arrayListRemoveTime;
        long linkedListSequentialTime = linkedListGetTime + linkedListInsertTime + linkedListRemoveTime;
        System.out.println("Время последовательного выполнения всех методов для ArrayList: " + arrayListSequentialTime + " ns");
        System.out.println("Время последовательного выполнения всех методов для LinkedList: " + linkedListSequentialTime + " ns");
    }

    public static void accessByIndex(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
        }
    }

    public static void insertValues(List<Integer> list) {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int randomIndex = random.nextInt(list.size());
            int randomValue = random.nextInt(10000);
            list.add(randomIndex, randomValue);
        }
    }

    public static void removeValues(List<Integer> list) {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int randomIndex = random.nextInt(list.size());
            list.remove(randomIndex);
        }
    }

    public static long getTimeInNanos(Runnable task) {
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}