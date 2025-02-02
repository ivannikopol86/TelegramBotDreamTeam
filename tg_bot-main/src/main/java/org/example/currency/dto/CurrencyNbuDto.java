package org.example.currency.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.currency.Currency;

import java.math.BigDecimal;

/*
    Клас, для парсингу з json відповіді банка в об'єкт
*/
@Setter
@Getter
@ToString
@AllArgsConstructor
public class CurrencyNbuDto {
    private long r030;
    private String txt;
    private BigDecimal rate;
    private Currency cc;
    private String exchangedate;
}
