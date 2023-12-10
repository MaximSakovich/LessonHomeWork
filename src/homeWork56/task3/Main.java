package homeWork56.task3;

import homeWork56.task1.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Task 3
//Дан список Employee. Вычислите среднюю зарплату сотрудников в каждом отделе и
// найдите отдел с максимальной средней зарплатой.

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Employee.createEmployeeList();

        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        // Вычисление средней зарплаты по отделам
        Map<String, Double> averageSalaryByDepartment = employeesByDepartment.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .mapToDouble(Employee::getSalary)
                                .average()
                                .orElse(0.0)
                ));
        System.out.println("Средняя зарплата по отделам:");
        averageSalaryByDepartment.forEach((department, averageSalary) ->
                System.out.println("Department: " + department + ", Average Salary: " + averageSalary));

        // Нахождение отдела с максимальной средней зарплатой
        String maxAverageSalaryDepartment = averageSalaryByDepartment.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Unknown");
        System.out.println("\nОтдел с максимальной средней зарплатой: " + maxAverageSalaryDepartment);
    }
}
