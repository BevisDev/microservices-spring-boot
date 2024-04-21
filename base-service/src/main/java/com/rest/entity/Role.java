//package com.rest.entity;
//
//import com.rest.enums.RoleEnum;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.List;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "role")
//public class Role extends BaseEntity {
//
//    @Column(columnDefinition = "varchar(50)")
//    @Enumerated(EnumType.STRING)
//    private RoleEnum name;
//
//    @ManyToOne
//    private User user;
//
//    @OneToMany(mappedBy = "role")
//    private List<Permission> permissions;
//
//}
