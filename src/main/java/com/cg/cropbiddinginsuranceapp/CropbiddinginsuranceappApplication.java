package com.cg.cropbiddinginsuranceapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CropbiddinginsuranceappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CropbiddinginsuranceappApplication.class, args);

	}

	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any()).build();
	}

}
