package lesson_29.flyable;

public abstract class Transport {
    int capacity;

    public Transport(int capacity) {
        this.capacity = capacity;
    }

    abstract void takePassengers();
    public int countPassengers() {
        return capacity;
    }
}