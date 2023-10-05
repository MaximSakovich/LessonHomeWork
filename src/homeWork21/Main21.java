package homeWork21;

import homeWork20.Employee;

public class Main21 {
    public static void main(String[] args) {

        Employee21 employee = new Employee21 ("Иван Петров", 30, 50000.0);
        Employee21 employee2 = new Employee21 ("Петр Сидоров", 26, 54000.0);
        Employee21 employee3 = new Employee21 ("Максим Иванов", 48, 43000.0);
        Employee21 employee4 = new Employee21 ("Евгений Жирнов", 56, 80000.0);
        Employee21 employee5 = new Employee21 ("Михаил Сергеев", 25, 30000.0);

        employee.info();
        employee2.info();
        employee3.info();
        employee4.info();
        employee5.info();
    }


}
