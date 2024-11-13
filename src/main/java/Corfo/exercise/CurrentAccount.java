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
    public void transfer( double amount, BankAccount destinationAccount) {
        double administrationCharge = 0.05 * maintenanceCost;
        double totalAmount = amount + administrationCharge;

        if (totalAmount <= getBalance()) {
            setBalance(getBalance() - totalAmount);
            destinationAccount.deposit(amount, destinationAccount.getAccountNumber());
            addTransaction(new Transaction(-totalAmount, destinationAccount.getAccountNumber()));
            destinationAccount.addTransaction(new Transaction(amount, destinationAccount.getAccountNumber()));
        } else {
            System.out.println("Saldo insuficiente para realizar la transferencia.");
        }
    }
}
