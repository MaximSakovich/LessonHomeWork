package homeWork56.task1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Task 1
//Дан список сотрудников (Employee) с полями name, department, salary.
// Используя Stream API, сгруппируйте сотрудников по отделам

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Employee.createEmployeeList();

        // Группировка сотрудников по отделам
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        employeesByDepartment.forEach((department, employeeList) -> {
            System.out.println("Department: " + department);
            employeeList.forEach(employee -> System.out.println("  " + employee.getName() + ", Salary: " + employee.getSalary()));
            System.out.println();
        });
    }
}