package com.rohith.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohith.microservices.currencyexchangeservice.model.CurrencyExchange;

/**
 * While we are dealing with spring data jpa, we need to make use of a
 * repository that extends the JpaRepository
 * 
 * {@link JpaRepository} {@link CurrencyExchange}
 * 
 * @author rohithvazhathody
 *
 */
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	CurrencyExchange findByFromAndTo(String from, String to);
}
