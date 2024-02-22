package com.knotty.twitter.user.subscription.usecase.impl;

import com.knotty.twitter.user.profile.api.service.CurrentUserProfileApiService;
import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.subscription.mapper.PageFollowersToFollowerPageResponseMapper;
import com.knotty.twitter.user.subscription.model.FollowerSubscription;
import com.knotty.twitter.user.subscription.model.Subscription_;
import com.knotty.twitter.user.subscription.service.SubscriptionService;
import com.knotty.twitter.user.subscription.usecase.SubscriptionFindFollowerUseCase;
import com.knotty.twitter.user.subscription.web.dto.FollowerFindRequest;
import com.knotty.twitter.user.subscription.web.dto.FollowerPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscriptionFindFollowerUserCaseFacade implements SubscriptionFindFollowerUseCase {
    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final SubscriptionService subscriptionService;
    private final PageFollowersToFollowerPageResponseMapper followersToListFollowerResponseMapper;

    @Override
    public FollowerPageResponse findFollowers(FollowerFindRequest followerFindRequest) {
        UserProfile currentUserProfile = currentUserProfileApiService.currentUserProfile();
        Pageable pageable = PageRequest.of(followerFindRequest.page(),
                followerFindRequest.limit(),
                Sort.by(Sort.Direction.DESC,
                        Subscription_.CREATED_TIMESTAMP));

        Page<FollowerSubscription> allCurrentUserSubscriptions = subscriptionService.findAllFollowersSubscriptions(currentUserProfile, pageable);

        return this.followersToListFollowerResponseMapper.map(allCurrentUserSubscriptions);
    }


}
