package com.knotty.twitter.security.service.impl;

import com.knotty.twitter.common.exception.TwitterException;
import com.knotty.twitter.security.model.UserAccount;
import com.knotty.twitter.security.model.UserRole;
import com.knotty.twitter.security.repository.UserAccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UserAccountServiceImplUnitTest {
    @Mock
    UserAccountRepository userAccountRepository;
    @InjectMocks
    UserAccountServiceImpl userAccountService;


    @Test
    void shouldThrowTwitterException(){

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("user@gmail.com");
        userAccount.setPassword("password");
        UserRole userRole = new UserRole();
        userRole.setAuthority("ROLE_USER");
        userAccount.setUserRoles(Collections.singleton(userRole));

        Mockito.when(this.userAccountRepository.existsByUsername(userAccount.getUsername())).thenReturn(true);

        assertThrows(TwitterException.class, () -> userAccountService.createUserAccount(userAccount));

        Mockito.verify(userAccountRepository, Mockito.times(1)).existsByUsername(any());

    }
    @Test
    void shouldCreateUserAccountSuccessfully(){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("user@gmail.com");
        userAccount.setPassword("password");
        UserRole userRole = new UserRole();
        userRole.setAuthority("ROLE_USER");
        userAccount.setUserRoles(Collections.singleton(userRole));

        Mockito.when(this.userAccountRepository.existsByUsername(userAccount.getUsername())).thenReturn(false);

        Assertions.assertDoesNotThrow(() -> this.userAccountService.createUserAccount(userAccount));

        Mockito.verify(userAccountRepository, Mockito.times(1)).existsByUsername(any());

    }

    @Test
    void shouldSuccessfullyFindByUsername(){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("user@gmail.com");
        userAccount.setPassword("password");
        UserRole userRole = new UserRole();
        userRole.setAuthority("ROLE_USER");
        userAccount.setUserRoles(Collections.singleton(userRole));

        String username = "username";

        Mockito.when(this.userAccountRepository.findByUsername(username)).thenReturn(Optional.of(userAccount));

        Optional<UserAccount> byUsername = this.userAccountService.findUserByUsername(username);

        assertEquals(Optional.of(userAccount) , byUsername);

        Mockito.verify(userAccountRepository, Mockito.times(1)).findByUsername(any());

    }

}