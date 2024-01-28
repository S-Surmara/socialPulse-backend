package com.socialPulse.socialPulse.modal;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String text;

    @Lob
    @Column(columnDefinition = "mediumblob")
    private byte[] image;

    @Column(name = "user_id")
    private Long userId;

    public Long getId() {
            return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // Constructor with text and image parameters
    public Post(String text, byte[] image , Long userId) {
        this.text = text;
        this.image = image;
        this.userId = userId;
    }

}
