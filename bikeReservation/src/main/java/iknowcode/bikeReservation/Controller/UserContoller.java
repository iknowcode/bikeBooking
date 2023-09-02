package iknowcode.bikeReservation.Controller;

import iknowcode.bikeReservation.Entity.User;
import iknowcode.bikeReservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserContoller {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> fetchUsers(){
        return userService.fetchAllUsers();
    }

    @PostMapping("/users")
    public User addUser(
            @RequestBody User user
    ){
        return userService.saveUser(user);
    }

    @DeleteMapping("/users/{id}")
    public String removeUser( @PathVariable("id") Long userId) {
        try{
            userService.deleteUserById(userId);
        } catch (Exception e) {
            return "Exception occuerd : " + e.getMessage();
        }

        return "Deleted Successfully!!";
    }

}
