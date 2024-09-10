package com.bevis.identity.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 596960242602342438L;

    @Id
    @UuidGenerator
    @Column(columnDefinition = "VARCHAR(50)")
    String id;

    @Column(columnDefinition = "VARCHAR(50)")
    String createdBy;

    @Column(columnDefinition = "VARCHAR(50)")
    String updatedBy;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(updatable = false)
    Date transactionDate;

    @CreationTimestamp
    @Column(updatable = false)
    Date createdDateTime;

    @UpdateTimestamp
    @Column(insertable = false)
    Date updatedDateTime;
}
