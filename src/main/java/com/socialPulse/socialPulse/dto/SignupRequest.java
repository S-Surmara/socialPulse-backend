package com.socialPulse.socialPulse.dto;

public class SignupRequest {
    private String username;
    private String password;

    // Constructors, getters, and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SignupRequest() {
    }

    public SignupRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
