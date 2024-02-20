package com.knotty.twitter.user.subscription.service.impl;

import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.subscription.model.Subscription;
import com.knotty.twitter.user.subscription.repository.SubscriptionRepository;
import com.knotty.twitter.user.subscription.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    @Override
    public void createSubscribe(Subscription subscription) {
        subscriptionRepository.save(subscription);
    }

    @Override
    public void deleteSubscribe(Subscription subscription) {
        UserProfile follower = subscription.getFollower();
        UserProfile followed = subscription.getFollowed();
        subscriptionRepository.findByFollowerAndFollowed(follower, followed)
                .ifPresent(subscriptionRepository::delete);
    }

    @Override
    public boolean existsSubscription(Subscription subscription) {
        return this.subscriptionRepository.existsByFollowerAndFollowed(subscription.getFollower(), subscription.getFollowed());
    }
}
