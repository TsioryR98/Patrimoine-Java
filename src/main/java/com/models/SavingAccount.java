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

    public Double getUpdateValues(LocalDate calculationDate) {
        double months = (double) (Duration.between(this.dateOfOpening.atStartOfDay(), calculationDate.atStartOfDay()).toDays() / 30);
        if (months < 0) {
            throw new IllegalArgumentException(" calculationDate must be after dateOfOpening");
        }
        double interest = this.interestRate / 12; //per month
        return this.cash.getBalance() * Math.pow(1 + interest, months);
        //
    }

    @Override
    public SavingAccount getPropertyFutureValue(LocalDate calculationDate) {
        return new SavingAccount(this.assetName,
                new Cash(this.getUpdateValues(calculationDate), this.cash.getCurrencies()),
                calculationDate);
    }
}

