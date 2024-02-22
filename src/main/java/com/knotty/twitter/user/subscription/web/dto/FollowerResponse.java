package com.knotty.twitter.user.subscription.web.dto;

import java.time.Instant;

public record FollowerResponse(
        Long followerId,
        String followerNickname,
        String followerImageLink,
        Instant createdTimestamp,
        Long subscriptionId
) {
}
