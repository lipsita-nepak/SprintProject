package com.cg.cropbiddinginsuranceapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.cropbiddinginsuranceapp.entity.Address;
import com.cg.cropbiddinginsuranceapp.entity.Bank;
import com.cg.cropbiddinginsuranceapp.entity.Bidder;
import com.cg.cropbiddinginsuranceapp.entity.Crop;
import com.cg.cropbiddinginsuranceapp.entity.Farmer;

@Service
public interface IFarmerService {
	
	public Farmer addFarmer(Farmer farmer);

	public Farmer updateFarmer(int id, Farmer farmer);

	public Farmer deleteFarmerById(int id);

	public List<Farmer> retrieveAllFarmers();

	public Farmer retrieveFarmerById(int id);
	
	public Farmer addCropForBidding(int farmerId,int cropId);
	
	public Farmer addCropByFarmerId(int farmerId,Crop crop);
	
	public Farmer retrieveFarmerByName(String name);
	
	public Farmer addFarmerAddress(int farmerId, Address address);
	
	public Farmer addFarmerBankDetails(int farmerId,Bank bank);

	

}
