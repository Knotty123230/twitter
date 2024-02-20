package com.knotty.twitter.user.subscription.repository;

import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.subscription.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    boolean existsByFollowerAndFollowed(UserProfile follower, UserProfile followed);

    Optional<Subscription> findByFollowerAndFollowed(UserProfile follower, UserProfile followed);
}
