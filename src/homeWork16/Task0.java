package homeWork16;

public class Task0 {
    public static void main(String[] args) {
        // Task0
        // Написать метод переводящие все маленькие буквы латинского
        // алфавита в строке в верхний регистр, toUpperCase() использовать нельзя.
        String input = "Maksym Sakovych";
        String result = toUpperCaseCustom(input);
        System.out.println(result);
    }

    public static String toUpperCaseCustom(String input) {
        StringBuilder sb = new StringBuilder(input.length());

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c >= 'a' && c <= 'z') {
                sb.append((char) (c - 'a' + 'A'));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}