package com.socialPulse.socialPulse.services;

import com.socialPulse.socialPulse.dto.PostDTO;
import com.socialPulse.socialPulse.modal.Post;
import com.socialPulse.socialPulse.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
        String username = postDTO.getUsername();

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
        if(image != null ) post = new Post(text, image , username);
        else post = new Post(text , username);
        return postRepository.save(post);
    }

    @Override
    public int deletePost(int a) {
        long id = a;
        Post post;
        boolean exists = postRepository.existsById(id);
        if(exists)
             post = postRepository.getReferenceById(id);
        else
            return 1;
        postRepository.delete(post);
        return 0;
    }

    @Override
    public List<Post> getUserPosts(String username) {
        // Implement logic to retrieve posts for a specific user
        // You can adjust this based on your user structure
        return postRepository.findByUsername(username);
    }

    @Override
    public Optional<Post> getUserPostById(int id) {
        long a = id;
        return postRepository.findById(a);
    }


}
