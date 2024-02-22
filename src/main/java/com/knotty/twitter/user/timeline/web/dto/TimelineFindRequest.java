package com.knotty.twitter.user.timeline.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record TimelineFindRequest(
        @Min(0) int page,
        @Min(25) @Max(180) int limit
) {
}
