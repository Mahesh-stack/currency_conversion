package com.boot.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.boot.test.entity.CurrencyConversionEntity;
import com.boot.test.service.CurrencyConversionService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = { CurrencyConversionController.class })
public class CurrencyConversionControllerTest {

	@MockBean
	private CurrencyConversionService currencyConversionService;

	@Autowired
	private MockMvc mockMvc;

	ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testInsertNewCurrencyOrUpdateCurrency() throws Exception {
		CurrencyConversionEntity cuConversionEntity = new CurrencyConversionEntity(1, "1947", "2050", "Rupee",
				"Indian");

		String jsonObject = mapper.writeValueAsString(cuConversionEntity);

		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders
				.post("/currency/conversion/new-currency-save-update").contentType(MediaType.APPLICATION_JSON)
				.content(jsonObject);
		ResultActions perform = mockMvc.perform(mockHttpServletRequestBuilder);
		MvcResult result = perform.andReturn();
		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		assertEquals(202, status);
	}

	@Test
	public void testFindCurrency() throws Exception {

		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders
				.get("/currency/conversion/findCurrency/{currencyName}", "indian");

		ResultActions perform = mockMvc.perform(mockHttpServletRequestBuilder);
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
	}

	@Test
	public void testTotalNumberOfRecords() throws Exception {

		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/currency/conversion/countRecords");
		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
	}

	@Test
	public void testFindRecordsWithCurrencyNameAndCurrencyFrom() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/currency/conversion/findByCurNameAndCurFrom/{currencyName}/{currencyFrom}", "indian", "1947");
		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult result = perform.andReturn();
		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
	}

	@Test
	public void testFindAll() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/currency/conversion/All-Records");
		ResultActions perform = mockMvc.perform(requestBuilder);
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
	}
}
