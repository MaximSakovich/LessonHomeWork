package lesson_03;

public class MathOperations {
    public static void main(String[] args) {
        int a = 20;
        int b = 7;
        int c = a + b;
        System.out.println("C: " + c);
        c = a - b;
        System.out.println("C: " + c);
        c = a * b;
        System.out.println("C: " + c);
        double resultDiv = (double) a /b;
        System.out.println("Itogo: " + resultDiv);
        System.out.printf("itog ", resultDiv);
        int restDiv = a % b;
        System.out.println("Itogo: " + restDiv);
        double q = 15;
        double w = 6.0;
        double qq = q/w;
        System.out.println("Itogo: " + qq);
        System.out.printf("itog %.2f\nitogo ok %.2f", qq,q);

    }
}
