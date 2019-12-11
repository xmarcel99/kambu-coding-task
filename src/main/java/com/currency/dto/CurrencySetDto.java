package com.currency.dto;


import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencySetDto {

    @JsonProperty("effectiveDate")
    public String effectiveDate;

    @JsonProperty("rates")
    public List<CurrencyDto> currencyDtos;
}
