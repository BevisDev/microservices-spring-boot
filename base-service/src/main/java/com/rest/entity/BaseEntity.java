package com.rest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @UuidGenerator
    private String id;

    @Column(columnDefinition = "varchar(50) default 'admin'")
    private String createdBy;

    @Column(columnDefinition = "varchar(50) default 'admin'")
    private String updateBy;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(updatable = false)
    private Date transactionDate;

    @CreationTimestamp
    @Column(updatable = false)
    private Date createdDateTime;

    @UpdateTimestamp
    @Column(insertable = false)
    private Date updatedDateTime;

}
