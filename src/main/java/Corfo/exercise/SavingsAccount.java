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
        //Filtrar solo los depósitos (transacciones con cantidad positiva)
        List<Transaction> transactions = this.transactionHistory.stream()
                .filter(Transaction::isPayment)
                .toList();
        //Tomar solo los últimos cinco depósitos y sumar sus cantidades
        double addDeposits = transactions.stream()
                .skip(Math.max(0,transactions.size() - 5))
                .mapToDouble(Transaction::getAmount)
                .sum();
        //Calcular el incremento de rentabilidad y actualizar el saldo
        //el italo dijo algo y yo la hice, veamos k pasa
        double increase = addDeposits * (1 + (profitabilityPercentage/100));
        double newBalance = this.getBalance() + increase;
        this.setBalance(newBalance);
    }

    @Override
    public void transfer( double amount, BankAccount destinationAccount) {
        double penalizedAmount = amount * (profitabilityPercentage/100);
        double finalAmount = amount - penalizedAmount;

        if (getBalance() >= amount) {
            setBalance(getBalance() - amount);
            destinationAccount.deposit(finalAmount, destinationAccount.accountNumber);
            addTransaction(new Transaction(-amount, "Transferencia a " + destinationAccount.getAccountNumber()));
            destinationAccount.addTransaction(new Transaction( finalAmount, "Transferencia desde " + getAccountNumber()));
        } else {
            System.out.println("Saldo insuficiente para realizar la transferencia.");
        }
    }
}
