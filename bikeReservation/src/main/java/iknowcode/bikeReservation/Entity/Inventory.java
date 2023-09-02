package iknowcode.bikeReservation.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bikeId;
    private int totalbikes;
    private String bike_name;
    private String brand;
    private String engine;
    @OneToMany(mappedBy = "bike")
    private List<Bookings> booking;

    public Inventory(int bikeId, int totalbikes, String bike_name, String brand, String engine, Bookings booking) {
        this.bikeId = bikeId;
        this.totalbikes = totalbikes;
        this.bike_name = bike_name;
        this.brand = brand;
        this.engine = engine;
        this.booking = new ArrayList<>();
    }

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public int getTotalbikes() {
        return totalbikes;
    }

    public void setTotalbikes(int totalbikes) {
        this.totalbikes = totalbikes;
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

}
