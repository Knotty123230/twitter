package com.knotty.twitter.user.subscription.mapper.impl;

import com.knotty.twitter.user.profile.api.service.CurrentUserProfileApiService;
import com.knotty.twitter.user.profile.api.service.UserProfileApiService;
import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.subscription.mapper.UnsubscribeRequestToSubscriptionMapper;
import com.knotty.twitter.user.subscription.model.Subscription;
import com.knotty.twitter.user.subscription.web.dto.UnsubscribeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UnsubscribeRequestToSubscriptionMapperImpl implements UnsubscribeRequestToSubscriptionMapper {
    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final UserProfileApiService userProfileApiService;

    @Override
    public Subscription map(UnsubscribeRequest source) {
        Subscription subscription = new Subscription();
        UserProfile followed = this.userProfileApiService.findUserProfileById(source.followedId());
        UserProfile follower = currentUserProfileApiService.currentUserProfile();
        subscription.setFollower(follower);
        subscription.setFollowed(followed);
        return subscription;
    }
}
