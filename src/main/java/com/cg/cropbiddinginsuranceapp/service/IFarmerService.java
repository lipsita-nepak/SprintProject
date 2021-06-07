package com.cg.cropbiddinginsuranceapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.cropbiddinginsuranceapp.entity.Crop;
import com.cg.cropbiddinginsuranceapp.entity.Farmer;

@Service
public interface IFarmerService {
	
	public Farmer addFarmer(Farmer farmer);

	public Farmer updateFarmer(int id, Farmer farmer);

	public Farmer deleteFarmerById(int id);

	public List<Farmer> retrieveAllFarmers();

	public Farmer retrieveFarmerById(int id);
	

}
