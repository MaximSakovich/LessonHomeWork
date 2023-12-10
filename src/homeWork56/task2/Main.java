package homeWork56.task2;

import java.util.Comparator;
import java.util.List;

//Task 2
//Дан список транзакций (Transaction) с полями amount, type (DEBIT/CREDIT), timestamp.
// Используя Stream API, вычислите общую сумму для дебетовых и кредитных транзакций отдельно,
// а также найдите транзакцию с максимальной суммой.

public class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = Transaction.createTransactionList();

        // Вычисление общей суммы для дебетовых транзакций
        double totalDebitAmount = transactions.stream()
                .filter(transaction -> transaction.getType() == TransactionType.DEBIT)
                .mapToDouble(Transaction::getAmount)
                .sum();

        // Вычисление общей суммы для кредитных транзакций
        double totalCreditAmount = transactions.stream()
                .filter(transaction -> transaction.getType() == TransactionType.CREDIT)
                .mapToDouble(Transaction::getAmount)
                .sum();

        // Нахождение транзакции с максимальной суммой
        Transaction maxAmountTransaction = transactions.stream()
                .max(Comparator.comparingDouble(Transaction::getAmount))
                .orElse(null);

        // Вывод результатов
        System.out.println("Общая сумма для дебетовых транзакций: " + totalDebitAmount);
        System.out.println("Общая сумма для кредитных транзакций: " + totalCreditAmount);
        System.out.println("Транзакция с максимальной суммой: " + maxAmountTransaction);
    }
}

