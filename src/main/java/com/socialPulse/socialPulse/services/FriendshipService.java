// FriendshipService.java

package com.socialPulse.socialPulse.services;

import com.socialPulse.socialPulse.dto.FriendshipDTO;
import com.socialPulse.socialPulse.modal.Friendship;
import com.socialPulse.socialPulse.modal.User;
import com.socialPulse.socialPulse.repository.FriendshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialPulse.socialPulse.repository.UserRepository;

@Service
public class FriendshipService {

    @Autowired
    private FriendshipRepository friendshipRepository;

    @Autowired
    private UserRepository userRepository;

    public void sendFriendshipRequest(FriendshipDTO requestDTO) {
        User user = userRepository.findById(requestDTO.getUserId()).orElseThrow();
        User friend = userRepository.findById(requestDTO.getFriendId()).orElseThrow();

        Friendship friendship = new Friendship();
        friendship.setUser(user);
        friendship.setFriend(friend);
        friendship.setStatus("pending");
        friendshipRepository.save(friendship);
    }

    public void acceptFriendRequest(FriendshipDTO requestDTO) {
        // Retrieve the friendship entity by user and friend IDs
        System.out.println("userId = "+ requestDTO.getUserId());
        System.out.println("friendID = "+ requestDTO.getFriendId());
        Friendship friendship = null;
        try {
            friendship = friendshipRepository.findByUser_IdAndFriend_Id(requestDTO.getUserId(), requestDTO.getFriendId());
        }catch (Exception e){
            System.out.println("inside exception" + e);
        }
        System.out.println("friendship = "+ friendship);
        // Update the status to "accepted"
        friendship.setStatus("accepted");

        // Save the updated friendship entity
        friendshipRepository.save(friendship);
    }

    public void rejectFriendRequest(FriendshipDTO requestDTO) {
        // Retrieve the friendship entity by user and friend IDs
        System.out.println("userId = "+ requestDTO.getUserId());
        System.out.println("friendID = "+ requestDTO.getFriendId());
        Friendship friendship = friendshipRepository.findByUser_IdAndFriend_Id(requestDTO.getUserId(), requestDTO.getFriendId());
        System.out.println("friendship = "+ friendship);
        // Update the status to "accepted"
        friendship.setStatus("rejected");

        // Save the updated friendship entity
        friendshipRepository.save(friendship);
    }
}
