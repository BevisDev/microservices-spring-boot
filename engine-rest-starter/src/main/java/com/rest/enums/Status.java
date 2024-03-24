package com.rest.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Status {
    SUCCESS("Success","SUCCEEDED"),
    FAIL("Fail", "FAILED"),
    CREATE("Create", "CREATED"),
    UPDATE("Update", "UPDATED"),
    EDIT("Edit", "EDITED"),
    DELETE("Delete","DELETED"),
    ACTIVE("Active","ACTIVATED"),
    INACTIVE("Inactive", "INACTIVATED"),
    ;

    private String value;
    private String pastValue;
}
