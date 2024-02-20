package com.knotty.twitter.user.tweet.usecase.impl;

import com.knotty.twitter.user.profile.api.service.CurrentUserProfileApiService;
import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.tweet.mapper.TweetPageToTweetPageResponseMapper;
import com.knotty.twitter.user.tweet.model.Tweet;
import com.knotty.twitter.user.tweet.service.TweetService;
import com.knotty.twitter.user.tweet.usecase.TweetFindUseCase;
import com.knotty.twitter.user.tweet.web.dto.TweetFindRequest;
import com.knotty.twitter.user.tweet.web.dto.TweetPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import static com.knotty.twitter.user.tweet.model.Tweet_.CREATED_TIMESTAMP;

@Component
@RequiredArgsConstructor
public class TweetFindUseCaseFacade implements TweetFindUseCase {
    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final TweetService tweetService;
    private final TweetPageToTweetPageResponseMapper tweetPageToTweetPageResponseMapper;


    @Override
    public TweetPageResponse findTweets(TweetFindRequest tweetFindRequest) {
        UserProfile currentUserProfile = currentUserProfileApiService.currentUserProfile();
        Sort sort = Sort.by(Sort.Direction.DESC, CREATED_TIMESTAMP);
        Pageable pageable = PageRequest.of(tweetFindRequest.page(), tweetFindRequest.limit(),sort);
        Page<Tweet> allOwnerTweets = this.tweetService.findAllTweets(currentUserProfile,pageable);
        return this.tweetPageToTweetPageResponseMapper.map(allOwnerTweets);

    }

}
