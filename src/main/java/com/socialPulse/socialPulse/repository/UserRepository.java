package com.socialPulse.socialPulse.repository;

import com.socialPulse.socialPulse.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    // You can add custom query methods here if needed
}