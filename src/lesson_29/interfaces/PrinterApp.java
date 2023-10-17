package lesson_29.interfaces;

public class PrinterApp {
    public static void main(String[] args) {
       Printable book = new Book("Философия Java", "Б.Эккуль");
       Printable magazine = new Magazine("Cosmopolitan", 3);

       Book book1 = new Book("Мастер и Маргарита", "М. Булгаков");

       book.print();
       System.out.println();
       magazine.print();
       book1.print();
       System.out.println();
       book.test();
       magazine.test();

       Printable.testStatic("Hello");


    }
}
