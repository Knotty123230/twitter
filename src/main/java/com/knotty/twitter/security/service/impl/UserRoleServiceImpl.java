package com.knotty.twitter.security.service.impl;

import com.knotty.twitter.security.model.UserRole;
import com.knotty.twitter.security.repository.UserRoleRepository;
import com.knotty.twitter.security.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    @Override
    public Optional<UserRole> findUserRole() {
        return userRoleRepository.findByAuthority("ROLE_USER");
    }
}
