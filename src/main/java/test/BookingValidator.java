package test;

import java.util.ArrayList;
import java.util.List;

public class BookingValidator {

    List<String> validBookingDetail;
    List<String> inValidBookingDetail;

    public BookingValidator() {

        validBookingDetail = new ArrayList<>();
        inValidBookingDetail = new ArrayList<>();

    }

    public List<String> getValidBookingDetails() {

        return validBookingDetail;

    }

    public List<String> getInValidBookingDetails() {

        return inValidBookingDetail;

    }

    public void addValidBookingDetail(String validBooking) {

        validBookingDetail.add(validBooking);

    }

    public void addInValidBookingDetail(String inValidBooking) {

        inValidBookingDetail.add(inValidBooking);

    }
}
