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

    @Column(name = "username")
    private String username;

    // Default constructor
    public Post() {
    }

    // Constructor with text and userId parameters
    public Post(String text, String username) {
        this.text = text;
        this.username = username;
    }

    // Constructor with text, image, and userId parameters
    public Post(String text, byte[] image, String username) {
        this.text = text;
        this.image = image;
        this.username = username;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
