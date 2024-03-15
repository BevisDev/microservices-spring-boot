package com.rest.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum StatusEnum {
    SUCCESS("Success", "Succeeded"),
    FAIL("Fail", "Failed"),
    CREATE("Create", "Created"),
    UPDATE("Update", "Updated"),
    EDIT("Edit", "Edited"),
    DELETE("Delete", "Deleted"),
    PENDING("Pending", "Pended"),
    PROCESSING("Processing", "Processed"),
    ACTIVE("Active", "Activated"),
    INACTIVE("Inactive", "Inactivated"),
    ;

    private String capitalValue;
    private String pastValue;
}
