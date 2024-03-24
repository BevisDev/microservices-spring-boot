package com.rest.repository;

import com.rest.base.BaseRepository;
import com.rest.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User> {
}
