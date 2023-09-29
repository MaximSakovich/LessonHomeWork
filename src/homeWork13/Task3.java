package homeWork13;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {

       /* Task 3
        Дано: Два отсортированных массива целых чисел.
        Вам нужно найти элемент, который будет находиться на k-й позиции
        в объединенном отсортированном массиве.
                Массив 1 - {100, 112, 256, 349, 770}
        Массив 2 - {72, 86, 113, 119, 265, 445, 892}
        k = 7
        Вывод: 256
        Можно такой вывод:
        72, 86, 100, 112, 113, 119, 256
        Искомое число: 256
        Объединенный отсортированный массив был бы такой (выводить, формировать его не обязательно) -
        [72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892]
        7-й элемент (по счету) этого массива хранит значение 256.*/

        int[] array1 = {100, 112, 256, 349, 770};
        int[] array2 = {72, 86, 113, 119, 265, 445, 892};
        int k = 7;
        //int[] array1 = {1,3};
        //int[] array2 = {2,4,5,6,7,8};
        //int k = 7;

        int[] mergedArray = mergeAndSort(array1, array2);
        int result = mergedArray[k];

        System.out.println("Массив 1: " + Arrays.toString(array1));
        System.out.println("Массив 2: " + Arrays.toString(array2));
        System.out.println("Элемент на " + k + "-й позиции: " + result);
        printArrayInFormat(mergedArray);
    }

    public static int[] mergeAndSort(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];
        int index1 = 0;
        int index2 = 0;
        int indexMerged = 0;

        while (index1 < array1.length && index2 < array2.length) {
            if (array1[index1] < array2[index2]) {
                mergedArray[indexMerged] = array1[index1];
                index1++;
            } else {
                mergedArray[indexMerged] = array2[index2];
                index2++;
            }
            indexMerged++;
        }

        while (index1 < array1.length) {
            mergedArray[indexMerged] = array1[index1];
            index1++;
            indexMerged++;
        }

        while (index2 < array2.length) {
            mergedArray[indexMerged] = array2[index2];
            index2++;
            indexMerged++;
        }
        return mergedArray;

    }

    //метод выводящий объединенный массив
    public static void printArrayInFormat(int[] arr) {
        System.out.print("Объединенный и отсортированный массив: " + "[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }
}