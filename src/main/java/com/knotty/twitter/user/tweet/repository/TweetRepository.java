package com.knotty.twitter.user.tweet.repository;

import com.knotty.twitter.user.tweet.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet,Long> {
}
