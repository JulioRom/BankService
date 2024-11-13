package Corfo.exercise;
import java.time.LocalDateTime;

// Clase Transaccion para representar cada transacción en la cuenta
public class Transaction {
    private final double amount;
    private final LocalDateTime dateTime;
    private final String associatedAccount;

    public Transaction(double amount, String associatedAccount) {
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
        this.associatedAccount = associatedAccount;
    }

    //Getters
    public double getAmount() {
        return amount;
    }
    public String getAssociatedAccount() {
        return associatedAccount;
    }

    // Método para determinar si es un abono (monto positivo)
    public boolean isPayment() {
        return amount > 0;
    }

    // Método para determinar si es un cargo (monto negativo)
    public boolean isCharge() {
        return amount < 0;
    }

    // Método para mostrar la información de la transacción
    public void ShowData() {
        String transactionType = isPayment() ? "Payment" : "Charge";
        System.out.println("Tipo de Transacción: " + transactionType);
        System.out.println("Monto: " + amount);
        System.out.println("Fecha y Hora: " + dateTime);
        System.out.println("Cuenta Asociada: " + associatedAccount);
    }

    @Override
    public String toString() {
        String transactionType = isPayment() ? "Payment" : "Charge";
        return "Tipo de Transacción: " + transactionType + ", Monto: " + amount + ", Fecha y Hora: " + dateTime + ", Cuenta Asociada: " + associatedAccount;
    }
}
