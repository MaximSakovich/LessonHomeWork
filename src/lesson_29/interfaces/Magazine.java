package lesson_29.interfaces;

public class Magazine implements Printable {
    String name;
    int number;

    public Magazine(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public void test() {
        Printable.super.test();
    }

    @Override
        public void print() {
            System.out.println("Magazin " + name + " #" + number);



        }

}
