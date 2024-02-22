package com.knotty.twitter.user.tweet.repository;

import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.tweet.model.Tweet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    Page<Tweet> findAllByUserProfile(UserProfile userProfile, Pageable pageable);

    @Query("""
                SELECT t from Tweet t
                join fetch t.userProfile up
                join up.followers f
                where f.follower.id = ?1
            """)
    Page<Tweet> findAllFollowerTweets(Long followerId, Pageable pageable);
}
