package com.bevis.identity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bevis.identity.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {}
