package com.cg.cropbiddinginsuranceapp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.cg.cropbiddinginsuranceapp.entity.Crop;
import com.cg.cropbiddinginsuranceapp.entity.Farmer;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class FarmerServiceTest {
	
	// AutoWiring the service class to call down the service

	@Autowired
	IFarmerService farmerService; 

	// test for add farmer

	@Test
	@Disabled
	void testAddFarmer() {

		Farmer farmer = new Farmer("Preeti M", "6703323213", "preeti@gmail.com", "2133 4523 2111", "LLMKL9876L",
				"123456789076","ICICI","KJOI0654324");
		farmer.setCity("Mumbai");
		farmer.setState("Ap");
		farmer.setPincode("607005");
		
		log.info("Testing AddFarmer()");

		Farmer persistedFarmer = farmerService.addFarmer(farmer);
		
		
		assertAll(() -> assertEquals("Preeti M", persistedFarmer.getName()),
				() -> assertEquals("6703323213", persistedFarmer.getContactNumber()),
				() -> assertEquals("preeti@gmail.com", persistedFarmer.getEmailId()),
				() -> assertEquals("2133 4523 2111", persistedFarmer.getAadharNumber()),
				() -> assertEquals("LLMKL9876L", persistedFarmer.getPanNumber()));
				
		log.info("Successful result");

	}

	// test for retrieving all farmers from database

	@Test
	@Disabled
	void testRetrieveAllFarmers() {
		log.info("Testing RetrieveAllFarmers()");
		List<Farmer> farmers = farmerService.retrieveAllFarmers();

		int size=farmers.size();
		assertEquals(size, farmers.size());
		log.info("Successful result");
	}

	// test for retrieving farmer by id

	@Test
	
	void testRetrieveFarmerById() {
		log.info("Testing RetrieveFarmerById()");
		Farmer farmer = farmerService.retrieveFarmerById(6);
		
		
		assertEquals("preeti@gmail.com", farmer.getEmailId());
		
		log.info("Successful result");
	}

	// test for updating farmer details

	@Test
	@Disabled
	void testUpdateFarmer() {
		Farmer farmer = new Farmer("Preeti M", "6703323213", "preeti@gmail.com", "2133 4523 2111", "LLMKL9876L",
				"123456789076","ICICI","KJOI0654324");
		farmer.setCity("Mumbai");
		farmer.setState("Ap");
		farmer.setPincode("607005");
		farmer.setUserId(6);
		log.info("Testing UpdateFarmerById()");

		Farmer updatedFarmer = farmerService.updateFarmer(6, farmer);
		
		assertAll(() -> assertEquals("LLMKL9876L", updatedFarmer.getPanNumber()));
				
		log.info("Successful result");

	}

	// test for deleting farmer by id

	@Test
	
	void testDeleteFarmerById() {

		log.info("Testing DeleteFarmerById()");
		Farmer farmer = farmerService.deleteFarmerById(6);
		
		assertEquals(6, farmer.getUserId());
		log.info("Successful result");

		
	}

}
