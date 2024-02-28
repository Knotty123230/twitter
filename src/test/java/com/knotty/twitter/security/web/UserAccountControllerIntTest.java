package com.knotty.twitter.security.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.knotty.twitter.common.exception.TwitterException;
import com.knotty.twitter.security.repository.UserAccountRepository;
import com.knotty.twitter.security.web.dto.RegisterRequest;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserAccountControllerIntTest {

    @Autowired
    private MockMvc restMockMvc;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Test
    void shouldCreateUserAccount() throws Exception {
        String username = getUsername();
        RegisterRequest registerRequest = new RegisterRequest(username, "password");

        boolean existBefore = userAccountRepository.existsByUsername(registerRequest.username());
        assertFalse(existBefore);

        restMockMvc.perform(MockMvcRequestBuilders.post("/api/v1/accounts/register")
                        .contentType(MediaType.APPLICATION_JSON).
                        content(new ObjectMapper().writeValueAsBytes(registerRequest)))
                .andExpect(status().isCreated());

        boolean existAfter = userAccountRepository.existsByUsername(registerRequest.username());

        assertTrue(existAfter);
    }

    @Test
    void shouldNotCreateUserAccountWithExistingUsername() throws Exception {
        String username = getUsername();
        RegisterRequest registerRequest = new RegisterRequest(username, "password");

        boolean existBefore = userAccountRepository.existsByUsername(registerRequest.username());
        assertFalse(existBefore);

        restMockMvc.perform(MockMvcRequestBuilders.post("/api/v1/accounts/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsBytes(registerRequest)))
                .andExpect(status().isCreated());

        boolean existAfter = userAccountRepository.existsByUsername(registerRequest.username());
        assertTrue(existAfter);

        MvcResult mvcResult = restMockMvc.perform(MockMvcRequestBuilders.post("/api/v1/accounts/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper()
                                .writeValueAsBytes(registerRequest)))
                .andExpect(status().isBadRequest()).andReturn();

        Exception ex = mvcResult.getResolvedException();
        assertNotNull(ex);
        assertThat(ex).isExactlyInstanceOf(TwitterException.class);
        assertEquals("Account with this username already exists", ex.getMessage());
    }


    @Test
    void shouldNotCreateUserUserAccountWhenInvalidRegisterRequest() throws Exception {
        String username = getNotValidUsername();
        RegisterRequest registerRequest = new RegisterRequest(username, "password");

        boolean existBefore = userAccountRepository.existsByUsername(registerRequest.username());
        assertFalse(existBefore);

        restMockMvc.perform(MockMvcRequestBuilders.post("/api/v1/accounts/register")
                        .contentType(MediaType.APPLICATION_JSON).
                        content(new ObjectMapper().writeValueAsBytes(registerRequest)))
                .andExpect(status().isBadRequest());


        boolean existsAfter = userAccountRepository.existsByUsername(registerRequest.username());
        assertFalse(existsAfter);
    }

    @NotNull
    private static String getUsername() {
        String string = UUID.randomUUID().toString();
        String[] split = string.split("-");
        return split[0] + split[1] + "@email.com";
    }
    private static String getNotValidUsername(){
        String string = UUID.randomUUID().toString();
        String[] split = string.split("-");
        return split[0] + split[1];
    }
}
