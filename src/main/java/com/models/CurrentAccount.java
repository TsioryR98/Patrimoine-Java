package com.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Getter
@Setter
public final class CurrentAccount extends FinancialProperty {
    private final Set<LivingExpense> livingExpenses;
    private final LocalDate dateOfOpening;

    CurrentAccount(String assetName, Cash cash, LocalDate propertyDateValue, Set<LivingExpense> livingExpenses, LocalDate dateOfOpening) {
        super(assetName, cash, propertyDateValue);
        this.livingExpenses = new HashSet<>();
        this.dateOfOpening = dateOfOpening;
    }

    @Override
    public CurrentAccount getPropertyFutureValue(LocalDate calculationDate) {
        //total of living expenses
        Optional<Cash> total = livingExpenses.stream()
                .map(livingExpense -> livingExpense.getPropertyFutureValue(calculationDate).cash)
                .reduce(cash.getBalance()).orElse();

        Cash totalOfLivingExpense = new Cash(total, this.getCash().getCurrencies());


        return null;
    }
}
