package com.rohith.microservices.currencyconversionservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
	public Docket currencyConversionApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.rohith.microservices.currencyconversionservice")).build()
				.apiInfo(metaData());
	}

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("Currency Conversion Rate", "Rest Api for converting amount of one currency type to another currency", "latest",
				"Terms of service", new Contact("Rohith V", "https://github.com/Rohithv07", "rohithv63@gmail.com"),
				"License", "License");
		return apiInfo;
	}
}
