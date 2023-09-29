package homeWork12;


public class Task3 {
    public static void main(String[] args) {

        // Task3
        // *опционально Написать программу, выводящую на
        // экран треугольник, состоящий из цифр от 1 до 6
        int number = 6;

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
