package com.knotty.twitter.user.tweet.mapper.impl;

import com.knotty.twitter.user.profile.api.service.CurrentUserProfileApiService;
import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.tweet.mapper.TweetAddRequestToTweetMapper;
import com.knotty.twitter.user.tweet.model.Tweet;
import com.knotty.twitter.user.tweet.web.dto.TweetAddRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TweetAddRequestToTweetMapperImpl implements TweetAddRequestToTweetMapper {
    private final CurrentUserProfileApiService currentUserProfileApiService;

    @Override
    public Tweet map(TweetAddRequest source) {
        Tweet tweet = new Tweet();
        tweet.setMessage(source.message());
        UserProfile userProfile = currentUserProfileApiService.currentUserProfile();
        tweet.setUserProfile(userProfile);

        return tweet;
    }
}
