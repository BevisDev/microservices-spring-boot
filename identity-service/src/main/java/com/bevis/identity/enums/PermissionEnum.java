package com.bevis.identity.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum PermissionEnum {
    VIEW,
    EDIT,
    CREATE,
    DELETE,
    EXPORT,
    ;
}
