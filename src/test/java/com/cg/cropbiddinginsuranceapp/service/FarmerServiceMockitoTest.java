package com.cg.cropbiddinginsuranceapp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.cropbiddinginsuranceapp.entity.Crop;
import com.cg.cropbiddinginsuranceapp.entity.Farmer;
import com.cg.cropbiddinginsuranceapp.repository.IFarmerRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ExtendWith(SpringExtension.class)
class FarmerServiceMockitoTest {

	@InjectMocks
	FarmerServiceImpl farmerService;

	@MockBean
	IFarmerRepository farmerRepo;

	// Initialization of mock objects
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	// test for add farmer

	@Test
	void testAddFarmer() {
		Farmer farmer = new Farmer("Preeti", "6703323213", "preeti@gmail.com", "2133 4523 2111", "LLMKL9876L",
				"123456789076","ICICI","KJOI0654324");
		farmer.setCity("Mumbai");
		farmer.setState("Ap");
		farmer.setPincode("607005");
		farmer.setUserId(100);

		log.info("Testing AddFarmer() inside Mockito");

		Mockito.when(farmerRepo.save(farmer)).thenReturn(farmer);

		Farmer persistedFarmer = farmerService.addFarmer(farmer);
		assertEquals("Preeti", persistedFarmer.getName());
		log.info("Successful result");

	}

	// test for retrieving all farmers from database

	@Test
	void testRetrieveAllFarmers() {
		Farmer farmer = new Farmer("Preeti", "6703323213", "preeti@gmail.com", "2133 4523 2111", "LLMKL9876L",
				"123456789076","ICICI","KJOI0654324");
		farmer.setCity("Mumbai");
		farmer.setState("Ap");
		farmer.setPincode("607005");
		farmer.setUserId(100);

		

		List<Farmer> farmerList = new ArrayList<>();
		farmerList.add(farmer);
		log.info("Testing RetrieveAllFarmers() inside Mockito");

		Mockito.when(farmerRepo.findAll()).thenReturn(farmerList);

		List<Farmer> farmers = farmerService.retrieveAllFarmers();
		

		assertEquals(1, farmers.size());
		log.info("Successful result");

	}

	// test for retrieving farmer by id

	@Test
	void testRetrieveFarmerById() {
		Farmer farmer = new Farmer("Preeti", "6703323213", "preeti@gmail.com", "2133 4523 2111", "LLMKL9876L",
				"123456789076","ICICI","KJOI0654324");
		farmer.setCity("Mumbai");
		farmer.setState("Ap");
		farmer.setPincode("607005");
		farmer.setUserId(100);
		
		log.info("Testing RetrieveFarmerById() inside Mockito");


		Mockito.when(farmerRepo.findById(3)).thenReturn(Optional.of(farmer));

		Farmer persistedFarmer = farmerService.retrieveFarmerById(3);
		
		assertEquals("preeti@gmail.com", persistedFarmer.getEmailId());
		assertEquals("Preeti", persistedFarmer.getName());
		log.info("Successful result");
	}

	// test for updating farmer details

	@Test
	void testUpdateFarmer() {
		Farmer farmer = new Farmer("Preeti", "6703323213", "preeti@gmail.com", "2133 4523 2111", "LLMKL9876L",
				"123456789076","ICICI","KJOI0654324");
		farmer.setCity("Mumbai");
		farmer.setState("Ap");
		farmer.setPincode("607005");
		farmer.setUserId(100);
		
		log.info("Testing UpdateFarmerById() inside Mockito");


		Mockito.when(farmerRepo.findById(100)).thenReturn(Optional.of(farmer));
		Mockito.when(farmerRepo.save(farmer)).thenReturn(farmer);

		Farmer persistedFarmer = farmerService.updateFarmer(100, farmer);
		
		assertEquals("preeti@gmail.com", persistedFarmer.getEmailId());
		assertEquals("Preeti", persistedFarmer.getName());
		log.info("Successful result");
	}

	// test for deleting farmer by id

	@Test
	void testDeleteFarmerById() {

		Farmer farmer = new Farmer("Preeti", "6703323213", "preeti@gmail.com", "2133 4523 2111", "LLMKL9876L",
				"123456789076","ICICI","KJOI0654324");
		farmer.setCity("Mumbai");
		farmer.setState("Ap");
		farmer.setPincode("607005");
		farmer.setUserId(3);
		
		log.info("Testing DeleteFarmerById() inside Mockito ");

		Mockito.when(farmerRepo.findById(3)).thenReturn(Optional.of(farmer));
		farmerRepo.deleteById(3);
		Farmer persistedFarmer = farmerService.deleteFarmerById(3);
		

		assertEquals("preeti@gmail.com", persistedFarmer.getEmailId());
		assertEquals("Preeti", persistedFarmer.getName());
		log.info("Successful result");
	}

}
