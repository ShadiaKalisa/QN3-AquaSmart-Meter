package qn3.aquasmart.meter;

public class SmartMeter {
    private final String meterId;
    private double creditBalance;
    private boolean valveOpen;

    public SmartMeter(String meterId, double openingBalance) {
        this.meterId = meterId;
        this.creditBalance = openingBalance;
        this.valveOpen = true;
    }

    public double loadToken(double amount) {
        creditBalance += amount;
        if (amount > 0) {
            valveOpen = true;
        }
        return creditBalance;
    }

    public boolean recordConsumption(double litres) {
        if (!valveOpen) {
            return false;
        }
        double cost = litres * 50.0;
        if (creditBalance - cost <= 0) {
            creditBalance = 0.0;
            valveOpen = false;
            return false;
        }
        creditBalance -= cost;
        return true;
    }

    public String getMeterId() {
        return meterId;
    }

    public double getCreditBalance() {
        return creditBalance;
    }

    public boolean isValveOpen() {
        return valveOpen;
    }
}