package lesson_27.transport;

public class Bicycle extends Vehicle {

    public Bicycle(){
        setEngine(null);
    }

    @Override
    void startEngine() {
        System.out.println("Двигатель отсутствует");
    }

    @Override
    public String toString() {
        return "Bicycle {id:" +  getId() + "; двигателя нет}";
    }
}
