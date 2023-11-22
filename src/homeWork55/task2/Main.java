package homeWork55.task2;

import java.util.Arrays;

//Task 2
//Разбейте строку на слова, используя в качестве разделителя пробел.
// Используя функцию reduce верните суммарное количество букв в словах, которые длиннее 4 символов

public class Main {
    public static void main(String[] args) {
        String text = "Hello, world and good afternoon";
        int countLetters = countLetters(text);
        System.out.println("countLetters: " + countLetters);
    }

    private static int countLetters(String text) {
        return Arrays.stream(text.split("\\s+"))
                .map(word -> word.replaceAll("[^a-zA-Z]", ""))
                .filter(word -> word.length() > 4)
                .mapToInt(String::length)
                .reduce(0, Integer::sum);
    }
}

