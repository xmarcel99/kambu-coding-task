package com.currency.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CurrencyOperation {

    @GeneratedValue
    @Id
    private Long operationId;

    @NotNull
    private String operationType;

    private String operationUrl;

    private LocalDateTime operationTime = LocalDateTime.now();

    public CurrencyOperation(@NotNull String operationType, String operationUrl) {
        this.operationType = operationType;
        this.operationUrl = operationUrl;
    }
}
