package homeWork15;


public class Task4 {
    public static void main(String[] args) {
        //Task 4
      /*  Написать метод, принимающий на вход массив целых чисел.
      Метод должен вернуть массив, состоящий только из простых чисел,
      присутствующих в изначальном массиве. */
        int[] numbers = {0, 13, -25, 11, 31, 55, 98, 11, 5};
        int[] primeNumbers = filterPrimes(numbers);

        System.out.println("Простые числа из исходного массива:");
        for (int num : primeNumbers) {
            System.out.print(num + " ");
        }
    }

    //Метод для проверки, является ли число простым из Task0
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

    // Метод для фильтрации простых чисел из массива
    public static int[] filterPrimes(int[] numbers) {
        int count = 0; // Счетчик простых чисел
        for (int num : numbers) {
            if (isPrime(num)) {
                count++;
            }
        }

        int[] primeArray = new int[count];

        int index = 0;
        for (int num : numbers) {
            if (isPrime(num)) {
                primeArray[index] = num;
                index++;
            }
        }
        return primeArray;
    }
}



