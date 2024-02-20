package com.knotty.twitter.user.tweet.mapper.impl;

import com.knotty.twitter.common.exception.TwitterException;
import com.knotty.twitter.user.tweet.mapper.TweetEditRequestToTweetMapper;
import com.knotty.twitter.user.tweet.model.Tweet;
import com.knotty.twitter.user.tweet.service.TweetService;
import com.knotty.twitter.user.tweet.web.dto.TweetEditRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TweetEditRequestToTweetMapperImpl implements TweetEditRequestToTweetMapper {
    private final TweetService tweetService;

    @Override
    public Tweet map(TweetEditRequest source) {
        Tweet curr = this.tweetService.findTweetById(source.id())
                .orElseThrow(() -> new TwitterException("твіт за id %s не інстує".formatted(source.id())));
        curr.setMessage(source.message());
        return curr;
    }
}
