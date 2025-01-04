package com.dhulai.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DaysOfWeek {
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;

    @JsonCreator
    public static DaysOfWeek fromString(String day) {
        // Convert the string to uppercase and return the corresponding enum
        return DaysOfWeek.valueOf(day.toUpperCase());
    }

    @JsonValue
    public String toJson() {
        return name().toLowerCase();  // This ensures that enum values are serialized in lowercase.
    }
}
