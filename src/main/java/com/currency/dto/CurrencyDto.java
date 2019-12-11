package com.currency.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CurrencyDto {

    @JsonProperty("currency")
    public String currencyName;
    @JsonProperty("code")
    public String code;
    @JsonProperty("mid")
    public Double value;

}