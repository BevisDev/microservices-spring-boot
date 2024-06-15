package com.bevis.identity.entity;

import jakarta.persistence.*;

import com.bevis.identity.enums.FeatureEnum;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Authority extends BaseEntity {

    @Column(columnDefinition = "VARCHAR(100)")
    @Enumerated(EnumType.STRING)
    FeatureEnum featureName;

    @ManyToOne
    Role role;

    @ManyToOne
    Permission permission;
}
