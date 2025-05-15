package com.models;

import com.models.enums.Currencies;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;

@Getter
@Setter
public final class SavingAccount extends FinancialProperty {
    private Double interestRate;
    private LocalDate dateOfOpening;

    SavingAccount(String assetName, Cash cash) {
        super(assetName, cash);
    }

    public Double getActualSavingAccountValue(LocalDate calculationDate) {
        double months = (double) (Duration.between(this.dateOfOpening.atStartOfDay(), calculationDate.atStartOfDay()).toDays() / 30);
        if (months < 0) {
            throw new IllegalArgumentException(" calculationDate must be after dateOfOpening");
        }
        double interest = this.interestRate / 12; //per month
        return this.cash.getBalance() * Math.pow(1 + interest, months);
    }
}
