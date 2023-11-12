package homeWork47.Task1;

import java.util.HashMap;
import java.util.Map;

//Task1
//Частотный словарь слов: Напишите метод, который принимает строку текста и
// возвращает Map<String, Integer>, где каждому слову соответствует количество его вхождений в текст.

public class FrequencyDictionary {

        public static Map<String, Integer> frequencyDictionary(String text) {
            String[] words = text.split("\\s+");
            Map<String, Integer> frequencyMap = new HashMap<>();

            for (String word : words) {
                word = word.toLowerCase().replaceAll("[^а-яa-z]", "");
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }

            return frequencyMap;
        }

        public static Map<Character, Integer> frequencyCharsDictionary(String text) {
            Map<Character, Integer> frequencyCharsMap = new HashMap<>();

            for (char c : text.toCharArray()) {
                frequencyCharsMap.put(c, frequencyCharsMap.getOrDefault(c, 0) + 1);
            }

            return frequencyCharsMap;
        }

        public static void main(String[] args) {
            String text = "Строка для проверки количества вхождений слов" +
                    ".\n Строка для проверки и теста. и количества слов для проверки";

            Map<String, Integer> frequencyMap = frequencyDictionary(text);
            System.out.println("Частотный словарь слов:");
            frequencyMap.forEach((key, value) -> System.out.println(key + ": " + value));

            Map<Character, Integer> frequencyCharsMap = frequencyCharsDictionary(text);

            System.out.println("\nВхождение символов:");
            frequencyCharsMap.forEach((k, v) -> System.out.print("'" + k + "': " + v + "; "));
            System.out.println();
        }
    }