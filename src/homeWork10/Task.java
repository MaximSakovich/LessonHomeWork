package homeWork10;

import java.util.Scanner;

public class Task {
    public static void main(String[] args) {

        // Task4
        // Решение вторым способом без цикла while, который убирает
        // ограничение по вводу длинны целого числа больше long
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Введите целое число:");

        String input2 = scanner2.nextLine();


        if (input2.matches("\\d+"))// Проверяю, что введенная строка состоит только из цифр
        // (без знака минуса для отрицательных чисел)
        {
            long sum2 = 0;

            for (int i = 0; i < input2.length(); i++) {
                char digitChar2 = input2.charAt(i);
                long digit2 = Character.getNumericValue(digitChar2); // использую функцию, чтобы вернуть символу числовое значение
                sum2 += digit2;// суммирую числа
            }
            System.out.println("Сумма цифр: " + sum2);
        } else {
            System.out.println("Некорректный ввод. Введите только цифры (целое число).");
        }
    }
}



