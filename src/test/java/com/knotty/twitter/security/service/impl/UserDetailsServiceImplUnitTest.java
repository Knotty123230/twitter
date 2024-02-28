package com.knotty.twitter.security.service.impl;

import com.knotty.twitter.security.mapper.UserAccountToUserMapper;
import com.knotty.twitter.security.model.UserAccount;
import com.knotty.twitter.security.model.UserRole;
import com.knotty.twitter.security.service.UserAccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImplUnitTest {
    @Mock
    private UserAccountToUserMapper userMapper;
    @Mock
    private UserAccountService userAccountService;
    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Test
    void shouldReturnNotEmptyUserDetails() {
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("user@gmail.com");
        userAccount.setPassword("password");
        UserRole userRole = new UserRole();
        userRole.setAuthority("ROLE_USER");
        userAccount.setUserRoles(Collections.singleton(userRole));

        User user = new User(userAccount.getUsername(),
                userAccount.getPassword(),
                userAccount.getUserRoles());
        Mockito.when(userAccountService.findUserByUsername(userAccount.getUsername())).thenReturn(Optional.of(userAccount));

        Mockito.when(this.userMapper.map(userAccount)).thenReturn(user);

        UserDetails userDetails = userDetailsService.loadUserByUsername(userAccount.getUsername());

        assertEquals(user, userDetails);

        Mockito.verify(userAccountService, Mockito.times(1)).findUserByUsername(any());

        Mockito.verify(userMapper, Mockito.times(1)).map(any());
    }

    @Test
    void shouldThrowUserNotFoundException() {
        // Setup
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("user@gmail.com");
        userAccount.setPassword("password");
        UserRole userRole = new UserRole();
        userRole.setAuthority("ROLE_USER");
        userAccount.setUserRoles(Collections.singleton(userRole));

        // Mocking behavior
        Mockito.when(userAccountService.findUserByUsername(userAccount.getUsername()))
                .thenReturn(Optional.empty());
        String username = userAccount.getUsername();
        try {
            userDetailsService.loadUserByUsername(username);
            fail("Expected UsernameNotFoundException to be thrown");
        } catch (UsernameNotFoundException ex) {

            Mockito.verify(userAccountService, Mockito.times(1))
                    .findUserByUsername(any());
            Mockito.verify(userMapper, Mockito.never())
                    .map(any());
        }
    }

}