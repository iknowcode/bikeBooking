package iknowcode.bikeReservation.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import iknowcode.bikeReservation.service.InventoryService;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;// id + userId gives us composite Primary key
    private int userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Timestamp start;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Timestamp end;
    @ManyToMany()
    @JoinTable(
            name = "bookings_bikes",
            joinColumns = @JoinColumn(name = "bookingId"),
            inverseJoinColumns = @JoinColumn(name = "bikeId")
    )
    private List<Inventory> bikes;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public List<Inventory> getBikes() {
        return bikes;
    }

    public void setBikes(List<Inventory> bikes) {
        this.bikes = bikes;
    }

    public Bookings() {
    }

    public Bookings(int bookingId, int userId, String start, String end, List<Inventory> bikes) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.start = Timestamp.valueOf(start);
        this.end = Timestamp.valueOf(end);
        this.bikes = bikes;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }
}
