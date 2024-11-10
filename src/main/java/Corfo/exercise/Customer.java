package Corfo.exercise;

public class Customer {
    private String name;
    private String rut;
    private double currentAccount;
    private double savingsAccount;

    // Constructor
    public Customer(String name, String rut, double currentAccount, double savingsAccount) {
        this.name = name;
        this.rut = rut;
        this.currentAccount = currentAccount;
        this.savingsAccount = savingsAccount;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getRut() {
        return rut;
    }

    public double getCurrentAccount() {
        return currentAccount;
    }

    public double getSavingsAccount() {
        return savingsAccount;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setCurrentAccount(double currentAccount) {
        this.currentAccount = currentAccount;
    }

    public void setSavingsAccount(double savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    // Método para mostrar la información del cliente
    public void showData() {
        System.out.println("Nombre: " + name);
        System.out.println("RUT: " + rut);
        System.out.println("Cuenta Corriente: " + currentAccount);
        System.out.println("Cuenta de Ahorro: " + savingsAccount);
    }
}
