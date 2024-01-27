package com.socialPulse.socialPulse.services;

import com.socialPulse.socialPulse.modal.User;
import com.socialPulse.socialPulse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticateUser(String username, String password) {
        // Implement your authentication logic here
        User user = userRepository.findByUsername(username);

        System.out.println("Username: " + username);
        System.out.println("Expected Password: " + password);
        System.out.println("Actual User: " + user);
        System.out.println("Actual Password: " + (user != null ? user.getPassword() : null));

        // Check if the user exists and the password matches
        return user != null && user.getPassword().equals(password);
    }
}
