package com.rest.entity;

import com.rest.enums.Level;
import com.rest.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "approver")
public class Approver extends BaseEntity {

    @Column(columnDefinition = "varchar(20)")
    @Enumerated(EnumType.STRING)
    private Level level;

    @Column(columnDefinition = "varchar(20)")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "`order`")
    private Integer order;
    private String comment;

    @ManyToOne
    private Document document;

    @ManyToOne
    private User user;
}
