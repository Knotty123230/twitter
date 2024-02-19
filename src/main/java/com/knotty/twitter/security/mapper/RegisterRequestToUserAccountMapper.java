package com.knotty.twitter.security.mapper;

import com.knotty.twitter.security.model.UserAccount;
import com.knotty.twitter.security.web.dto.RegisterRequest;

public interface RegisterRequestToUserAccountMapper extends Mapper<UserAccount, RegisterRequest> {
}
