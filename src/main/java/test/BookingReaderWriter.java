package test;

import java.io.*;

public class BookingReaderWriter {

    FlightInventory flightInventoryObj;
    // Map<String, Flight> flightInventoryObj;
    BookingValidator bookings;

    public BookingReaderWriter() {

        flightInventoryObj = new FlightInventory();
        // flightInventoryObj = FlightInventory.getInstance();
        bookings = new BookingValidator();

    }

    public void writeValidBookingDetails(String path) throws IOException {

        File validBookingDetail = new File(path);
        FileWriter fw = new FileWriter(validBookingDetail);
        PrintWriter pw = new PrintWriter(fw);

        pw.println("Booking name, Flight Number, Category, Number of seats, Total Price");
        for (String detail : bookings.getValidBookingDetails())
            pw.println(detail);

        pw.close();
    }

    public void writeInvalidBookingDetail(String path) throws IOException {

        File invalidBookingDetail = new File(path);
        FileWriter fw = new FileWriter(invalidBookingDetail);
        PrintWriter pw = new PrintWriter(fw);

        for (String detail : bookings.getInValidBookingDetails())
            pw.println(detail);

        pw.close();
    }

    public void readBookingCSV(String path) {

        BufferedReader br;

        try {

            br = new BufferedReader(new FileReader(path));
            String line = br.readLine();

            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");
                String name = values[0].trim(), flightNumber = values[1].trim(), category = values[2].trim();
                int noOfSeats = Integer.parseInt(values[3].trim());
                Card creditCard = new Card(values[4].trim());

                if (!flightInventoryObj.checkFlight(flightNumber)) {

                    bookings.addInValidBookingDetail(name + ": Flight does not exists");

                } else {

                    Flight flightObj = flightInventoryObj.getFlight(flightNumber);

                    if (!flightObj.validSeatCount(category, noOfSeats)) {

                        bookings.addInValidBookingDetail(name + ": Not enough seats for this category");

                    } else {

                        if (!flightObj.checkValidCreditCard(creditCard)) {

                            bookings.addInValidBookingDetail(name + ": Invalid Card");

                        } else {

                            double priceOfEachSeat = flightObj.costOfSeat.get(category);
                            double totalPrice = flightObj.getTotalPrice(noOfSeats, priceOfEachSeat);

                            flightObj.subSeatCount(category, noOfSeats);
                            bookings.addValidBookingDetail(name + ", " + flightNumber + ", " + category + ", " +
                                    noOfSeats + ", " + totalPrice);

                        }
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFlightCSV(String path) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();

        while ((line = br.readLine()) != null) {

            String[] values = line.split(",");
            String category = values[0], flightNumber = values[1], arrivalCity = values[4], departureCity = values[5];
            int seats = Integer.parseInt(values[2]);
            double price = Double.parseDouble(values[3]);
            Flight flightObj;

            if (!flightInventoryObj.checkFlight(flightNumber)) {

                flightObj = new Flight(flightNumber, arrivalCity, departureCity);

            } else {

                flightObj = flightInventoryObj.getFlight(flightNumber);

            }

            flightObj.addSeatCount(category, seats);
            flightObj.setPrice(category, price);
            flightInventoryObj.updateFlight(flightObj);

        }

        br.close();

    }
}
