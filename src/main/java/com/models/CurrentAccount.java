package com.models;

import com.models.enums.Currencies;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class CurrentAccount extends FinancialProperty {

    CurrentAccount(String assetName, Cash cash) {
        super(assetName, cash);
    }
}
