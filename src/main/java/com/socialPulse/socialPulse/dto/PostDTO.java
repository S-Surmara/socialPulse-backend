package com.socialPulse.socialPulse.dto;

import org.springframework.web.multipart.MultipartFile;

public class PostDTO {
    private String text;
    private MultipartFile image;

    private String username;

    // Constructors, getters, and setters

    public PostDTO() {
    }

    public PostDTO(String text, MultipartFile image , String username) {
        this.text = text;
        this.image = image;
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getUsername() { return username; }

    public void setUsername(String username){ this.username = username; }
}
