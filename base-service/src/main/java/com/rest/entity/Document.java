package com.rest.entity;

import com.rest.enums.DocumentSource;
import com.rest.enums.DocumentType;
import com.rest.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "document")
public class Document extends BaseEntity {

    @Column(columnDefinition = "nvarchar(150)")
    private String title;

    @Column(columnDefinition = "varchar(30)")
    @Enumerated(EnumType.STRING)
    private DocumentType type;

    @Column(columnDefinition = "varchar(30)")
    @Enumerated(EnumType.STRING)
    private DocumentSource source;

    @Column(columnDefinition = "varchar(20)")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    private FileDocument fileDocument;

    @OneToMany(mappedBy = "document")
    private List<Approver> approvers;

}
