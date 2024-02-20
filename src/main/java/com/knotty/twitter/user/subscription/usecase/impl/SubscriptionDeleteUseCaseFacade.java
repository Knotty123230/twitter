package com.knotty.twitter.user.subscription.usecase.impl;

import com.knotty.twitter.common.exception.TwitterException;
import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.subscription.mapper.UnsubscribeRequestToSubscriptionMapper;
import com.knotty.twitter.user.subscription.model.Subscription;
import com.knotty.twitter.user.subscription.service.SubscriptionService;
import com.knotty.twitter.user.subscription.usecase.SubscriptionDeleteUseCase;
import com.knotty.twitter.user.subscription.web.dto.UnsubscribeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscriptionDeleteUseCaseFacade implements SubscriptionDeleteUseCase {
    private final UnsubscribeRequestToSubscriptionMapper unsubscribeRequestToSubscriptionMapper;
    private final SubscriptionService subscriptionService;

    @Override
    public void unsubscribe(UnsubscribeRequest unsubscribeRequest) {
        Subscription subscription = unsubscribeRequestToSubscriptionMapper.map(unsubscribeRequest);
        UserProfile follower = subscription.getFollower();
        UserProfile followed = subscription.getFollowed();
        if (follower.equals(followed)) {
            throw new TwitterException("користувач не може відписатись сам від себе");
        }
        if (!subscriptionService.existsSubscription(subscription)) {
            throw new TwitterException("ви не були підписані на %s".formatted(followed.getNickname()));
        }
        this.subscriptionService.deleteSubscribe(subscription);

    }
}
