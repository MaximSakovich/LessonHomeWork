package homeWork62;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    public static void main(String[] args) {
        String inputString = "Bears, Bees, and Bunnies are beautiful.";
        String regex = "[bB]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputString);
        while (matcher.find()) {
            System.out.println("Найденная буква: " + matcher.group());
        }
    }
}
