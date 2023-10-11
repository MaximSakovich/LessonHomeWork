package lesson_24;

public class BusDriver extends Person {

    private String driverLicense;
    private int id;
    private static int counter = 100;


    // Конструктор с параметрами для инициализации всех полей
    public BusDriver(String name, int age, String driverLicense) {
        super(name, age); // Вызов конструктора родительского класса
        this.driverLicense = driverLicense;
        this.id = counter++;
    }

    public void driverInfo() {
        System.out.println("BusDriver" + getName() + " id: " + id);
    }


    // Геттеры и сеттеры для дополнительного поля
    public String getDriverLicense() {
        return driverLicense;
    }

    public int getId() {
        return id;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public int setId() {
        return id;
    }

}