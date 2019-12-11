package com.currency.service;

import com.currency.domain.CurrencyOperation;
import com.currency.repository.CurrencyOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyOperationService {

    @Autowired
    private CurrencyOperationRepository currencyOperationRepository;

    public void save(CurrencyOperation currencyOperation) {
        currencyOperationRepository.save(currencyOperation);
    }


}
