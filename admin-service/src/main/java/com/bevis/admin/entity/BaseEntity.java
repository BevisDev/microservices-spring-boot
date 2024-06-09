package com.bevis.admin.entity;

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
