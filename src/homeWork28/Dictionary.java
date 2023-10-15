package homeWork28;


class Dictionary {

    //внутренний класс, Inner
    public class Translator {

        public String[] translate(String[] words) {
            String[] translation = new String[words.length];
            for (int i = 0; i < words.length; i++) {
                translation[i] = get(words[i]);
            }
            return translation;
        }
    }

    //вложенный класс, Nested
    private static class DictionaryPair {
        private final String words;
        private String translate;
        public DictionaryPair(String words, String translate) {
            this.words = words;
            this.translate = translate;
        }
    }
    private final DictionaryPair[] pairs;
    private int count;

    public Dictionary() {
        this.pairs = new DictionaryPair[10];
        this.count = 0;
    }
    public void put(String words, String translate) {
        for (int i = 0; i < count; i++) {
            DictionaryPair current = pairs[i];
            if (current.words.equals(words)) {
                current.translate = translate;
                return;
            }
        }
        if (count < pairs.length) {
            DictionaryPair dictionaryPair = new DictionaryPair(words, translate);
            pairs[count] = dictionaryPair;
            count++;
        } else {
            System.out.println("Словарь переполнен, добавить больше слов невозможно.");
        }
    }
    public String get(String words) {
        for (int i = 0; i < count; i++) {
            DictionaryPair current = pairs[i];
            if (current.words.equals(words)) {
                return current.translate;
            }
        }
        return words;
    }
}

