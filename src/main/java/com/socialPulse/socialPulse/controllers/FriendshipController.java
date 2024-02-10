package com.socialPulse.socialPulse.controllers;
import com.socialPulse.socialPulse.dto.FriendshipDTO;
import com.socialPulse.socialPulse.modal.Friendship;
import com.socialPulse.socialPulse.modal.User;
import com.socialPulse.socialPulse.services.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/friendship")
public class FriendshipController {

    private final FriendshipService friendshipService;

    @Autowired
    public FriendshipController(FriendshipService friendshipService) {
        this.friendshipService = friendshipService;
    }

    @PostMapping("/send-request")
    public  Map<String, String> sendFriendshipRequest(@RequestBody FriendshipDTO friendshipDTO) {
        Map<String, String> response = new HashMap<>();
        System.out.println("inside friendship send req controller");
        try {
            friendshipService.sendFriendshipRequest(friendshipDTO);
            response.put("response", "success");
            return response;
        } catch (Exception e) {
            response.put("response", "failure");
            return response;
        }
    }

    @PostMapping("/accept-request")
    public Map<String, String> acceptFriendRequest(@RequestBody FriendshipDTO friendshipDTO) {
        Map<String, String> response = new HashMap<>();
        System.out.println("inside friendship accept req controller");
        try {
            friendshipService.acceptFriendRequest(friendshipDTO);
            response.put("response", "success");
            return response;
        } catch (Exception e) {
            response.put("response", "failure");
            return response;
        }
    }

    @PostMapping("/reject-request")
    public Map<String, String> rejectFriendRequest(@RequestBody FriendshipDTO friendshipDTO) {
        Map<String, String> response = new HashMap<>();
        System.out.println("inside friendship reject req controller");
        try {
            friendshipService.rejectFriendRequest(friendshipDTO);
            response.put("response", "success");
            return response;
        } catch (Exception e) {
            response.put("response", "failure");
            return response;
        }
    }

    @GetMapping("/{userId}/friends")
    public ResponseEntity<List<User>> getFriendsOfUser(@PathVariable Long userId) {
        List<User> friends = friendshipService.findFriendsOfUser(userId);
        if (friends.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(friends, HttpStatus.OK);
    }

}
