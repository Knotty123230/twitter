package com.knotty.twitter.user.tweet.usecase.impl;

import com.knotty.twitter.user.profile.api.service.CurrentUserProfileApiService;
import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.tweet.mapper.TweetToTweetResponceMapper;
import com.knotty.twitter.user.tweet.model.Tweet;
import com.knotty.twitter.user.tweet.service.TweetService;
import com.knotty.twitter.user.tweet.usecase.TweetFindUseCase;
import com.knotty.twitter.user.tweet.web.dto.TweetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
@Component
@RequiredArgsConstructor
public class TweetFindUseCaseFacade implements TweetFindUseCase {
    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final TweetService tweetService;
    private final TweetToTweetResponceMapper tweetToTweetResponceMapper;

    @Override
    public Collection<TweetResponse> findTweets() {
        UserProfile currentUserProfile = currentUserProfileApiService.currentUserProfile();
        Collection<Tweet> allOwnerTweets = this.tweetService.findAllTweets(currentUserProfile);
        return allOwnerTweets.stream()
                .map(tweetToTweetResponceMapper::map)
                .toList();

    }
}
