package com.bevis.identity.service.role;

import com.bevis.identity.dto.api.ApiRequest;
import com.bevis.identity.dto.role.RoleReq;
import com.bevis.identity.dto.role.RoleResp;

public interface IRoleService {
    RoleResp createRole(ApiRequest<RoleReq> request);
}
