package homeWork28.task1;


public class Main {
    public static void main(String[] args) {
/*Task1
Создать класс "Dictionary" - таблица слов и их переводов.
dictionary.put("Hello", "Привет");
dictionary.put("Bye", "Пока");
dictionary.get("Hello"); // Привет
Вложенный класс - DictionaryPair (содержит исходное слово и перевод)
Внутренний класс - Translator
Translator содержит метод String[] translate(String[] words)
dictionary.put("Hello", "Привет");
dictionary.put("Bye", "Пока");
String[] words = {"Hello", "Bye", "Java"};
translator.translate(words); // {"Привет", "Пока", "Java"}
Он переводит входной набор слов по КОНКРЕТНОМУ словарю.
 */
        Dictionary dictionary = new Dictionary();
        dictionary.put("Hello", "Привет");
        dictionary.put("Bye", "Пока");
        dictionary.put("Java", "Джава");
        dictionary.put("Please", "Пожалуйста");
        dictionary.put("Rest", "Отдых");
        dictionary.put("Work", "Труд");
        dictionary.put("Job", "Работа");

        Dictionary.Translator translator = dictionary.new Translator();
        String[] words = {"Bye", "Hello", "Bye", "Java", "Job"};

        String[] translatedWords = translator.translate(words);
        for (String word : translatedWords) {
           System.out.println(word);
        }
    }
}

