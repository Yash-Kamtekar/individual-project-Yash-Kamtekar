package test;

import java.util.HashMap;
import java.util.Map;

public class FlightInventory implements IBuilder {

    Map<String, Flight> flights;
    private static FlightInventory firstIntance = null;

    private FlightInventory() {
    }

    public static FlightInventory getInstance() {

        if (firstIntance == null) {

            firstIntance = new FlightInventory();
            firstIntance.flights = new HashMap<>();

        }

        return firstIntance;

    }

    public void updateFlight(Flight flight) {

        // String flightNumber = flight.getFlightNumber();

        // flights.put(flightNumber, flight);
        String flightNumber = flight.getFlightNumber();
        firstIntance.flights.put(flightNumber, flight);

    }

    public boolean checkFlight(String flightNumber) {

        // return flights.containsKey(flightNumber);
        return firstIntance.flights.containsKey(flightNumber);

    }

    public Flight getFlight(String flightNumber) {

        // return flights.get(flightNumber);
        return firstIntance.flights.get(flightNumber);

    }
}
