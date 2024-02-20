package com.knotty.twitter.user.tweet.mapper.impl;

import com.knotty.twitter.user.tweet.mapper.TweetPageToTweetPageResponseMapper;
import com.knotty.twitter.user.tweet.mapper.TweetToTweetResponceMapper;
import com.knotty.twitter.user.tweet.model.Tweet;
import com.knotty.twitter.user.tweet.web.dto.TweetPageResponse;
import com.knotty.twitter.user.tweet.web.dto.TweetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TweetPageToTweetPageResponseMapperImpl implements TweetPageToTweetPageResponseMapper {
    private final TweetToTweetResponceMapper tweetToTweetResponceMapper;

    @Override
    public TweetPageResponse map(Page<Tweet> source) {
        List<TweetResponse> tweetResponses = source.stream()
                .map(tweetToTweetResponceMapper::map)
                .toList();
        return new TweetPageResponse(tweetResponses,
                source.getTotalElements(),
                source.isFirst(),
                source.isLast());

    }
}
