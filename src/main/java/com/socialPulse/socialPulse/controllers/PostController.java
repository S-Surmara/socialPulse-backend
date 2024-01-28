package com.socialPulse.socialPulse.controllers;

import com.socialPulse.socialPulse.dto.PostDTO;
import com.socialPulse.socialPulse.modal.Post;
import com.socialPulse.socialPulse.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(
            @RequestPart("text") String text,
            @RequestPart("image") MultipartFile image,
            @RequestPart("userId") Long userId
    ) {
        PostDTO postDTO = new PostDTO();
        postDTO.setText(text);
        postDTO.setImage(image);
        postDTO.setUserId(userId);

        System.out.println("text is : " + text);
        System.out.println("image is : " + image);
        System.out.println("userId is : " + userId);

        Post createdPost = postService.createPost(postDTO);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getUserPosts(@PathVariable Long userId) {
        List<Post> userPosts = postService.getUserPosts(userId);
        return new ResponseEntity<>(userPosts, HttpStatus.OK);
    }

}
