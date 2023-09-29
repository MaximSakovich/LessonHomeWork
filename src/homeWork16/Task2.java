package homeWork16;


public class Task2 {
    public static void main(String[] args) {
        //  Task 2
        // Написать метод, принимающий строку и один или два индекса (перегрузка).
        // Метод должен возвращать подстроку начиная с первого индекса (включительно) и
        // заканчивая вторым индексом (не включительно) Если индекс 1 - начиная с индекса и до конца строки.
        // Функционал повторяет метод String.substring(), так что этот метод использовать не нужно.
        // Оригинальный метод ломает программу, если введены не корректные индексы.
        // Наш метод аварийно завершать программу не должен.
        String str = "Maksym Sakovych";

        // Вызываем метод для получения подстроки с одним индексом
        String substring1 = getSubstring(str, 7);
        System.out.println(substring1);

        // Вызываем метод для получения подстроки с двумя индексами
        String substring2 = getSubstring(str, 0, 5);
        System.out.println(substring2);
    }

    // Метод для получения подстроки начиная с индекса и до конца строки
    public static String getSubstring(String str, int startIndex) {
        if (startIndex < 0 || startIndex >= str.length()) {
            System.out.println("Индекс находится за пределами строки.");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    // Перегруженный метод для получения подстроки между двумя индексами
    public static String getSubstring(String str, int startIndex, int endIndex) {
        if (startIndex < 0 || startIndex >= str.length() || endIndex < 0 || endIndex > str.length() || startIndex > endIndex) {
            System.out.println("Один или оба индекса находятся за пределами строки или некорректны.");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i < endIndex; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}