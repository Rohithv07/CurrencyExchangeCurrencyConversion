package com.rohith.microservices.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Special configuration have to be added in order to add some routes, rewrite
 * some paths etc..
 * 
 * @author rohithvazhathody
 *
 */
@Configuration
public class ApiGatewayConfiguration {

	/**
	 * This is a helper method to configure the router
	 * @param builder
	 * @return {@link RouteLocator}
	 */
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/get")
						.filters(f -> f.addRequestHeader("MyHeader", "MYURI").addRequestParameter("Param", "Value"))
						.uri("http://httpbin.org"))
				.route(p -> p.path("/currency-exchange/**").uri("lb://currency-exchange")) // registered name on eureka
				.route(p -> p.path("/currency-conversion/**").uri("lb://currency-conversion"))
				.route(p -> p.path("/currency-conversion-new/**").filters(f -> f
						.rewritePath("/currency-conversion-new/(?<segment>.*)", "/currency-conversion/${segment}"))
						.uri("lb://currency-conversion"))
				.build();
	}

}
