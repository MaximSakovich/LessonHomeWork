package homeWork15;

public class Task1 {
    public static void main(String[] args) {
        //Task 1
       /* Написать метод, принимающий массив целых чисел. Метод должен вернуть
       количество простых чисел в массиве. Для проверки на "простоту" числа
       рекомендуется использовать метод из Task 0 */

            int[] numbers = {2, 3, 4, 5, 6, 7, 8, 9, 10};
            int primeCount = countPrimesInArray(numbers);
            System.out.println("Количество простых чисел в массиве: " + primeCount);
        }

// Метод для проверки, является ли число простым
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

        // Метод для подсчета простых чисел в массиве
        public static int countPrimesInArray(int[] arr) {
            int count = 0;
            for (int num : arr) {
                if (isPrime(num)) {
                    count++;
                }
            }
            return count;
        }

    }

