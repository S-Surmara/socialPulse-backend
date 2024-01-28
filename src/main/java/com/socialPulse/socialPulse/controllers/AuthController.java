package com.socialPulse.socialPulse.controllers;

import com.socialPulse.socialPulse.dto.LoginRequest;
import com.socialPulse.socialPulse.dto.SignupRequest;
import com.socialPulse.socialPulse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest loginRequest) {
        Map<String, String> response = new HashMap<>();
        String username = loginRequest.getUsername();
        System.out.println("Username in controller : " + username);

        Long userId = userService.authenticateUserAndGetId(loginRequest.getUsername(), loginRequest.getPassword());

        // Your authentication logic
        if (userService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword())) {
            response.put("response", "success");
            response.put("userId", String.valueOf(userId));
            return ResponseEntity.ok(response);
        } else {
            response.put("response", "failure");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> createUser(@RequestBody SignupRequest signupRequest) {
        Map<String, String> response = new HashMap<>();

        // Your user creation logic
        if (userService.createUser(signupRequest)) {
            response.put("response", "success");
            return ResponseEntity.ok(response);
        } else {
            response.put("response", "failure");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
