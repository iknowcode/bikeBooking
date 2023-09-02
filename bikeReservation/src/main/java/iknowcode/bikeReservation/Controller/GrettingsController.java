package iknowcode.bikeReservation.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrettingsController {

    @GetMapping("/")
    public String greetUser(){
        return "Hey User Welcome to BikeBookings API";
    }
}
