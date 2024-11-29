package AssignmentOne;

import java.util.Calendar;

public class DepositTransaction extends BaseTransaction {
    public DepositTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
    }

    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        double previousBalance = ba.getBalance();
        ba.deposit(getAmount());

        System.out.println("Deposit Transaction Applied Successfully:");
        System.out.println("Previous Balance: Ksh" + String.format("%.2f", previousBalance));
        System.out.println("Deposited Amount: Ksh" + String.format("%.2f", getAmount()));
        System.out.println("New Balance: Ksh" + String.format("%.2f", ba.getBalance()));
    }
}