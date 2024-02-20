package com.knotty.twitter.security.web;

import com.knotty.twitter.security.usecase.AuthenticationUseCase;
import com.knotty.twitter.security.web.dto.AccessToken;
import com.knotty.twitter.security.web.dto.LoginRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authentication")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationUseCase authenticationUseCase;

    @PostMapping("/access_token")
    public AccessToken getToken(@Valid @RequestBody LoginRequest loginRequest) {
        return authenticationUseCase.authenticate(loginRequest);
    }
}
