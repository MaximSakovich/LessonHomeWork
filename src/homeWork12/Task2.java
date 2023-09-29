package homeWork12;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
       /* Task 2
       Заполните массив 50 случайными числами от 1 до 100.
       Программа должна найти, и вывести на экран все простые числа.
       Посчитайте сколько получилось таких чисел в массиве.
       Простое число - число, которое делится на целое только на 1 и само себя.
        */

        int[] randomArray = new int[50];
        Random random = new Random();

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(100) + 1;
        }
        System.out.println("Сгенерированный массив случайных чисел:");

        for (int number : randomArray) {
            System.out.print(number + " ");
        }
        System.out.println();
        System.out.println("Простые числа в массиве:");

        int count = 0; // Счетчик простых чисел

        for (int number : randomArray) {
            if (primeNumber(number)) {
                System.out.print(number + " ");
                count++;
            }
        }
        System.out.println();
        System.out.println("Количество простых чисел в массиве: " + count);
    }

    // Метод для проверки, является ли число простым
    public static boolean primeNumber (int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
// нужно отсечь единицу