package com.currency.service;

import com.currency.dto.CurrencyDto;
import com.currency.dto.CurrencyInfoDto;
import com.currency.dto.CurrencySetDto;
import com.currency.mapper.CurrencyDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CurrencyDtoMapper currencyDtoMapper;

    public List<String> getCurrenciesValues() {
        CurrencySetDto []currencySet = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/tables/A/", CurrencySetDto[].class);
        if(currencySet != null && currencySet[0].getCurrencyDtos() != null) {
            return currencySet[0].getCurrencyDtos().stream()
                    .map(currencyDto -> currencyDto.getCurrencyName() +" ("+ currencyDto.getCode() +") " +  currencyDto.getValue())
                    .collect(Collectors.toList());
        } else {
            throw new NullPointerException("Currency set was null");
        }
    }

    public List<String> getAvailableCurrencies(){
        CurrencySetDto[] currencySet = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/tables/A/", CurrencySetDto[].class);
        if(currencySet != null && currencySet[0].getCurrencyDtos() != null) {
            return currencySet[0].getCurrencyDtos().stream()
                    .map(CurrencyDto::getCurrencyName)
                    .collect(Collectors.toList());
        } else {
            throw  new NullPointerException("Currency set was null");
        }
    }

    public double convertCurrency(double amount,String currencyFrom,String currencyTo){
        CurrencyDto fromCurrency = currencyDtoMapper.mapToCurrencyDto(restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/A/"+ currencyFrom +  "/",CurrencyInfoDto.class));
        CurrencyDto toCurrency = currencyDtoMapper.mapToCurrencyDto(restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/A/"+ currencyTo +  "/",CurrencyInfoDto.class));
        return  (amount*fromCurrency.getValue()) / toCurrency.getValue();
    }
}
