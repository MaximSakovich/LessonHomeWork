package homeWork36.Task1;

import java.util.Arrays;

//Task1
// Напишите MyComparator, реализующий Comparator с методом сравнения для сортировки
// массива целых чисел в следующем порядке: Четные целые числа должны идти перед нечетными числами.

public class Main {
    public static void main(String[] args) {

        Integer[] numbers = {1, 6, 5, 4, 7, 8, 9, 2, 7, 3};

        Arrays.sort(numbers, new MyComparator());
        System.out.println(Arrays.toString(numbers));

// Task2
// Обновите MyComparator методом сравнения для сортировки массива целых чисел в следующем порядке:
//Четные целые числа должны идти перед нечетными числами в порядке возрастания.
//Нечетные целые числа должны идти после четных в порядке убывания.

        // через лямба-выражение
        Arrays.sort(numbers, (o1, o2) -> {
            if (o1 % 2 != o2 % 2) {
                return (o1 % 2 == 0) ? -1 : 1;
            } else {
                if (o1 % 2 == 0) {
                    return o1.compareTo(o2);
                } else {
                    return o2.compareTo(o1);
                }
            }
        });
        System.out.println(Arrays.toString(numbers));
    }
}
