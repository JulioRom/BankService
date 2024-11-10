package Corfo.exercise;

// Clase Transaccion para representar cada transacción en la cuenta
public class Transaction {
    private final String type;  // "Depósito" o "Transferencia"
    private final double amount;
    private final String description;

    public Transaction(String type, double amount, String description) {
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    // Getters
    public String getType() {
        return type;
    }

    public double getAmout() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Tipo: " + type + ", Monto: " + amount + ", Descripción: " + description;
    }
}
