package lesson_04;
import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // создали сканнер для чтения данных из консоли

        System.out.println("Введите первое слово:");
        String word1 = scanner.nextLine(); // считали первую строку из консоли
        System.out.println("Введите второе слово:");
        String word2 = scanner.nextLine(); // считали вторую строку из консоли

        String result = word1 + word2; // соединили эти два слова и положили их в третье

        System.out.println(result); // вывели на экран
    }
}