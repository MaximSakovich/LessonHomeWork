package homeWork11;

public class Task2 {
    public static void main(String[] args) {
        // Task 2
        // Дан массив строк. Вывести на экран все символы из самой длинной строки массива
        // {“One”, “Two”, “Twenty”}
        String[] strings = {"One", "Two", "Twenty"};
        String longestString = "";
        int x = 0;
        while (x < strings.length) {
            if (strings[x].length() > longestString.length()) {
                longestString = strings[x];
            }
            x++;
        }
        int y = 0;
        while (y < longestString.length()) {
            System.out.println(longestString.charAt(y) + " ");
            y++;
        }
    }
}