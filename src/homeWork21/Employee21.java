package homeWork21;

public class Employee21 {

    // Приватные поля класса
    private int id; // Уникальный идентификатор

    private static String companyName;
    private static int nextId = 1;
    private String name;
    private int age;
    private double salary;

    // Конструктор для инициализации объекта Employee
    public Employee21(String name, int age, double salary) {
        this.id = nextId++;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Геттер для имени
    public String getName() {
        return name;
    }

    // Геттер для возраста
    public int getAge() {
        return age;
    }

    // Геттер для зарплаты
    public double getSalary() {
        return salary;
    }

    // Сеттер для имени
    public void setName(String name) {
        this.name = name;
    }

    // Сеттер для зарплаты
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Метод info() для вывода информации о работнике
    public void info() {
        System.out.println("Название фирмы: " + getCompanyName());
        System.out.println("Имя: " + name);
        System.out.println("Уникальный идентификатор: " + id);
        System.out.println("Возраст: " + age + " лет");
        System.out.println("Зарплата: " + salary + " рублей");
    }

    public static String getCompanyName() {
        companyName = "Рога и копыта";
        return companyName;
    }

}
