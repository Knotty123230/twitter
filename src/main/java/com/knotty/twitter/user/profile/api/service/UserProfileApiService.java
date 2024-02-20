package com.knotty.twitter.user.profile.api.service;


import com.knotty.twitter.user.profile.model.UserProfile;

public interface UserProfileApiService {
    UserProfile findUserProfileById(Long id);
}
