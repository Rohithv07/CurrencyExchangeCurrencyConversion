package com.rohith.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	@Retry(name="sample-api", fallbackMethod="hardCodedResponse")
	public String sampleApi() {
		logger.info("Sample api call received");
		// after retry for 3, the response is returned as default
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/sample", String.class);
		return forEntity.getBody();
	}
	
	public String hardCodedResponse(Exception ex) {
		return "Fallback response";
	}
}
