package com.rest.service.impl;

import com.rest.dto.UserDTO;
import com.rest.entity.User;
import com.rest.repository.UserRepository;
import com.rest.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO getUsers() {
        List<User> user = userRepository.findAll();
        return new UserDTO();
    }
}
