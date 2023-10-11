package lesson_24;

public class Passenger extends Person {

    private final int id;
    private int ticketNumber;
    private boolean isKind;
    private static int counter;

    // Конструктор с параметрами для инициализации всех полей
    public Passenger(String name, int age, int ticketNumber) {
        super(name, age); // Вызов конструктора родительского класса
        this.id = counter++;
        this.ticketNumber = ticketNumber;
        this.isKind = age < 15;
    }

    // Геттеры и сеттеры для дополнительного поля
    public int getTicketNumber() {
        return ticketNumber;
    }

    public int getId() {
        return id;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int setId() {
        return id;
    }

}









