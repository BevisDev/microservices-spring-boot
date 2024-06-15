package com.bevis.identity.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum FeatureEnum {
    DOCUMENT_MANAGEMENT("DocumentManagement"),
    ;
    String name;
}
