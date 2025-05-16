package com.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public final class CurrentAccount extends FinancialProperty {
    CurrentAccount(String assetName, Cash cash, LocalDate propertyDateValue) {
        super(assetName, cash, propertyDateValue);
    }

    @Override
    public CurrentAccount getPropertyFutureValue(LocalDate calculationDate) {
        return null;
    }
}
