package com.rest.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum VersionEnum {
    V1(1), V2(2), V3(3), V4(4), V5(5);

    private int version;
}
