package com.cg.cropbiddinginsuranceapp.service;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.cropbiddinginsuranceapp.entity.*;
import java.util.*;
import com.cg.cropbiddinginsuranceapp.exception.*;

@SpringBootTest
class BidderServiceTest {

	
	 //Logger
	 
	org.apache.logging.log4j.Logger logger =LogManager.getLogger(BidderServiceTest.class);
	
	@Autowired
	IBidderService bidService;
	
	//test to add bidder
	@Test
	@Disabled
	void testAddBidder() {
		
		
		Address homeAddress=new Address("6757","yamgal","Hyd","Telangana","501510");
		Address bankAddress=new Address("9867","lbnagar","hyd","Telangana","502001");
		
		Bank bank=new Bank(9,"ICICI","123abc");
		bank.setAddress(bankAddress);
		
		Account bankDetails=new Account(879);
		bankDetails.setBank(bank);
		Bidder bidder=new Bidder("abc","sam","1234567890","abc@gmail.com","123456789012","xyz");
		bidder.setBankDetails(bankDetails);
		bidder.setHomeAddress(homeAddress);
		
		Bidder persistedBidder=bidService.addBidder(bidder);
		logger.info("new bidder added "+persistedBidder);
		assertEquals("sam",persistedBidder.getName());
		assertEquals("abc@gmail.com",persistedBidder.getEmailId());
		
		
	}
	
	//test to update bidder
	@Test
	//@Disabled
	void testUpdateBidder() {
		
		
		Address homeAddress=new Address("6590","yamgal","Hyd","Telangana","501510");
		Address bankAddress=new Address("1145","lbnagar","hyd","Telangana","502001");
		
		Bank bank=new Bank(44,"ICICI","123abc");
		bank.setAddress(bankAddress);
		
		Account bankDetails=new Account(1006);
		bankDetails.setBank(bank);
		
		Bidder bidder=new Bidder("abc","Pranil","1234554321","abc@gmail.com","123455432112","xyz");
		bidder.setUserId(4);
		bidder.setBankDetails(bankDetails);
		bidder.setHomeAddress(homeAddress);
		
		Bidder updated=bidService.updateBidder(bidder);
		logger.info("Bidder updated "+updated);
		System.out.println(updated);
		assertEquals("Pranil", updated.getName());
	}
	
	//test to delete bidder
	@Test
	@Disabled
	void testDeleteBidder() {
		Bidder bidder = bidService.deleteBidder(4);
		logger.info("deleted bidder id is "+bidder.getUserId());
		assertEquals(4, bidder.getUserId());
		
	}
	
	//test to get all bidders
	@Test
	@Disabled
	void testRetrieveAllBidders() {
		List<Bidder> bidder = bidService.retrieveAllBidders();
		logger.info("Bidder list "+bidder);
		int size=bidder.size();
		assertEquals(size, bidder.size());
		
	}
	
	//test to get bidder by userId
	@Test
	@Disabled
	void testRetrieveBidderById() throws PersonNotFoundException {
		Bidder bidder = bidService.retrieveBidderById(3);
		logger.info("getting bidder by id "+bidder);
		assertEquals("Pranil",bidder.getName());
		
	}

}

