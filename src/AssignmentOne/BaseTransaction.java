package AssignmentOne;

import java.util.Calendar;

public abstract class BaseTransaction implements TransactionInterface {
    private double amount;
    private Calendar date;
    private String transactionID;

    public BaseTransaction(double amount, Calendar date, String transactionID) {
        this.amount = amount;
        this.date = date;
        this.transactionID = transactionID;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public Calendar getDate() {
        return date;
    }

    @Override
    public String getTransactionID() {
        return transactionID;
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Transaction Details:");
        System.out.println("Type: " + this.getClass().getSimpleName());
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Amount: Ksh" + String.format("%.2f", amount));
        System.out.println("Date: " + date.getTime());
    }

    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        System.out.println("Base transaction apply method called");
    }
}