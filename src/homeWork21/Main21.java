package homeWork21;

import homeWork20.Employee;

public class Main21 {
    public static void main(String[] args) {

        Employee21[] employees = new Employee21[5];

        employees[0] = new Employee21("Иван Петров", 30, 50000.0);
        employees[1] = new Employee21("Петр Сидоров", 26, 54000.0);
        employees[2] = new Employee21("Максим Иванов", 48, 43000.0);
        employees[3] = new Employee21("Евгений Жирнов", 56, 80000.0);
        employees[4] = new Employee21("Михаил Сергеев", 25, 30000.0);

        for (Employee21 employee : employees) {
            employee.info();
        }
    }

}
