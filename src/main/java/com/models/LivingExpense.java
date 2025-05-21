package com.models;

import lombok.Getter;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MONTHS;
import static java.util.Calendar.MONTH;

@Getter
 public final class LivingExpense extends Possession {
    private final CurrentAccount financeLivingExpense;
    private final int operationDebitDate; // first day of the month

    LivingExpense(String assetName, Cash cash, LocalDate propertyDateValue, CurrentAccount financeLivingExpense, int operationDebitDate) {
        super(assetName, cash, propertyDateValue);
        this.financeLivingExpense = financeLivingExpense;
        this.operationDebitDate = operationDebitDate;
    }

    @Override
    public LivingExpense getPropertyFutureValue(LocalDate calculationDate) {
        if (calculationDate.isAfter(propertyDateValue)) {
            return new LivingExpense(
                    assetName,
                    new Cash(0.0d, cash.getCurrencies()),
                    propertyDateValue,
                    financeLivingExpense,
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
                financeLivingExpense,
                operationDebitDate
        );
    }
}
