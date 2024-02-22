package com.knotty.twitter.user.timeline.web;

import com.knotty.twitter.user.timeline.usecase.TimeLineFindUseCase;
import com.knotty.twitter.user.timeline.web.dto.TimelineFindRequest;
import com.knotty.twitter.user.timeline.web.dto.TimelinePageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/timelines")
@RequiredArgsConstructor
public class TimelineController {
    private final TimeLineFindUseCase timeLineFindUseCase;

    @GetMapping
    @Operation(security = { @SecurityRequirement(name = "bearer-key") },summary = "find all posts followers of current user", tags = "news")
    public TimelinePageResponse findTimelines(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        TimelineFindRequest timelineFindRequest = new TimelineFindRequest(page, limit);
        return timeLineFindUseCase.findTimelines(timelineFindRequest);
    }
}
