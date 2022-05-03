package test;

import java.util.HashMap;
import java.util.Map;

public class FlightInventory {

    // public static Map<String, Flight> flights = null;
    Map<String, Flight> flights;
    // public static FlightInventory firstIntance = null;

    public FlightInventory() {

        flights = new HashMap<>();

    }

    // public static FlightInventory getInstance() {

    //     if (firstIntance == null) {

    //         firstIntance = new FlightInventory();
    //         firstIntance.flights = new HashMap<>();

    //     }

    //     return firstIntance;

    // }

    public void updateFlight(Flight flight) {

        String flightNumber = flight.getFlightNumber();

        flights.put(flightNumber, flight);
        // firstIntance.
        // firstIntance.flights.put(flightNumber, flight);

    }

    public boolean checkFlight(String flightNumber) {

        return flights.containsKey(flightNumber);
        // return firstIntance.flights.containsKey(flightNumber);

    }

    public Flight getFlight(String flightNumber) {

        return flights.get(flightNumber);
        // return firstIntance.flights.get(flightNumber);

    }
}
