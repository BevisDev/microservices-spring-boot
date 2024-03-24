package com.rest.entity;

import com.rest.base.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class User extends BaseEntity {

    private String username;
    private String password;
}
