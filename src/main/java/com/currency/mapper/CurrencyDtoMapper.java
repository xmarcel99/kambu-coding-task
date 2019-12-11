package com.currency.mapper;

import com.currency.dto.CurrencyDto;
import com.currency.dto.CurrencyInfoDto;
import org.springframework.stereotype.Component;

@Component
public class CurrencyDtoMapper {

    public CurrencyDto mapToCurrencyDto(CurrencyInfoDto currencyInfoDto) {
        return new CurrencyDto(currencyInfoDto.getCurrency()
                ,currencyInfoDto.getCode()
                ,currencyInfoDto.getCurrencySet().get(0).getValue());
    }
}
