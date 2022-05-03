package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class FlightInventoryTest {
    @Test
    public void testCheckFlight() {
        FlightInventory flightInventoryObj = new FlightInventory();
        String flightNumber = "XYZ123";

        assertFalse(flightInventoryObj.checkFlight(flightNumber));
    }

    @Test
    public void testGetFlight() {

        FlightInventory flightInventoryObj = new FlightInventory();
        String flightNumber = "XYZ123";

        Flight flightObj = new Flight(flightNumber, "Mumbai", "San Fransico");

        flightInventoryObj.updateFlight(flightObj);

        assertEquals(flightObj, flightInventoryObj.getFlight(flightNumber));


    }
}
