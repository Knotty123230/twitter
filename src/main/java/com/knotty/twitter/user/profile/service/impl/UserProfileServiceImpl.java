package com.knotty.twitter.user.profile.service.impl;

import com.knotty.twitter.common.exception.TwitterException;
import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.profile.repository.UserProfileRepository;
import com.knotty.twitter.user.profile.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {
    private final UserProfileRepository userProfileRepository;

    @Override
    public void createUserProfile(UserProfile userProfile) {
        if (userProfileRepository.existsById(userProfile.getId())) {
            String errorMessage = "Профіль користувача з таким id %s уже був створений".formatted(userProfile.getId());
            throw new TwitterException(errorMessage);
        }
        if (userProfileRepository.existsByNickname(userProfile.getNickname())) {
            throw new TwitterException("профіль з таким нікнеймом %s уже існує".formatted(userProfile.getNickname()));
        }
        userProfileRepository.save(userProfile);
    }

    @Override
    public UserProfile findUserProfileById(Long userProfileId) {
        return userProfileRepository.findById(userProfileId).orElseThrow(() -> new TwitterException("профіля користувача з айді %s не існує".formatted(userProfileId)));
    }
}
