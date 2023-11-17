package lesson_47;

import java.util.*;
public class Task1 {
    public static void main(String[] args) {
        String testString = "Тестовая строка для удаления слов!   оно фбв абв,! которые повторяются. \"строка\" для удаления!";
        System.out.println("список: " + getUniqueSortedWords(testString));
    }

    private static List<String> getUniqueSortedWords(String testString) {
        // 1. Избавиться от знаков препинания
        // 2. Разбить на слова
        // 3. Поместить в коллекцию, которая обеспечивает уникальность и сортировку
        // 4. Преобразовать в список и вернуть

        // массив слов, состоящих только из букв и цифр
        String[] words = testString.replaceAll("[^a-zA-Z0-9а-яА-Я ]", "").split("\\s+");
//        String[] words = testString.split("[^a-zA-Z0-9а-яА-Я]");
        System.out.println("array: " + Arrays.toString(words));



        Set<String> uniqueWords = new TreeSet<>(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));

        // Arrays.asList(T[] array) -> преобразует массив в коллекцию
        uniqueWords.addAll(Arrays.asList(words));
        // System.out.println("uniqueWords: " + uniqueWords);

        return new ArrayList<>(uniqueWords);

    }
}
