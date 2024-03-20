package com.camunda.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum DateTimeEnum {
    // =========================================================== //
    // ------------------ Days of week
    // =========================================================== //
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday"),

    // =========================================================== //
    // ------------------ Date
    // =========================================================== //
    DATE("Date"),
    MONTH("Month"),
    YEAR("Year"),
    WEEK("Week"),

    // =========================================================== //
    // ------------------ Time
    // =========================================================== //
    HOUR("Hour"),
    MINUTE("Minute"),
    SECOND("Second"),
    MILLISECOND("Millisecond"),
    ;

    private String value;

}
