package com.rohith.microservices.currencyexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The rate for the conversion of one currency to another is different, so we
 * need to keep a record about what is the rate and this service do that work.
 * 
 * @author rohithvazhathody
 *
 */
@SpringBootApplication
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}

}
