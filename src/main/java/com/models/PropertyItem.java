package com.models;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;
public final class PropertyItem extends Possession {
    private final Double depreciationRate;
     public PropertyItem(String assetName, Cash cash, LocalDate propertyDateValue, Double depreciationRate) {
        super(assetName, cash, propertyDateValue);
        this.depreciationRate = depreciationRate;
    }

    public Double getUpdateValues (LocalDate calculateDate) {
        double daysNumber = DAYS.between(propertyDateValue, calculateDate);
        double valueAfterDepreciation = cash.getBalance() * depreciationRate/100 *(daysNumber / 365);
        return Math.ceil(cash.getBalance() - valueAfterDepreciation);
    }

    @Override
    public PropertyItem getPropertyFutureValue(LocalDate calculationDate) {
        return new PropertyItem(this.assetName,
                new Cash(Math.ceil(this.getUpdateValues(calculationDate)),this.cash.getCurrencies()),
                calculationDate,
                depreciationRate
                );
    }
}
//calcul de amortissement par année