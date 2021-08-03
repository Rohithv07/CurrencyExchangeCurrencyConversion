package com.rohith.microservices.currencyconversionservice.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

/**
 * After receiving the conversionMultiple, we need to calculate the quantity and
 * CurrencyConversionService service will make it happen
 * 
 * @author rohithvazhathody
 *
 */
@Service
public class CurrencyConversionService {
	/**
	 * We multiply the quantiy and conversionMultiple to get the calculateAmount;
	 * @param quantity
	 * @param conversionMultiple
	 * @return {@link BigDecimal} 
	 */
	public BigDecimal findConversionAmount(BigDecimal quantity, BigDecimal conversionMultiple) {
		return quantity.multiply(conversionMultiple);
	}
}
