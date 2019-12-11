package com.currency.mapper;

import com.currency.dto.CurrencyDto;
import com.currency.dto.CurrencyInfoDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CurrencyDtoMapperTest {

    @Autowired
    private CurrencyDtoMapper currencyDtoMapper;

    @Test
    void mapToCurrencyDto() {
        //Given
        CurrencyInfoDto currencyInfoDto = new CurrencyInfoDto("Dolar Amerykański","USD", Arrays.asList(new CurrencyDto("Dolar Amerykański","USD",3.75)));
        //When
        CurrencyDto resultCurrencyDto = currencyDtoMapper.mapToCurrencyDto(currencyInfoDto);
        //Then
        assertEquals("Dolar Amerykański",resultCurrencyDto.getCurrencyName());
        assertEquals("USD",resultCurrencyDto.getCode());
    }
}