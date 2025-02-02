package org.example.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.currency.Currency;
import org.example.currency.dto.CurrencyNbuDto;
import org.example.currency.dto.CurrencyRateDto;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class NbuSendRequest implements CurrencyService {
    // url по якому будем відправляти get запрос
    private static final String URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json%";

    @Override
    public List<CurrencyRateDto> getRate(Currency currency) {
        try {
            String currencyResponse = Jsoup.connect(URL)
                    .ignoreContentType(true)
                    .get()
                    .body()
                    .text();

            Type type = new TypeToken<List<CurrencyNbuDto>>() {}.getType();
            return new Gson().fromJson(currencyResponse, type); // Парсинг Json в об'єкти
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
