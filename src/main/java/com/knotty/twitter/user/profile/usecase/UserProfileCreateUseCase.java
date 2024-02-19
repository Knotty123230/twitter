package com.knotty.twitter.user.profile.usecase;

import com.knotty.twitter.user.profile.web.dto.UserProfileRequest;

public interface UserProfileCreateUseCase {
    void createUserProfile(UserProfileRequest userProfileRequest);
}
