package homeWork16;


public class Task1 {
    public static void main(String[] args) {
        //Task1
        //Написать метод swap, принимающий на вход массив целых чисел, и два индекса.
        // Метод должен поменять местами значения, хранящихся в этих индексах
        // {0, 1, 2, 3, 4, 5, 6} -> swap(arr, 1, 5} -> {0, 5, 2, 3, 4, 1, 6}
        //Если индексы за пределами массива? Перегрузка метода для работы с массивами строк.
        int[] intArray = {0, 1, 2, 3, 4, 5, 6};
        String[] strArray = {"night", "morning", "One", "Two", "Twenty"};
        //В этом коде есть два метода swap - один для массивов целых чисел и один для массивов строк.
        // Каждый метод проверяет, находятся ли переданные индексы
        // в пределах массива, и, если это так, меняет элементы местами.

        swap(intArray, 1, 5);
        for (int num : intArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        swap(strArray, 0, 2);
        for (String str : strArray) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    // Метод для обмена элементами массива целых чисел
    public static void swap(int[] arr, int index1, int index2) {
        if (index1 < 0 || index1 >= arr.length || index2 < 0 || index2 >= arr.length) {
            System.out.println("Один или оба индекса находятся за пределами массива.");
            return;
        }

        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    // Перегруженный метод для обмена элементами массива строк
    public static void swap(String[] arr, int index1, int index2) {
        if (index1 < 0 || index1 >= arr.length || index2 < 0 || index2 >= arr.length) {
            System.out.println("Один или оба индекса находятся за пределами массива.");
            return;
        }

        String temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}