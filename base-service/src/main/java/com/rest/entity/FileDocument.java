package com.rest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "fileDocument")
public class FileDocument extends BaseEntity {

    @Column(columnDefinition = "nvarchar(150)")
    private String fileId;

    @Column(columnDefinition = "nvarchar(150)")
    private String fileName;

    @Column(columnDefinition = "varchar(1000)")
    private String url;

    @OneToOne
    private Document document;

    @OneToMany(mappedBy = "fileDocument")
    private List<FileAttachment> fileAttachments;

}
