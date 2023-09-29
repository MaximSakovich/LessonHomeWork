package homeWork16;


public class Task5 {
    public static void main(String[] args) {
        //Task 5
        //Реализуйте метод sumOfArray (сумма элементов массива),
        // который получает на вход массив и определяет сумму его элементов.
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = sumOfArray(arr);
        System.out.println("Сумма элементов массива равна: " + sum);
    }

    // Метод для вычисления суммы элементов массива
    public static int sumOfArray(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum;
    }
}