package test;

import java.io.IOException;

public class RunClient {

    public static void main(String[] args) {
        BookingReaderWriter bookingReadWriter = new BookingReaderWriter();

        try {

            bookingReadWriter.readFlightCSV(args[1]);
            bookingReadWriter.readBookingCSV(args[0]);
            bookingReadWriter.writeValidBookingDetails(args[2]);
            bookingReadWriter.writeInvalidBookingDetail(args[3]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
