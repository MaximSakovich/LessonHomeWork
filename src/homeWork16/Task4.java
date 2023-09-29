package homeWork16;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        //Task4
        //Написать метод, принимающий строку и возвращающий новую строку,
        //состоящую из 2го и 3го символа входящей строки, переведенных
        //в верхний регистр. Распечатать полученный результат в методе main
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        scanner.close();

        String result = getSubstringToUpper(input);
        System.out.println(result);
    }

    // Метод для получения подстроки из 2-го и 3-го символов в верхнем регистре
    public static String getSubstringToUpper(String input) {
        if (input.length() < 2) {
            System.out.println("Строка слишком короткая. Не могу получить подстроку.");
            return "";
        }

        char char2 = Character.toUpperCase(input.charAt(1));

        if (input.length() == 2) {
            return String.valueOf(char2);
        } else {
            char char3 = Character.toUpperCase(input.charAt(2));
            return String.valueOf(char2) + String.valueOf(char3);
        }

    }
}
