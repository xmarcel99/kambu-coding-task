package com.currency.repository;

import com.currency.domain.CurrencyOperation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CurrencyOperationRepository extends CrudRepository<CurrencyOperation,Long> {

}
