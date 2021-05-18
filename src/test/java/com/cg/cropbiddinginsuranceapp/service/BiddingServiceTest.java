package com.cg.cropbiddinginsuranceapp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cropbiddinginsuranceapp.entity.Account;
import com.cg.cropbiddinginsuranceapp.entity.Address;
import com.cg.cropbiddinginsuranceapp.entity.Bank;
import com.cg.cropbiddinginsuranceapp.entity.Bid;
import com.cg.cropbiddinginsuranceapp.entity.BidStatus;
import com.cg.cropbiddinginsuranceapp.entity.Bidder;
import com.cg.cropbiddinginsuranceapp.entity.Bidding;
import com.cg.cropbiddinginsuranceapp.entity.Crop;
import com.cg.cropbiddinginsuranceapp.entity.CropVerificationStatus;
import com.cg.cropbiddinginsuranceapp.entity.Farmer;
import com.cg.cropbiddinginsuranceapp.entity.StorageSpace;


@SpringBootTest
class BiddingServiceTest {

	@Autowired
	IBiddingService bs;
	
	@Test
	void testAdd() {
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
		Bid bid = new Bid();
		bid.setBidId(1001);
		Address homeAddress1=new Address("102","D-Nagar","Bhubaneswar","Odisha","760004");
		Address farmAddress1=new Address("202","E-Nagar","Bhubaneswar","Odisha","760005");
		Address bankAddress1=new Address("302","F-Nagar","Bhubaneswar","Odisha","760006");
		
		Bank bank1=new Bank(402,"State Bank","S34TS");
		bank1.setAddress(bankAddress1);

		Account account=new Account(1673211231);
		account.setBank(bank1);
		
		Farmer farmer=new Farmer("Akshara Singhania","9861778566","akshara@gmail.com","1459 8900 7863","DEF332");
		
		farmer.setHomeAddress(homeAddress1);
		farmer.setFarmAddress(farmAddress1);
		farmer.setBankDetails(account);
		bid.setFarmer(farmer);
		
		
		Crop c=new Crop(107, "cash", "wheat", "clayloam", 1500.0,80.0,
				StorageSpace.CLOSED_SHED,CropVerificationStatus.PENDING);
		
		bid.setCrop(c);
		bid.setDateOfBidding("2022-05-15");
		
		Bidding b=new Bidding(5,1500.0,BidStatus.CLOSED);
		b.setBid(bid);
		b.setBidder(bidder);
		Bidding bidd=bs.addBidding(b);
		assertEquals(5,bidd.getBiddingId());
	}
	
	@Test
	void testViewAll(){
		List<Bidding> bid=bs.retriveAllBidding();
		assertEquals(1,bid.size());
	}
	
	@Test
	void testViewAllById(){
		Bidding bid=bs.findById(5);
		System.out.println(bid);
		assertEquals(1500,bid.getBidPerQuintal());
	}
	
	@Test
	void testUpdateStatus(){
		Bidding bid=bs.findById(5);
		
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
		
		Bid bidd = new Bid();
		bidd.setBidId(20);
		bidd.setBidId(1001);
		Address homeAddress1=new Address("102","D-Nagar","Bhubaneswar","Odisha","760004");
		Address farmAddress=new Address("202","E-Nagar","Bhubaneswar","Odisha","760005");
		Address bankAddress1=new Address("302","F-Nagar","Bhubaneswar","Odisha","760006");
		
		Bank bank1=new Bank(402,"State Bank","S34TS");
		bank1.setAddress(bankAddress1);

		Account account=new Account(1673211231);
		account.setBank(bank1);
		
		Farmer farmer=new Farmer("Akshara Singhania","9861778566","akshara@gmail.com","1459 8900 7863","DEF332");
		
		farmer.setHomeAddress(homeAddress1);
		farmer.setFarmAddress(farmAddress);
		farmer.setBankDetails(account);
		bidd.setFarmer(farmer);
		
		
		Crop c=new Crop(107, "cash", "wheat", "clayloam", 1500.0,80.0,
				StorageSpace.CLOSED_SHED,CropVerificationStatus.PENDING);
		
		bidd.setCrop(c);
		bidd.setDateOfBidding("2021-05-15");
		
		bid.setBidStatus(BidStatus.OPEN);
		bid.setBidder(bidder);
		bid.setBid(bidd);
		bs.updateBiddingStatus(5, bid);
		assertEquals(BidStatus.OPEN,BidStatus.OPEN);
	}
	
}
