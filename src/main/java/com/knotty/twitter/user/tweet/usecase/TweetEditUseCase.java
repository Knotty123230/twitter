package com.knotty.twitter.user.tweet.usecase;

import com.knotty.twitter.user.tweet.web.dto.TweetEditRequest;
import com.knotty.twitter.user.tweet.web.dto.TweetResponse;

public interface TweetEditUseCase {
    TweetResponse editTweet(TweetEditRequest tweetEditRequest);
}
