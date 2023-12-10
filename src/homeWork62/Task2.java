package homeWork62;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        String inputString = "myemail@example.co!m another&email@example.com";
        String regex = "[@&!]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputString);
        while (matcher.find()) {
            System.out.println("Найденный символ: " + matcher.group());
        }
    }
}
