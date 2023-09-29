package homeWork10;

import java.util.Scanner;

public class HomeWork10 {
    public static void main(String[] args) {

        //  Task 0
        //  Распечатать 10 строк: “Task1”. “Task2”. … “Task10”. Используем цикл while

        int taskNumber = 1;

        while (taskNumber <= 10) {
            System.out.print("Task" + taskNumber + ", ");
            taskNumber++;
        }
        System.out.println();

        //  Task 1
        //  Распечатать все числа от 1 до 100, которые делятся на 5 без остатка. Используем цикл do-while

        int number = 0;

        do {
            if (number % 5 == 0) {
                number = number + 5;
                System.out.print(number + "; ");
            } else {

            number++;}
        }
        while (number < 100);
        System.out.println();

        //  Task 2
        //  Распечатать только 7 чисел от 1 до 100, которые делятся на 5 без остатка. Используем цикл while

        int y = 0;//счетчик
        int x = 1;

        while (y < 7 && x <= 100) {
            if (x % 5 == 0) {
                System.out.print(x + "; ");
                y++;

            }
            x++;
        }
        System.out.println();

        //   Task 3
        //   Программа просит пользователя слово "hello" Если пользователь вводит правильное слово -
        //   программа распечатывает на экран благодарность и завершает работу. Если вводится
        //   не верное слово - программа просит ввести слово снова. До тех пор, пока не будет введено запрашиваемое слово
        //   и считать кол-во попыток, которые потребовались пользователю для введения правильного слова
        //   По окончанию - вывести число попыток на экран

        Scanner scanner = new Scanner(System.in);
        String secretWord = "hello";
        int attempts = 0;

        System.out.println("Введите слово 'hello': ");

        while (true) {
            String userInput = scanner.nextLine().trim();
            attempts++;

            if (userInput.equalsIgnoreCase(secretWord)) {
                System.out.println("Поздравляем! Вы правильно ввели 'hello'.");
                System.out.println("Количество попыток: " + attempts);
                break;
            } else {
                System.out.println("Вы ввели неправильное слово. Попробуйте ещё раз:");
            }
        }

        // Task 4
        // Программа просит пользователя ввести произвольное число.
        // Вывести сумму цифр этого числа.

        Scanner scan = new Scanner(System.in);

        long arbitraryNumber; //ввел переменную типа long для исключения ограничения
        System.out.println("Введите произвольное число:");

        while (true) {
            String input = scan.nextLine();

            if (input.matches("\\d+")) { // Проверка, что строка содержит только цифры
                arbitraryNumber = Long.parseLong(input);// метод преобразования строки в целое число типа long
                // ввод целых чисел ограничивается пределами допустимого значения для переменной типа long
                // для обхода этого ограничения нужно использовать стороннюю библиотеку BigInteger или второй метод
                break;
            } else {
                System.out.println("Некорректный ввод. Введите целое число:");
            }
        }

        long sum = 0;// ввожу переменную для суммирования целых чисел
        long originalNumber = arbitraryNumber;

        while (arbitraryNumber != 0) {
            long digit = arbitraryNumber % 10;
            sum += digit;
            arbitraryNumber /= 10;
        }
        System.out.println("Сумма цифр числа " + originalNumber + " равна " + sum);
    }
}






