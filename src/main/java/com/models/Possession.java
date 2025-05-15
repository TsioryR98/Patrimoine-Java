package com.models;

import com.models.enums.Currencies;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public abstract sealed class Possession permits LivingExpense, FinancialProperty, PropertyItem {
    protected String assetName;
    protected Cash cash;

}
