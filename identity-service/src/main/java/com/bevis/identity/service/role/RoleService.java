package com.bevis.identity.service.role;

import com.bevis.identity.dto.api.ApiRequest;
import com.bevis.identity.dto.role.RoleReq;
import com.bevis.identity.dto.role.RoleResp;
import com.bevis.identity.mapper.RoleMapper;
import com.bevis.identity.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService implements IRoleService {

    RoleMapper roleMapper;

    RoleRepository roleRepository;

    @Override
    public RoleResp createRole(ApiRequest<RoleReq> request) {
        log.info("createRole with request {} ", request);
        var role = roleMapper.fromRoleReq(request.getDataReq());
        role = roleRepository.save(role);
        return roleMapper.fromEntity(role);
    }
}
