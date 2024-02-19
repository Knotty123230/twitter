package com.knotty.twitter.user.tweet.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TweetEditRequest(
        @NotNull Long id,
        @NotNull @Size(min = 10, max = 180) String message
) {
}
