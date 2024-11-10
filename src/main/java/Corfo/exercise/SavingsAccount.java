package Corfo.exercise;
import java.util.List;

public class SavingsAccount extends BankAccount {

    private final double profitabilityPercentage;
    private final double withdrawalPenalty;

    public SavingsAccount(double openingBalance, String accountNumber, double profitabilityPercentage, double withdrawalPenalty) {
        super(openingBalance, accountNumber);
        this.profitabilityPercentage = profitabilityPercentage;
        this.withdrawalPenalty = withdrawalPenalty;
    }



    @Override
    public void updateMonthlyBalance() {
        List<Transaction> transactions = getTransactionHistory();
        double addDeposits = 0;
        int depositsCounted = 0;

        // Contamos los últimos 5 depósitos
        for (int i = transactions.size() - 1; i >= 0 && depositsCounted < 5; i--) {
            Transaction transaction = transactions.get(i);
            if (transaction.getType().equals("Depósito")) {
                addDeposits += transaction.getAmout();
                depositsCounted++;
            }
        }

        double increase = addDeposits * (1 + profitabilityPercentage);
        setBalance(getBalance() + increase);
    }

    @Override
    public void transfer(BankAccount destinationAccount, double amount) {
        double penalizedAmount = amount * (1 - withdrawalPenalty);

        if (penalizedAmount <= getBalance()) {
            setBalance(getBalance() - penalizedAmount);
            destinationAccount.deposit(amount);
            addTransaction(new Transaction("Transferencia", -penalizedAmount, "Transferencia a " + destinationAccount.getAccountNumber()));
            destinationAccount.addTransaction(new Transaction("Transferencia", amount, "Transferencia desde " + getAccountNumber()));
        } else {
            System.out.println("Saldo insuficiente para realizar la transferencia.");
        }
    }
}
