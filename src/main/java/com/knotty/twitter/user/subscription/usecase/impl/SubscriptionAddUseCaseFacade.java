package com.knotty.twitter.user.subscription.usecase.impl;

import com.knotty.twitter.common.TwitterException;
import com.knotty.twitter.user.subscription.mapper.SubscribeRequestToSubscriptionMapper;
import com.knotty.twitter.user.subscription.model.Subscription;
import com.knotty.twitter.user.subscription.service.SubscriptionService;
import com.knotty.twitter.user.subscription.usecase.SubscriptionAddUseCase;
import com.knotty.twitter.user.subscription.web.dto.SubscribeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscriptionAddUseCaseFacade implements SubscriptionAddUseCase {
    private final SubscribeRequestToSubscriptionMapper subscribeRequestToSubscriptionMapper;
    private final SubscriptionService subscriptionService;

    @Override
    public void subscribe(SubscribeRequest subscribeRequest) {
        Subscription subscription = this.subscribeRequestToSubscriptionMapper.map(subscribeRequest);
        if (subscription.getFollower().equals(subscription.getFollowed())) {
            throw new TwitterException("користувач не може підписатись сам на себе");
        }
        if (subscriptionService.existsSubscription(subscription)) {
            throw new TwitterException("ви уже підписані на користувача %s".formatted(subscription.getFollowed().getNickname()));
        }
        subscriptionService.createSubscribe(subscription);
    }
}
