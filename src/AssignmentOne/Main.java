package AssignmentOne;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        // Scenario 1: Successful Deposit
        System.out.println("--- Scenario 1: Successful Deposit ---");
        BankAccount account = new BankAccount(1000);
        System.out.println("Initial Balance: Ksh" + account.getBalance());

        Calendar depositDate = Calendar.getInstance();
        DepositTransaction deposit = new DepositTransaction(500.0, depositDate, "DEP001");
        try {
            deposit.apply(account);
            deposit.printTransactionDetails();
        } catch (InsufficientFundsException e) {
            System.out.println("Error in deposit: " + e.getMessage());
        }

        // Scenario 2: Withdrawal with Insufficient Funds
        System.out.println("\n--- Scenario 2: Withdrawal with Insufficient Funds ---");
        Calendar withdrawalDate = Calendar.getInstance();
        WithdrawalTransaction largeWithdrawal = new WithdrawalTransaction(2000.0, withdrawalDate, "WDL002");
        try {
            largeWithdrawal.apply(account);
        } catch (InsufficientFundsException e) {
            System.out.println("You have Insufficient funds: " + e.getMessage());
        }

        // Scenario 3: Partial Withdrawal
        System.out.println("\n--- Scenario 3: Partial Withdrawal ---");
        WithdrawalTransaction partialWithdrawal = new WithdrawalTransaction(1500.0, withdrawalDate, "WDL003");
        try {
            partialWithdrawal.apply(account);
        } catch (InsufficientFundsException e) {
            System.out.println("You have Insufficient funds: " + e.getMessage());
        }
    }
}