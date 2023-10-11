package lesson_01;

public class HelloWorld {
    public static void main(String[] args) {
        int maFirstVariable;
        maFirstVariable = 1; //ok
        int mySecondVariable = 25;//объявление и инициализация
        System.out.println(mySecondVariable);
        mySecondVariable = 100;
        System.out.println(mySecondVariable);
        byte byteVariable = 99;
        System.out.println(byteVariable);
        short shortVariable = 32000;
        long longVariable = 1_200_000_000_000_000L;
        System.out.println("Число Long " + longVariable);
        double doubleVariable;
        doubleVariable = 10;
        System.out.println("Число " + doubleVariable);
        doubleVariable = 5.432;
        System.out.println("Число " + doubleVariable);

            System.out.println("Hello, World!");

   }
}
