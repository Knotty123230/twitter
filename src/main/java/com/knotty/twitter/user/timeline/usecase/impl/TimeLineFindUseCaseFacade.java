package com.knotty.twitter.user.timeline.usecase.impl;

import com.knotty.twitter.user.profile.api.service.CurrentUserProfileApiService;
import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.timeline.mapper.TweetPageToTimelinePageResponseMapper;
import com.knotty.twitter.user.timeline.usecase.TimeLineFindUseCase;
import com.knotty.twitter.user.timeline.web.dto.TimelineFindRequest;
import com.knotty.twitter.user.timeline.web.dto.TimelinePageResponse;
import com.knotty.twitter.user.tweet.api.service.TweetApiService;
import com.knotty.twitter.user.tweet.model.Tweet;
import com.knotty.twitter.user.tweet.model.Tweet_;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TimeLineFindUseCaseFacade implements TimeLineFindUseCase {
    private final CurrentUserProfileApiService userProfileApiService;
    private final TweetApiService tweetApiService;
    private final TweetPageToTimelinePageResponseMapper mapper;

    @Override
    public TimelinePageResponse findTimelines(TimelineFindRequest timelineFindRequest) {
        Sort sort = Sort.by(Sort.Direction.DESC, Tweet_.CREATED_TIMESTAMP);
        Pageable pageable = PageRequest.of(timelineFindRequest.page(), timelineFindRequest.limit(), sort);
        UserProfile follower = userProfileApiService.currentUserProfile();
        Page<Tweet> tweetPage = tweetApiService.findAllFollowerTweets(follower, pageable);


        return mapper.map(tweetPage);
    }
}
