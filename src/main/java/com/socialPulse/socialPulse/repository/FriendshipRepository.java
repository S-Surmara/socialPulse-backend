package com.socialPulse.socialPulse.repository;

import com.socialPulse.socialPulse.modal.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {
    Friendship findByUser_IdAndFriend_Id(Long userId, Long friendId);
}
