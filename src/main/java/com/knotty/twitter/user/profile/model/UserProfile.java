package com.knotty.twitter.user.profile.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
