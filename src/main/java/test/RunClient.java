package test;

import java.io.IOException;

public class RunClient {

    public static void main(String[] args) {
        // mvn exec:java -Dexec.mainClass=test.RunClient -Dexec.args="/Users/shkamtek/Desktop/Yash/Sample.csv /Users/shkamtek/Desktop/Yash/flights.csv /Users/shkamtek/Desktop/Yash/test/booking_detail.csv /Users/shkamtek/Desktop/Yash/test/invalid_booking.txt"
        BookingReaderWriter bookingReadWriter = new BookingReaderWriter();

        try {

            bookingReadWriter.readFlightCSV("/Users/shkamtek/Desktop/Yash/flights.csv");
            bookingReadWriter.readBookingCSV("/Users/shkamtek/Desktop/Yash/Sample.csv");
            bookingReadWriter.writeValidBookingDetails("/Users/shkamtek/Desktop/Yash/test/booking_detail.csv");
            bookingReadWriter.writeInvalidBookingDetail("/Users/shkamtek/Desktop/Yash/test/invalid_booking.txt");
            
            // bookingReadWriter.readFlightCSV(args[1]);
            // bookingReadWriter.readBookingCSV(args[0]);
            // bookingReadWriter.writeValidBookingDetails(args[2]);
            // bookingReadWriter.writeInvalidBookingDetail(args[3]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
