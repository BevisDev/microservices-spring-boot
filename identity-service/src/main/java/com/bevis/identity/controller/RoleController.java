package com.bevis.identity.controller;

import com.bevis.identity.constant.ApiConst;
import com.bevis.identity.dto.api.ApiRequest;
import com.bevis.identity.dto.api.ApiResponse;
import com.bevis.identity.dto.role.RoleReq;
import com.bevis.identity.dto.role.RoleResp;
import com.bevis.identity.service.role.IRoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConst.ROLE_PATH)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleController {

    IRoleService _roleService;

    @PostMapping(ApiConst.CREATE)
    public ApiResponse<RoleResp> createRole(@RequestBody ApiRequest<RoleReq> request) {
        return ApiResponse.<RoleResp>builder()
                .result(_roleService.createRole(request))
                .build();
    }
}
