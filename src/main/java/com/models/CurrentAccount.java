package com.models;

import com.models.enums.Currencies;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public final class CurrentAccount extends FinancialProperty {

    CurrentAccount(String assetName, Cash cash, LocalDate propertyDateValue) {
        super(assetName, cash, propertyDateValue);
    }
}
