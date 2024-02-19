package com.knotty.twitter.user.tweet.mapper.impl;

import com.knotty.twitter.user.tweet.mapper.TweetToTweetResponceMapper;
import com.knotty.twitter.user.tweet.model.Tweet;
import com.knotty.twitter.user.tweet.web.dto.TweetResponse;
import org.springframework.stereotype.Component;

@Component
public class TweetToTweetResponceMapperImpl implements TweetToTweetResponceMapper {
    @Override
    public TweetResponse map(Tweet source) {
        return new TweetResponse(source.getId(),
                source.getMessage(),
                source.getCreatedTimestamp(),
                source.getModifiedTimestamp());
    }
}
