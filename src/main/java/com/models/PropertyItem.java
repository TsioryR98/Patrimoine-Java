package com.models;

import com.models.enums.Currencies;

import java.time.LocalDate;

public final class PropertyItem extends Possession {
    private LocalDate propertyDateValue;
    private Double depreciationRate;

    PropertyItem(String assetName, Cash cash) {
        super(assetName, cash);
    }
}
