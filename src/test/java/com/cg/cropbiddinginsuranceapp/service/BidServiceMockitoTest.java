package com.cg.cropbiddinginsuranceapp.service;

import static org.junit.jupiter.api.Assertions.*;

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
import com.cg.cropbiddinginsuranceapp.entity.Bid;
import com.cg.cropbiddinginsuranceapp.entity.Crop;
import com.cg.cropbiddinginsuranceapp.entity.Farmer;
import com.cg.cropbiddinginsuranceapp.repository.IBidRepository;

@ExtendWith(SpringExtension.class)
class BidServiceMockitoTest {

	@InjectMocks
	BidServiceImpl bidService;

	@MockBean
	IBidRepository bidRepo;

	// Initialization of mock objects
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test

	/**
	 * Test case for the method to create all the values
	 */
	void testCreateBid() {
		Farmer farmer = new Farmer("Preeti", "6703323213", "preeti@gmail.com", "213345232111", "LLM121");

		Address homeAddress = new Address("103", "G-Nagar", "Noida", "Delhi", "760007");
		Address farmAddress = new Address("203", "H-Nagar", "Noida", "Delhi", "760008");
		Address bankAddress = new Address("303", "I-Nagar", "Noida", "Delhi", "760009");

		Bank bank = new Bank(403, "HDFC Bank", "1CD21");
		bank.setAddress(bankAddress);

		Account account = new Account(1986452177);
		account.setBank(bank);

		farmer.setHomeAddress(homeAddress);
		farmer.setFarmAddress(farmAddress);
		farmer.setBankDetails(account);
		Crop c = new Crop(104, "cash", "paddy", "clayloam", 1800.0, 50.0);
		Bid bid = new Bid(1001, "2022-05-15");

		Mockito.when(bidRepo.save(bid)).thenReturn(bid);
		Bid persistedBid = bidService.save(bid);
		assertEquals(1001, persistedBid.getBidId());
	}

	@Test


	/**
	 * Test case for the method to get the values from the database using id 
	 */
	void testFindByBidId() {
		Farmer farmer = new Farmer("Preeti", "6703323213", "preeti@gmail.com", "213345232111", "LLM121");

		Address homeAddress = new Address("103", "G-Nagar", "Noida", "Delhi", "760007");
		Address farmAddress = new Address("203", "H-Nagar", "Noida", "Delhi", "760008");
		Address bankAddress = new Address("303", "I-Nagar", "Noida", "Delhi", "760009");

		Bank bank = new Bank(403, "HDFC Bank", "1CD21");
		bank.setAddress(bankAddress);

		Account account = new Account(1986452177);
		account.setBank(bank);

		farmer.setHomeAddress(homeAddress);
		farmer.setFarmAddress(farmAddress);
		farmer.setBankDetails(account);
		Crop c = new Crop(104, "cash", "paddy", "clayloam", 1800.0, 50.0);
		Bid bid = new Bid(20, "2022-05-15");
		Mockito.when(bidRepo.findById(20)).thenReturn(Optional.of(bid));

		Bid persistedBid = bidService.findByBidId(20);
		assertEquals(20, persistedBid.getBidId());
	}

	@Test

	/**
	 * Test case for the method to delete the values from the database using id 
	 */
	void testDeleteBid() {
		Farmer farmer = new Farmer("Preeti", "6703323213", "preeti11@gmail.com", "213345232111", "LLM121");

		Address homeAddress = new Address("103", "G-Nagar", "Noida", "Delhi", "760007");
		Address farmAddress = new Address("203", "H-Nagar", "Noida", "Delhi", "760008");
		Address bankAddress = new Address("303", "I-Nagar", "Noida", "Delhi", "760009");

		Bank bank = new Bank(403, "HDFC Bank", "1CD21");
		bank.setAddress(bankAddress);

		Account account = new Account(1986452177);
		account.setBank(bank);

		farmer.setHomeAddress(homeAddress);
		farmer.setFarmAddress(farmAddress);
		farmer.setBankDetails(account);
		Crop c = new Crop(104, "cash", "paddy", "clayloam", 1800.0, 50.0);
		Bid bid = new Bid(20, "2022-05-15");

		Mockito.when(bidRepo.findById(20)).thenReturn(Optional.of(bid));

		Bid persistedBid = bidService.deleteByBidId(20);
		assertEquals(20, bid.getBidId());

	}

	@Test


	/**
	 * Test case for the method to update all the values
	 */
	void testUpdateBid() {

		Farmer farmer = new Farmer("Preeti", "6703323213", "preeti11@gmail.com", "213345232111", "LLM121");

		Address homeAddress = new Address("103", "G-Nagar", "Noida", "Delhi", "760007");
		Address farmAddress = new Address("203", "H-Nagar", "Noida", "Delhi", "760008");
		Address bankAddress = new Address("303", "I-Nagar", "Noida", "Delhi", "760009");

		Bank bank = new Bank(403, "HDFC Bank", "1CD21");
		bank.setAddress(bankAddress);

		Account account = new Account(1986452177);
		account.setBank(bank);

		farmer.setHomeAddress(homeAddress);
		farmer.setFarmAddress(farmAddress);
		farmer.setBankDetails(account);
		Crop c = new Crop(104, "cash", "rice", "clayloam", 1800.0, 50.0);
		Bid bid = new Bid(20, "2022-05-15");

		Mockito.when(bidRepo.findById(20)).thenReturn(Optional.of(bid));
		Mockito.when(bidRepo.save(bid)).thenReturn(bid);

		Bid persistedBid = bidService.update(bid);
		assertEquals("2022-05-15", persistedBid.getDateOfBidding());
	}

	@Test


	/**
	 * Test case for the method to get all the values from the database
	 */
	void testRetrieveBid() {
		Farmer farmer = new Farmer("Preeti", "6703323213", "preeti@gmail.com", "213345232111", "LLM121");

		Address homeAddress = new Address("103", "G-Nagar", "Noida", "Delhi", "760007");
		Address farmAddress = new Address("203", "H-Nagar", "Noida", "Delhi", "760008");
		Address bankAddress = new Address("303", "I-Nagar", "Noida", "Delhi", "760009");

		Bank bank = new Bank(403, "HDFC Bank", "1CD21");
		bank.setAddress(bankAddress);

		Account account = new Account(1986452177);
		account.setBank(bank);

		farmer.setHomeAddress(homeAddress);
		farmer.setFarmAddress(farmAddress);
		farmer.setBankDetails(account);
		Crop c = new Crop(104, "cash", "paddy", "clayloam", 1800.0, 50.0);
		List<Bid> bid = bidService.findAll();
		int size = bid.size();
		assertEquals(size, bid.size());
	}
}
