package homeWork22;


import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8, -12, 23, 45, 15, 19, -1, 3, 55};
        bubbleSort(arr);
        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(arr));
        for (int num : arr) {
            System.out.print(num + " ");

        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Поменять элементы местами, если текущий больше следующего
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // Если во внутреннем цикле не было обменов, массив уже отсортирован
            if (!swapped) {
                break;
            }
        }
    }
}
