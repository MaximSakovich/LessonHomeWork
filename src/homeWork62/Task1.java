package homeWork62;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static void main(String[] args) {
        String inputString = "Моя дата рождения 2.6.1990";
        String regex = "[0-6]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputString);
        while (matcher.find()) {
            System.out.println("Найденная цифра: " + matcher.group());
        }
    }
}
