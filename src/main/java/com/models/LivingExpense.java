package com.models;

import lombok.Getter;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MONTHS;
import static java.util.Calendar.MONTH;

@Getter
 public final class LivingExpense extends Possession {
    private final int operationDebitDate; // first day of the month

    LivingExpense(String assetName, Cash cash, LocalDate propertyDateValue, int operationDebitDate) {
        super(assetName, cash, propertyDateValue);
        this.operationDebitDate = operationDebitDate;
    }

    @Override
    public LivingExpense getPropertyFutureValue(LocalDate calculationDate) {
        if (calculationDate.isAfter(propertyDateValue)) {
            return new LivingExpense(
                    assetName,
                    new Cash(cash.getBalance(), cash.getCurrencies()),
                    propertyDateValue,
                    operationDebitDate
                    );
        }
        long passedMonths = MONTHS.between(propertyDateValue, calculationDate);
        if (calculationDate.getDayOfMonth() >= operationDebitDate) {
            return new LivingExpense(
                    assetName,
                    new Cash(cash.getBalance() * passedMonths, cash.getCurrencies()),
                    propertyDateValue,
                    operationDebitDate
            );
        }
        return null;
    }
}
