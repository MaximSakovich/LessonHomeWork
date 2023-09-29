package homeWork08;

import java.util.Scanner;

public class BankATM {
    private static int totalDeposited = 0; // Общая сумма внесенных денег
    private static int totalDispensed = 0; // Общая сумма выданных денег
    private static int totalBalances = 0; // Общая сумма остатка на текущем счете денежных средств
    private static int depositAmount = 0; // Сумма денежных средств на депозитном счете
    private static int[] banknotes = {5, 10, 20, 50, 100, 200};//номинал банкнот EUR
    private static int[] counts = {4, 10, 23, 54, 11, 15};//количество покупюрных остатков банкнот EUR
    private static Scanner scanner = new Scanner(System.in); // Выносим Scanner в статическое поле

    public static void main(String[] args) {
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
                case 1://получение денежных средств с текущего счета
                    withdrawMoney();
                    break;
                case 2://Внесение денежных средств на текущий счет
                    depositMoney();
                    break;
                case 3://Открыть депозит (Перевести деньги с текущего счета на депозитный)
                    openDeposit();
                    break;
                case 4:// Проверка баланса текущего и депозитного счета
                    checkBalance();
                    break;
                case 0://Завершение работы (выход с программы)
                    System.out.println("Завершение работы");
                    System.exit(0);
                default:
                    System.err.println("Некорректная команда");
            }
        }
    }

    // метод получение денежных средств с текущего счета
    private static void withdrawMoney() {
        System.out.println("Получение денег");
        System.out.println("Введите сумму:");
        int requestedSum = scanner.nextInt();// Запрашиваемая сумма для выдачи с текущего счета
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
        if (remainingSum >= 0) {
            System.out.println("Операция выполнена успешно.");
        } else {
            System.err.println("Недостаточно средств в банкомате.");
        }
        totalBalances -= requestedSum;// Обновляем общий баланс на текущем счете
        System.out.println("Сумма выдачи: " + requestedSum + " EUR");
        System.out.println("Общая сумма выданных денег: " + totalDispensed + " EUR");
        System.out.println("Остаток на текущем счете: " + totalBalances + " EUR");
    }

    // метод внесения денежных средств на текущий счет
    private static void depositMoney() {
        System.out.println("Внесение денежных средств на текущий счет");
        System.out.println("Введите количество купюр:");
        int totalDepositedThisTime = 0; // Общая сумма, которую внесли за одну операцию на текущий счет
        for (int i = 0; i < banknotes.length; i++) {
            int banknote = banknotes[i];
            System.out.print("Номинал " + banknote + ": ");
            int additionalBanknotes = scanner.nextInt();
            counts[i] += additionalBanknotes;
            System.out.println("--> Вы внесли " + additionalBanknotes +
                    " купюр номиналом " + banknote + " EUR");
            totalDepositedThisTime += additionalBanknotes * banknote;
        }
        totalDeposited += totalDepositedThisTime; // Обновляем общую сумму внесенных денег
        totalBalances += totalDepositedThisTime;// Обновляем общий баланс на текущем счете
        System.out.println("Общая сумма внесенных денег: " + totalDepositedThisTime + " EUR");
        System.out.println("Остаток на текущем счете после внесения: " + totalBalances + " EUR");
    }

    // метод перечисления денежных средств на депозитный счет
    private static void openDeposit() {
        System.out.println("Открыть (перевести деньги на) депозит");
        System.out.println("Введите сумму для перечисления на депозит:");
        int depositAmountToTransfer = scanner.nextInt();//Сумма, которую внесли за одну операцию на депозитный счет
        if (depositAmountToTransfer <= 0) {
            System.err.println("Некорректная сумма для перевода на депозит.");
            return;
        }
        if (depositAmountToTransfer > totalBalances) { // Проверка доступности денег на текущем счете для депозита
            System.err.println("Запрашиваемая сумма недоступна. Баланс: " + totalBalances + " EUR.");
            return;
        } // Вычитаем сумму депозита с текущего счета и добавляем ее к depositAmount
        else {
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
        System.out.println("Сумма начисленных процентов через 5 месяцев из расчета 7% годовых с капитализацией: " +
                (int) (finalAmount - depositAmount) + " EUR");
        System.out.println("Сумма на депозите через пять месяцев с процентами: " +
                (int) finalAmount + " EUR");
        System.out.println("Остаток на текущем счете после внесения: " + totalBalances + " EUR");
    }

    //метод расчета суммы депозита с ежемесячным начислением процентов (капитализацией) за 5 месяцев при ставке 7% годовых
    private static double calculateDepositInterest() {
        double annualRate = 0.07;
        int compoundingFrequency = 12;
        int months = 5;
        double monthlyRate = annualRate / compoundingFrequency;
        return BankATM.depositAmount * Math.pow(1 + monthlyRate, compoundingFrequency * (months / 12.0));
    }

    //метод проверки остатка на текущем и депозитном счете
    private static void checkBalance() {
        System.out.println("Проверка баланса:");
        int tempTotalBalances = 0; // Временная переменная для подсчета баланса
        for (int i = 0; i < counts.length; i++) {
            int banknote = banknotes[i];
            int count = counts[i];
            int subtotal = banknote * count; // Сумма для данного номинала
            System.out.println("Баланс номинал " + count + " EUR по - "
                    + banknote + " штук: итого в сумме " + subtotal + " EUR");
            tempTotalBalances += subtotal; // Добавляем сумму для данного номинала к временной переменной
        }
        int availableBalance = tempTotalBalances - depositAmount;//Временная переменная для подсчета остатка на депозите
        if (availableBalance < 0) {
            System.err.println("Запрашиваемая сумма недоступна.");
            return;
        }
        System.out.println("Остаток денежных средств на текущем счете: " + availableBalance + " EUR");
        System.out.println("Сумма на депозите: " + depositAmount + " EUR");
        System.out.println("Итого в сумме: " + tempTotalBalances + " EUR");
    }

    //метод проверки остатка на текущем счете в начале операций
    private static void balance() {
        for (int i = 0; i < counts.length; i++) {
            int banknote = banknotes[i];
            int count = counts[i];
            totalBalances += banknote * count;
        }
        System.out.println("Остаток денежных средств на текущем счете: " + totalBalances + " EUR");
    }
}
