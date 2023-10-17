package lesson_29.interfaces;

public interface Printable {
    void print();

default void test(){System.out.println("Test");}

static void testStatic(String str) {System.out.println("Static method print: " + str);}



}
