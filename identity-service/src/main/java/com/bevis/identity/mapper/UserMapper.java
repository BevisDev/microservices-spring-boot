package com.bevis.identity.mapper;

import org.mapstruct.Mapper;

import com.bevis.identity.dto.user.UserReq;
import com.bevis.identity.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserReq dto);
}
