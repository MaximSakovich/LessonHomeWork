package lesson_17;

public class MainDog {
    public static void main(String[] args) {

        Dog dog = new Dog("Bim", 5);
        System.out.println(dog.whoAmI());

        dog.run();
        dog.run();
        dog.run();
        dog.run();
        dog.run();
        dog.run();

        System.out.println(dog.whoAmI());
    }
}