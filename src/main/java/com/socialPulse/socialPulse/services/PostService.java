package com.socialPulse.socialPulse.services;

import com.socialPulse.socialPulse.dto.PostDTO;
import com.socialPulse.socialPulse.modal.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post createPost(PostDTO postDTO);

    public int deletePost(int id);

    List<Post> getUserPosts(String username);

    Optional<Post> getUserPostById(int id);
}
