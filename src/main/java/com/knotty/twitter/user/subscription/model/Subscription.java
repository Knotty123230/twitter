package com.knotty.twitter.user.subscription.model;

import com.knotty.twitter.user.profile.model.UserProfile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@Table(name = "subscriptions", schema = "twitter")
@EntityListeners(value = AuditingEntityListener.class)
@Getter
@Setter
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserProfile follower;

    @ManyToOne
    private UserProfile followed;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdTimestamp;
}
