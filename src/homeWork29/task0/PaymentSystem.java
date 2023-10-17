package homeWork29.task0;


// Интерфейс платежной системы
interface PaymentSystem {
    void transferMoney(double amount, PaymentSystem recipient);
    void withdrawMoney(double amount);
    void receiveMoney(double amount);
    double checkBalance();
}