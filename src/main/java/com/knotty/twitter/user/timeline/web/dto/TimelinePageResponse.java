package com.knotty.twitter.user.timeline.web.dto;

import java.util.Collection;

public record TimelinePageResponse(
        long totalTweets,
        boolean isFirstPage,
        boolean isLastPage,
        Collection<TimelineResponse> tweets
) {
}
