package homeWork12;

import java.util.Random;

public class Task0 {
    public static void main(String[] args) {

        // Task 0
        //  Заполните массив 20 случайными целыми числами.
        //  Программа должна вывести на экран массив,
        //  количество четных чисел в массиве и сумму всех четных чисел.

        int[] randomArray = new int[20];
        Random random = new Random();

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(101);
        }

        System.out.println("Массив случайных чисел:");
        for (int number : randomArray) {
            System.out.print(number + " ");
        }
        System.out.println();

        int evenCount = 0;
        int evenSum = 0;
        for (int number : randomArray) {
            if (number % 2 == 0) {
                evenCount++;
                evenSum += number;
            }
        }

        System.out.println("Количество четных чисел: " + evenCount);
        System.out.println("Сумма четных чисел: " + evenSum);
    }
}
