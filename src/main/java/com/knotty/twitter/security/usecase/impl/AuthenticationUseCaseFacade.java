package com.knotty.twitter.security.usecase.impl;

import com.knotty.twitter.security.service.AccessTokenService;
import com.knotty.twitter.security.usecase.AuthenticationUseCase;
import com.knotty.twitter.security.web.dto.AccessToken;
import com.knotty.twitter.security.web.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationUseCaseFacade implements AuthenticationUseCase {

    private final AuthenticationManager authenticationManager;
    private final AccessTokenService accessTokenService;

    @Override
    public AccessToken authenticate(LoginRequest loginRequest) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password());
        Authentication authentication = this.authenticationManager.authenticate(authToken);
        String generatedIdToken = this.accessTokenService.generateIdToken(authentication);
        return new AccessToken(generatedIdToken);
    }
}
