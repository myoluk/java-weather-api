package com.myoluk.enums;

import lombok.Getter;

@Getter
public enum EnumDays {
    DAILY(1),
    WEEKLY(7),
    MONTHLY(16);

    private final int value;

    EnumDays(int value) {
        this.value = value;
    }
}
