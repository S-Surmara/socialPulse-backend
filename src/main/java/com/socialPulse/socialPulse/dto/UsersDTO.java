package com.socialPulse.socialPulse.dto;

public class UsersDTO {
    private String name;
    private String username;

    public UsersDTO(String name , String username){
        this.setName(name);
        this.setUsername(username);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
