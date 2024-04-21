package com.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Column(columnDefinition = "varchar(50) NOT NULL")
    private String username;

    @Column(columnDefinition = "varchar(100)")
    private String email;

    @Column(columnDefinition = "varchar(50)")
    private String domain;

    @Column(columnDefinition = "varchar(150)")
    private String fullname;

    @OneToMany(mappedBy = "user")
    private List<Approver> approvers;
//
//    @OneToMany(mappedBy = "user")
//    private List<Role> roles;

}
