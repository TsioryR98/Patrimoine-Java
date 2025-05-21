package com.models;

import com.models.enums.Currencies;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Cash {
    private Double balance;
    private Currencies currencies;

    public static Cash ariary( double balance) {
        return new Cash(balance, Currencies.ARIARY);
    }
    public static Cash euros( double balance) {
        return new Cash(balance, Currencies.EUROS);
    }
    public Cash toSum( Cash that ) {
        return new Cash(this.getBalance() + that.getBalance(),
                this.getCurrencies());
    }
    public Cash toSubtract( Cash that ) {
        return new Cash(this.getBalance() - that.getBalance(),
                this.getCurrencies());
    }

    public Cash toMultiply( double factor ) {
        return new Cash(Math.ceil(this.getBalance() * factor),
                this.getCurrencies());
    }

}
