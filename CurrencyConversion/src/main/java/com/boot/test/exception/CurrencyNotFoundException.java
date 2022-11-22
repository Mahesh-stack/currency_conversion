package com.boot.test.exception;

public class CurrencyNotFoundException extends RuntimeException {

	@Override
	public String getMessage() {
		return "Currency Not Exists";
	}

}
