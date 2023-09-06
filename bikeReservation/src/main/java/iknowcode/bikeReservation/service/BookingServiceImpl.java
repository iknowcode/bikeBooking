package iknowcode.bikeReservation.service;

import iknowcode.bikeReservation.Entity.Bookings;
import iknowcode.bikeReservation.Repository.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
@Service
public class BookingServiceImpl implements BookingService{
    @Autowired
    private BookingsRepository bkRepo;
    @Override
    public Bookings saveBooking(Bookings booking) {

        return bkRepo.save(booking);
    }

    @Override
    public List<List<Timestamp>> availableSlots(Date date, long bikeId) {
        /* Yet to be implemented
        * */
        System.out.println("Slots methods yet to be implemented");
        return null;
    }

    @Override
    public List<Bookings> getBookings() {
        return (List<Bookings>)bkRepo.findAll();
    }

    @Override
    public Bookings getBookingById(Long id) {
        Optional<Bookings> res =  bkRepo.findById(id);
        if (res.isPresent()) {
            return res.get();
        }
        System.out.println("No such booking found");
        return null;
    }

    @Override
    public String deleteBookingById(Long id) {
        Optional<Bookings> res = bkRepo.findById(id);
        if (res.isPresent()) {
            bkRepo.delete(res.get());
            return "Booking deleted";
        }
        return "No such booking found";
    }

    @Override
    public Bookings updateBooking(Bookings booking) {
        return bkRepo.save(booking);
    }
}
