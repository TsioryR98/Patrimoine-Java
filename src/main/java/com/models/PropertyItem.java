package com.models;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;
public final class PropertyItem extends Possession {
    private final Double depreciationRate;
     public PropertyItem(String assetName, Cash cash, LocalDate propertyDateValue, Double depreciationRate) {
        super(assetName, cash, propertyDateValue);
        this.depreciationRate = depreciationRate;
    }

    @Override
    public PropertyItem getPropertyFutureValue(LocalDate calculationDate) {
        double daysNumber = DAYS.between(propertyDateValue, calculationDate);
        Cash valueDepreciation = cash.toMultiply(depreciationRate/100);
        Cash valueFuture = cash.toSubtract( valueDepreciation.toMultiply(daysNumber /365));

        return new PropertyItem(this.assetName,
                valueFuture,
                calculationDate,
                depreciationRate
                );
    }
}
