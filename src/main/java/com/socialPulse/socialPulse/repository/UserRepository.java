package com.socialPulse.socialPulse.repository;

import com.socialPulse.socialPulse.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    Optional<User> findById(Long id);
    List<User> findAll();

    List<User> findByIdIn(List<Long> friendIds);

    @Query("SELECT u.id AS id, u.name AS name, u.username AS username, u.email AS email FROM User u WHERE u.id IN :friendIds")
    List<Map<String, Object>> findIdNameUsernameByIdIn(@Param("friendIds") List<Long> friendIds);
}