package com.models;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;

@Getter
@Setter
public final class SavingAccount extends FinancialProperty {
    private Double interestRate;
    private LocalDate dateOfOpening;

    SavingAccount(String assetName, Cash cash, LocalDate propertyDateValue) {
        super(assetName, cash, propertyDateValue);
    }

    @Override
    public SavingAccount getPropertyFutureValue(LocalDate calculationDate) {
        double months = (double) (Duration.between(this.dateOfOpening.atStartOfDay(), calculationDate.atStartOfDay()).toDays() / 30);
        double interest = this.interestRate / 12; //per month
        Cash savingAccountValue = cash.toMultiply(Math.pow(1 + interest, months));

        return new SavingAccount(this.assetName,
                savingAccountValue,
                calculationDate);
    }
}

