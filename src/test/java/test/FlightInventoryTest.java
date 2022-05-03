package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class FlightInventoryTest {
    @Test
    public void testCheckFlight() {
        FlightInventory flightInventoryObj = FlightInventory.getInstance();
        String flightNumber = "XYZ123";

        assertFalse(flightInventoryObj.checkFlight(flightNumber));
    }

    @Test
    public void testValidGetFlight() {

        FlightInventory flightInventoryObj = FlightInventory.getInstance();
        String flightNumber = "XYZ123";

        Flight flightObj = new Flight(flightNumber, "Mumbai", "San Fransico");

        flightInventoryObj.updateFlight(flightObj);

        assertEquals(flightObj, flightInventoryObj.getFlight(flightNumber));

    }

    @Test
    public void testInValidGetFlight() {

        FlightInventory flightInventoryObj = FlightInventory.getInstance();
        String flightNumber = "XYZ13";

        Flight flightObj = new Flight(flightNumber, "Mumbai", "San Fransico");

        flightInventoryObj.updateFlight(flightObj);

        assertNotEquals(flightObj, flightInventoryObj.getFlight("ABC123"));


    }
}
