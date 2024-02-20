package com.knotty.twitter.user.tweet.mapper;

import com.knotty.twitter.common.Mapper;
import com.knotty.twitter.user.tweet.model.Tweet;
import com.knotty.twitter.user.tweet.web.dto.TweetResponse;

public interface TweetToTweetResponceMapper extends Mapper<TweetResponse, Tweet> {
}
