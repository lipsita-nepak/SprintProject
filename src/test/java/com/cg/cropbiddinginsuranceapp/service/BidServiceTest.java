package com.cg.cropbiddinginsuranceapp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cropbiddinginsuranceapp.controller.BidController;
import com.cg.cropbiddinginsuranceapp.entity.Account;
import com.cg.cropbiddinginsuranceapp.entity.Address;
import com.cg.cropbiddinginsuranceapp.entity.Bank;
import com.cg.cropbiddinginsuranceapp.entity.Bid;
import com.cg.cropbiddinginsuranceapp.entity.Crop;
import com.cg.cropbiddinginsuranceapp.entity.CropVerificationStatus;
import com.cg.cropbiddinginsuranceapp.entity.Farmer;
import com.cg.cropbiddinginsuranceapp.entity.StorageSpace;

import ch.qos.logback.classic.Logger;

@SpringBootTest
class BidServiceTest {

	/**
	 * AutoWiring the service class to call down the service
	 */
	@Autowired
	IBidService bidService;

	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(BidController.class);

	@Test

	/**
	 * Test case for the method to save all the values
	 */
	void testSaveBid() {
		Bid bid = new Bid();
		bid.setBidId(1001);
		Address homeAddress = new Address("102", "D-Nagar", "Bhubaneswar", "Odisha", "760004");
		Address farmAddress = new Address("202", "E-Nagar", "Bhubaneswar", "Odisha", "760005");
		Address bankAddress = new Address("302", "F-Nagar", "Bhubaneswar", "Odisha", "760006");

		Bank bank = new Bank(402, "State Bank", "S34TS");
		bank.setAddress(bankAddress);

		Account account = new Account(1673211231);
		account.setBank(bank);

		Farmer farmer = new Farmer("Akshara Singhania", "9861778566", "akshara@gmail.com", "145989007863", "DEF332");

		farmer.setHomeAddress(homeAddress);
		farmer.setFarmAddress(farmAddress);
		farmer.setBankDetails(account);
		bid.setFarmer(farmer);

		Crop c = new Crop(107, "cash", "wheat", "clayloam", 1500.0, 80.0, StorageSpace.CLOSED_SHED,
				CropVerificationStatus.PENDING);

		bid.setCrop(c);
		bid.setDateOfBidding("2022-05-15");
		Bid persistedBid = bidService.save(bid);

		logger.info("saved details successfully");
		assertEquals(1001, persistedBid.getBidId());
	}

	@Test

	/**
	 * Test case for the method to delete the values from the database using id
	 */
	void testDeleteBid() {
		Bid bid = bidService.deleteByBidId(1001);

		logger.info("deleated details successfully");
		assertEquals(1001, bid.getBidId());

	}

	@Test

	/**
	 * Test case for the method to update all the values
	 */
	void testUpdateBid() {
		Bid bid = new Bid();
		bid.setBidId(20);
		bid.setBidId(1001);
		Address homeAddress = new Address("102", "D-Nagar", "Bhubaneswar", "Odisha", "760004");
		Address farmAddress = new Address("202", "E-Nagar", "Bhubaneswar", "Odisha", "760005");
		Address bankAddress = new Address("302", "F-Nagar", "Bhubaneswar", "Odisha", "760006");

		Bank bank = new Bank(402, "State Bank", "S34TS");
		bank.setAddress(bankAddress);

		Account account = new Account(1673211231);
		account.setBank(bank);

		Farmer farmer = new Farmer("Akshara Singhania", "9861778566", "akshara@gmail.com", "145989007863", "DEF332");

		farmer.setHomeAddress(homeAddress);
		farmer.setFarmAddress(farmAddress);
		farmer.setBankDetails(account);
		bid.setFarmer(farmer);

		Crop c = new Crop(107, "cash", "wheat", "clayloam", 1500.0, 80.0, StorageSpace.CLOSED_SHED,
				CropVerificationStatus.PENDING);

		bid.setCrop(c);
		bid.setDateOfBidding("2021-05-15");
		Bid persistedBid = bidService.update(bid);

		logger.info("updated details successfully");
		assertEquals("2021-05-15", persistedBid.getDateOfBidding());
	}

	@Test

	/**
	 * Test case for the method to get all the values from the database
	 */
	void testRetrieveBid() {
		List<Bid> bid = bidService.findAll();

		logger.info("fetched details successfully");
		assertEquals(4, bid.size());
	}

	@Test

	/**
	 * Test case for the method to get the values from the database using id
	 */
	void testRetrieveBidById() {
		Bid bid = bidService.findByBidId(1001);

		logger.info("fetched details successfully by id");
		assertEquals(1001, bid.getBidId());
	}

}
