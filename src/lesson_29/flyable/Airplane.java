package lesson_29.flyable;

public class Airplane extends Transport  implements Flyable {
    public Airplane(int capacity) {
        super(capacity);
    }

    @Override
    public void fly() {
        System.out.println("Airplane fly");
    }

    @Override
    void takePassengers() {
        System.out.println("Беру на борт пассажиров");
    }
}
