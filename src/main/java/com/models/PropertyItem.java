package com.models;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.YEARS;
public final class PropertyItem extends Possession {
    private final Double depreciationRate;
    PropertyItem(String assetName, Cash cash, LocalDate propertyDateValue, Double depreciationRate) {
        super(assetName, cash, propertyDateValue);
        this.depreciationRate = depreciationRate;
    }

    public Double getPropertyFutureValue (LocalDate calculateDate) {
        double daysNumber = DAYS.between(propertyDateValue, calculateDate);
        double valueAfterDepreciation = cash.getBalance() * depreciationRate/100 *(daysNumber / 365);
        return cash.getBalance() - valueAfterDepreciation;
    }
}
//calcul de amortissement par année