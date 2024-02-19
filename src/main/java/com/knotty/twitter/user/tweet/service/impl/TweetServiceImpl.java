package com.knotty.twitter.user.tweet.service.impl;

import com.knotty.twitter.user.tweet.model.Tweet;
import com.knotty.twitter.user.tweet.repository.TweetRepository;
import com.knotty.twitter.user.tweet.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TweetServiceImpl implements TweetService {
    private final TweetRepository tweetRepository;
    @Override
    public Tweet createTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    @Override
    public Tweet updateTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    @Override
    public Optional<Tweet> findTweetById(Long tweetId) {
        return tweetRepository.findById(tweetId);
    }
}
