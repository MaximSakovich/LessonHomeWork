package lesson_43.functions.predicate;

/**
 * 11/3/2023
 * lesson_43
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main {
    public static void main(String[] args) {
        ListFilter filter = new ListFilter();

        MyArrayList<Integer> numbers = new MyArrayList<>();
        numbers.addAll(10, -15, 20, 11, -28, 7, -5);

        MyArrayList<String> strings = new MyArrayList<>();
        strings.addAll("Hello", "Hi", "Marsel", "Henry", "Berlin");

//        Predicate<Integer> isPositive = new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                return integer > 0;
//            }
//        };
//
//        Predicate<Integer> isEven = new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                return integer % 2 == 0;
//            }
//        };
//
//        Predicate<Integer> isOdd = new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer x) {
//                return x % 2 != 0;
//            }
//        };

//        Predicate<Integer> isPositive = integer -> {
//            return integer > 0;
//        };
//
//        Predicate<Integer> isEven = integer -> {
//            return integer % 2 == 0;
//        };
//
//        Predicate<Integer> isOdd = integer -> {
//            return integer % 2 != 0;
//        };


        MyArrayList<Integer> filteredNumbers = filter.filter(numbers, x -> x % 2 == 0);
        MyArrayList<String> filteredStrings = filter.filter(strings, (word -> word.startsWith("H")));

        System.out.println(filteredNumbers);
        System.out.println(filteredStrings);
    }
}
