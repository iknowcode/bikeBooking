package iknowcode.bikeReservation.service;

import iknowcode.bikeReservation.Entity.Bookings;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public interface BookingService {
    Bookings saveBooking( Bookings booking);
    List<List<Timestamp>> availableSlots(Date date, long bikeId);//[[startTime, endTime],[startTime, endTime]]
    List<Bookings> getBookings();
    Bookings getBookingById(Long id);
    String deleteBookingById(Long id);
    Bookings updateBooking(Bookings booking);
}
