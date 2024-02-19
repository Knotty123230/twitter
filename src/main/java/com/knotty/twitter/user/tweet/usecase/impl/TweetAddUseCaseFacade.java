package com.knotty.twitter.user.tweet.usecase.impl;

import com.knotty.twitter.user.tweet.mapper.TweetAddRequestToTweetMapper;
import com.knotty.twitter.user.tweet.mapper.TweetToTweetResponceMapper;
import com.knotty.twitter.user.tweet.model.Tweet;
import com.knotty.twitter.user.tweet.service.TweetService;
import com.knotty.twitter.user.tweet.usecase.TweetAddUseCase;
import com.knotty.twitter.user.tweet.web.dto.TweetAddRequest;
import com.knotty.twitter.user.tweet.web.dto.TweetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TweetAddUseCaseFacade implements TweetAddUseCase {
    private final TweetToTweetResponceMapper tweetToTweetResponceMapper;
    private final TweetAddRequestToTweetMapper tweetAddRequestToTweetMapper;
    private final TweetService tweetService;

    @Override
    public TweetResponse addTweet(TweetAddRequest tweetAddRequest) {
        Tweet tweet = tweetAddRequestToTweetMapper.map(tweetAddRequest);
        Tweet createdTweet = tweetService.createTweet(tweet);
        return tweetToTweetResponceMapper.map(createdTweet);


    }
}
