package homeWork29.task0;
/*Task 0
Платежные системы: Создайте интерфейс PaymentSystem с методами transferMoney,
withdrawMoney и checkBalance. Реализуйте классы BankAccount и ElectronicWallet,
которые реализуют данный интерфейс.
Убедитесь, что каждый класс корректно выполняет каждую из операций. */

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);
        System.out.println("Баланс банковского счета: " + bankAccount.checkBalance());
        bankAccount.withdrawMoney(400);
        System.out.println("Баланс банковского счета после вывода: " + bankAccount.checkBalance());

        // Пример использования электронного кошелька
        ElectronicWallet electronicWallet = new ElectronicWallet(500);
        System.out.println("Баланс Электронного кошелька: " + electronicWallet.checkBalance());
        electronicWallet.transferMoney(200, bankAccount);
        System.out.println("Баланс Электронного кошелька после перевода: " + electronicWallet.checkBalance());
        System.out.println("Баланс банковского счета после перевода: " + bankAccount.checkBalance());
    }
}