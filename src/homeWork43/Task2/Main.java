package homeWork43.Task2;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Predicate<Integer> greaterThanTen = x -> x > 10;
        Predicate<Integer> lessThanTwenty = x -> x < 20;
        Predicate<Integer> betweenTenAndTwenty = greaterThanTen.and(lessThanTwenty);

        System.out.println(betweenTenAndTwenty.test(15)); // Вывод: true
        System.out.println(betweenTenAndTwenty.test(5));  // Вывод: false


        Predicate<String> nonEmptyString = s -> !s.isEmpty();
        Predicate<String> emptyString = nonEmptyString.negate();

        System.out.println(emptyString.test("Hello")); // Вывод: false
        System.out.println(emptyString.test(""));      // Вывод: true


        Predicate<Integer> lessThanFive = x -> x < 5;
        Predicate<Integer> greaterThanTenNew = x -> x > 10;
        Predicate<Integer> lessThanFiveOrGreaterThanTen = lessThanFive.or(greaterThanTen);

        System.out.println(lessThanFiveOrGreaterThanTen.test(3));  // Вывод: true
        System.out.println(lessThanFiveOrGreaterThanTen.test(8));  // Вывод: true
        System.out.println(lessThanFiveOrGreaterThanTen.test(6));  // Вывод: false


        Predicate<Integer> isZero = x -> x == 0;
        Predicate<Integer> isNotZero = Predicate.not(isZero);

        System.out.println(isNotZero.test(0)); // Вывод: false
        System.out.println(isNotZero.test(5)); // Вывод: true



    }
}
