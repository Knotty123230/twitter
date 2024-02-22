package com.knotty.twitter.user.timeline.mapper;

import com.knotty.twitter.common.mapper.Mapper;
import com.knotty.twitter.user.timeline.web.dto.TimelinePageResponse;
import com.knotty.twitter.user.tweet.model.Tweet;
import org.springframework.data.domain.Page;

public interface TweetPageToTimelinePageResponseMapper extends Mapper<TimelinePageResponse, Page<Tweet>> {
}
