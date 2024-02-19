package com.knotty.twitter.user.tweet.web.dto;

import java.time.Instant;

public record TweetResponse(Long id, String message, Instant createdTimestamp, Instant modifiedTimestamp) {
}
