package com.knotty.twitter.user.tweet.usecase;

import com.knotty.twitter.user.tweet.web.dto.TweetFindRequest;
import com.knotty.twitter.user.tweet.web.dto.TweetPageResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface TweetFindUseCase {
    TweetPageResponse findTweets(@Valid TweetFindRequest tweetFindRequest);
}
