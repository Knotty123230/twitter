package com.knotty.twitter.user.profile.service;

import com.knotty.twitter.user.profile.model.UserProfile;

import java.util.Optional;

public interface UserProfileService {
    void createUserProfile(UserProfile userProfile);

    Optional<UserProfile> findUserProfileById(Long userProfileId);
}
