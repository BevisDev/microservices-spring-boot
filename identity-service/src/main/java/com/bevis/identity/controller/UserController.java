package com.bevis.identity.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bevis.identity.constant.ApiConst;
import com.bevis.identity.dto.api.ApiResponse;
import com.bevis.identity.dto.user.UserReq;
import com.bevis.identity.dto.user.UserResp;
import com.bevis.identity.service.user.IUserService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping(ApiConst.USER_PATH)
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {

    IUserService _userService;

    @PostMapping(ApiConst.CREATE)
    public ApiResponse<UserResp> createUser(@RequestBody UserReq requestBody) {
        return ApiResponse.<UserResp>builder()
                .result(_userService.createUser(requestBody))
                .build();
    }
}
