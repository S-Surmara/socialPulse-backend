package com.socialPulse.socialPulse.services;

import com.socialPulse.socialPulse.dto.SignupRequest;
import com.socialPulse.socialPulse.dto.UsersDTO;
import com.socialPulse.socialPulse.modal.User;
import com.socialPulse.socialPulse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

        System.out.println("Username in service : " + username);
        System.out.println("Expected Password: " + password);
        System.out.println("Actual User: " + user);
        System.out.println("Actual Password: " + (user != null ? user.getPassword() : null));

        // Check if the user exists and the password matches
        return user != null && user.getPassword().equals(password);
    }

    public boolean createUser(SignupRequest signupRequest) {
        // Check if the username is already taken
        if (userRepository.findByUsername(signupRequest.getUsername()) != null) {
            return false; // Username already exists
        }

        // Create a new user
        User newUser = new User();
        newUser.setName((signupRequest.getName()));
        newUser.setUsername(signupRequest.getUsername());
        newUser.setEmail(signupRequest.getEmail());
        newUser.setPassword(signupRequest.getPassword());

        // Save the new user to the database
        userRepository.save(newUser);

        return true; // User created successfully
    }

    public Long authenticateUserAndGetId(String username, String password) {
        // Implement your authentication logic here
        User user = userRepository.findByUsername(username);

        // Check if the user exists and the password matches
        if (user != null && user.getPassword().equals(password)) {
            return user.getId();
        }

        return null; // Return null if authentication fails
    }

    public List<UsersDTO> getAllUsers() {
        List<User> users = userRepository.findAll();

        // Convert User entities to UsersDTOs
        return users.stream()
                .map(user -> new UsersDTO(user.getId(),user.getName(), user.getUsername()))
                .collect(Collectors.toList());
    }
}
