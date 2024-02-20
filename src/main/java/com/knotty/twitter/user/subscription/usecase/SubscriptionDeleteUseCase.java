package com.knotty.twitter.user.subscription.usecase;

import com.knotty.twitter.user.subscription.web.dto.UnsubscribeRequest;

public interface SubscriptionDeleteUseCase {
    void unsubscribe(UnsubscribeRequest unsubscribeRequest);
}
