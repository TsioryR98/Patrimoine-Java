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
}
