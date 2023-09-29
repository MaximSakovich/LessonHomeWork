package lesson_07;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //  greet("Maksym", "Sakovych");
        // greet("Dmitriy", "Dmitriy");
        //  greet("Tatyana", "Matviychuk");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String lastname = scanner.nextLine();
        greet(name, lastname);
        //add(5,5);
        //System.out.println(add(5, 5));
        //System.out.println(add(add(4, 4), add(4, 4)));
        //  add(add(add(4, 4), 4), add(4, 4))
        int x = 16;
        if (x == 16) {
            System.out.println("Всем привет!");
            System.out.println("if");
        } else if (x < 5) {
            System.out.println("else if");
        } else {
            System.out.println("else");
        }

        int money = 100;
        int note;

        Random random = new Random();
        note = random.nextInt(5) + 1;// генерация числа от 1 до 5
        if (note == 5) {
            money += 20;
        } else if (note == 4) {
            money += 10;
        } else if (note == 2) {
            money -= 20;
        } else if (note == 1) {
            money = 0;
        }

        System.out.println("Введите число: ");
        int nam = scanner.nextInt();
        if (nam > 10) {
            nam += 20;
        } else if (nam < -10) {
            nam *= -1;
        } else if (nam == 4) {
            nam *= 4;
        } else {
            nam = nam * -1;
        }
        System.out.println(nam);
    }




    public static void greet(String name, String lastname) {
        System.out.println("Hello " + name + " " + lastname);
        System.out.println(name.equals(lastname));//сравнение строк через метод equals выдает false and true
    }


    public static int add(int numberA, int numberB) {
        int result = numberA + numberB;
        return result;


    }


}
