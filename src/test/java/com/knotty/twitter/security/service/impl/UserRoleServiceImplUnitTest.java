package com.knotty.twitter.security.service.impl;

import com.knotty.twitter.security.model.UserRole;
import com.knotty.twitter.security.repository.UserRoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UserRoleServiceImplUnitTest {
    @Mock
    UserRoleRepository userRoleRepository;
    @InjectMocks
    UserRoleServiceImpl userRoleService;

    @Test
    void shouldSuccessfullyFindUserRole(){

        UserRole userRole = new UserRole();
        userRole.setAuthority("ROLE_USER");
        Mockito.when(this.userRoleRepository.findByAuthority(userRole.getAuthority())).thenReturn(Optional.of(userRole));

        Optional<UserRole> userRole1 = userRoleService.findUserRole();

        assertEquals(Optional.of(userRole), userRole1);

        Mockito.verify(userRoleRepository, Mockito.times(1)).findByAuthority(any());
    }

    @Test
    void shouldUnSuccessfullyFindUserRole(){
        UserRole userRole = new UserRole();
        userRole.setAuthority("ROLE_USER");
        Mockito.when(this.userRoleRepository.findByAuthority(userRole.getAuthority())).thenReturn(Optional.empty());

        Optional<UserRole> userRole1 = this.userRoleService.findUserRole();

        assertNotEquals(Optional.of(userRole), userRole1);

    }

}