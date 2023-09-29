package lesson_08;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
        // Преобразуем введенную строку в целочисленные значения
        int digit1 = (int) input.charAt(0);
        int digit2 = (int) input.charAt(1);
        int digit3 = (int) input.charAt(2);
        int digit4 = (int) input.charAt(3);

        // Проверяем, является ли число "счастливым билетом"
        if (digit1 + digit2 == digit3 + digit4) {
            System.out.println("Поздравляем! Вы ввели счастливый билет.");
        } else {
            System.out.println("Увы, это не счастливый билет.");
        }

/*
Task 1

Запишите в 4 переменные случайные числа от 0 до 100
Выведите все 4 на экран
Программа должна определить максимальное из этих четырех чисел
Результат вывести на экран

 */
                Random random = new Random();
                int var1 = random.nextInt(101);
                int var2 = random.nextInt(101);
                int var3 = random.nextInt(101);
                int var4 = random.nextInt(101);

                System.out.println(var1 + " : " + var2 + " : " + var3 + " : " + var4);

                int max = var1;

                if (var2 > max) {
                    max = var2;
                }
                if (var3 > max) {
                    max = var3;
                }
                if (var4 > max) {
                    max = var4;
                }

                System.out.println("Max: " + max);

/*
программа предлагает пользователю ввести четырехзначное число
Причем: мы можем получать от пользователя ТОЛЬКО строки. Данные в формате String
Если число не четырехзначное, должно вывестись на экран сообщение об ошибке и работа программы завершается
Проверить, является ли число "счастливым билетом". Т.е. совпадает ли сумма цифр первых двух цифр числа с суммой третьей и четвертой цифры
 */

                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите четырехзначное число:");
                String inputStr = scanner.next();

                // "1234"

                //Выполняем проверку, что в строке 4 символа
                if (inputStr.length() != 4) {
                    System.out.println("Ошибка! Число не 4-х значное");
                } else {
                    // System.out.println((int)inputStr.charAt(0)); // получаю код символа в 10-й системе
                    // int char1 = (int)inputStr.charAt(0) - 48; // из кода символа получаю числовое значение этого символа (код 1 = 49, значение 49-48 = 1)
                    // System.out.println(char1);


                    System.out.println((int) inputStr.charAt(1));
                    if (inputStr.charAt(0) + inputStr.charAt(1) == inputStr.charAt(2) + inputStr.charAt(3)) {
                        System.out.println("Число счастливое! Ура!");
                    } else {
                        System.out.println("Число НЕ являктся \"счастливым\"");
                    }
                }

                if (inputStr.length() != 4) {
                    System.out.println("Ошибка! Число не 4-х значное");
                } else {

                    int inputInt = Integer.parseInt(inputStr);
                    System.out.println(inputInt);

                    // 1234
                    int digit0 = inputInt % 10;
                    inputInt = inputInt / 10;

                    //123
                    int digit10 = inputInt % 10;
                    inputInt /= 10;

                    //12
                    int digit20 = inputInt % 10;
                    int digit30 = inputInt / 10;

                    System.out.println("Числа: " + digit0 + " : " + digit1 + " : " + digit2 + " : " + digit3);

                    if (digit0 + digit1 == digit2 + digit3) {
                        System.out.println("Число счастливое! Ура!");
                    } else {
                        System.out.println("Число НЕ является \"счастливым\"");
                    }
                }

                if (inputStr.length() != 4) {
                    System.out.println("Ошибка! Число не 4-х значное");
                } else {

                    int inputInt = Integer.parseInt(inputStr);
                    System.out.println(inputInt);

                    // "откусываем" от числа по 1 цифре

                    // 1234
                    int digit0 = inputInt / 1000;
                    inputInt = inputInt % 1000;

                    //234
                    int digit10 = inputInt / 100;
                    inputInt %= 100;

                    //34
                    int digit20 = inputInt / 10;
                    int digit30 = inputInt % 10;

                    System.out.println("Числа: " + digit0 + " : " + digit10 + " : " + digit20 + " : " + digit30);

                    if (digit0 + digit1 == digit2 + digit3) {
                        System.out.println("Число счастливое! Ура!");
                    } else {
                        System.out.println("Число НЕ является \"счастливым\"");
                    }
                }




    }
}
