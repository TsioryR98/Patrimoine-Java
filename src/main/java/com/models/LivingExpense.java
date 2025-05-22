package com.models;

import lombok.Getter;
import java.time.LocalDate;

@Getter
 public final class LivingExpense extends Possession {
    private final CurrentAccount financier;
    private final int operationDebitDate; // first day of the month

    LivingExpense(String assetName, Cash cash, LocalDate propertyDateValue, CurrentAccount financier, int operationDebitDate) {
        super(assetName, cash, propertyDateValue);
        this.financier = financier;
        this.operationDebitDate = operationDebitDate;
    }

    @Override
    public LivingExpense getPropertyFutureValue(LocalDate calculationDate) {
        if (calculationDate.isAfter(propertyDateValue)) {
            return new LivingExpense(
                    assetName,
                    new Cash(0.0d, cash.getCurrencies()),
                    propertyDateValue,
                    financier,
                    operationDebitDate
                    );
        }
        //number of debit operations
        long numberDebitOperation = propertyDateValue
                .datesUntil((calculationDate.plusDays(1)))
                // include the last day and propertyDateValue until calculation date
                .filter( localDate -> localDate.getDayOfMonth() == operationDebitDate)
                .count();
        Cash livingExpenseCash = cash.toMultiply(numberDebitOperation);

        return new LivingExpense(
                assetName,
                livingExpenseCash,
                propertyDateValue,
                financier,
                operationDebitDate
        );
    }
}
