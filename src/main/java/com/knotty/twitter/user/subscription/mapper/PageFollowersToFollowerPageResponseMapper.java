package com.knotty.twitter.user.subscription.mapper;

import com.knotty.twitter.common.mapper.Mapper;
import com.knotty.twitter.user.subscription.model.FollowerSubscription;
import com.knotty.twitter.user.subscription.web.dto.FollowerPageResponse;
import org.springframework.data.domain.Page;

public interface PageFollowersToFollowerPageResponseMapper extends Mapper<FollowerPageResponse, Page<FollowerSubscription>> {
}
