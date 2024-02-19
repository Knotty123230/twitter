package com.knotty.twitter.user.tweet.usecase;

import com.knotty.twitter.user.tweet.web.dto.TweetResponse;
import com.knotty.twitter.user.tweet.web.dto.TweetEditRequest;

public interface TweetEditUseCase {
    TweetResponse editTweet(TweetEditRequest tweetEditRequest);
}
