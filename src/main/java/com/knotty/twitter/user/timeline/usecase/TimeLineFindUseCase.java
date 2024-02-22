package com.knotty.twitter.user.timeline.usecase;

import com.knotty.twitter.user.timeline.web.dto.TimelineFindRequest;
import com.knotty.twitter.user.timeline.web.dto.TimelinePageResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface TimeLineFindUseCase {
    TimelinePageResponse findTimelines(@Valid TimelineFindRequest timelineFindRequest);
}
