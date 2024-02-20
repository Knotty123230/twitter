package com.knotty.twitter.user.subscription.mapper;

import com.knotty.twitter.common.Mapper;
import com.knotty.twitter.user.subscription.model.Subscription;
import com.knotty.twitter.user.subscription.web.dto.UnsubscribeRequest;

public interface UnsubscribeRequestToSubscriptionMapper extends Mapper<Subscription, UnsubscribeRequest> {

}
