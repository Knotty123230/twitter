package com.knotty.twitter.user.subscription.web;

import com.knotty.twitter.user.subscription.usecase.SubscriptionAddUseCase;
import com.knotty.twitter.user.subscription.usecase.SubscriptionDeleteUseCase;
import com.knotty.twitter.user.subscription.usecase.SubscriptionFindFollowerUseCase;
import com.knotty.twitter.user.subscription.web.dto.FollowerFindRequest;
import com.knotty.twitter.user.subscription.web.dto.FollowerPageResponse;
import com.knotty.twitter.user.subscription.web.dto.SubscribeRequest;
import com.knotty.twitter.user.subscription.web.dto.UnsubscribeRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionAddUseCase subscriptionAddUseCase;
    private final SubscriptionDeleteUseCase subscriptionDeleteUseCase;
    private final SubscriptionFindFollowerUseCase subscriptionFindFollowerUserCase;

    @PostMapping("/subscribe")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") }, summary = "subscribe for the another profile controller", tags = "Subscribe endpoint")
    public void subscribe(@Valid @RequestBody SubscribeRequest subscribeRequest) {
        subscriptionAddUseCase.subscribe(subscribeRequest);
    }

    @DeleteMapping("/unsubscribe")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") }, summary = "delete subscription", tags = "delete subscription entrypoint")
    public void subscribe(@Valid @RequestBody UnsubscribeRequest unsubscribeRequest) {
        subscriptionDeleteUseCase.unsubscribe(unsubscribeRequest);
    }

    @GetMapping("/followers")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") }, summary = "find all followers of current user", tags = "all followers for current user")
    public FollowerPageResponse allFollowers(@RequestParam("page") int page,
                                             @RequestParam("limit") int limit) {
        FollowerFindRequest followerFindRequest = new FollowerFindRequest(page, limit);
        return subscriptionFindFollowerUserCase.findFollowers(followerFindRequest);
    }

}
