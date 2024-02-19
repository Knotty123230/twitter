package com.knotty.twitter.user.tweet.usecase.impl;

import com.knotty.twitter.user.profile.api.service.CurrentUserProfileApiService;
import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.tweet.model.Tweet;
import com.knotty.twitter.user.tweet.service.TweetService;
import com.knotty.twitter.user.tweet.usecase.TweetDeleteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TweetDeleteUseCaseFacade implements TweetDeleteUseCase {
    private final TweetService tweetService;
    private final CurrentUserProfileApiService currentUserProfileApiService;

    @Override
    public void deleteTweet(Long tweetId) {
        UserProfile actor = currentUserProfileApiService.currentUserProfile();
        UserProfile curr = tweetService.findTweetById(tweetId)
                .map(Tweet::getUserProfile)
                .orElseThrow(() -> new RuntimeException("твіт з id %s не існує".formatted(tweetId)));
        if (!curr.equals(actor)) {
            throw new RuntimeException("видалення твіта з id %s заборонено, користувач %s не є його власником".formatted(tweetId,
                    actor.getNickname()));
        }
        tweetService.deleteTweet(tweetId);

    }
}
