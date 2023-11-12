package lesson_46.sets;

import java.text.Collator;
import java.util.*;

public class SetExample {

        public static List<String> getUniqueSortedWords(String input) {
            String[] words = input.split("[\\p{Punct}\\s]+");
            Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

            List<String> sortedWords = new ArrayList<>(uniqueWords);

            sortedWords.sort((o1, o2) -> {
                if (o1.length() == o2.length()) {
                    Collator collator = Collator.getInstance(new Locale("ru", "RU"));
                    return collator.compare(o1, o2);
                }
                return Integer.compare(o1.length(), o2.length());
            });
            return sortedWords;
        }

        public static void main(String[] args) {
            String testString = "Тестовая строка для удаления слов, которые повторяются. \"строка\" для удаления!";
            System.out.println(SetExample.getUniqueSortedWords(testString));
        }
    }
