package com.knotty.twitter.user.tweet.api.service;

import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.tweet.model.Tweet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TweetApiService {
    Page<Tweet> findAllFollowerTweets(UserProfile userProfile, Pageable pageable);
}
