package com.rohith.microservices.currencyconversionservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rohith.microservices.currencyconversionservice.data.CurrencyConversion;

/**
 * Communication from CurrencyConversion to CurrencyExchange is done using a
 * feignclient and a proxy is used to make this communication
 * 
 * @author rohithvazhathody
 *
 */
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {
	/**
	 * Retrieve the exchange value from the CurrencyExchange service
	 * 
	 * @param from
	 * @param to
	 * @return {@link CurrencyConversion}
	 */
	@GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
