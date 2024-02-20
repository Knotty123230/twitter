package com.knotty.twitter.user.subscription.service;

import com.knotty.twitter.user.subscription.model.Subscription;

public interface SubscriptionService {
    void createSubscribe(Subscription subscription);

    void deleteSubscribe(Subscription subscription);

    boolean existsSubscription(Subscription subscription);
}
