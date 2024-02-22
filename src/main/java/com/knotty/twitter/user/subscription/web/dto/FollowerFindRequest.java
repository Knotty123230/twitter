package com.knotty.twitter.user.subscription.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record FollowerFindRequest(
        @Min(0) int page,
        @Min(25) @Max(180) int limit
) {
}
