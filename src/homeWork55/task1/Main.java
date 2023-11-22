package homeWork55.task1;

import java.util.Arrays;
import java.util.List;


//Task1
// Из списка целых чисел выделите те значения, которые больше 10;
// отсортируйте эти значения по значению последней цифры в числе и выведите результат на экране

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(15, 23, 8, 42, 17, 91, 30, 55);

        System.out.println("Значения больше 10, отсортированные по последней цифре:");
        numbers.stream()
                .filter(number -> number > 10)
                .sorted((a, b) -> Integer.compare(a % 10, b % 10))
                .forEach(System.out::println);
    }
}
