package com.socialPulse.socialPulse.repository;

import com.socialPulse.socialPulse.modal.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {
    Friendship findByUser_IdAndFriend_Id(Long userId, Long friendId);

    @Query(value = "SELECT f.friend_id FROM friendship f WHERE f.user_id = :userId", nativeQuery = true)
    List<Long> findFriendIdsByUserId(@Param("userId") Long userId);

    @Query(value = "SELECT f.user_id FROM friendship f WHERE f.friend_id = :userId", nativeQuery = true)
    List<Long> findUsersIdsByFriendId(@Param("userId") Long userId);

}
