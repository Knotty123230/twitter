package com.knotty.twitter.user.subscription.usecase;

import com.knotty.twitter.user.subscription.web.dto.SubscribeRequest;

public interface SubscriptionAddUseCase {
    void subscribe(SubscribeRequest subscribeRequest);
}
