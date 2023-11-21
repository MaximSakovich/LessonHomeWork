package homeWork53;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//Task 1
//Напишите метод, принимающий список чисел и возвращающий новый, отфильтрованный список.
// Используйте несколько предикатов для фильтрации списка чисел,
// где числа должны быть четными, больше 10 и меньше 100

public class Task1 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(30, 5, 25, 12, 45, 60, 61, 75, 90, 105);

        List<Integer> filteredNumbers = filterNumbers(numbers);
        System.out.println(filteredNumbers);
    }

    public static List<Integer> filterNumbers(List<Integer> numbers) {
        Predicate<Integer> isEven = num -> num % 2 == 0;
        Predicate<Integer> isGreaterThan10 = num -> num > 10;
        Predicate<Integer> isLessThan100 = num -> num < 100;

        return numbers.stream()
                .filter(isEven.and(isGreaterThan10).and(isLessThan100))
                .sorted()
                .collect(Collectors.toList());
    }
}
