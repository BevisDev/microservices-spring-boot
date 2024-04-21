//package com.rest.entity;
//
//import com.rest.enums.Feature;
//import com.rest.enums.PermissionEnum;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "permission")
//public class Permission extends BaseEntity {
//
//    @Column(columnDefinition = "varchar(50)")
//    @Enumerated(EnumType.STRING)
//    private Feature feature;
//
//    @Column(columnDefinition = "varchar(20)")
//    @Enumerated(EnumType.STRING)
//    private PermissionEnum name;
//
//    @ManyToOne
//    private Role role;
//
//}
