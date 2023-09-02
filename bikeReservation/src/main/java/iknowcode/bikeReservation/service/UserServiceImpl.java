package iknowcode.bikeReservation.service;

import iknowcode.bikeReservation.Entity.User;
import iknowcode.bikeReservation.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRep;
    @Override
    public User saveUser(User user) {
        return userRep.save(user);
    }

    @Override
    public List<User> fetchAllUsers() {
        return (List<User>) userRep.findAll();
    }

    @Override
    public User updateUser(User user, Long userId) {
        Optional<User> u;

        u = userRep.findById(userId);
        User foundUser = null;
        if(u.isPresent()){
            foundUser = u.get();

            foundUser.setName(user.getName());
            foundUser.setEmail(user.getEmail());
            foundUser.setPass(user.getPass());
        }

        return userRep.save(foundUser);
    }

    @Override
    public void deleteUserById(Long userId) {
        userRep.deleteById(userId);
    }
}
