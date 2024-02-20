package com.knotty.twitter.user.tweet.usecase.impl;

import com.knotty.twitter.common.TwitterException;
import com.knotty.twitter.user.profile.api.service.CurrentUserProfileApiService;
import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.tweet.mapper.TweetEditRequestToTweetMapper;
import com.knotty.twitter.user.tweet.mapper.TweetToTweetResponceMapper;
import com.knotty.twitter.user.tweet.model.Tweet;
import com.knotty.twitter.user.tweet.service.TweetService;
import com.knotty.twitter.user.tweet.usecase.TweetEditUseCase;
import com.knotty.twitter.user.tweet.web.dto.TweetEditRequest;
import com.knotty.twitter.user.tweet.web.dto.TweetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TweetEditUseCaseImpl implements TweetEditUseCase {
    private final TweetService tweetService;
    private final TweetEditRequestToTweetMapper tweetEditRequestToTweetMapper;
    private final TweetToTweetResponceMapper tweetToTweetResponceMapper;
    private final CurrentUserProfileApiService currentUserProfileApiService;

    @Override
    public TweetResponse editTweet(TweetEditRequest tweetEditRequest) {
        UserProfile actor = this.currentUserProfileApiService.currentUserProfile();
        UserProfile owner = tweetService.findTweetById(tweetEditRequest.id()).orElseThrow(() -> new TwitterException("твіт з id %s не існує".formatted(tweetEditRequest.id()))).getUserProfile();
        if (!actor.equals(owner)) {
            throw new TwitterException("редагування твіта з id %s заборонено, користувач %s не є його власником".formatted(tweetEditRequest.id(), actor.getNickname()));
        }
        Tweet map = this.tweetEditRequestToTweetMapper.map(tweetEditRequest);
        Tweet updateTweet = tweetService.updateTweet(map);
        return this.tweetToTweetResponceMapper.map(updateTweet);
    }
}
