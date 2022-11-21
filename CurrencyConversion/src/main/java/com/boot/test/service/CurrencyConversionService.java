package com.boot.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boot.test.repository.CurrencyConversionRepository;

@Component
public class CurrencyConversionService {

	@Autowired
	private CurrencyConversionRepository currencyConversionRepository;

}
