package homeWork55.task1;

import java.util.Comparator;
import java.util.List;

//Task1
// Из списка целых чисел выделите те значения, которые больше 10;
// отсортируйте эти значения по значению последней цифры в числе и выведите результат на экране

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(15, 23, 8, 42, 17, 91, 30, 55, 2, 6);

        System.out.println("Значения больше 10, отсортированные по последней цифре:");
        numbers.stream()
                .filter(number -> number > 10)
                .sorted(Comparator.comparingInt(n -> n % 10))
                .forEach(System.out::println);
    }
}
