package lesson_29.flyable;

public class Duck implements Swimmable, Flyable{
    @Override
    public void fly() {
        System.out.println("Duck fly");
    }

    @Override
    public void swim() {
        System.out.println("Duck swim");
    }
}