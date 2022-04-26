package test;

import java.util.*;

public class Flight {
    String arrivalCity;
    String departureCity;
    Map<String, Integer> availableSeats = new HashMap<>();
    Map<String, Double> costOfSeat = new HashMap<>();
    Map<String, int[]> categoryValues;

    public Flight(String arrivalCity, String departureCity, String category, int noOfSeats, double price) {
        this.availableSeats.put(category, noOfSeats);
        this.costOfSeat.put(category, price);
        this.arrivalCity = arrivalCity;
        this.departureCity = departureCity;
        // this.categoryValues.put("Economy", new int[] {0, 0});
        // this.categoryValues.put("Premium Economy", new int[] {0, 0});
        // this.categoryValues.put("Business", new int[] {0, 0});
    }

    // public void setCategoryPrice(String category, int price) {
    // this.categoryValues.put(category)[0] = price;
    // }

    public void addSeatCount(String category, int noOfSeats) {
        int oldSeatCount = this.availableSeats.getOrDefault(category, 0);
        this.availableSeats.put(category, oldSeatCount + noOfSeats);
    }

    public void subSeatCount(String category, int noOfSeats) {
        int oldSeatCount = this.availableSeats.get(category);
        this.availableSeats.put(category, oldSeatCount - noOfSeats);
    }

    public int getSeatCount(String category) {
        return this.availableSeats.getOrDefault(category, 0);
    }

    public void setPrice(String category, double price) {
        this.costOfSeat.put(category, price);
    }
}
