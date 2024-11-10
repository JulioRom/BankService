package Corfo.exercise;

public class CurrentAccount  extends BankAccount{
    private final double maintenanceCost;

    public CurrentAccount(double openingBalance, String accountNumber, double maintenanceCost) {
        super(openingBalance, accountNumber);
        this.maintenanceCost = maintenanceCost;
    }

    @Override
    public void updateMonthlyBalance() {
        setBalance(getBalance() - maintenanceCost);
    }

    @Override
    public void transfer(BankAccount destinationAccount, double amount) {
        double administrationCharge = 0.05 * maintenanceCost;
        double totalAmount = amount + administrationCharge;

        if (totalAmount <= getBalance()) {
            setBalance(getBalance() - totalAmount);
            destinationAccount.deposit(amount);
            addTransaction(new Transaction("Transferencia", -totalAmount, "Transferencia a " + destinationAccount.getAccountNumber()));
            destinationAccount.addTransaction(new Transaction("Transferencia", amount, "Transferencia desde " + getAccountNumber()));
        } else {
            System.out.println("Saldo insuficiente para realizar la transferencia.");
        }
    }
}
