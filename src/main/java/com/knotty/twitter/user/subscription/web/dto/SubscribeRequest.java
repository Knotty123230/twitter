package com.knotty.twitter.user.subscription.web.dto;

import jakarta.validation.constraints.NotNull;

public record SubscribeRequest(@NotNull Long followedId) {
}
