package com.knotty.twitter.security.web;

import com.knotty.twitter.security.mapper.RegisterRequestToUserAccountMapper;
import com.knotty.twitter.security.model.UserAccount;
import com.knotty.twitter.security.model.UserRole;
import com.knotty.twitter.security.service.UserAccountService;
import com.knotty.twitter.security.service.UserRoleService;
import com.knotty.twitter.security.usecase.RegisterUserAccountUseCase;
import com.knotty.twitter.security.web.dto.RegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/accounts")
@Slf4j
@RequiredArgsConstructor
public class UserAccountController {
    private final RegisterUserAccountUseCase registerUserAccountUseCase;


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody RegisterRequest registerRequest) {
        log.info("register request: {}", registerRequest);
        registerUserAccountUseCase.register(registerRequest);
    }
}
