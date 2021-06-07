package com.cg.cropbiddinginsuranceapp;

import org.apache.logging.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import lombok.extern.log4j.Log4j2;

import com.cg.cropbiddinginsuranceapp.controller.CropController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Log4j2
public class CropbiddinginsuranceappApplication {
	
	org.apache.logging.log4j.Logger logger =LogManager.getLogger(CropbiddinginsuranceappApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CropbiddinginsuranceappApplication.class, args);

		log.info("Initializing Application");
    }



	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any()).build();
	}

}
