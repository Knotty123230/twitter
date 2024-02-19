package com.knotty.twitter.user.profile.web;

import com.knotty.twitter.user.profile.usecase.UserProfileCreateUseCase;
import com.knotty.twitter.user.profile.web.dto.UserProfileRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user-profiles")
@RequiredArgsConstructor
public class UserProfileController  {
    private final UserProfileCreateUseCase userProfileCreateUseCase;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUserProfile(@RequestBody @Valid UserProfileRequest userProfileRequest){
        userProfileCreateUseCase.createUserProfile(userProfileRequest);
    }
}