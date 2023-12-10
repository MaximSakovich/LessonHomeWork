package homeWork56.task1;

import java.util.List;

public class Employee {
    private final String name;
    private final String department;
    private final double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static List<Employee> createEmployeeList() {
        return List.of(
                new Employee("Максим", "IT", 60000),
                new Employee("Сергей", "HR", 50000),
                new Employee("Борис", "IT", 70000),
                new Employee("Андрей", "Finance", 80000),
                new Employee("Данил", "HR", 55000),
                new Employee("Михаил", "Finance", 75000)
        );
    }
}
