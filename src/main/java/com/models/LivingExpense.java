package com.models;

import com.models.enums.Currencies;
import lombok.Getter;

import java.time.LocalDate;

@Getter
 public final class LivingExpense extends Possession {
    LivingExpense(String assetName, Cash cash, LocalDate propertyDateValue) {
        super(assetName, cash, propertyDateValue);
    }
}
