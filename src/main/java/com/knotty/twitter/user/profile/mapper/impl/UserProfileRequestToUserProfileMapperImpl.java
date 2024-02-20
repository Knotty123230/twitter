package com.knotty.twitter.user.profile.mapper.impl;

import com.knotty.twitter.common.TwitterException;
import com.knotty.twitter.security.api.model.CurrentUserApiModel;
import com.knotty.twitter.security.api.service.IdentityApiService;
import com.knotty.twitter.user.profile.mapper.UserProfileRequestToUserProfileMapper;
import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.profile.web.dto.UserProfileRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProfileRequestToUserProfileMapperImpl implements UserProfileRequestToUserProfileMapper {
    private final IdentityApiService identityApiService;

    @Override
    public UserProfile map(UserProfileRequest source) {
        CurrentUserApiModel currentUserApiModel = this.identityApiService.currentUserAccount()
                .orElseThrow(
                        () -> new TwitterException("для створення профіля користувач має бути авторизований в системі")
                );

        return new UserProfile(currentUserApiModel.userAccountId(), source.nickname(), source.imageLink());
    }
}
