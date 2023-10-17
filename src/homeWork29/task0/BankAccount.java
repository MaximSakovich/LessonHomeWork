package homeWork29.task0;

// Класс банковского счета
class BankAccount implements PaymentSystem {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public void transferMoney(double amount, PaymentSystem recipient) {
        if (amount <= balance) {
            balance -= amount;
            recipient.receiveMoney(amount);
            System.out.println(amount + " передан успешно.");
        } else {
            System.out.println("Недостаточный баланс.");
        }
    }

    @Override
    public void withdrawMoney(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + " успешно выведены.");
        } else {
            System.out.println("Недостаточный баланс.");
        }
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public void receiveMoney(double amount) {
        balance += amount;
    }
}