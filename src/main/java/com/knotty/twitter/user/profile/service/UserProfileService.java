package com.knotty.twitter.user.profile.service;

import com.knotty.twitter.user.profile.model.UserProfile;

public interface UserProfileService {
    void createUserProfile(UserProfile userProfile);

    UserProfile findUserProfileById(Long userProfileId);
}
