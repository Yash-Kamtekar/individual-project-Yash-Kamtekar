package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FlightTest {

    @Test
    public void testCheckInValidFlightNumber() {

        String flightNumber = "XYZ123", arrivalCity = "Mumbai", departureCity = "San Jose";
        Flight flightObj = new Flight(flightNumber, arrivalCity, departureCity);

        assertNotEquals("XY123", flightObj.getFlightNumber());

    }

    @Test
    public void testCheckValidFlightNumber() {

        String flightNumber = "XYZ123", arrivalCity = "Mumbai", departureCity = "San Jose";
        Flight flightObj = new Flight(flightNumber, arrivalCity, departureCity);

        assertEquals("XYZ123", flightObj.getFlightNumber());

    }

    @Test
    public void testGetTotalPrice() {
        String flightNumber = "XYZ123", arrivalCity = "Mumbai", departureCity = "San Jose";
        Flight flightObj = new Flight(flightNumber, arrivalCity, departureCity);

        flightObj.addSeatCount("Economy", 10);
        flightObj.setPrice("Economy", 500.00);

        assertNotEquals(500.00, flightObj.getTotalPrice(2, 500.00));
    }

    @Test
    public void testGetSeatCount() {
        String flightNumber = "XYZ123", arrivalCity = "Mumbai", departureCity = "San Jose";
        Flight flightObj = new Flight(flightNumber, arrivalCity, departureCity);

        flightObj.addSeatCount("Economy", 10);
        flightObj.setPrice("Economy", 500.00);

        assertEquals(10, flightObj.getSeatCount("Economy"));
    }

    @Test
    public void testValidSeatCount() {
        String flightNumber = "XYZ123", arrivalCity = "Mumbai", departureCity = "San Jose";
        Flight flightObj = new Flight(flightNumber, arrivalCity, departureCity);

        flightObj.addSeatCount("Economy", 10);
        flightObj.setPrice("Economy", 500.00);

        assertTrue(flightObj.validSeatCount("Economy", 10));
        assertFalse(flightObj.validSeatCount("Premium Economy", 10));
        assertTrue(flightObj.validSeatCount("Premium Economy", 0));
    }
}
