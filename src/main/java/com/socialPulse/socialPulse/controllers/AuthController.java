package com.socialPulse.socialPulse.controllers;

import com.socialPulse.socialPulse.dto.LoginRequest;
import com.socialPulse.socialPulse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // Extract username and password from the login request
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        // Call the service to authenticate the user
        if (userService.authenticateUser(username, password)) {
            return "Login successful!";
        } else {
            return "Login failed. Invalid username or password.";
        }
    }
}
