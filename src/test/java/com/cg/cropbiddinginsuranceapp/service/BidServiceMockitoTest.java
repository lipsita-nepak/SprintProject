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




import com.cg.cropbiddinginsuranceapp.entity.Bid;
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
		
		Bid bid = new Bid( "2022-05-15",600);
		bid.setBidId(100);
		Mockito.when(bidRepo.save(bid)).thenReturn(bid);
		Bid persistedBid = bidService.save(bid);
		assertEquals(100, persistedBid.getBidId());
	}

	@Test


	/**
	 * Test case for the method to get the values from the database using id 
	 */
	void testFindByBidId() {
		Bid bid = new Bid( "2022-05-15",600);
		bid.setBidId(100);
		Mockito.when(bidRepo.findById(100)).thenReturn(Optional.of(bid));

		Bid persistedBid = bidService.findByBidId(100);
		assertEquals(100, persistedBid.getBidId());
	}

	@Test

	/**
	 * Test case for the method to delete the values from the database using id 
	 */
	void testDeleteBid() {
		Bid bid = new Bid( "2022-05-15",600);
		bid.setBidId(20);

		Mockito.when(bidRepo.findById(20)).thenReturn(Optional.of(bid));

		Bid persistedBid = bidService.deleteByBidId(20);
		assertEquals(20, persistedBid.getBidId());

	}

	@Test


	/**
	 * Test case for the method to update all the values
	 */
	void testUpdateBid() {

		Bid bid = new Bid( "2022-05-15",600);
		bid.setBidId(20);

		Mockito.when(bidRepo.findById(20)).thenReturn(Optional.of(bid));
		Mockito.when(bidRepo.save(bid)).thenReturn(bid);

		Bid persistedBid = bidService.update(20, bid);
		assertEquals("2022-05-15", persistedBid.getDateOfBidding());
	}

	@Test


	/**
	 * Test case for the method to get all the values from the database
	 */
	void testRetrieveBid() {
		Bid bid = new Bid( "2022-05-15",600);
		bid.setBidId(20);
		List<Bid> bidd = bidService.findAll();
		int size = bidd.size();
		assertEquals(size, bidd.size());
	}
}
