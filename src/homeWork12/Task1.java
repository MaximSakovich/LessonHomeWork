package homeWork12;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        /* Task 1
        За каждый месяц банк начисляет к сумме вклада 7% от суммы.
        Напишите консольную программу, в которую пользователь вводит
        сумму вклада и количество месяцев. А банк вычисляет конечную
        сумму вклада с учетом начисления процентов за каждый месяц.
        Для вычисления суммы с учетом процентов используйте цикл for.
        Пусть сумма вклада будет представлять тип float. */

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму вклада: ");
        float initialDeposit = scanner.nextFloat();

        System.out.print("Введите количество месяцев: ");
        int months = scanner.nextInt();

        float interestRate = 7;

        for (int i = 1; i <= months; i++) {
            initialDeposit += initialDeposit * interestRate/100;
        }
        System.out.format("Итоговая сумма вклада после " + months + " месяцев: " + "%.2f", initialDeposit);
    }
}
