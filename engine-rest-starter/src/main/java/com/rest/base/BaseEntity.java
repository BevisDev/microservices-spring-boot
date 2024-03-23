package com.rest.base;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;

@Entity
@Getter
@Setter
public class BaseEntity {

    @Id
    @UuidGenerator
    private String id;

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;

    @CreationTimestamp
    private Date createdDateTime;

    @UpdateTimestamp
    private Date updatedDateTime;

}
