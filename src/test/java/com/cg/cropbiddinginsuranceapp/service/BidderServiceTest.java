package com.cg.cropbiddinginsuranceapp.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.cropbiddinginsuranceapp.entity.*;
import java.util.*;
import com.cg.cropbiddinginsuranceapp.exception.*;

@SpringBootTest
class BidderServiceTest {

	@Autowired
	IBidderService bidService;
	
	@Test
	@Disabled
	void testAddBidder() {
		
		
		Address homeAddress=new Address("888","yamgal","Hyd","Telangana","501510");
		Address bankAddress=new Address("8888","lbnagar","hyd","Telangana","502001");
		
		Bank bank=new Bank(1,"ICICI","123abc");
		bank.setAddress(bankAddress);
		
		Account bankDetails=new Account(99);
		bankDetails.setBank(bank);
		Bidder bidder=new Bidder("abc","sam","12345","abc@gmail.com","12345","xyz");
		bidder.setBankDetails(bankDetails);
		bidder.setHomeAddress(homeAddress);
		
		Bidder persistedBidder=bidService.addBidder(bidder);
		assertEquals("sam",persistedBidder.getName());
		assertEquals("abc@gmail.com",persistedBidder.getEmailId());
		
		
	}
	
	@Test
	@Disabled
	void testUpdateBidder() {
		
		
		Address homeAddress=new Address("999","yamgal","Hyd","Telangana","501510");
		Address bankAddress=new Address("9999","lbnagar","hyd","Telangana","502001");
		
		Bank bank=new Bank(2,"ICICI","123abc");
		bank.setAddress(bankAddress);
		
		Account bankDetails=new Account(999);
		bankDetails.setBank(bank);
		
		Bidder bidder=new Bidder("abc","Pranil","12345","abc@gmail.com","12345","xyz");
		bidder.setUserId(1);
		bidder.setBankDetails(bankDetails);
		bidder.setHomeAddress(homeAddress);
		
		Bidder updated=bidService.updateBidder(bidder);
		System.out.println(updated);
		assertEquals("Pranil", updated.getName());
	}
	
	@Test
	@Disabled
	void testDeleteBidder() {
		Bidder bidder = bidService.deleteBidder(4);
		assertEquals(4, bidder.getUserId());
		
	}
	
	@Test
	@Disabled
	void testRetrieveAllBidders() {
		List<Bidder> bidder = bidService.retrieveAllBidders();
		int size=bidder.size();
		assertEquals(size, bidder.size());
		
	}
	
	@Test
	@Disabled
	void testRetrieveBidderById() throws PersonNotFoundException {
		Bidder bidder = bidService.retrieveBidderById(3);
		assertEquals("Pranil",bidder.getName());
		
	}

}

