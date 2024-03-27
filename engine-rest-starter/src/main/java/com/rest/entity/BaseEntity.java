package com.rest.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @UuidGenerator
    private String id;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(updatable = false)
    private Date createdDate;

    @CreationTimestamp
    @Column(updatable = false)
    private Date createdDateTime;

    @UpdateTimestamp
    @Column(insertable = false)
    private Date updatedDateTime;

}
