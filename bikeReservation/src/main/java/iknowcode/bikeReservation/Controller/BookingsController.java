package iknowcode.bikeReservation.Controller;

import iknowcode.bikeReservation.Entity.Bookings;
import iknowcode.bikeReservation.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingsController {
    @Autowired
    private BookingService bookingService;
    @PostMapping("/booking")
    public Bookings createBooking(@RequestBody Bookings booking) {
        System.out.println("Creating a new Booking as : " + booking.toString());
        return bookingService.saveBooking(booking);
    }

    @GetMapping("/booking")
    public List<Bookings> getAllBookings() {
        List<Bookings> res = bookingService.getBookings();
        for( Bookings b : res ) {
            System.out.println(b.toString());
        }
        return res;
    }

}
