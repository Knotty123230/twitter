package com.knotty.twitter.user.timeline.mapper.impl;

import com.knotty.twitter.user.timeline.mapper.TweetPageToTimelinePageResponseMapper;
import com.knotty.twitter.user.timeline.mapper.TweetToTimelineResponseMapper;
import com.knotty.twitter.user.timeline.web.dto.TimelinePageResponse;
import com.knotty.twitter.user.timeline.web.dto.TimelineResponse;
import com.knotty.twitter.user.tweet.model.Tweet;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class TweetPageToTimelinePageResponseMapperImpl implements TweetPageToTimelinePageResponseMapper {
    private final TweetToTimelineResponseMapper mapper;

    @Override
    public TimelinePageResponse map(Page<Tweet> source) {
        Collection<TimelineResponse> timelineResponses = source.stream()
                .map(mapper::map)
                .toList();
        return new TimelinePageResponse(
                source.getTotalElements(),
                source.isFirst(),
                source.isLast(),
                timelineResponses
        );
    }

}
