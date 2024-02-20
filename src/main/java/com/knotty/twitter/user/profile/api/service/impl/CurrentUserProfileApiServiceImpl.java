package com.knotty.twitter.user.profile.api.service.impl;

import com.knotty.twitter.common.TwitterException;
import com.knotty.twitter.security.api.model.CurrentUserApiModel;
import com.knotty.twitter.security.api.service.IdentityApiService;
import com.knotty.twitter.user.profile.api.service.CurrentUserProfileApiService;
import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.profile.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrentUserProfileApiServiceImpl implements CurrentUserProfileApiService {
    private final IdentityApiService identityApiService;
    private final UserProfileService userProfileService;

    @Override
    public UserProfile currentUserProfile() {
        CurrentUserApiModel currentUserApiModel = identityApiService.currentUserAccount().orElseThrow(() -> new TwitterException("користувач повинен бути авторизований"));
        return this.userProfileService.findUserProfileById(currentUserApiModel.userAccountId());
    }
}
