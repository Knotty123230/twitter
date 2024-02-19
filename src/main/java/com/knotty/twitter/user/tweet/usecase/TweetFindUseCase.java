package com.knotty.twitter.user.tweet.usecase;

import com.knotty.twitter.user.tweet.web.dto.TweetResponse;

import java.util.Collection;

public interface TweetFindUseCase {
    Collection<TweetResponse> findTweets();
}
