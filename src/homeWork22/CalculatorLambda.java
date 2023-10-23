package homeWork22;

import java.util.Scanner;

public class CalculatorLambda {

    interface ExponentiationFunction {
        double apply(double num1, double num2);
    }

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

        final ExponentiationFunction[] exponentiation = new ExponentiationFunction[1];
        exponentiation[0] = (a, b) -> {
            if (b == 0) {
                return 1.0;
            } else if (b > 0) {
                double res = 1.0;
                for (int i = 0; i < b; i++) {
                    res *= a;
                }
                return res;
            } else {
                return 1.0 / exponentiation[0].apply(a, -b);
            }
        };

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
                result = exponentiation[0].apply(num1, num2);
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
}