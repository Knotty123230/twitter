package com.knotty.twitter.user.timeline.web.dto;

import java.time.Instant;

public record TimelineResponse(
        long id,
        long authorId,
        String message,
        String authorNickname,
        String authorImageLink,
        Instant createdTimestamp
) {
}
