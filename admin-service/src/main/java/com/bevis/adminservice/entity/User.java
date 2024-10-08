package com.bevis.adminservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import com.bevis.masterservice.entity.BaseEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Table(name = "user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity {

    String username;
    String password;
}
