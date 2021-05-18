package com.cg.cropbiddinginsuranceapp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cropbiddinginsuranceapp.entity.Account;
import com.cg.cropbiddinginsuranceapp.entity.Address;
import com.cg.cropbiddinginsuranceapp.entity.Bank;
import com.cg.cropbiddinginsuranceapp.entity.Bid;
import com.cg.cropbiddinginsuranceapp.entity.Crop;
import com.cg.cropbiddinginsuranceapp.entity.CropVerificationStatus;
import com.cg.cropbiddinginsuranceapp.entity.Farmer;
import com.cg.cropbiddinginsuranceapp.entity.StorageSpace;

@SpringBootTest
class BidServiceTest {
@Autowired
IBidService bidService;

	@Test
@Disabled
	void testSaveBid() {
		Bid bid = new Bid();
		bid.setBidId(1001);
		Address homeAddress=new Address("102","D-Nagar","Bhubaneswar","Odisha","760004");
		Address farmAddress=new Address("202","E-Nagar","Bhubaneswar","Odisha","760005");
		Address bankAddress=new Address("302","F-Nagar","Bhubaneswar","Odisha","760006");
		
		Bank bank=new Bank(402,"State Bank","S34TS");
		bank.setAddress(bankAddress);

		Account account=new Account(1673211231);
		account.setBank(bank);
		
		Farmer farmer=new Farmer("Akshara Singhania","9861778566","akshara@gmail.com","145989007863","DEF332");
		
		farmer.setHomeAddress(homeAddress);
		farmer.setFarmAddress(farmAddress);
		farmer.setBankDetails(account);
		bid.setFarmer(farmer);
		
		
		Crop c=new Crop(107, "cash", "wheat", "clayloam", 1500.0,80.0,
				StorageSpace.CLOSED_SHED,CropVerificationStatus.PENDING);
		
		bid.setCrop(c);
		bid.setDateOfBidding("2022-05-15");
		Bid persistedBid = bidService.save(bid);
		assertEquals(1001,persistedBid.getBidId());
	}
	
	@Test
@Disabled
	void testDeleteBid() {
		Bid bid = bidService.deleteByBidId(1001);
		assertEquals(1001,bid.getBidId());
		
}
	
	@Test
	
	void testUpdateBid() {
		Bid bid = new Bid();
		bid.setBidId(20);
		bid.setBidId(1001);
		Address homeAddress=new Address("102","D-Nagar","Bhubaneswar","Odisha","760004");
		Address farmAddress=new Address("202","E-Nagar","Bhubaneswar","Odisha","760005");
		Address bankAddress=new Address("302","F-Nagar","Bhubaneswar","Odisha","760006");
		
		Bank bank=new Bank(402,"State Bank","S34TS");
		bank.setAddress(bankAddress);

		Account account=new Account(1673211231);
		account.setBank(bank);
		
		Farmer farmer=new Farmer("Akshara Singhania","9861778566","akshara@gmail.com","145989007863","DEF332");
		
		farmer.setHomeAddress(homeAddress);
		farmer.setFarmAddress(farmAddress);
		farmer.setBankDetails(account);
		bid.setFarmer(farmer);
		
		
		Crop c=new Crop(107, "cash", "wheat", "clayloam", 1500.0,80.0,
				StorageSpace.CLOSED_SHED,CropVerificationStatus.PENDING);
		
		bid.setCrop(c);
		bid.setDateOfBidding("2021-05-15");
		Bid persistedBid = bidService.update(bid);
		assertEquals("2021-05-15",persistedBid.getDateOfBidding());
	}
	
	@Test
	@Disabled
	void testRetrieveBid() {
		List<Bid> bid = bidService.findAll();
		
		assertEquals(1,bid.size());
	}
	
	@Test
	
	void testRetrieveBidById() {
		Bid bid = bidService.findByBidId(1001);
		assertEquals(1001,bid.getBidId());
		}
		
}


