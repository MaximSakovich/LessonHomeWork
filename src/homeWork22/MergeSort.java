package homeWork22;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7,-12, 5, 28, 19, 156, 121, 12, 73, 54};
        System.out.println("Исходный массив:");
        printArray(arr);
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Отсортированный массив:");
        printArray(arr);
        System.out.println(Arrays.toString(arr));

        for (String arg : args) {
            System.out.println(arg);
        }

    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Находим средний индекс массива
            int mid = left + (right - left) / 2;

            // Рекурсивно сортируем левую и правую половины
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Объединяем отсортированные половины
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        // Размеры временных подмассивов
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Создаем временные подмассивы
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Копируем данные во временные подмассивы leftArray[] и rightArray[]
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        // Индексы для обхода временных подмассивов
        int i = 0, j = 0;

        // Индекс начала временного подмассива
        int k = left;

        // Слияние leftArray[] и rightArray[] обратно в arr[]
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Копируем оставшиеся элементы leftArray[], если таковые есть
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Копируем оставшиеся элементы rightArray[], если таковые есть
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}