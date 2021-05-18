package com.cg.cropbiddinginsuranceapp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cropbiddinginsuranceapp.entity.Account;
import com.cg.cropbiddinginsuranceapp.entity.Address;
import com.cg.cropbiddinginsuranceapp.entity.Bank;
import com.cg.cropbiddinginsuranceapp.entity.Farmer;

@SpringBootTest
class FarmerServiceTest {

	@Autowired
	IFarmerService farmerService;

	// test for add farmer

	@Test
	@Disabled
	void testAddFarmer() {
		Farmer farmer = new Farmer("Naira Goenka", "6703321453", "naira@gmail.com", "213312332111", "ABC121");

		Address homeAddress = new Address("101", "A-Nagar", "Noida", "Delhi", "760001");
		Address farmAddress = new Address("201", "B-Nagar", "Noida", "Delhi", "760002");
		Address bankAddress = new Address("301", "C-Nagar", "Noida", "Delhi", "760003");

		Bank bank = new Bank(401, "ICICI Bank", "1AB21");
		bank.setAddress(bankAddress);

		Account account = new Account(1865441232);
		account.setBank(bank);

		farmer.setHomeAddress(homeAddress);
		farmer.setFarmAddress(farmAddress);
		farmer.setBankDetails(account);

		Farmer persistedFarmer = farmerService.addFarmer(farmer);

		assertAll(() -> assertEquals("Naira Goenka", persistedFarmer.getName()),
				() -> assertEquals("6703321453", persistedFarmer.getContactNumber()),
				() -> assertEquals("naira@gmail.com", persistedFarmer.getEmailId()),
				() -> assertEquals("213312332111", persistedFarmer.getAadharNumber()),
				() -> assertEquals("ABC121", persistedFarmer.getPanNumber()),
				() -> assertEquals(1865441232, persistedFarmer.getBankDetails().getAccountId()));

	}

	// test for retrieving all farmers from database

	@Test
	@Disabled
	void testRetrieveAllFarmers() {
		List<Farmer> farmers = farmerService.retrieveAllFarmers();
		assertEquals(1, farmers.size());
	}

	// test for retrieving farmer by id

	@Test
	@Disabled
	void testRetrieveFarmerById() {
		Farmer farmer = farmerService.retrieveFarmerById(2);
		assertEquals("Naira Goenka", farmer.getName());
		assertEquals("101", farmer.getHomeAddress().getHouseno());
	}

	// test for updating farmer details

	@Test
	@Disabled
	void testUpdateFarmer() {
		Farmer farmer = new Farmer();

		Address homeAddress = new Address("101", "A-Nagar", "Noida", "Delhi", "760001");
		Address farmAddress = new Address("201", "B-Nagar", "Noida", "Delhi", "760002");
		Address bankAddress = new Address("301", "C-Nagar", "Noida", "Delhi", "760003");

		Bank bank = new Bank(401, "ICICI Bank", "1AB21");
		bank.setAddress(bankAddress);

		Account account = new Account(1865441232);
		account.setBank(bank);

		farmer.setName("Naira Singhania");
		farmer.setAadharNumber("213312332111");
		farmer.setContactNumber("6703321453");
		farmer.setEmailId("naira@gmail.com");
		farmer.setPanNumber("ABC121");
		farmer.setHomeAddress(homeAddress);
		farmer.setFarmAddress(farmAddress);
		farmer.setBankDetails(account);
		;

		Farmer updatedFarmer = farmerService.updateFarmer(2, farmer);
		System.out.println(updatedFarmer);
		assertAll(() -> assertEquals("ABC121", updatedFarmer.getPanNumber()),
				() -> assertEquals("A-Nagar", updatedFarmer.getHomeAddress().getStreet()));

	}

	// test for deleting farmer by id

	@Test
	@Disabled
	void testDeleteFarmerById() {
		Farmer farmer = farmerService.deleteFarmerById(1);
		assertEquals(1, farmer.getUserId());
	}

}
