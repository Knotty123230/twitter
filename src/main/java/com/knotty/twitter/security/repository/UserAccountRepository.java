package com.knotty.twitter.security.repository;

import com.knotty.twitter.security.model.UserAccount;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount,Long> {
    boolean existsByUsername(String username);

    Optional<UserAccount> findByUsername(String username);
}
