package homeWork08;

import java.util.Scanner;

public class BankATMold {
    private int totalDeposited = 0;
    private int totalDispensed = 0;
    private int totalBalances = 0;
    private int depositAmount = 0;

    private int[] banknotes = {5, 10, 20, 50, 100, 200};
    private int[] counts = {4, 10, 23, 54, 11, 15};

    public static void main(String[] args) {
      //  BankATM atm = new BankATM();
      //  atm.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Банкомат");

        balance();// Инициализируем общий остаток на текущем счете только один раз

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Выдать деньги");
            System.out.println("2. Внести деньги");
            System.out.println("3. Открыть (перевести деньги на) депозит");
            System.out.println("4. Проверить баланс");
            System.out.println("0. Завершить работу");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdrawMoney();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    openDeposit();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 0:
                    System.out.println("Завершение работы");
                    System.exit(0);
                default:
                    System.err.println("Некорректная команда");
            }
        }
    }

    private void withdrawMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Получение денег");
        System.out.println("Введите сумму:");
        int requestedSum = scanner.nextInt();

        if (requestedSum <= 0) {
            System.err.println("Некорректная сумма.");
            return;
        }

        if (requestedSum > totalBalances) {
            System.err.println("Запрашиваемая сумма недоступна. Баланс: " + totalBalances + " EUR.");
            return;
        }

        int remainingSum = requestedSum;
        for (int i = banknotes.length - 1; i >= 0; i--) {
            int banknote = banknotes[i];
            int count = counts[i];
            int banknotesToDispense = Math.min(count, remainingSum / banknote);
            if (banknotesToDispense > 0) {
                counts[i] -= banknotesToDispense;
                remainingSum -= banknotesToDispense * banknote;
                totalDispensed += banknotesToDispense * banknote;
                System.out.println("Выдаем " + banknote + "-ками " + banknotesToDispense +
                        ", осталось выдать - " + remainingSum);
            }
        }

        if (remainingSum == 0) {
            System.out.println("Операция выполнена успешно.");
        } else {
            System.err.println("Недостаточно средств в банкомате.");
        }

        totalBalances -= requestedSum;
        System.out.println("Сумма выдачи: " + requestedSum + " EUR");
        System.out.println("Общая сумма выданных денег: " + totalDispensed + " EUR");
        System.out.println("Остаток на текущем счете: " + totalBalances + " EUR");
    }

    private void depositMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Внесение денег на текущий счет");
        System.out.println("Введите количество купюр:");

        int totalDepositedThisTime = 0;
        for (int i = 0; i < banknotes.length; i++) {
            int banknote = banknotes[i];
            System.out.print("Номинал " + banknote + ": ");
            int additionalBanknotes = scanner.nextInt();

            if (additionalBanknotes < 0) {
                System.err.println("Некорректное количество купюр.");
                return;
            }

            counts[i] += additionalBanknotes;
            System.out.println("--> Вы внесли " + additionalBanknotes +
                    " купюр номиналом " + banknote + " EUR");
            totalDepositedThisTime += additionalBanknotes * banknote;
        }

        totalDeposited += totalDepositedThisTime;
        totalBalances += totalDepositedThisTime;

        System.out.println("Общая сумма внесенных денег: " + totalDepositedThisTime + " EUR");
        System.out.println("Остаток на текущем счете после внесения: " + totalBalances + " EUR");
    }

    private void openDeposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Открыть (перевести деньги на) депозит");
        System.out.println("Введите сумму для перечисления на депозит:");
        int depositAmountToTransfer = scanner.nextInt();

        if (depositAmountToTransfer <= 0) {
            System.err.println("Некорректная сумма для перевода на депозит.");
            return;
        }

        if (depositAmountToTransfer > totalBalances) {
            System.err.println("Запрашиваемая сумма недоступна. Баланс: " + totalBalances + " EUR.");
            return;
        } else {
            totalBalances -= depositAmountToTransfer;
            depositAmount += depositAmountToTransfer;

            if (depositAmount <= 0) {
                System.err.println("Некорректная сумма для перевода на депозит.");
                return;
            }
        }

        System.out.println("Деньги на депозит успешно переведены.");
        double finalAmount = calculateDepositInterest();
        System.out.println("Сумма на депозите: " + depositAmount + " EUR");
        System.out.println("Сумма начисленных процентов через 5 месяцев: " +
                (int) (finalAmount - depositAmount) + " EUR");
        System.out.println("Сумма на депозите через пять месяцев с процентами: " +
                (int) finalAmount + " EUR");
        System.out.println("Остаток на текущем счете после внесения: " + totalBalances + " EUR");
    }

    private double calculateDepositInterest() {
        double annualRate = 0.07;
        int compoundingFrequency = 12;
        int months = 5;
        double monthlyRate = annualRate / compoundingFrequency;
        return depositAmount * Math.pow(1 + monthlyRate, compoundingFrequency * (months / 12.0));
    }

    private void checkBalance() {
        System.out.println("Проверка баланса:");
        int tempTotalBalances = 0;
        for (int i = 0; i < counts.length; i++) {
            int banknote = banknotes[i];
            int count = counts[i];
            int subtotal = banknote * count;
            System.out.println("Баланс номинал " + count + " EUR по - "
                    + banknote + " штук: итого в сумме " + subtotal + " EUR");
            tempTotalBalances += subtotal;
        }
        int availableBalance = tempTotalBalances - depositAmount;
        if (availableBalance < 0) {
            System.err.println("Запрашиваемая сумма недоступна.");
            return;
        }
        System.out.println("Остаток денежных средств на текущем счете: " + availableBalance + " EUR");
        System.out.println("Сумма на депозите: " + depositAmount + " EUR");
        System.out.println("Итого в сумме: " + (tempTotalBalances + depositAmount) + " EUR");
    }

    private void balance() {
        for (int i = 0; i < counts.length; i++) {
            int banknote = banknotes[i];
            int count = counts[i];
            totalBalances += banknote * count;
        }
        System.out.println("Остаток денежных средств на текущем счете: " + totalBalances + " EUR");
    }
}


