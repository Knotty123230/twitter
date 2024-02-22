package com.knotty.twitter.user.tweet.service;

import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.tweet.model.Tweet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TweetService {
    Tweet createTweet(Tweet tweet);

    Tweet updateTweet(Tweet tweet);

    Optional<Tweet> findTweetById(Long tweetId);

    void deleteTweet(Long tweetId);

    Page<Tweet> findAllTweets(UserProfile userProfile, Pageable pageable);

    Page<Tweet> findAllFollowerTweets(UserProfile follower, Pageable pageable);


}
