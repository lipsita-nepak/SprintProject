package com.cg.cropbiddinginsuranceapp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
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
		
		Mockito.when(bidRepo.save(bidder)).thenReturn(bidder);
		
		Bidder persistedBidder=bidService.addBidder(bidder);
		assertEquals("sam",persistedBidder.getName());
		assertEquals("abc@gmail.com",persistedBidder.getEmailId());
		
		
	}
	
	//test to update bidder
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
		
		Mockito.when(bidRepo.findById(1)).thenReturn(Optional.of(bidder));
		Mockito.when(bidRepo.save(bidder)).thenReturn(bidder);
		
		Bidder updated=bidService.updateBidder(bidder);
		System.out.println(updated);
		assertEquals("Pranil", updated.getName());
	}
	
	//test to delete bidder
	@Test
	@Disabled
	void testDeleteBidder() {
		Address homeAddress=new Address("999","yamgal","Hyd","Telangana","501510");
		Address bankAddress=new Address("9999","lbnagar","hyd","Telangana","502001");
		
		Bank bank=new Bank(2,"ICICI","123abc");
		bank.setAddress(bankAddress);
		
		Account bankDetails=new Account(999);
		bankDetails.setBank(bank);
		
		Bidder bidder=new Bidder("abc","Pranil","12345","abc@gmail.com","12345","xyz");
		bidder.setUserId(5);
		bidder.setBankDetails(bankDetails);
		bidder.setHomeAddress(homeAddress);
		
		Mockito.when(bidRepo.findById(5)).thenReturn(Optional.of(bidder));
		bidRepo.deleteById(5);
		Bidder persistedbid = bidService.deleteBidder(5);
		
		assertEquals(5, persistedbid.getUserId());
		
	}
	
	//test to get all bidders
	@Test
	@Disabled
	void testRetrieveAllBidders() {
		
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
		
		Address homeAddress1=new Address("9","abc","Hyd","Telangana","501510");
		Address bankAddress1=new Address("90","lbnagar","hyd","Telangana","502001");
		
		Bank bank1=new Bank(3,"HDFC","123abc");
		bank1.setAddress(bankAddress1);
		
		Account bankDetails1=new Account(99900);
		bankDetails1.setBank(bank1);
		
		Bidder bidder1=new Bidder("abc","samyuktha","12345","sam@gmail.com","123456","xyzab");
		bidder1.setUserId(2);
		bidder1.setBankDetails(bankDetails1);
		bidder1.setHomeAddress(homeAddress1);
		
		List<Bidder> bidderList = new ArrayList<>();
		bidderList.add(bidder);
		bidderList.add(bidder1);
		
		Mockito.when(bidRepo.findAll()).thenReturn(bidderList);
		
		List<Bidder> bidders = bidService.retrieveAllBidders();
		assertEquals(2, bidders.size());
		
	}
	
	//test to get bidder using user id
	@Test
	@Disabled
	void testRetrieveBidderById() throws PersonNotFoundException {
		
		Address homeAddress=new Address("999","yamgal","Hyd","Telangana","501510");
		Address bankAddress=new Address("9999","lbnagar","hyd","Telangana","502001");
		
		Bank bank=new Bank(2,"ICICI","123abc");
		bank.setAddress(bankAddress);
		
		Account bankDetails=new Account(999);
		bankDetails.setBank(bank);
		
		Bidder bidder=new Bidder("abc","sam","12345","abc@gmail.com","12345","xyz");
		bidder.setUserId(5);
		bidder.setBankDetails(bankDetails);
		bidder.setHomeAddress(homeAddress);
		
		Mockito.when(bidRepo.findById(5)).thenReturn(Optional.of(bidder));
		Bidder persistedbid = bidService.retrieveBidderById(5);
		assertEquals("sam",persistedbid.getName());
		
	}

}
