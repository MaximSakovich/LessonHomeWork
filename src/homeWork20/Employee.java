package homeWork20;

public class Employee {

        // Приватные поля класса
        private String name;
        private int age;
        private double salary;

        // Конструктор для инициализации объекта Employee
        public Employee(String name, int age, double salary) {
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

        // Сеттер для зарплаты
        public void setSalary(double salary) {
            this.salary = salary;
        }

        // Метод info() для вывода информации о работнике
        public void info() {
            System.out.println("Имя: " + name);
            System.out.println("Возраст: " + age + " лет");
            System.out.println("Зарплата: " + salary + " рублей");
        }

        }
