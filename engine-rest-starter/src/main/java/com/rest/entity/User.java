package com.rest.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class User extends BaseEntity {

    private String username;
    private String password;
}
