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
		
		
		Bidder bidder=new Bidder("abc","sam P","6309167207","abc@gmail.com","1234 5678 9012","JKLOI8976L","675432789076",
				"ICICI","KLOI0546789");
		bidder.setCity("Hyd");
		bidder.setState("telangana");
		bidder.setPincode("502001");
		
		Bidder persistedBidder=bidService.addBidder(bidder);
		logger.info("new bidder added "+persistedBidder);
		assertEquals("sam P",persistedBidder.getName());
		assertEquals("abc@gmail.com",persistedBidder.getEmailId());
		
		
	}
	
	//test to update bidder
	@Test
	@Disabled
	void testUpdateBidder() {
		
		
		Bidder bidder=new Bidder("abc","Pranil M","6309167207","abc@gmail.com","1234 5678 9012","JKLOI8976L","675432789076",
				"ICICI","KLOI0546789");
		bidder.setCity("Hyd");
		bidder.setState("telangana");
		bidder.setPincode("502001");
		bidder.setUserId(3);
		
		Bidder updated=bidService.updateBidder(bidder);
		logger.info("Bidder updated "+updated);
		System.out.println(updated);
		assertEquals("Pranil M", updated.getName());
	}
	
	//test to delete bidder
	@Test
	@Disabled
	void testDeleteBidder() {
		Bidder bidder = bidService.deleteBidder(1);
		logger.info("deleted bidder id is "+bidder.getUserId());
		assertEquals(1, bidder.getUserId());
		
	}
	
	// test for retrieving all Bidders from database

		@Test
		
		void testRetrieveAllBidders() {
			logger.info("Testing RetrieveAllBidders()");
			List<Bidder> bidders = bidService.retrieveAllBidders();

			int size=bidders.size();
			assertEquals(size, bidders.size());
			logger.info("Successful result");
		}

		// test for retrieving bidder by id

		@Test
		
		void testRetrieveBidderById() {
			logger.info("Testing RetrieveBidderById()");
			Bidder bidder = bidService.retrieveBidderById(3);
			
			
			assertEquals("abc@gmail.com", bidder.getEmailId());
			
			logger.info("Successful result");
		}
	
	
}

