package com.rohith.microservices.currencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * After getting to know about the exchange rate, we need to convert an amount
 * from a currency to another after communicating with CurrencyExchange service.
 * So we use this service.
 * 
 * @author rohithvazhathody
 *
 */
@SpringBootApplication
@EnableFeignClients
public class CurrencyConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionApplication.class, args);
	}

}
