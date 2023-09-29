package homeWork04;

import java.util.Scanner;

public class HomeWork04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше имя");
        String name = scanner.nextLine();
        System.out.println("Введите вашу фамилию");
        String surname = scanner.nextLine();
        System.out.println("Введите ваш город");
        String city = scanner.nextLine();
        System.out.println("Введите ваш возраст");
        int age = scanner.nextInt();
        System.out.println("Введите ваш рост (в метрах)");
        double height = scanner.nextDouble();
        String message = "Меня зовут " + name + " " + surname + ", мне " + age + " лет, я из "
                + city + ", мой рост - " + height;
        System.out.println(message);
    }
}
