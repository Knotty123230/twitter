package com.knotty.twitter.user.tweet.model;

import com.knotty.twitter.user.profile.model.UserProfile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@Table(schema = "twitter", name = "tweets")
@Getter
@Setter
@EntityListeners(value = AuditingEntityListener.class)
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Instant createdTimestamp;
    @LastModifiedDate
    @Column(nullable = false, updatable = true)
    private Instant modifiedTimestamp;
    @ManyToOne(optional = false)
    private UserProfile userProfile;
}
