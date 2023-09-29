package homeWork07;

import java.util.Random;
import java.util.Scanner;

public class HomeWork07 {
    public static void main(String[] args) {
        //Task 0
        /* Необходимо написать программу, где бы пользователю предлагалось
        ввести число на выбор: 1, 2 или 3, а программа должна сказать,
        какое число ввёл пользователь: 1, 2, или 3  */
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Введите число на выбор 1, 2 или 3: ");

        number = scanner.nextInt();

        if (number == 1) {
            System.out.println("Вы ввели число один");
        } else if (number == 2) {
            System.out.println("Вы ввели число два");
        } else if (number == 3) {
            System.out.println("Вы ввели число три");
        } else {
            System.out.println("Вы ввели неверное число");
        }

        // Task 1
        /*  Запишите в 4 переменные случайные числа от 0 до 100.
        Выведите все 4 на экран
        Программа должна определить максимальное из этих четырех чисел
        Результат вывести на экран */

        int up = 100;
        int num1;
        int num2;
        int num3;
        int num4;
        Random random = new Random();
        num1 = random.nextInt(up) + 1;
        System.out.println("Первое случайное число: " + num1);
        num2 = random.nextInt(up) + 1;
        System.out.println("Второе случайное число: " + num2);
        num3 = random.nextInt(up) + 1;
        System.out.println("Третье случайное число: " + num3);
        num4 = random.nextInt(up) + 1;
        System.out.println("Четвертое случайное число: " + num4);

        int max1 = num1 < num2 ? num2 : num1;
        int max2 = num3 < num4 ? num4 : num3;
        System.out.println("Максимальное случайное число, первый способ с помощью Тернарного оператора: " + (max1 < max2 ? max2 : max1));

        int max = 0;
        if (num1 >= num2 && num1 >= num3 && num1 >= num4) max = num1;
        if (num2 >= num1 && num2 >= num3 && num2 >= num4) max = num2;
        if (num3 >= num2 && num3 >= num2 && num3 >= num4) max = num3;
        if (num4 >= num2 && num4 >= num1 && num4 >= num3) max = num4;
        System.out.println("Максимальное случайное число, второй способ: " + max);

        System.out.println("Максимальное случайное число, третий способ без ввода доп. переменных: " +
                ((num1 >= num2 && num1 >= num3 && num1 >= num4) ?
                        num1 : (num2 >= num1 && num2 >= num3 && num2 >= num4) ? num2 :
                        (num3 >= num1 && num3 >= num2 && num3 >= num4) ? num3 :
                                (num4 >= num1 && num4 >= num2 && num4 >= num2) ? num4 : num1));

        //  Task 2
/*
        Программа предлагает пользователю ввести четырехзначное число
        Причем: мы можем получать от пользователя ТОЛЬКО строки.
        Данные в формате String
        Если число не четырехзначное, должно вывестись на экран сообщение
        об ошибке и работа программы завершается
        Проверить, является ли число "счастливым билетом". Т.е. совпадает
        ли сумма цифр первых двух цифр числа с суммой третьей и четвертой цифры
*/
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите четырехзначное число:");

        // Считываем введенную строку от пользователя
        String input = scan.nextLine();

        // Проверяем, является ли введенная строка четырехзначным числом
        if (input.length() != 4) {
            System.out.println("Ошибка: Введенная строка не является четырехзначным числом.");
            return; // Завершаем программу
        }
        // Переводим введенную строку в целочисленные значения
        int digit1 = Character.getNumericValue(input.charAt(0));
        int digit2 = Character.getNumericValue(input.charAt(1));
        int digit3 = Character.getNumericValue(input.charAt(2));
        int digit4 = Character.getNumericValue(input.charAt(3));

        // Проверяем, является ли число "счастливым билетом"
        if (digit1 + digit2 == digit3 + digit4) {
            System.out.println("Поздравляем! Вы ввели \"счастливый\" билет.");
        } else {
            System.out.println("Увы, это не счастливый билет.");
        }

    }
}
