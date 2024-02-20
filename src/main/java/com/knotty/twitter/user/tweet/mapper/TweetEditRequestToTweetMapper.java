package com.knotty.twitter.user.tweet.mapper;

import com.knotty.twitter.common.mapper.Mapper;
import com.knotty.twitter.user.tweet.model.Tweet;
import com.knotty.twitter.user.tweet.web.dto.TweetEditRequest;

public interface TweetEditRequestToTweetMapper extends Mapper<Tweet, TweetEditRequest> {
}
