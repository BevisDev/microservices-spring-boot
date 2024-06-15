package com.bevis.identity.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

import com.bevis.identity.enums.Status;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity {

    @Column(columnDefinition = "VARCHAR(50)")
    String username;

    @Column(columnDefinition = "VARCHAR(100)")
    String password;

    @Column(columnDefinition = "VARCHAR(100)")
    String email;

    @Column(columnDefinition = "VARCHAR(150)")
    String fullName;

    LocalDate dob;

    @Column(columnDefinition = "VARCHAR(30)")
    @Enumerated(EnumType.STRING)
    Status status;

    @ManyToMany
    List<Role> roles;
}
