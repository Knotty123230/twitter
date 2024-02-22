package com.knotty.twitter.security.web;

import com.knotty.twitter.security.usecase.RegisterUserAccountUseCase;
import com.knotty.twitter.security.web.dto.RegisterRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
@Slf4j
@RequiredArgsConstructor
public class UserAccountController {
    private final RegisterUserAccountUseCase registerUserAccountUseCase;


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "create account for user", tags = "create account")
    public void registerAccount(@Valid @RequestBody RegisterRequest registerRequest) {
        log.info("register request: {}", registerRequest);
        registerUserAccountUseCase.register(registerRequest);
    }
}
