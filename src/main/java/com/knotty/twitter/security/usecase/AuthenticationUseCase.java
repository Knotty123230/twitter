package com.knotty.twitter.security.usecase;

import com.knotty.twitter.security.web.dto.AccessToken;
import com.knotty.twitter.security.web.dto.LoginRequest;

public interface AuthenticationUseCase {
    AccessToken authenticate(LoginRequest loginRequest);
}
