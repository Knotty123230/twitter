package com.knotty.twitter.security.usecase;

import com.knotty.twitter.security.web.dto.RegisterRequest;

public interface RegisterUserAccountUseCase {
    void register(RegisterRequest registerRequest);
}
