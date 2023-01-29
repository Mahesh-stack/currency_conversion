package com.boot.test.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boot.test.entity.CurrencyConversionEntity;
import com.boot.test.exception.CurrencyNotFoundException;
import com.boot.test.repository.CurrencyConversionRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CurrencyConversionService {

	Logger logger = LoggerFactory.getLogger(CurrencyConversionService.class);

	@Autowired
	private CurrencyConversionRepository currencyConversionRepository;

	public CurrencyConversionEntity saveUpdateCurrency(CurrencyConversionEntity currencyConverison) {

		logger.info("Inside saveUpdateCurrency() method");
		CurrencyConversionEntity currencyConversionEntity = new CurrencyConversionEntity();

		try {
			CurrencyConversionEntity conversionEntity = currencyConversionRepository
					.findByCurrencyNameIgnoreCase(currencyConverison.getCurrencyName());
			if (conversionEntity == null) {
				logger.info("new currency saving");
				currencyConversionEntity.setCurrencyFrom(currencyConverison.getCurrencyFrom());
				currencyConversionEntity.setCurrencyTo(currencyConverison.getCurrencyTo());
				currencyConversionEntity.setCurrencyValue(currencyConverison.getCurrencyValue());
				currencyConversionEntity.setCurrencyName(currencyConverison.getCurrencyName());
				currencyConversionEntity = currencyConversionRepository.save(currencyConversionEntity);
			} else {
				logger.info("updating currency");
				conversionEntity.setCurrencyFrom(currencyConverison.getCurrencyFrom());
				conversionEntity.setCurrencyTo(currencyConverison.getCurrencyTo());
				conversionEntity.setCurrencyValue(currencyConverison.getCurrencyValue());
				conversionEntity.setCurrencyName(currencyConverison.getCurrencyName());
				currencyConversionEntity = currencyConversionRepository.save(conversionEntity);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return currencyConversionEntity;
	}

	public String findCurrency(String currencyName) {
		logger.info("inside findCurrency() method");
		String message = null;
		try {
			CurrencyConversionEntity conversionEntity = currencyConversionRepository
					.findByCurrencyNameIgnoreCase(currencyName);
			if (conversionEntity != null) {
				message = "Currency Exists";
			} else {
				message = "Currency Not Found";
				throw new CurrencyNotFoundException();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return message;
	}

	public int totalCountOfRecords() throws Exception {
		return currencyConversionRepository.countRecords();
	}

	public List<CurrencyConversionEntity> findByCurrencyNameAndCurrencyFrom(String currencyName, String currencyFrom) {
		List<CurrencyConversionEntity> list = null;
		try {
			list = currencyConversionRepository.findByCurrencyNameIgnoreCaseAndCurrencyFromIgnoreCase(currencyName,
					currencyFrom);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return list;
	}

	public List<CurrencyConversionEntity> findAllRecords() {
		return currencyConversionRepository.findAll();
	}

	public CurrencyConversionEntity saveNewCurrency(CurrencyConversionEntity currencyConversionEntity) {
		return currencyConversionRepository.save(currencyConversionEntity);
	}

}
