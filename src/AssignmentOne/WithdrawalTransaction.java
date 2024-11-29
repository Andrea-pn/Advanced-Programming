package AssignmentOne;

import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {
    private double unwithdrawableAmount;
    private BankAccount bankAccount;
    private double originalBalance;

    public WithdrawalTransaction(double amount, Calendar date, String transactionID) {
        super(amount, date, transactionID);
        this.unwithdrawableAmount = 0;
    }

    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        originalBalance = ba.getBalance();

        if (originalBalance <= 0) {
            throw new InsufficientFundsException("No funds available for withdrawal");
        }

        try {
            if (getAmount() > originalBalance) {
                // Partial withdrawal scenario
                unwithdrawableAmount = getAmount() - originalBalance;
                ba.withdraw(originalBalance);

                System.out.println("Full Withdrawal Processed:");
                System.out.println("Withdrawn Amount: Ksh" + String.format("%.2f", originalBalance));
                System.out.println("Remaining Amount: Ksh" + String.format("%.2f", unwithdrawableAmount));
            } else {
                ba.withdraw(getAmount());

                System.out.println("Full Withdrawal Processed:");
                System.out.println("Previous Balance: Ksh" + String.format("%.2f", originalBalance));
                System.out.println("Withdrawn Amount: Ksh" + String.format("%.2f", getAmount()));
                System.out.println("New Balance: Ksh" + String.format("%.2f", ba.getBalance()));
            }
        } catch (InsufficientFundsException e) {
            System.out.println("Withdrawal Error: " + e.getMessage());
            throw e;
        }
    }

    public boolean reverse() {
        if (bankAccount != null) {
            try {
                bankAccount.setBalance(originalBalance);
                return true;
            } catch (Exception e) {
                System.out.println("Could not reverse transaction: " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    public double getUnwithdrawableAmount() {
        return unwithdrawableAmount;
    }
}