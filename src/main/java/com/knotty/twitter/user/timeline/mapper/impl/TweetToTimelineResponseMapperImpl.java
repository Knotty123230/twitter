package com.knotty.twitter.user.timeline.mapper.impl;

import com.knotty.twitter.user.timeline.mapper.TweetToTimelineResponseMapper;
import com.knotty.twitter.user.timeline.web.dto.TimelineResponse;
import com.knotty.twitter.user.tweet.model.Tweet;
import org.springframework.stereotype.Component;

@Component
public class TweetToTimelineResponseMapperImpl implements TweetToTimelineResponseMapper {
    @Override
    public TimelineResponse map(Tweet source) {
        return new TimelineResponse(source.getId(),
                source.getUserProfile().getId(),
                source.getMessage(),
                source.getUserProfile().getNickname(),
                source.getUserProfile().getImageLink(),
                source.getCreatedTimestamp());
    }
}
