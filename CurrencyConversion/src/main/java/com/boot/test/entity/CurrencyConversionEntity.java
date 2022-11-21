package com.boot.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "CurrencyConversion")
@Table(name = "CurrencyConversion")
public class CurrencyConversionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CURRENCY_ID")
	private int currencyId;
	@Column(name = "CURRENCY_FROM")
	private String currencyFrom;
	@Column(name = "CURRENCY_TO")
	private String currencyTo;
	@Column(name = "CURRENCY_VALUE")
	private String currencyValue;
	@Column(name = "CURRENCY_NAME")
	private String currencyName;

	public CurrencyConversionEntity(int currencyId, String currencyFrom, String currencyTo, String currencyValue,
			String currencyName) {
		super();
		this.currencyId = currencyId;
		this.currencyFrom = currencyFrom;
		this.currencyTo = currencyTo;
		this.currencyValue = currencyValue;
		this.currencyName = currencyName;
	}

	public CurrencyConversionEntity() {
		super();
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyFrom() {
		return currencyFrom;
	}

	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	public String getCurrencyTo() {
		return currencyTo;
	}

	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}

	public String getCurrencyValue() {
		return currencyValue;
	}

	public void setCurrencyValue(String currencyValue) {
		this.currencyValue = currencyValue;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	@Override
	public String toString() {
		return "CurrencyConversionEntity [currencyId=" + currencyId + ", currencyFrom=" + currencyFrom + ", currencyTo="
				+ currencyTo + ", currencyValue=" + currencyValue + ", currencyName=" + currencyName + "]";
	}

}
