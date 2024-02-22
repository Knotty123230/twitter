package com.knotty.twitter.user.subscription.model;

import com.knotty.twitter.user.profile.model.UserProfile;

import java.time.Instant;

public interface FollowerSubscription {
    Long getId();

    UserProfile getFollower();

    Instant getCreatedTimestamp();
}
