package iknowcode.bikeReservation.service;

import iknowcode.bikeReservation.Entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> fetchAllUsers();

    User updateUser(User user, Long userId);

    void deleteUserById(Long userId);
}
