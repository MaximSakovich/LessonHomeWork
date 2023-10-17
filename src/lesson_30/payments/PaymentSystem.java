package lesson_30.payments;

public interface PaymentSystem {

    boolean transferMoney(double amount, PaymentSystem recipient);
    boolean withdrawMoney(double amount);
    double checkBalance();
    void acceptTransferUSD(double amount);
    void acceptTransferBTC(double amount);
}