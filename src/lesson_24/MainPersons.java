package lesson_24;

public class MainPersons {

    public static void main(String[] args) {
        // Создание объекта Passenger
        Passenger passenger = new Passenger("Bob", 30, 12345);

        // Использование методов и геттеров
        passenger.info();
        System.out.println("Ticket Number: " + passenger.getTicketNumber());

        // Создание объекта BusDriver
        BusDriver busDriver = new BusDriver("Max", 40, "DL123");

        // Использование методов и геттеров
        busDriver.info();
        System.out.println("Driver License: " + busDriver.getDriverLicense());
        busDriver.driverInfo();
    }


}
