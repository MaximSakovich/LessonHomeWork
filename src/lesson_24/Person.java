package lesson_24;


/*
Создайте базовый класс Person c двумя полями и методами:

        Поля:
        Конструктор с параметрами для инициализации полей
        Методы для получения (get) и установки (set) значений полей
        Метод info(), который выводит информацию о человеке (поля)

        Создайте класс Passenger, который наследует класс Person. Добавьте дополнительное поля и метод /ы:
        Поле:
        Конструктор с параметрами для инициализации всех полей (включая поля родительского класса)
        Гетеры / сеттеры

        Создайте класс BusDriver, который также наследует класс Person. Добавьте дополнительное поля и метод /ы:
        Поле:
        Геттеры / сеттеры */
public class Person {

        private String name;
        private int age;
    // Конструктор с параметрами для инициализации всех полей
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    // Геттеры и сеттеры для дополнительного поля
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void info() {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        }
    }

