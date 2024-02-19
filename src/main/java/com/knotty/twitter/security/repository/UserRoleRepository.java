package com.knotty.twitter.security.repository;

import com.knotty.twitter.security.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    Optional<UserRole> findByAuthority(String authority);
}
