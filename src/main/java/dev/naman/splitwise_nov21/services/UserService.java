package dev.naman.splitwise_nov21.services;

import dev.naman.splitwise_nov21.models.User;
import dev.naman.splitwise_nov21.repositories.UserRepository;
import dev.naman.splitwise_nov21.services.passwordencoder.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public User registerUser(String name,
                             String phoneNumber,
                             String password) {
        // create password hash
        String encodedPassword = passwordEncoder.encode(password);
        // create user object
        User user = new User();
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setHashedPassword(encodedPassword);
        // save user object in the repository

        return userRepository.save(user);
    }

    public User updateUserProfile(Long id,
                                  String name,
                                  String phoneNumber,
                                  String password) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setHashedPassword(passwordEncoder.encode(password));

        return userRepository.save(user);
    }
}
