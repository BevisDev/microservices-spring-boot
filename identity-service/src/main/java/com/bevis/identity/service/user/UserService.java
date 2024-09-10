package com.bevis.identity.service.user;

import org.springframework.stereotype.Service;

import com.bevis.identity.dto.user.UserReq;
import com.bevis.identity.dto.user.UserResp;
import com.bevis.identity.repository.UserRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserService implements IUserService {

    UserRepository userRepository;

    @Override
    public UserResp createUser(UserReq requestBody) {
        return null;
    }
}
