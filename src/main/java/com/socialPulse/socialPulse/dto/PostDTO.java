package com.socialPulse.socialPulse.dto;

import org.springframework.web.multipart.MultipartFile;

public class PostDTO {
    private String text;
    private MultipartFile image;

    private Long userId;

    // Constructors, getters, and setters

    public PostDTO() {
    }

    public PostDTO(String text, MultipartFile image , Long userId) {
        this.text = text;
        this.image = image;
        this.userId = userId;
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

    public Long getUserId() { return userId; }

    public void setUserId(Long userId){ this.userId = userId; }
}
