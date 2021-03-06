package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@EnableDiscoveryClient
@SpringBootApplication
public class StockMarketManageExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockMarketManageExchangeApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.stockapp"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Exchange API",
				"Stock Exchange API Documentation",
				"1.0.0",
				"Free",
				new springfox.documentation.service.Contact("Pranav Karnani",
						"https://pranavkarnani.com","thisispranavkarnani@gmail.com"),
				"API License",
				"https://pranavkarnani.com",
				Collections.emptyList()
		);
	}

}
