package com.knotty.twitter.security.usecase.impl;

import com.knotty.twitter.security.mapper.RegisterRequestToUserAccountMapper;
import com.knotty.twitter.security.model.UserAccount;
import com.knotty.twitter.security.service.UserAccountService;
import com.knotty.twitter.security.usecase.RegisterUserAccountUseCase;
import com.knotty.twitter.security.web.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterUserAccountUseCaseFacade implements RegisterUserAccountUseCase {
    private final UserAccountService userAccountService;
    private final RegisterRequestToUserAccountMapper registerRequestToUserAccountMapper;

    @Override
    public void register(RegisterRequest registerRequest) {
        UserAccount userAccount = registerRequestToUserAccountMapper.map(registerRequest);
        this.userAccountService.createUserAccount(userAccount);
    }
}
