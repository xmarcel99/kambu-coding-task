package com.currency.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyInfoDto {

    @JsonProperty("currency")
    public String currency;

    @JsonProperty("code")
    public String code;

    @JsonProperty("rates")
    public List<CurrencyDto> currencySet;

}
