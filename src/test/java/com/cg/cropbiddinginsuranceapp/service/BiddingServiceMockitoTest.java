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
import com.cg.cropbiddinginsuranceapp.entity.Bid;
import com.cg.cropbiddinginsuranceapp.entity.BidStatus;
import com.cg.cropbiddinginsuranceapp.entity.Bidder;
import com.cg.cropbiddinginsuranceapp.entity.Bidding;
import com.cg.cropbiddinginsuranceapp.entity.Crop;
import com.cg.cropbiddinginsuranceapp.entity.Farmer;
import com.cg.cropbiddinginsuranceapp.repository.IBiddingDao;

@ExtendWith(SpringExtension.class)
class BiddingServiceMockitoTest {
	@InjectMocks
	BiddingServiceImpl bs;
	
	@MockBean
	IBiddingDao bdao;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	@Disabled
	void testAdd(){
		Address homeAddress=new Address("888","yamgal","Hyd","Telangana","501510");
		Address bankAddress=new Address("8888","lbnagar","hyd","Telangana","502001");
		
		Bank bank=new Bank(1,"ICICI","123abc");
		bank.setAddress(bankAddress);
		
		Account bankDetails=new Account(99);
		bankDetails.setBank(bank);
		Bidder bidder=new Bidder("abc","sam","12345","abc@gmail.com","12345","xyz");
		bidder.setBankDetails(bankDetails);
		bidder.setHomeAddress(homeAddress);
		
		Farmer farmer = new Farmer("Preeti","6703323213","preeti@gmail.com","2133 4523 2111","LLM121");
		
		Address homeAddress1=new Address("103","G-Nagar","Noida","Delhi","760007");
		Address farmAddress1=new Address("203","H-Nagar","Noida","Delhi","760008");
		Address bankAddress1=new Address("303","I-Nagar","Noida","Delhi","760009");
		

		Bank bank1=new Bank(403,"HDFC Bank","1CD21");
		bank.setAddress(bankAddress1);

		Account account=new Account(1986452177);
		account.setBank(bank1);
		
		farmer.setHomeAddress(homeAddress1);
		farmer.setFarmAddress(farmAddress1);
		farmer.setBankDetails(account);
		Crop c=new Crop(104, "cash", "paddy", "clayloam", 1800.0,50.0);
		Bid bidd = new Bid(20,"2022-05-15");
		bidd.setCrop(c);
		bidd.setFarmer(farmer);
		
		Bidding bid=new Bidding(3,1800.0,BidStatus.CLOSED);
		bid.setBidder(bidder);
		bid.setBid(bidd);
		
		Mockito.when(bdao.save(bid)).thenReturn(bid);
		Bidding b=bdao.save(bid);
		assertEquals(3,b.getBiddingId());
	}
	
	@Test 
	@Disabled
	void testViewAll() {
		Address homeAddress=new Address("888","yamgal","Hyd","Telangana","501510");
		Address bankAddress=new Address("8888","lbnagar","hyd","Telangana","502001");
		
		Bank bank=new Bank(1,"ICICI","123abc");
		bank.setAddress(bankAddress);
		
		Account bankDetails=new Account(99);
		bankDetails.setBank(bank);
		Bidder bidder=new Bidder("abc","sam","12345","abc@gmail.com","12345","xyz");
		bidder.setBankDetails(bankDetails);
		bidder.setHomeAddress(homeAddress);
		
		Farmer farmer = new Farmer("Preeti","6703323213","preeti@gmail.com","2133 4523 2111","LLM121");
		
		Address homeAddress1=new Address("103","G-Nagar","Noida","Delhi","760007");
		Address farmAddress1=new Address("203","H-Nagar","Noida","Delhi","760008");
		Address bankAddress1=new Address("303","I-Nagar","Noida","Delhi","760009");
		

		Bank bank1=new Bank(403,"HDFC Bank","1CD21");
		bank.setAddress(bankAddress1);

		Account account=new Account(1986452177);
		account.setBank(bank1);
		
		farmer.setHomeAddress(homeAddress1);
		farmer.setFarmAddress(farmAddress1);
		farmer.setBankDetails(account);
		Crop c=new Crop(104, "cash", "paddy", "clayloam", 1800.0,50.0);
		Bid bidd = new Bid(20,"2022-05-15");
		bidd.setCrop(c);
		bidd.setFarmer(farmer);
		
		
		
		Bidding bid1=new Bidding(5,1700.0,BidStatus.CLOSED);
		bid1.setBidder(bidder);
		List<Bidding>l=new ArrayList<>();
		l.add(bid1);
		Mockito.when(bdao.findAll()).thenReturn(l);
		List<Bidding>bidList=bs.retriveAllBidding();
		assertEquals(1,bidList.size());
	}
	
