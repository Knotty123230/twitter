package com.knotty.twitter.user.subscription.web.dto;

import java.util.Collection;

public record FollowerPageResponse(
        Long totalCountFollowers,
        boolean isFirstPage,
        boolean isLastPage,
        Collection<FollowerResponse> followers
) {
}
