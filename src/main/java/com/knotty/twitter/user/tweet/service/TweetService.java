package com.knotty.twitter.user.tweet.service;

import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.tweet.model.Tweet;

import java.util.Collection;
import java.util.Optional;

public interface TweetService {
    Tweet createTweet(Tweet tweet);

    Tweet updateTweet(Tweet tweet);

    Optional<Tweet> findTweetById(Long tweetId);

    void deleteTweet(Long tweetId);

    Collection<Tweet> findAllTweets(UserProfile userProfile);
}
