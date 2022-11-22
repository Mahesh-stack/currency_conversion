package com.boot.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boot.test.entity.CurrencyConversionEntity;

@Repository
public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversionEntity, Integer> {

	CurrencyConversionEntity findByCurrencyNameIgnoreCase(String currencyName);

	@Query(value = "select count(*) from currency_conversion", nativeQuery = true)
	int countRecords();

	List<CurrencyConversionEntity> findByCurrencyNameIgnoreCaseAndCurrencyFromIgnoreCase(String currencyName,
			String currencyFrom);

}
