package com.boot.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.test.entity.CurrencyConversionEntity;
import com.boot.test.service.CurrencyConversionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/currency/conversion")
@Slf4j
public class CurrencyConversionController {

	Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);

	@Autowired
	private CurrencyConversionService currencyConversionService;

	@PostMapping("/new-currency-save-update")
	public ResponseEntity<Map<String, Object>> insertNewCurrencyOrUpdateCurrency(
			@RequestBody CurrencyConversionEntity currencyConverison) {
		Map<String, Object> response = new HashMap<>();
		CurrencyConversionEntity cuEntity = currencyConversionService.saveUpdateCurrency(currencyConverison);
		response.put("currency", cuEntity);
		return ResponseEntity.accepted().body(response);
	}

	@PostMapping("/save-new-currency")
	public ResponseEntity<Map<String, Object>> saveNewCurrency(
			@RequestBody CurrencyConversionEntity currencyConversionEntity) {
		Map<String, Object> resp = new HashMap<>();
		CurrencyConversionEntity cuConversionEntity = currencyConversionService
				.saveNewCurrency(currencyConversionEntity);
		resp.put("currency", cuConversionEntity);
		return ResponseEntity.accepted().body(resp);

	}

	@GetMapping("/findCurrency/{currencyName}")
	public ResponseEntity<String> findCurrency(@PathVariable("currencyName") String currencyName) {
		String isCurrencyAvailable = currencyConversionService.findCurrency(currencyName);
		return new ResponseEntity<String>(isCurrencyAvailable, HttpStatus.OK);
	}

	@GetMapping("/countRecords")
	public ResponseEntity<Integer> totalNumberOfRecords() throws Exception {
		int count = currencyConversionService.totalCountOfRecords();
		return new ResponseEntity<Integer>(count, HttpStatus.OK);
	}

	@GetMapping("/findByCurNameAndCurFrom/{currencyName}/{currencyFrom}")
	public ResponseEntity<List<CurrencyConversionEntity>> findRecordsWithCurrencyNameAndCurrencyFrom(
			@PathVariable String currencyName, @PathVariable String currencyFrom) {
		List<CurrencyConversionEntity> list = currencyConversionService.findByCurrencyNameAndCurrencyFrom(currencyName,
				currencyFrom);
		return new ResponseEntity<List<CurrencyConversionEntity>>(list, HttpStatus.OK);
	}

	@GetMapping("/All-Records")
	public ResponseEntity<List<CurrencyConversionEntity>> findAll() {
		List<CurrencyConversionEntity> list = currencyConversionService.findAllRecords();
		return new ResponseEntity<List<CurrencyConversionEntity>>(list, HttpStatus.OK);
	}

}
