package homeWork15;

public class Task0 {
    public static void main(String[] args) {
        // Task 0
       /* Написать метод принимающий целое число и проверяющий является ли число простым.
       Если является, метод должен вернуть true, не является - false
        */

        int number = 13;

        if (isPrime(number)) {
            System.out.println(number + " является простым числом.");
        } else {
            System.out.println(number + " не является простым числом.");
        }
    }

    //Метод для проверки, является ли число простым
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
