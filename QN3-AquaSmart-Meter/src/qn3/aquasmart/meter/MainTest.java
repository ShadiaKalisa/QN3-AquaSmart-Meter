package qn3.aquasmart.meter;

public class MainTest {
    public static void main(String[] args) {
        SmartMeter meter = new SmartMeter("KIS-PROP-09", 80.0);
        System.out.println("Meter ID: " + meter.getMeterId());
        System.out.println("Starting Balance: UGX " + meter.getCreditBalance());
        System.out.println("Is Valve Open: " + meter.isValveOpen());

        System.out.println("\n Attempting Normal Consumption (1 Litre = 5000 UGX) ");
        boolean firstRun = meter.recordConsumption(1.0);
        System.out.println("Dispensed Status: " + firstRun);
        System.out.println("Remaining Balance: UGX " + meter.getCreditBalance());

        System.out.println("\n Attempting Excess Consumption (Blocks and locks valve) ");
        boolean secondRun = meter.recordConsumption(2.0);
        System.out.println("Dispensed Status: " + secondRun);
        System.out.println("Remaining Balance: UGX " + meter.getCreditBalance());
        System.out.println("Is Valve Open: " + meter.isValveOpen());

        System.out.println("\n Loading Fresh Money Token ");
        meter.loadToken(1000.0);
        System.out.println("New Balance: UGX " + meter.getCreditBalance());
        System.out.println("Is Valve Open Now: " + meter.isValveOpen());
    }
}