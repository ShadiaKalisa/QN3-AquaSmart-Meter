import org.junit.Test;
import static org.junit.Assert.*;
import qn3.aquasmart.meter.SmartMeter;

public class SmartMeterTest {

    @Test
    public void testLoadTokenReopensValve() {
        SmartMeter meter = new SmartMeter("M100", 10.0);
        meter.recordConsumption(1.0);
        assertFalse(meter.isValveOpen());
        meter.loadToken(500.0);
        assertTrue(meter.isValveOpen());
    }

    @Test
    public void testConsumptionBeyondCreditClosesValve() {
        SmartMeter meter = new SmartMeter("M200", 100.0);
        boolean status = meter.recordConsumption(3.0);
        assertFalse(status);
        assertEquals(0.0, meter.getCreditBalance(), 0.001);
        assertFalse(meter.isValveOpen());
    }
}