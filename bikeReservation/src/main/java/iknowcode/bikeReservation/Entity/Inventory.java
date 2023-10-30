package iknowcode.bikeReservation.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bikeId;
    private String bike_name;
    private String brand;
    private String engine;
//    @OneToOne
//    @JoinColumn(name = "bookingId")
    @JsonIgnore
    @ManyToOne()
    @JoinTable(
            name = "bookings_bikes",
            joinColumns = @JoinColumn(name = "bikeId"),
            inverseJoinColumns = @JoinColumn(name = "bookingId")
    )
    private Bookings bookings;

    public Inventory() {
    }

    public Inventory(int bikeId, String bike_name, String brand, String engine, Bookings bookings) {
        this.bikeId = bikeId;
        this.bike_name = bike_name;
        this.brand = brand;
        this.engine = engine;
        this.bookings = bookings;
    }

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getBike_name() {
        return bike_name;
    }

    public void setBike_name(String bike_name) {
        this.bike_name = bike_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Bookings getBookings() {
        return bookings;
    }

    public void setBookings(Bookings bookings) {
        this.bookings = bookings;
    }
}
