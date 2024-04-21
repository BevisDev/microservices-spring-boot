package com.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "fileAttachment")
public class FileAttachment extends BaseEntity {

    @Column(columnDefinition = "nvarchar(150)")
    private String name;

    @Column(columnDefinition = "varchar(1000)")
    private String url;

    @ManyToOne
    private FileDocument fileDocument;
}
