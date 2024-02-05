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
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(
            @RequestParam(value = "text") String text,
            @RequestPart(value = "image", required = false) MultipartFile image,
            @RequestParam(value ="username") String username
    ) {
        System.out.println("text is : " + text);
        if(image != null) System.out.println("image is : " + image);
        System.out.println("username is : " + username);

        PostDTO postDTO = new PostDTO();
        postDTO.setText(text);
        postDTO.setImage(image);
        postDTO.setUsername(username);

        Post createdPost = postService.createPost(postDTO);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<Post>> getUserPosts(@PathVariable String username) {
        List<Post> userPosts = postService.getUserPosts(username);
        System.out.println("user posts:"+ userPosts);
        return new ResponseEntity<>(userPosts, HttpStatus.OK);
    }

    @DeleteMapping("/delpost/{id}")
    public ResponseEntity<String> deleteUserPost(@PathVariable int id) {
        int rcode = postService.deletePost(id);
        if(rcode == 1)
            return new ResponseEntity<>("Post does not exists", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/postbyid/{id}")
    public ResponseEntity getPostById(@PathVariable int id){
        Optional<Post> post = postService.getUserPostById(id);
        return new ResponseEntity(post, HttpStatus.OK);
    }

}
