package homeWork08;

import java.util.Scanner;

public class BankAtmEng {
    private static int totalDeposited = 0; // Total deposited amount
    private static int totalDispensed = 0; // Total dispensed amount
    private static int totalBalances = 0; // Total balance on the current account
    private static int depositAmount = 0; // Deposit account balance
    private static int[] banknotes = {5, 10, 20, 50, 100, 200}; // Banknote denominations in EUR
    private static int[] counts = {4, 10, 23, 54, 11, 15}; // Banknote counts in EUR
    private static Scanner scanner = new Scanner(System.in); // Scanner for user input

    public static void main(String[] args) {
        System.out.println("ATM");
        balance(); // Initialize the total balance on the current account only once
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Withdraw Money");
            System.out.println("2. Deposit Money");
            System.out.println("3. Open Deposit Account");
            System.out.println("4. Check Balance");
            System.out.println("0. Exit");
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
                    System.out.println("Exiting");
                    System.exit(0);
                default:
                    System.err.println("Invalid command");
            }
        }
    }

    private static void withdrawMoney() {
        System.out.println("Withdraw Money");
        System.out.println("Enter amount:");
        int requestedSum = scanner.nextInt();
        if (requestedSum > totalBalances) {
            System.err.println("The requested amount is not available. Balance: " + totalBalances + " EUR.");
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
                System.out.println("Dispensing " + banknote + " EUR banknotes: " + banknotesToDispense +
                        ", remaining to dispense: " + remainingSum);
            }
        }
        if (remainingSum >= 0) {
            System.out.println("Transaction successful.");
        } else {
            System.err.println("Not enough funds in the ATM.");
        }
        totalBalances -= requestedSum;
        System.out.println("Amount dispensed: " + requestedSum + " EUR");
        System.out.println("Total amount dispensed: " + totalDispensed + " EUR");
        System.out.println("Balance on the current account: " + totalBalances + " EUR");
    }

    private static void depositMoney() {
        System.out.println("Deposit Money");
        System.out.println("Enter the number of banknotes:");
        int totalDepositedThisTime = 0;
        for (int i = 0; i < banknotes.length; i++) {
            int banknote = banknotes[i];
            System.out.print("Denomination " + banknote + ": ");
            int additionalBanknotes = scanner.nextInt();
            counts[i] += additionalBanknotes;
            System.out.println("--> You deposited " + additionalBanknotes +
                    " banknotes of " + banknote + " EUR");
            totalDepositedThisTime += additionalBanknotes * banknote;
        }
        totalDeposited += totalDepositedThisTime;
        totalBalances += totalDepositedThisTime;
        System.out.println("Total amount deposited: " + totalDepositedThisTime + " EUR");
        System.out.println("Balance on the current account after deposit: " + totalBalances + " EUR");
    }

    private static void openDeposit() {
        System.out.println("Open Deposit Account");
        System.out.println("Enter the amount to transfer to the deposit account:");
        int depositAmountToTransfer = scanner.nextInt();
        if (depositAmountToTransfer <= 0) {
            System.err.println("Invalid amount for the deposit.");
            return;
        }
        if (depositAmountToTransfer > totalBalances) {
            System.err.println("The requested amount is not available. Balance: " + totalBalances + " EUR.");
            return;
        } else {
            totalBalances -= depositAmountToTransfer;
            depositAmount += depositAmountToTransfer;
            if (depositAmount <= 0) {
                System.err.println("Invalid amount for the deposit.");
                return;
            }
        }
        System.out.println("Money transferred to the deposit account successfully.");
        double finalAmount = calculateDepositInterest();
        System.out.println("Deposit account balance: " + depositAmount + " EUR");
        System.out.println("Interest earned after 5 months at an annual rate of 7% with capitalization: " +
                (int) (finalAmount - depositAmount) + " EUR");
        System.out.println("Deposit account balance after five months with interest: " +
                (int) finalAmount + " EUR");
        System.out.println("Balance on the current account after the transfer: " + totalBalances + " EUR");
    }

    private static double calculateDepositInterest() {
        double annualRate = 0.07;
        int compoundingFrequency = 12;
        int months = 5;
        double monthlyRate = annualRate / compoundingFrequency;
        return BankAtmEng.depositAmount * Math.pow(1 + monthlyRate, compoundingFrequency * (months / 12.0));
    }

    private static void checkBalance() {
        System.out.println("Checking Balance:");
        int tempTotalBalances = 0;
        for (int i = 0; i < counts.length; i++) {
            int banknote = banknotes[i];
            int count = counts[i];
            int subtotal = banknote * count;
            System.out.println("Balance of " + count + " EUR banknotes of " +
                    banknote + " each: total " + subtotal + " EUR");
            tempTotalBalances += subtotal;
        }
        int availableBalance = tempTotalBalances - depositAmount;
        if (availableBalance < 0) {
            System.err.println("The requested amount is not available.");
            return;
        }
        System.out.println("Balance of funds on the current account: " + availableBalance + " EUR");
        System.out.println("Deposit account balance: " + depositAmount + " EUR");
        System.out.println("Total balance: " + tempTotalBalances + " EUR");
    }

    private static void balance() {
        for (int i = 0; i < counts.length; i++) {
            int banknote = banknotes[i];
            int count = counts[i];
            totalBalances += banknote * count;
        }
        System.out.println("Balance on the current account: " + totalBalances + " EUR");
    }
}