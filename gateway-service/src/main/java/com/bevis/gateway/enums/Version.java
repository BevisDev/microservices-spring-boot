package com.bevis.gateway.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Version {
    VERSION_1(1),
    VERSION_2(2),
    VERSION_3(3),
    VERSION_4(4),
    VERSION_5(5),
    ;

    private int value;
}
