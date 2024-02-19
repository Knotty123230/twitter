package com.knotty.twitter.security.mapper.impl;

import com.knotty.twitter.security.mapper.UserAccountToUserMapper;
import com.knotty.twitter.security.model.UserAccount;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
@Component
public class UserAccountToUserMapperImpl implements UserAccountToUserMapper {
    @Override
    public User map(UserAccount userAccount) {
        return new User(
                userAccount.getUsername(),
                userAccount.getPassword(),
                userAccount.getUserRoles());
    }
}
