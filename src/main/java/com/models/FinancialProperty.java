package com.models;

import com.models.enums.Currencies;
import lombok.Getter;
@Getter
public abstract sealed class FinancialProperty extends Possession
        permits SavingAccount, CurrentAccount {

    protected FinancialProperty(String assetName, Cash cash) {
        super(assetName, cash);
    }
}
