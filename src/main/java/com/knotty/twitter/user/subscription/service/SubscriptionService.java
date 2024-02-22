package com.knotty.twitter.user.subscription.service;

import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.subscription.model.FollowerSubscription;
import com.knotty.twitter.user.subscription.model.Subscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubscriptionService {
    void createSubscribe(Subscription subscription);

    void deleteSubscribe(Subscription subscription);

    boolean existsSubscription(Subscription subscription);

    Page<FollowerSubscription> findAllFollowersSubscriptions(UserProfile currentUserProfile, Pageable pageable);
}
