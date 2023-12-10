package homeWork62;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) {
        String inputString = "London is the capital of Great Britain.";
        String regex = "[A-Z]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputString);
        while (matcher.find()) {
            System.out.println("Найденная заглавная буква: " + matcher.group());
        }
    }
}
