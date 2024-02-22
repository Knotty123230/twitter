package com.knotty.twitter.security.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.knotty.twitter.security.usecase.RegisterUserAccountUseCase;
import com.knotty.twitter.security.web.dto.RegisterRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class UserAccountControllerUnitTest {
    @InjectMocks
    private UserAccountController controller;
    @Mock
    private RegisterUserAccountUseCase registerUserAccountUseCase;
    MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void shouldReturnStatusCreated() throws Exception {
        RegisterRequest registerRequest = new RegisterRequest("username@gmail.com",
                "passwordEncoded");

        Mockito.doNothing().when(registerUserAccountUseCase).register(registerRequest);


        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/accounts/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsBytes(registerRequest)))
                .andExpect(status().isCreated());

        Mockito.verify(registerUserAccountUseCase, Mockito.times(1)).register(any());
    }

    @Test
    void shouldReturnStatus4xxWhenInvalidRegisterRequest() throws Exception {
        RegisterRequest registerRequest = new RegisterRequest("username",
                "passwordEncoded");


        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/accounts/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsBytes(registerRequest)))
                .andExpect(status().is4xxClientError()).andReturn();

        Exception resolvedException = mvcResult.getResolvedException();

        assertNotNull(resolvedException);

        Assertions.assertInstanceOf(MethodArgumentNotValidException.class, resolvedException);

        Mockito.verify(registerUserAccountUseCase, Mockito.never()).register(any());
    }
}