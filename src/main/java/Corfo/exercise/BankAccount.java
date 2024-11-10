package Corfo.exercise;
import java.util.ArrayList;
import java.util.List;

// Clase abstracta CuentaBancaria
public abstract class BankAccount {
    private double balance;
    private final String accountNumber;
    private final List<Transaction> transactionHistory;

    // Constructor
    public BankAccount(double openingBalance, String accountNumber) {
        this.balance = openingBalance;
        this.accountNumber = accountNumber;
        this.transactionHistory = new ArrayList<>();
    }

    // Método para depositar dinero
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction(new Transaction("Depósito", amount, "Depósito a cuenta"));
        } else {
            System.out.println("Monto de depósito inválido.");
        }
    }

    // Método para transferir dinero a otra cuenta
    public void transfer(BankAccount destinationAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            destinationAccount.deposit(amount);
            addTransaction(new Transaction("Transferencia", -amount, "Transferencia a " + destinationAccount.getAccountNumber()));
            destinationAccount.addTransaction(new Transaction("Transferencia", amount, "Transferencia desde " + accountNumber));
        } else {
            System.out.println("Monto de transferencia inválido o saldo insuficiente.");
        }
    }

    // Método para agregar una transacción al historial y limitar a las últimas 20 transacciones
    protected void addTransaction(Transaction transaction) {
        if (transactionHistory.size() >= 20) {
            transactionHistory.removeFirst(); // Elimina la transacción más antigua TODO: revisar si elimina la ultima transaccion
        }
        transactionHistory.add(transaction);
    }

    // Método protegido para que las subclases puedan acceder al historial de transacciones
    protected List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    // Método abstracto para actualizar el saldo mensual
    public abstract void updateMonthlyBalance();

    // Método para mostrar la información de la cuenta
    public void showDataAccount() {
        System.out.println("Número de Cuenta: " + accountNumber);
        System.out.println("Saldo: " + balance);
        System.out.println("Historial de Transacciones:");
        for (Transaction t : transactionHistory) {
            System.out.println(t);
        }
    }

    // Getters para saldo y número de cuenta
    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // Setter para el saldo (para uso de clases hijas si es necesario)
    protected void setBalance(double balance) {
        this.balance = balance;
    }
}