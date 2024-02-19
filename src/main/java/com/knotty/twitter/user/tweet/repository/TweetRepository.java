package com.knotty.twitter.user.tweet.repository;

import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.tweet.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    Collection<Tweet> findAllByUserProfile(UserProfile userProfile);
}
