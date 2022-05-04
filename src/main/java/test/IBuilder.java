package test;

public interface IBuilder {

    void updateFlight(Flight flight);

    boolean checkFlight(String flightNumber);

    Flight getFlight(String flightNumber);

}
