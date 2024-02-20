package com.knotty.twitter.user.profile.mapper;

import com.knotty.twitter.common.mapper.Mapper;
import com.knotty.twitter.user.profile.model.UserProfile;
import com.knotty.twitter.user.profile.web.dto.UserProfileRequest;

public interface UserProfileRequestToUserProfileMapper extends Mapper<UserProfile, UserProfileRequest> {
}
