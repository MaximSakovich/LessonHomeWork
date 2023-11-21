package homeWork53;

import java.util.function.Function;

public class Task2 {
    public static void main(String[] args) {
        String input = "Строка как пример для подсчета";

        String result = transformString(input, String::trim, String::toUpperCase, s -> "Количество символов: " + s.length());
        System.out.println(result);
    }

    // Метод, который позволяет создавать цепочки функций для преобразования строк.
    private static String transformString(String input, Function<String, String>... functions) {
        String result = input;

        for (Function<String, String> function : functions) {
            result = function.apply(result);
        }

        return result;
    }
}
