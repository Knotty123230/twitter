package com.knotty.twitter.user.tweet.repository;

import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.tweet.model.Tweet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    Page<Tweet> findAllByUserProfile(UserProfile userProfile, Pageable pageable);
}
