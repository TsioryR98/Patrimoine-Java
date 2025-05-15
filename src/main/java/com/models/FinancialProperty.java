package com.models;

import com.models.enums.Currencies;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public abstract sealed class FinancialProperty extends Possession
        permits SavingAccount, CurrentAccount {

    protected FinancialProperty(String assetName, Cash cash, LocalDate propertyDateValue) {
        super(assetName, cash, propertyDateValue);
    }
}
