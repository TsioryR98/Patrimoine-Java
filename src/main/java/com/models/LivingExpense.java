package com.models;

import com.models.enums.Currencies;
import lombok.Getter;

@Getter
 public final class LivingExpense extends Possession {

    LivingExpense(String assetName, Cash cash) {
        super(assetName, cash);
    }
}
