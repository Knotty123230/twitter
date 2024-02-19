package com.knotty.twitter.security.service.impl;

import com.knotty.twitter.security.mapper.UserAccountToUserMapper;
import com.knotty.twitter.security.service.UserAccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserAccountService userAccountService;
    private final UserAccountToUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userAccountService.findUserByUsername(username)
                .map(this.userMapper::map)
                .orElseThrow(() -> new UsernameNotFoundException("bad credentials"));
    }
}
