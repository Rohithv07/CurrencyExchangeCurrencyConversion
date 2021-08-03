package com.rohith.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rohith.microservices.currencyconversionservice.data.CurrencyConversion;
import com.rohith.microservices.currencyconversionservice.feignclient.CurrencyExchangeProxy;
import com.rohith.microservices.currencyconversionservice.service.CurrencyConversionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

/**
 * After talking with the CurrencyExchange service, we get the exchange rate,
 * now we need to find what is the converted amount and we make use of this rest
 * controller
 * 
 * @author rohithvazhathody
 *
 */
@RestController
@Api(value = "Currency Conversion", description = "Operations for converting one type of currency amount to another currency type")
public class CurrencyConversionController {

	/**
	 * We talk with CurrencyExchange with the help of a proxy
	 * 
	 * {@link CurrencyExchangeProxy}
	 */
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;

	/**
	 * We need to move the logic of finding the conversion and we make use of a
	 * service for implementing that logic.
	 */
	@Autowired
	private CurrencyConversionService currencyConversionService;

	/**
	 * Receive the from currency, to currency, quantity as pathvariable and the
	 * totalCalculated amout is found
	 * 
	 * @param from
	 * @param to
	 * @param quantity
	 * @return CurrencyConversion {@link CurrencyConversion}
	 */
	@CrossOrigin(origins = "*")
	@ApiOperation(value = "Get the currency conversion object along with the calculated amount")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully sets the calculated amount and returned the currency conversion object"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		CurrencyConversion currencyConversion = currencyExchangeProxy.retrieveExchangeValue(from, to);
		BigDecimal conversionMultiple = currencyConversion.getConversionMultiple();
		currencyConversion
				.setTotalCalculatedAmount(currencyConversionService.findConversionAmount(quantity, conversionMultiple));
		currencyConversion.setQuantity(quantity);
		return currencyConversion;
	}

}
