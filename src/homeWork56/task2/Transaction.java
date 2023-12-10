package homeWork56.task2;

import java.util.ArrayList;
import java.util.List;
class Transaction {
    private final double amount;
    private final TransactionType type;
    private final long timestamp;

    public Transaction(double amount, TransactionType type, long timestamp) {
        this.amount = amount;
        this.type = type;
        this.timestamp = timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", type=" + type +
                ", timestamp=" + timestamp +
                '}';
    }

    // Метод для создания списка транзакций (для примера)
    public static List<Transaction> createTransactionList() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(100.0, TransactionType.DEBIT, System.currentTimeMillis()));
        transactions.add(new Transaction(50.0, TransactionType.CREDIT, System.currentTimeMillis()));
        transactions.add(new Transaction(200.0, TransactionType.DEBIT, System.currentTimeMillis()));
        transactions.add(new Transaction(75.0, TransactionType.CREDIT, System.currentTimeMillis()));
        return transactions;
    }
}
