package homeWork22;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Простой калькулятор");
        System.out.print("Введите первое число: ");
        double num1 = scanner.nextDouble();
        System.out.print("Введите оператор (+, -, *, /, ^, s): ");
        char operator = scanner.next().charAt(0);
        System.out.print("Введите второе число: ");
        double num2 = scanner.nextDouble();
        double result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Ошибка: деление на ноль.");
                    return;
                }
                break;
            case '^':
                // Операция возведения в степень
                result = exponentiation(num1, num2);
                break;
            case 's':
                // Операция извлечения квадратного корня
                if (num1 >= 0) {
                    result = Math.sqrt(num1);
                } else {
                    System.out.println("Ошибка: извлечение корня из отрицательного числа.");
                    return;
                }
                break;

            default:
                System.out.println("Ошибка: некорректный оператор.");
                return;
        }
        System.out.printf("Результат: %.2f %n", result);
    }

    public static double exponentiation(double num1, double num2) {
        if (num2 == 0) {
            return 1.0;
        } else if (num2 > 0) {
            double result = 1.0;
            for (int i = 0; i < num2; i++) {
                result *= num1;
            }
            return result;
        } else {
            // Если степень отрицательная, то возвращаем 1 делённое на число в положительной степени
            return 1.0 / exponentiation(num1, -num2);
        }
    }
}


