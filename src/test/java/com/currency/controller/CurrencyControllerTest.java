package com.currency.controller;

import com.currency.service.CurrencyOperationService;
import com.currency.service.CurrencyService;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(CurrencyController.class)
class CurrencyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrencyService currencyService;

    @MockBean
    private CurrencyOperationService currencyOperationService;

    @Test
    public void getAvailableCurrencies() throws Exception{
        //Given
        when(currencyService.getAvailableCurrencies()).thenReturn(Arrays.asList("USD","AUD"));
        //When && Then
        mockMvc.perform(get("/currency/availableCurrencies"))
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0]",is("USD")))
                .andExpect(jsonPath("$[1]",is("AUD")));
    }

    @Test
    public void getCurrenciesValues() throws Exception{
        //Given
        when(currencyService.getCurrenciesValues()).thenReturn(Arrays.asList("USD-3.75","AUD-2.61"));
        //When && Then
        mockMvc.perform(get("/currency/currenciesValues"))
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0]",is("USD-3.75")))
                .andExpect(jsonPath("$[1]",is("AUD-2.63")));
    }

    @Test
    public void convertCurrency() throws Exception{
        //Given
        when(currencyService.convertCurrency(ArgumentMatchers.anyDouble(),ArgumentMatchers.anyString(),ArgumentMatchers.anyString())).thenReturn(234.5);
        //When && Then
        mockMvc.perform(get("/currency/convertCurrency/200/USD/AUD"));
    }
}