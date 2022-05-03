package test;

import java.util.*;

public class Flight {

    String flightNo;
    String arrivalCity;
    String departureCity;
    Map<String, Integer> availableSeats;
    Map<String, Double> costOfSeat;

    Chain chainVisa;
    Chain chainMasterCard;
    Chain chainDiscover;
    Chain chainAmex;

    public Flight(String flightNo, String arrivalCity, String departureCity) {

        availableSeats = new HashMap<>();
        availableSeats.put("Economy", 0);
        availableSeats.put("Premium Economy", 0);
        availableSeats.put("Business", 0);

        costOfSeat = new HashMap<>();
        costOfSeat.put("Economy", 0.0);
        costOfSeat.put("Premium Economy", 0.0);
        costOfSeat.put("Business", 0.0);

        this.arrivalCity = arrivalCity;
        this.departureCity = departureCity;
        this.flightNo = flightNo;

        chainVisa = new Visa();
        chainMasterCard = new MasterCard();
        chainDiscover = new Discover();
        chainAmex = new Amex();

        chainVisa.setNextChain(chainMasterCard);
        chainMasterCard.setNextChain(chainDiscover);
        chainDiscover.setNextChain(chainAmex);

    }

    public String getFlightNumber() {

        return this.flightNo;

    }

    public void addSeatCount(String category, int noOfSeats) {

        int oldSeatCount = this.availableSeats.get(category);
        this.availableSeats.put(category, oldSeatCount + noOfSeats);

    }

    public void subSeatCount(String category, int noOfSeats) {

        int oldSeatCount = this.availableSeats.get(category);
        this.availableSeats.put(category, oldSeatCount - noOfSeats);

    }

    public int getSeatCount(String category) {

        return this.availableSeats.get(category);

    }

    public void setPrice(String category, double price) {

        this.costOfSeat.put(category, price);

    }

    public double getPrice(String category) {

        return this.costOfSeat.get(category);

    }

    public boolean validSeatCount(String category, int noOfSeats) {

        return availableSeats.get(category) >= noOfSeats;

    }

    public boolean checkValidCreditCard(Card creditCard) {

        return chainVisa.evaluate(creditCard);

    }

    public double getTotalPrice(int noOfSeats, double priceOfEachSeat) {

        return noOfSeats * priceOfEachSeat;

    }
}
