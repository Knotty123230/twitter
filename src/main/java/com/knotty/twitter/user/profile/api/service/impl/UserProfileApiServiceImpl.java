package com.knotty.twitter.user.profile.api.service.impl;

import com.knotty.twitter.user.profile.api.service.UserProfileApiService;
import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.profile.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileApiServiceImpl implements UserProfileApiService {
    private final UserProfileService userProfileService;
    @Override
    public UserProfile findUserProfileById(Long id) {
        return this.userProfileService.findUserProfileById(id);
    }
}
