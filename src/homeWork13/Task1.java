package homeWork13;

public class Task1 {
    public static void main(String[] args) {
        //  Task 1

        //  Написать метод, принимающий на вход целое число.
        //  Метод должен вывести на экран 2 в степени это число.
        //  Класс Math для нахождения степени числа использовать нельзя.
        int number = 5;
        int result = powerTwo(number);
        System.out.println("2 в степени " + number + " = " + result);
    }

    // Метод для вычисления 2 в степени заданного числа
    public static int powerTwo(int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0; // Если степень отрицательная, результат будет 0
        }

        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= 2;
        }
        return result;
    }
}
