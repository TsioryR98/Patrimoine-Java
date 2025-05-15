package com.models;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.YEARS;
public final class PropertyItem extends Possession {
    private final Double depreciationRate;
    PropertyItem(String assetName, Cash cash, LocalDate propertyDateValue, Double depreciationRate) {
        super(assetName, cash, propertyDateValue);
        this.depreciationRate = depreciationRate;
    }

    public Double getPropertyFutureValue (LocalDate calculateDate) {
        double yearNumber = YEARS.between(propertyDateValue, calculateDate);
        if (yearNumber > 0) {
            return cash.getBalance() * Math.pow(1 - depreciationRate, yearNumber);
        }
        return null;
    }
}
//calcul de amortissement par année