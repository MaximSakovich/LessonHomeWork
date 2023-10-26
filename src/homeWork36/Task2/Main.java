package homeWork36.Task2;

import java.util.Arrays;

// Task2
// Обновите MyComparator методом сравнения для сортировки массива целых чисел в следующем порядке:
//Четные целые числа должны идти перед нечетными числами в порядке возрастания.
//Нечетные целые числа должны идти после четных в порядке убывания.


public class Main {
    public static void main(String[] args) {
        Integer[] numbers = { 1, 6, 5, 4, 7, 8, 9, 2, 7, 3 };
        Arrays.sort(numbers, new MyComparator());
        System.out.println(Arrays.toString(numbers));
    }
}
