package homeWork20;

public class Main20 {
    public static void main(String[] args) {
       /* Task 0
        Написать класс Employee (Работник) У него должны быть поля имя, возраст, зарплата
        Инкапсулировать класс. Написать метод info() выводящий информацию о работнике.
        */

        Employee employee = new Employee("Иван", 30, 50000.0);

        employee.info();// Вызов метода info() для вывода информации о работнике

    }
}