package com.bevis.identity.mapper;

import org.mapstruct.Mapper;

import com.bevis.identity.dto.role.RoleReq;
import com.bevis.identity.dto.role.RoleResp;
import com.bevis.identity.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role fromRoleReq(RoleReq roleReq);

    RoleResp fromEntity(Role role);
}
