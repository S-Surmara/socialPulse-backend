package com.socialPulse.socialPulse.dto;

public class UsersDTO {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name;
    private String username;

    public UsersDTO(Long id , String name , String username){
        this.setId(id);
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
