package com.knotty.twitter.user.profile.web;

import com.knotty.twitter.user.profile.usecase.UserProfileCreateUseCase;
import com.knotty.twitter.user.profile.web.dto.UserProfileRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user-profiles")
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileCreateUseCase userProfileCreateUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(security = {@SecurityRequirement(name = "bearer-key")}, summary = "create user profile controller", tags = {"user profile"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Void.class))}),
            @ApiResponse(responseCode = "401", description = "User must be authorized", content = @Content)
    })
    public void createUserProfile(@RequestBody @Valid UserProfileRequest userProfileRequest) {
        userProfileCreateUseCase.createUserProfile(userProfileRequest);
    }
}