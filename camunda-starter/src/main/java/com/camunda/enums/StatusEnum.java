package com.camunda.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum StatusEnum {
    SUCCESS("SUCCEEDED"),
    FAIL("FAILED"),
    CREATE("CREATED"),
    UPDATE("UPDATED"),
    EDIT("EDITED"),
    DELETE("DELETED"),
    ACTIVE("ACTIVATED"),
    INACTIVE("INACTIVATED"),
    ;

    private String pastValue;
}
