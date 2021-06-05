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

import com.cg.cropbiddinginsuranceapp.entity.Account;
import com.cg.cropbiddinginsuranceapp.entity.Address;
import com.cg.cropbiddinginsuranceapp.entity.Bank;
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
	@Disabled
	void testAddFarmer() {
		Farmer farmer = new Farmer("Preeti", "6703323213", "preeti@gmail.com", "2133 4523 2111", "LLM121");

		Address homeAddress = new Address("103", "G-Nagar", "Noida", "Delhi", "760007");
		Address farmAddress = new Address("203", "H-Nagar", "Noida", "Delhi", "760008");
		Address bankAddress = new Address("303", "I-Nagar", "Noida", "Delhi", "760009");
		
		Crop c1=new Crop(104, "cash", "paddy", "clayloam", 1800.0,50.0);
		Crop c2=new Crop(105, "food", "carrot", "clayloam", 1500.0,100.0);

		Bank bank = new Bank(403, "HDFC Bank", "1CD21");
		bank.setAddress(bankAddress);

		Account account = new Account(1986452177);
		account.setBank(bank);

		farmer.setHomeAddress(homeAddress);
		farmer.setFarmAddress(farmAddress);
		farmer.setBankDetails(account);
		
		List<Crop> cropList= new ArrayList<>();
		cropList.add(c1);
		cropList.add(c2);
		farmer.setCrops(cropList);
		
		log.info("Testing AddFarmer() inside Mockito");

		Mockito.when(farmerRepo.save(farmer)).thenReturn(farmer);

		Farmer persistedFarmer = farmerService.addFarmer(farmer);
		
		
		assertEquals("1CD21", persistedFarmer.getBankDetails().getBank().getIfscCode());
		assertEquals("Preeti", persistedFarmer.getName());
		log.info("Successful result");

	}

	// test for retrieving all farmers from database

	@Test
	@Disabled
	void testRetrieveAllFarmers() {
		Farmer farmer1 = new Farmer("Preeti", "6703323213", "preeti@gmail.com", "2133 4523 2111", "LLM121");

		Address homeAddress1 = new Address("103", "G-Nagar", "Noida", "Delhi", "760007");
		Address farmAddress1 = new Address("203", "H-Nagar", "Noida", "Delhi", "760008");
		Address bankAddress1 = new Address("303", "I-Nagar", "Noida", "Delhi", "760009");
		
		Crop c1=new Crop(104, "cash", "paddy", "clayloam", 1800.0,50.0);
		Crop c2=new Crop(105, "food", "carrot", "clayloam", 1500.0,100.0);

		Bank bank1 = new Bank(403, "HDFC Bank", "1CD21");
		bank1.setAddress(bankAddress1);

		Account account1 = new Account(1986452177);
		account1.setBank(bank1);

		farmer1.setHomeAddress(homeAddress1);
		farmer1.setFarmAddress(farmAddress1);
		farmer1.setBankDetails(account1);
		
		List<Crop> cropList= new ArrayList<>();
		cropList.add(c1);
		cropList.add(c2);
		farmer1.setCrops(cropList);
		

		List<Farmer> farmerList = new ArrayList<>();
		farmerList.add(farmer1);
		log.info("Testing RetrieveAllFarmers() inside Mockito");

		Mockito.when(farmerRepo.findAll()).thenReturn(farmerList);

		List<Farmer> farmers = farmerService.retrieveAllFarmers();
		

		assertEquals(1, farmers.size());
		log.info("Successful result");

	}

	// test for retrieving farmer by id

	@Test
	@Disabled
	void testRetrieveFarmerById() {
		Farmer farmer = new Farmer("Preeti", "6703323213", "preeti@gmail.com", "2133 4523 2111", "LLM121");

		Address homeAddress = new Address("103", "G-Nagar", "Noida", "Delhi", "760007");
		Address farmAddress = new Address("203", "H-Nagar", "Noida", "Delhi", "760008");
		Address bankAddress = new Address("303", "I-Nagar", "Noida", "Delhi", "760009");
		
		Crop c1=new Crop(104, "cash", "paddy", "clayloam", 1800.0,50.0);
		Crop c2=new Crop(105, "food", "carrot", "clayloam", 1500.0,100.0);

		Bank bank = new Bank(403, "HDFC Bank", "1CD21");
		bank.setAddress(bankAddress);

		Account account = new Account(1986452177);
		account.setBank(bank);

		farmer.setHomeAddress(homeAddress);
		farmer.setFarmAddress(farmAddress);
		farmer.setBankDetails(account);
		
		List<Crop> cropList= new ArrayList<>();
		cropList.add(c1);
		cropList.add(c2);
		farmer.setCrops(cropList); 
		
		log.info("Testing RetrieveFarmerById() inside Mockito");


		Mockito.when(farmerRepo.findById(3)).thenReturn(Optional.of(farmer));

		Farmer persistedFarmer = farmerService.retrieveFarmerById(3);
		
		assertEquals("preeti@gmail.com", persistedFarmer.getEmailId());
		assertEquals("Preeti", persistedFarmer.getName());
		log.info("Successful result");
	}

	// test for updating farmer details

	@Test
	@Disabled
	void testUpdateFarmer() {
		Farmer farmer = new Farmer("Preeti", "6703323213", "preeti11@gmail.com", "2133 4523 2111", "LLM121");

		Address homeAddress = new Address("103", "G-Nagar", "Noida", "Delhi", "760007");
		Address farmAddress = new Address("203", "H-Nagar", "Noida", "Delhi", "760008");
		Address bankAddress = new Address("303", "I-Nagar", "Noida", "Delhi", "760009");
		
		Crop c1=new Crop(104, "cash", "paddy", "clayloam", 1800.0,50.0);
		Crop c2=new Crop(105, "food", "carrot", "clayloam", 1500.0,100.0);

		Bank bank = new Bank(403, "HDFC Bank", "1CD21");
		bank.setAddress(bankAddress);

		Account account = new Account(1986452177);
		account.setBank(bank);

		farmer.setHomeAddress(homeAddress);
		farmer.setFarmAddress(farmAddress);
		farmer.setBankDetails(account);
		
		List<Crop> cropList= new ArrayList<>();
		cropList.add(c1);
		cropList.add(c2);
		farmer.setCrops(cropList);
		
		log.info("Testing UpdateFarmerById() inside Mockito");


		Mockito.when(farmerRepo.findById(3)).thenReturn(Optional.of(farmer));
		Mockito.when(farmerRepo.save(farmer)).thenReturn(farmer);

		Farmer persistedFarmer = farmerService.updateFarmer(3, farmer);
		
		assertEquals("preeti11@gmail.com", persistedFarmer.getEmailId());
		assertEquals("Preeti", persistedFarmer.getName());
		log.info("Successful result");
	}

	// test for deleting farmer by id

	@Test
	@Disabled
	void testDeleteFarmerById() {

		Farmer farmer = new Farmer("Preeti", "6703323213", "preeti11@gmail.com", "2133 4523 2111", "LLM121");

		Address homeAddress = new Address("103", "G-Nagar", "Noida", "Delhi", "760007");
		Address farmAddress = new Address("203", "H-Nagar", "Noida", "Delhi", "760008");
		Address bankAddress = new Address("303", "I-Nagar", "Noida", "Delhi", "760009");
		
		Crop c1=new Crop(104, "cash", "paddy", "clayloam", 1800.0,50.0);
		Crop c2=new Crop(105, "food", "carrot", "clayloam", 1500.0,100.0);

		Bank bank = new Bank(403, "HDFC Bank", "1CD21");
		bank.setAddress(bankAddress);

		Account account = new Account(1986452177);
		account.setBank(bank);

		farmer.setHomeAddress(homeAddress);
		farmer.setFarmAddress(farmAddress);
		farmer.setBankDetails(account);
		
		List<Crop> cropList= new ArrayList<>();
		cropList.add(c1);
		cropList.add(c2);
		farmer.setCrops(cropList);
		
		log.info("Testing DeleteFarmerById() inside Mockito ");

		Mockito.when(farmerRepo.findById(3)).thenReturn(Optional.of(farmer));
		farmerRepo.deleteById(3);
		Farmer persistedFarmer = farmerService.deleteFarmerById(3);
		

		assertEquals("preeti11@gmail.com", persistedFarmer.getEmailId());
		assertEquals("Preeti", persistedFarmer.getName());
		log.info("Successful result");
	}

}
