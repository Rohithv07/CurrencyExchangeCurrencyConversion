package com.rohith.microservices.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * We need to add some custom routes, provied some authorization and some other
 * features, so we need to make use of ApiGateWay
 * 
 * @author rohithvazhathody
 *
 */
@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
