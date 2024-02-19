package com.knotty.twitter.user.profile.service.impl;

import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.profile.repository.UserProfileRepository;
import com.knotty.twitter.user.profile.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {
    private final UserProfileRepository userProfileRepository;

    @Override
    public void createUserProfile(UserProfile userProfile) {
        if (userProfileRepository.existsById(userProfile.getId())){
            String errorMessage = "Профіль користувача з таким id %s уже був створений".formatted(userProfile.getId());
            throw new RuntimeException(errorMessage);
        }
        if (userProfileRepository.existsByNickname(userProfile.getNickname())){
            throw new RuntimeException("профіль з таким нікнеймом %s уже існує".formatted(userProfile.getNickname()));
        }
        userProfileRepository.save(userProfile);
    }

    @Override
    public Optional<UserProfile> findUserProfileById(Long userProfileId) {
        return userProfileRepository.findById(userProfileId);
    }
}
