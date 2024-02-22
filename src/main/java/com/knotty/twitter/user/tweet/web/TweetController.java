package com.knotty.twitter.user.tweet.web;

import com.knotty.twitter.user.tweet.usecase.TweetAddUseCase;
import com.knotty.twitter.user.tweet.usecase.TweetDeleteUseCase;
import com.knotty.twitter.user.tweet.usecase.TweetEditUseCase;
import com.knotty.twitter.user.tweet.usecase.TweetFindUseCase;
import com.knotty.twitter.user.tweet.web.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tweets")
@RequiredArgsConstructor
public class TweetController {
    private final TweetAddUseCase tweetAddUseCase;
    private final TweetEditUseCase tweetEditUseCase;
    private final TweetDeleteUseCase deleteUseCase;
    private final TweetFindUseCase tweetFindUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(security = { @SecurityRequirement(name = "bearer-key") }, summary = "add tweet in profile for current user", tags = "tweet")
    public TweetResponse addTweet(@RequestBody @Valid TweetAddRequest tweetAddRequest) {
        return tweetAddUseCase.addTweet(tweetAddRequest);
    }

    @PutMapping()
    @Operation(security = { @SecurityRequirement(name = "bearer-key") }, summary = "edit tweet in profile for current user", tags = "edit tweet")
    public TweetResponse editTweet(@RequestBody @Valid TweetEditRequest tweetEditRequest) {
        return tweetEditUseCase.editTweet(tweetEditRequest);
    }

    @DeleteMapping("/{tweetId}")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") }, summary = "delete tweet in profile for current user", tags = "delete tweet")
    public void deleteTweet(@PathVariable Long tweetId) {
        deleteUseCase.deleteTweet(tweetId);
    }

    @GetMapping
    @Operation(security = { @SecurityRequirement(name = "bearer-key") }, summary = "all tweets in profile for current user", tags = "all tweets")
    public TweetPageResponse findOwnerTweets(@PathParam("page") int page, @PathParam("limit") int limit) {
        TweetFindRequest tweetFindRequest = new TweetFindRequest(page, limit);
        return this.tweetFindUseCase.findTweets(tweetFindRequest);
    }
}
