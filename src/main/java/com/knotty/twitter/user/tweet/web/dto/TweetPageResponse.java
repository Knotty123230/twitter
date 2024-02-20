package com.knotty.twitter.user.tweet.web.dto;

import java.util.Collection;

public record TweetPageResponse(Collection<TweetResponse> tweets, long totalTweets, boolean isFirstPage,
                                boolean isLastPage) {
}
