package com.knotty.twitter.user.tweet.usecase;

import com.knotty.twitter.user.tweet.web.dto.TweetAddRequest;
import com.knotty.twitter.user.tweet.web.dto.TweetResponse;

public interface TweetAddUseCase {
    TweetResponse addTweet(TweetAddRequest tweetAddRequest);
}
