package com.currency.service;


import com.currency.dto.CurrencyDto;
import com.currency.dto.CurrencyInfoDto;
import com.currency.dto.CurrencySetDto;
import com.currency.mapper.CurrencyDtoMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CurrencyServiceTest {

    @InjectMocks
    private CurrencyService currencyService;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private CurrencyDtoMapper currencyDtoMapper;

    @Test
    public void testGetCurrenciesValues(){
        //Given
        when(restTemplate.getForObject(ArgumentMatchers.anyString(),ArgumentMatchers.any())).thenReturn(new CurrencySetDto("12-12-2019", Arrays.asList(new CurrencyDto("Dolar Amerykański","USD",3.75))));
        //When
        List<String> resultList = currencyService.getCurrenciesValues();
        //Then
        Assert.assertEquals(1,resultList.size());
    }

    @Test
    public void testGetAvailableCurrencies(){
        when(restTemplate.getForObject(ArgumentMatchers.anyString(),ArgumentMatchers.any())).thenReturn(new CurrencySetDto("12-12-2019", Arrays.asList(new CurrencyDto("Dolar Amerykański","USD",3.75))));
        //When
        List<String> resultList = currencyService.getCurrenciesValues();
        //Then
        Assert.assertEquals(1,resultList.size());
    }

    @Test
    public void testConvertCurrency(){
        //Given
        when(restTemplate.getForObject(ArgumentMatchers.anyString(),ArgumentMatchers.any())).thenReturn((new CurrencyDto("Dolar Amerykański","USD",3.75)));
        when(currencyDtoMapper.mapToCurrencyDto(ArgumentMatchers.any(CurrencyInfoDto.class))).thenReturn(new CurrencyDto("Dolar Amerykański","USD",3.75));
        //When
        double result = currencyService.convertCurrency(200,"USD","AUD");
        //Then
        Assert.assertEquals(200,result);
    }

}
