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

import com.cg.cropbiddinginsuranceapp.entity.*;
import com.cg.cropbiddinginsuranceapp.exception.PersonNotFoundException;
import com.cg.cropbiddinginsuranceapp.repository.IBidderRepository;


@ExtendWith(SpringExtension.class)
class BidderServiceMockitoTest {

	@InjectMocks
	BidderServiceImpl bidService;
	
	@MockBean
	IBidderRepository bidRepo;
	
	//Initialization of mock objects
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	//test to add bidder
	@Test
 
   void testAddBidder() {
		
		Bidder bidder=new Bidder("abc","sam P","6309167207","abc@gmail.com","123456789012","JKLOI8976L","675432789076",
				"ICICI","KLOI0546789");
		bidder.setCity("Hyd");
		bidder.setState("telangana");
		bidder.setPincode("502001");
		
		Mockito.when(bidRepo.save(bidder)).thenReturn(bidder);
		
		Bidder persistedBidder=bidService.addBidder(bidder);
		assertEquals("sam P",persistedBidder.getName());
		assertEquals("abc@gmail.com",persistedBidder.getEmailId());
		
		
	}
	
	//test to update bidder
	@Test
	
	void testUpdateBidder() {
		
		Bidder bidder=new Bidder("abc","Pranil M","6309167207","abc@gmail.com","123456789012","JKLOI8976L","675432789076",
				"ICICI","KLOI0546789");
		bidder.setUserId(1);
		bidder.setCity("Hyd");
		bidder.setState("telangana");
		bidder.setPincode("502001");
		Mockito.when(bidRepo.findById(1)).thenReturn(Optional.of(bidder));
		Mockito.when(bidRepo.save(bidder)).thenReturn(bidder);
		Bidder updated=bidService.updateBidder(bidder);
		assertEquals("Pranil M", updated.getName());
	}
	
	//test to delete bidder
	@Test
	
	void testDeleteBidder() {
		Bidder bidder=new Bidder("abc","Pranil M","6309167207","abc@gmail.com","123456789012","JKLOI8976L","675432789076",
				"ICICI","KLOI0546789");
		bidder.setUserId(5);
		bidder.setCity("Hyd");
		bidder.setState("telangana");
		bidder.setPincode("502001");
		
		Mockito.when(bidRepo.findById(5)).thenReturn(Optional.of(bidder));
		bidRepo.deleteById(5);
		Bidder persistedbid = bidService.deleteBidder(5);
		
		assertEquals(5, persistedbid.getUserId());
		
	}
	
	//test to get all bidders
	@Test
	
	void testRetrieveAllBidders() {
		
		Bidder bidder=new Bidder("abc","Pranil M","6309167207","abc@gmail.com","123456789012","JKLOI8976L","675432789076",
				"ICICI","KLOI0546789");
		bidder.setUserId(5);
		bidder.setCity("Hyd");
		bidder.setState("telangana");
		bidder.setPincode("502001");
		
		Bidder bidder1=new Bidder("abc","Sam P","6309167207","abc@gmail.com","123456789012","JKLOI8976L","675432789076",
				"ICICI","KLOI0546789");
		bidder.setUserId(6);
		bidder.setCity("Hyd");
		bidder.setState("telangana");
		bidder.setPincode("502001");
		
		List<Bidder> bidderList = new ArrayList<>();
		bidderList.add(bidder);
		bidderList.add(bidder1);
		
		Mockito.when(bidRepo.findAll()).thenReturn(bidderList);
		
		List<Bidder> bidders = bidService.retrieveAllBidders();
		assertEquals(2, bidders.size());
		
	}
	
	//test to get bidder using user id
	@Test

	void testRetrieveBidderById() throws PersonNotFoundException {
		
		Bidder bidder=new Bidder("abc","Pranil M","6309167207","abc@gmail.com","123456789012","JKLOI8976L","675432789076",
				"ICICI","KLOI0546789");
		bidder.setUserId(5);
		bidder.setCity("Hyd");
		bidder.setState("telangana");
		bidder.setPincode("502001");
		
		Mockito.when(bidRepo.findById(5)).thenReturn(Optional.of(bidder));
		Bidder persistedbid = bidService.retrieveBidderById(5);
		assertEquals("Pranil M",persistedbid.getName());
		
	}

}
