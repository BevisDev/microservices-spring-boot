package com.bevis.identity.service.user;

import com.bevis.identity.dto.user.UserReq;
import com.bevis.identity.dto.user.UserResp;

public interface IUserService {
    UserResp createUser(UserReq requestBody);
}
