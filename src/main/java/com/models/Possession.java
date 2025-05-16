package com.models;

import com.models.enums.Currencies;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public abstract sealed class Possession permits LivingExpense, FinancialProperty, PropertyItem {
    protected String assetName;
    protected Cash cash;
    protected LocalDate propertyDateValue;

    public abstract Possession getPropertyFutureValue(LocalDate calculationDate );
}
