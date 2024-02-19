package com.knotty.twitter.user.tweet.web;

import com.knotty.twitter.user.tweet.usecase.TweetAddUseCase;
import com.knotty.twitter.user.tweet.usecase.TweetEditUseCase;
import com.knotty.twitter.user.tweet.web.dto.TweetAddRequest;
import com.knotty.twitter.user.tweet.web.dto.TweetEditRequest;
import com.knotty.twitter.user.tweet.web.dto.TweetResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tweets")
@RequiredArgsConstructor
public class TweetController {
    private final TweetAddUseCase tweetAddUseCase;
    private final TweetEditUseCase tweetEditUseCase;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TweetResponse addTweet(@RequestBody @Valid TweetAddRequest tweetAddRequest){
       return tweetAddUseCase.addTweet(tweetAddRequest);
    }
    @PutMapping()
    public TweetResponse editTweet(@RequestBody @Valid TweetEditRequest tweetEditRequest){
      return  tweetEditUseCase.editTweet(tweetEditRequest);
    }
}
