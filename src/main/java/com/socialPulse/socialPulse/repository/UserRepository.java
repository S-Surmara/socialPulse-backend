package com.socialPulse.socialPulse.repository;

import com.socialPulse.socialPulse.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    Optional<User> findById(Long id);
    List<User> findAll();

    List<User> findByIdIn(List<Long> friendIds);
}