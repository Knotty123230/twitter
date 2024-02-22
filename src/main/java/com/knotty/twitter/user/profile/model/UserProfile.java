package com.knotty.twitter.user.profile.model;

import com.knotty.twitter.user.subscription.model.Subscription;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(schema = "twitter", name = "user_profiles")
public class UserProfile {
    @Id
    private Long id;
    @Column(nullable = false, unique = true)
    private String nickname;
    @Column(nullable = false)
    private String imageLink;
    @OneToMany
    @JoinColumn(name = "followed_id", referencedColumnName = "id")
    private List<Subscription> followers;

    public UserProfile(String nickname, String imageLink) {
        this.nickname = nickname;
        this.imageLink = imageLink;
    }

    public UserProfile(Long id, String nickname, String imageLink) {
        this.id = id;
        this.nickname = nickname;
        this.imageLink = imageLink;
    }

    public UserProfile() {
    }
}
