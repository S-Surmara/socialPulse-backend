// FriendshipDTO.java

package com.socialPulse.socialPulse.dto;

public class FriendshipDTO {

    private Long userId;
    private Long friendId;
    private String status;

    // Constructors, getters, and setters...

    public FriendshipDTO() {
    }

    public FriendshipDTO(Long userId, Long friendId, String status) {
        this.userId = userId;
        this.friendId = friendId;
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
