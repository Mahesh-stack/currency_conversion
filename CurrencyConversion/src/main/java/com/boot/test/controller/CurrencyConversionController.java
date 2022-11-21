package com.boot.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.test.service.CurrencyConversionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/currency/conversion")
@Slf4j
public class CurrencyConversionController {

	Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);

	@Autowired
	private CurrencyConversionService currencyConversionService;

}
