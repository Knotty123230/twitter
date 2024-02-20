package com.knotty.twitter.user.tweet.mapper;

import com.knotty.twitter.security.mapper.Mapper;
import com.knotty.twitter.user.tweet.model.Tweet;
import com.knotty.twitter.user.tweet.web.dto.TweetPageResponse;
import org.springframework.data.domain.Page;

public interface TweetPageToTweetPageResponseMapper extends Mapper<TweetPageResponse, Page<Tweet>> {


}
