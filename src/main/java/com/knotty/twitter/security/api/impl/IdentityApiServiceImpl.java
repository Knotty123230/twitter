package com.knotty.twitter.security.api.impl;

import com.knotty.twitter.security.api.model.CurrentUserApiModel;
import com.knotty.twitter.security.api.service.IdentityApiService;
import com.knotty.twitter.security.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IdentityApiServiceImpl implements IdentityApiService {
    private final UserAccountService accountService;

    @Override
    public Optional<CurrentUserApiModel> currentUserAccount() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Principal::getName)
                .flatMap(this.accountService::findUserByUsername)
                .map(it -> new CurrentUserApiModel(it.getId()));


    }
}
