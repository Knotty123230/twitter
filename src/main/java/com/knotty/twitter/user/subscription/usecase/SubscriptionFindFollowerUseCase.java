package com.knotty.twitter.user.subscription.usecase;

import com.knotty.twitter.user.subscription.web.dto.FollowerFindRequest;
import com.knotty.twitter.user.subscription.web.dto.FollowerPageResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface SubscriptionFindFollowerUseCase {

    FollowerPageResponse findFollowers(@Valid FollowerFindRequest followerFindRequest);
}
