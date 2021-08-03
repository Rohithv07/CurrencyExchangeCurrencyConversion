package com.rohith.microservices.currencyexchangeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rohith.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.rohith.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

/**
 * If we need to know about the currency rate of one currency to another, then
 * we make use of this restcontroller to retrieve that details.
 * 
 * @author rohithvazhathody
 *
 */
@RestController
@Api(value = "Currency Exchange Rate", description = "A rest controller to retrieve the exchange rate of one currency to another currency rate and also to get all the db values")
public class CurrencyExchangeController {

	/**
	 * This is field for the currency exchange repository
	 * {@link CurrencyExchangeRepository}
	 */
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	/**
	 * This field tells us what is the environment we are working on
	 * {@link Environment}
	 */
	@Autowired
	private Environment environment;

	/**
	 * We provide the from currency and to currency as pathvariables and retrieve
	 * the corresposing exchange rate after communicating with the in memory h2
	 * database with the help of currencyExchangeRepository
	 * {@link CurrencyExchangeRepository}
	 * 
	 * @param from
	 * @param to
	 * @return {@link CurrencyExchange}
	 */
	@CrossOrigin(origins = "*")
	@ApiOperation("Retrieve the exchange value after providing from currency and to currency")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved the currency exchange rate"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
		if (currencyExchange == null) {
			throw new RuntimeException("Unable to find data for " + from + " to" + to);
		}
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}

	/**
	 * If we need to get all the currency exchnage rate that are stored inside the
	 * data base.
	 * 
	 * @return List&ltCurrencyExchange&gt {@link CurrencyExchange}
	 */
	@CrossOrigin(origins = "*")
	@ApiOperation("Retrieve all the details that are stores inside the database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved full currency exchange list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(value = "/currency-exchange/all")
	public List<CurrencyExchange> getAllCurrencyExchangeRate() {
		return currencyExchangeRepository.findAll();
	}
}
