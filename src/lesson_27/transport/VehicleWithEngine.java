package lesson_27.transport;

abstract class VehicleWithEngine extends Vehicle {

//    private Engine engine;

    public VehicleWithEngine(Engine engine) {
        super.setEngine(engine);
    }


    @Override
    void startEngine() {
        if (getEngine() != null) {
            getEngine().start();
        } else {
            System.out.println("Двигателя нет");
        }
    }

    abstract public String toString();
}