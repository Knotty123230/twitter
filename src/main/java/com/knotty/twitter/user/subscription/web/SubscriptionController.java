package com.knotty.twitter.user.subscription.web;

import com.knotty.twitter.user.subscription.usecase.SubscriptionAddUseCase;
import com.knotty.twitter.user.subscription.usecase.SubscriptionDeleteUseCase;
import com.knotty.twitter.user.subscription.web.dto.SubscribeRequest;
import com.knotty.twitter.user.subscription.web.dto.UnsubscribeRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionAddUseCase subscriptionAddUseCase;
    private final SubscriptionDeleteUseCase subscriptionDeleteUseCase;

    @PostMapping("/subscribe")
    public void subscribe(@Valid @RequestBody SubscribeRequest subscribeRequest) {
        subscriptionAddUseCase.subscribe(subscribeRequest);
    }

    @DeleteMapping("/unsubscribe")
    public void subscribe(@Valid @RequestBody UnsubscribeRequest unsubscribeRequest) {
        subscriptionDeleteUseCase.unsubscribe(unsubscribeRequest);
    }

}
