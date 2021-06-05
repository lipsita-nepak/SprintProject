package com.cg.cropbiddinginsuranceapp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cropbiddinginsuranceapp.entity.Account;
import com.cg.cropbiddinginsuranceapp.entity.Address;
import com.cg.cropbiddinginsuranceapp.entity.Bank;
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

		Farmer farmer = new Farmer("Kirti Goenka", "9203321453", "kirti@gmail.com", "9865 1233 2111", "DEH332");

		Address homeAddress = new Address("102", "D-Nagar", "Banglore", "Karnataka", "760007");
		Address farmAddress = new Address("202", "E-Nagar", "Banglore", "Karnataka", "760008");
		Address bankAddress = new Address("302", "H-Nagar", "Banglore", "Karnataka", "760009");
		
		Crop c1=new Crop(104, "cash", "paddy", "clayloam", 1800.0,50.0);
		Crop c2=new Crop(105, "food", "carrot", "clayloam", 1500.0,100.0);

		Bank bank = new Bank(403, "HDFC Bank", "65MN21");
		bank.setAddress(bankAddress);

		Account account = new Account(1266542366);
		account.setBank(bank);

		farmer.setHomeAddress(homeAddress);
		farmer.setFarmAddress(farmAddress);
		farmer.setBankDetails(account);
		
		List<Crop> cropList= new ArrayList<>();
		cropList.add(c1);
		cropList.add(c2);
		farmer.setCrops(cropList); 
		
		log.info("Testing AddFarmer()");

		Farmer persistedFarmer = farmerService.addFarmer(farmer);
		
		
		assertAll(() -> assertEquals("Kirti Goenka", persistedFarmer.getName()),
				() -> assertEquals("9203321453", persistedFarmer.getContactNumber()),
				() -> assertEquals("kirti@gmail.com", persistedFarmer.getEmailId()),
				() -> assertEquals("9865 1233 2111", persistedFarmer.getAadharNumber()),
				() -> assertEquals("DEH332", persistedFarmer.getPanNumber()),
				() -> assertEquals(1266542366, persistedFarmer.getBankDetails().getAccountId()));
		log.info("Successful result");

	}

	// test for retrieving all farmers from database

	@Test
	@Disabled
	void testRetrieveAllFarmers() {
		log.info("Testing RetrieveAllFarmers()");
		List<Farmer> farmers = farmerService.retrieveAllFarmers();
		
		assertEquals(1, farmers.size());
		log.info("Successful result");
	}

	// test for retrieving farmer by id

	@Test
	@Disabled
	void testRetrieveFarmerById() {
		log.info("Testing RetrieveFarmerById()");
		Farmer farmer = farmerService.retrieveFarmerById(1);
		
		
		assertEquals("naira@gmail.com", farmer.getEmailId());
		assertEquals("101", farmer.getHomeAddress().getHouseno());
		log.info("Successful result");
	}

	// test for updating farmer details

	@Test
	@Disabled
	void testUpdateFarmer() {
		Farmer farmer = new Farmer();

		Address homeAddress = new Address("101", "A-Nagar", "Noida", "Delhi", "760001");
		Address farmAddress = new Address("201", "B-Nagar", "Noida", "Delhi", "760002");
		Address bankAddress = new Address("301", "C-Nagar", "Noida", "Delhi", "760003");
		
		Crop c1=new Crop(104, "cash", "rice", "clayloam", 1800.0,50.0);
		Crop c2=new Crop(105, "food", "capsicum", "clayloam", 1500.0,100.0);
		
		List<Crop> cropList= new ArrayList<>();
		cropList.add(c1);
		cropList.add(c2);

		Bank bank = new Bank(401, "ICICI Bank", "1AB21");
		bank.setAddress(bankAddress);

		Account account = new Account(1865441232);
		account.setBank(bank);

		farmer.setName("Naira Singhania");
		farmer.setAadharNumber("2133 1233 2111");
		farmer.setContactNumber("6703321453");
		farmer.setEmailId("naira@gmail.com");
		farmer.setPanNumber("ABC121");
		farmer.setHomeAddress(homeAddress);
		farmer.setFarmAddress(farmAddress);
		farmer.setBankDetails(account);
		farmer.setCrops(cropList);
		log.info("Testing UpdateFarmerById()");

		Farmer updatedFarmer = farmerService.updateFarmer(1, farmer);
		
		assertAll(() -> assertEquals("ABC121", updatedFarmer.getPanNumber()),
				() -> assertEquals("A-Nagar", updatedFarmer.getHomeAddress().getStreet()));
		log.info("Successful result");

	}

	// test for deleting farmer by id

	@Test
	@Disabled
	void testDeleteFarmerById() {
		log.info("Testing DeleteFarmerById()");
		Farmer farmer = farmerService.deleteFarmerById(4);
		
		assertEquals(4, farmer.getUserId());
		log.info("Successful result");
	}

}
