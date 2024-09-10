package com.bevis.identity.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role extends BaseEntity {

    @Column(columnDefinition = "VARCHAR(100)")
    String name;

    @Column(columnDefinition = "VARCHAR(150)")
    String description;

    @OneToMany(mappedBy = "role")
    List<Authority> authorities;
}
