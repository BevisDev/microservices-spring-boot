package com.bevis.identity.entity;

import java.util.List;

import jakarta.persistence.*;

import com.bevis.identity.enums.PermissionEnum;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Permission extends BaseEntity {

    @Column(columnDefinition = "VARCHAR(100)")
    @Enumerated(EnumType.STRING)
    PermissionEnum name;

    @Column(columnDefinition = "VARCHAR(150)")
    String description;

    @OneToMany(mappedBy = "permission")
    List<Authority> authorities;
}
