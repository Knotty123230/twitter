package com.knotty.twitter.user.subscription.mapper.impl;

import com.knotty.twitter.user.subscription.mapper.PageFollowersToFollowerPageResponseMapper;
import com.knotty.twitter.user.subscription.model.FollowerSubscription;
import com.knotty.twitter.user.subscription.web.dto.FollowerPageResponse;
import com.knotty.twitter.user.subscription.web.dto.FollowerResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FollowersToListFollowerResponseMapperImpl implements PageFollowersToFollowerPageResponseMapper {
    @Override
    public FollowerPageResponse map(Page<FollowerSubscription> source) {
        List<FollowerResponse> curr = source.stream()
                .map(item -> new FollowerResponse(item.getFollower().getId(),
                        item.getFollower().getNickname(),
                        item.getFollower().getImageLink(),
                        item.getCreatedTimestamp(),
                        item.getId()))
                .toList();
        return new FollowerPageResponse(source.getTotalElements(),
                source.isFirst(),
                source.isLast(),
                curr);
    }
}
