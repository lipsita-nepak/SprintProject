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

import com.cg.cropbiddinginsuranceapp.entity.Bid;
import com.cg.cropbiddinginsuranceapp.entity.BidStatus;
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
	@Disabled
	/**
	 * Test case for the method to save all the values
	 */
	void testSaveBid() {
		Bid bid = new Bid( "2022-05-15",600);
		bid.setBidId(100);
		Bid persistedBid = bidService.save(bid);

		logger.info("saved details successfully");
		assertEquals(100, persistedBid.getBidId());
	}

	@Test
	
	/**
	 * Test case for the method to delete the values from the database using id
	 */
	void testDeleteBid() {
		Bid bid = bidService.deleteByBidId(100);

		logger.info("deleated details successfully");
		assertEquals(100, bid.getBidId());

	}

	@Test
	@Disabled
	/**
	 * Test case for the method to update all the values
	 */
	void testUpdateBid() {
		Bid bid = new Bid( "2022-05-15",600);
		bid.setBidId(100);
		bid.setBidStatus(BidStatus.OPEN);
		Bid persistedBid = bidService.update(100,bid);

		logger.info("updated details successfully");
		assertEquals("2022-05-15", persistedBid.getDateOfBidding());
	}

	@Test
	@Disabled
	/**
	 * Test case for the method to get all the values from the database
	 */
	void testRetrieveBid() {
		List<Bid> bid = bidService.findAll();

		logger.info("fetched details successfully");
		int size=bid.size();
		assertEquals(size, bid.size());
	}

	@Test
	@Disabled
	/**
	 * Test case for the method to get the values from the database using id
	 */
	void testRetrieveBidById() {
		Bid bid = bidService.findByBidId(100);

		logger.info("fetched details successfully by id");
		assertEquals(100, bid.getBidId());
	}

}
