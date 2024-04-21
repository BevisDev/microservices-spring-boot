package com.rest.controller;

import com.rest.entity.User;
import com.rest.repository.UserRepository;
import com.rest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserRepository dao;

    @GetMapping("/users")
    @PageableDefault(size = 20, sort = "id", direction = Sort.Direction.ASC)
    public ResponseEntity<?> getUsers(Pageable pageable) {
        Page<User> page = dao.findAll(pageable);
        List<User> users = page.getContent();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
