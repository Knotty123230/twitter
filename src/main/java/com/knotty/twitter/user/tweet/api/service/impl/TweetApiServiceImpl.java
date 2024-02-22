package com.knotty.twitter.user.tweet.api.service.impl;

import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.tweet.api.service.TweetApiService;
import com.knotty.twitter.user.tweet.model.Tweet;
import com.knotty.twitter.user.tweet.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TweetApiServiceImpl implements TweetApiService {
    private final TweetService tweetService;

    @Override
    public Page<Tweet> findAllFollowerTweets(UserProfile userProfile, Pageable pageable) {
        return tweetService.findAllFollowerTweets(userProfile, pageable);
    }
}
