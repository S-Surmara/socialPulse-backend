package com.socialPulse.socialPulse.services;

import com.socialPulse.socialPulse.dto.PostDTO;
import com.socialPulse.socialPulse.modal.Post;

import java.util.List;

public interface PostService {
    Post createPost(PostDTO postDTO);

    List<Post> getUserPosts(Long userId);
}
