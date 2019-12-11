package com.currency.controller;

import com.currency.domain.CurrencyOperation;
import com.currency.service.CurrencyOperationService;
import com.currency.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("currency/")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private CurrencyOperationService currencyOperationService;

    @GetMapping(value = "availableCurrencies")
    public List<String> getAvailableCurrencies(){
        currencyOperationService.save(new CurrencyOperation("GET_AVAILABLE_CURRENCIES","http://localhost:8080/currency/availableCurrencies"));
        return currencyService.getAvailableCurrencies();
    }

    @GetMapping(value = "currenciesValues")
    public List<String> getCurrenciesValues() {
        currencyOperationService.save(new CurrencyOperation("GET_CURRENCIES_VALUES","http://localhost:8080/currency/currenciesValues"));
        return currencyService.getCurrenciesValues();
    }

    @GetMapping(value = "convertCurrency/{amount}/{currencyFrom}/{currencyTo}")
    public double convertCurrency(@PathVariable double amount,@PathVariable String currencyFrom,@PathVariable String currencyTo) {
        currencyOperationService.save(new CurrencyOperation("CONVERT_CURRENCY","http://localhost:8080/currency/convertCurrency/200/"+currencyFrom+"/"+currencyTo));
        return currencyService.convertCurrency(amount,currencyFrom,currencyTo);
    }
}