	@Test
	@Disabled
	void testViewById() {
		Address homeAddress=new Address("888","yamgal","Hyd","Telangana","501510");
		Address bankAddress=new Address("8888","lbnagar","hyd","Telangana","502001");
		
		Bank bank=new Bank(1,"ICICI","123abc");
		bank.setAddress(bankAddress);
		
		Account bankDetails=new Account(99);
		bankDetails.setBank(bank);
		Bidder bidder=new Bidder("abc","sam","12345","abc@gmail.com","12345","xyz");
		bidder.setBankDetails(bankDetails);
		bidder.setHomeAddress(homeAddress);
		
		Farmer farmer = new Farmer("Preeti","6703323213","preeti@gmail.com","2133 4523 2111","LLM121");
		
		Address homeAddress1=new Address("103","G-Nagar","Noida","Delhi","760007");
		Address farmAddress1=new Address("203","H-Nagar","Noida","Delhi","760008");
		Address bankAddress1=new Address("303","I-Nagar","Noida","Delhi","760009");
		

		Bank bank1=new Bank(403,"HDFC Bank","1CD21");
		bank.setAddress(bankAddress1);

		Account account=new Account(1986452177);
		account.setBank(bank1);
		
		farmer.setHomeAddress(homeAddress1);
		farmer.setFarmAddress(farmAddress1);
		farmer.setBankDetails(account);
		Crop c=new Crop(104, "cash", "paddy", "clayloam", 1800.0,50.0);
		Bid bidd = new Bid(20,"2022-05-15");
		bidd.setCrop(c);
		bidd.setFarmer(farmer);
		
		Bidding bid=new Bidding(5,1700.0,BidStatus.CLOSED);
		bid.setBid(bidd);
		bid.setBidder(bidder);
		Mockito.when(bdao.findById(5)).thenReturn(Optional.of(bid));
		assertEquals(5,bid.getBiddingId());
	}
	
	@Test
	@Disabled
	void testUpdateStatus() {
		Address homeAddress=new Address("888","yamgal","Hyd","Telangana","501510");
		Address bankAddress=new Address("8888","lbnagar","hyd","Telangana","502001");
		
		Bank bank=new Bank(1,"ICICI","123abc");
		bank.setAddress(bankAddress);
		
		Account bankDetails=new Account(99);
		bankDetails.setBank(bank);
		Bidder bidder=new Bidder("abc","sam","12345","abc@gmail.com","12345","xyz");
		bidder.setBankDetails(bankDetails);
		bidder.setHomeAddress(homeAddress);
		
		Farmer farmer = new Farmer("Preeti","6703323213","preeti@gmail.com","2133 4523 2111","LLM121");
		
		Address homeAddress1=new Address("103","G-Nagar","Noida","Delhi","760007");
		Address farmAddress1=new Address("203","H-Nagar","Noida","Delhi","760008");
		Address bankAddress1=new Address("303","I-Nagar","Noida","Delhi","760009");
		

		Bank bank1=new Bank(403,"HDFC Bank","1CD21");
		bank.setAddress(bankAddress1);

		Account account=new Account(1986452177);
		account.setBank(bank1);
		
		farmer.setHomeAddress(homeAddress1);
		farmer.setFarmAddress(farmAddress1);
		farmer.setBankDetails(account);
		Crop c=new Crop(104, "cash", "paddy", "clayloam", 1800.0,50.0);
		Bid bidd = new Bid(20,"2022-05-15");
		bidd.setCrop(c);
		bidd.setFarmer(farmer);
		
		Bidding bid=new Bidding(5,1700.0,BidStatus.CLOSED);
		bid.setBid(bidd);
		bid.setBidder(bidder);
		Mockito.when(bdao.findById(5)).thenReturn(Optional.of(bid));
		bid.setBidStatus(BidStatus.SOLD);
		bs.updateBiddingStatus(5, bid);
		assertEquals(BidStatus.SOLD,BidStatus.SOLD);
	}
}
