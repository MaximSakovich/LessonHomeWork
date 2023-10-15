package lesson_27.transport;

abstract class Vehicle {
    private final int  id;
    private static int counter;
    private Engine engine;

    public Vehicle() {
        this.id = counter++;
    }

    abstract void startEngine();

    abstract public String toString();

    public int getId() {
        return id;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}