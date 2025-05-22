package com.models.enums;

import lombok.Getter;

@Getter
public enum Currencies {
    EUROS(4000d), ARIARY(1);
    private final double valueInAriary;

    Currencies(double valueInAriary) {
        this.valueInAriary = valueInAriary;
    }
}
