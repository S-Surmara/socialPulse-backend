package com.socialPulse.socialPulse.services;

import com.socialPulse.socialPulse.dto.PostDTO;
import com.socialPulse.socialPulse.modal.Post;
import com.socialPulse.socialPulse.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post createPost(PostDTO postDTO) {
        // Extract text and image from PostDTO
        String text = postDTO.getText();
        MultipartFile multipartImage = postDTO.getImage();
        Long userId = postDTO.getUserId();

        // Convert MultipartFile to byte[]
        byte[] image = null;
        try {
            if(multipartImage != null) image = multipartImage.getBytes();
        } catch (IOException e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            throw new RuntimeException("Error converting MultipartFile to byte[]", e);
        }

        // Create a new Post entity using the extracted values
        Post post;
        if(image != null ) post = new Post(text, image , userId);
        else post = new Post(text , userId);
        return postRepository.save(post);
    }

    @Override
    public List<Post> getUserPosts(Long userId) {
        // Implement logic to retrieve posts for a specific user
        // You can adjust this based on your user structure
        return postRepository.findByUserId(userId);
    }
}
