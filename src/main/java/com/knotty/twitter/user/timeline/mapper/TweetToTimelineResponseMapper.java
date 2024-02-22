package com.knotty.twitter.user.timeline.mapper;

import com.knotty.twitter.common.mapper.Mapper;
import com.knotty.twitter.user.timeline.web.dto.TimelineResponse;
import com.knotty.twitter.user.tweet.model.Tweet;

public interface TweetToTimelineResponseMapper extends Mapper<TimelineResponse, Tweet> {
}
