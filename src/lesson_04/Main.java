package lesson_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("VVedite nachalo");
        String start = scanner.nextLine();
        System.out.println("VVedite konechniy");
        String finish = scanner.nextLine();
        System.out.println("VVEdite xnjmj");
        int minutes = scanner.nextInt();
        System.out.println("VVEdite dddd");
        double dist = scanner.nextDouble();
        String message = "van hw;no" + finish + start+minutes+dist;
        System.out.println(message);
    }
}