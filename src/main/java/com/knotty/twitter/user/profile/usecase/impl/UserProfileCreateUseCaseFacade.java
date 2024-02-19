package com.knotty.twitter.user.profile.usecase.impl;

import com.knotty.twitter.user.profile.mapper.UserProfileRequestToUserProfileMapper;
import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.profile.service.UserProfileService;
import com.knotty.twitter.user.profile.usecase.UserProfileCreateUseCase;
import com.knotty.twitter.user.profile.web.dto.UserProfileRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProfileCreateUseCaseFacade implements UserProfileCreateUseCase {
    private final UserProfileService userProfileService;
    private final UserProfileRequestToUserProfileMapper mapper;

    @Override
    public void createUserProfile(UserProfileRequest userProfileRequest) {
        UserProfile map = mapper.map(userProfileRequest);
        userProfileService.createUserProfile(map);
    }
}
