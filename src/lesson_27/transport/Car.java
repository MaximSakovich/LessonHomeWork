package lesson_27.transport;

public class Car extends VehicleWithEngine{

    public Car(Engine engine) {
        super(engine);
    }

    public Car() {
        super(new Engine(100, "Diesel"));
    }



    @Override
    public String toString() {
        return "Car {id:" +
                getId() + "; "+ getEngine()+"}";
    }
}