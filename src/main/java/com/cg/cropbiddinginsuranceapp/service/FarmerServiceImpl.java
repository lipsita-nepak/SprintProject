package com.cg.cropbiddinginsuranceapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cropbiddinginsuranceapp.entity.Address;
import com.cg.cropbiddinginsuranceapp.entity.Bank;
import com.cg.cropbiddinginsuranceapp.entity.Bidder;
import com.cg.cropbiddinginsuranceapp.entity.Crop;

import com.cg.cropbiddinginsuranceapp.entity.Farmer;
import com.cg.cropbiddinginsuranceapp.repository.ICropDao;
import com.cg.cropbiddinginsuranceapp.repository.IFarmerRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class FarmerServiceImpl implements IFarmerService {

	// AutoWiring the repository class to call down the repository
	
	@Autowired
	IFarmerRepository farmerRepo;
	
	@Autowired
	ICropDao cropRepo;
	Optional<Crop> c;

	Optional<Farmer> f;

	

	// Adding Farmer into the DATABASE

	@Override
	public Farmer addFarmer(Farmer farmer) {
		log.info(" Calling save() of farmerRepository");
		return farmerRepo.save(farmer);
	}

	// Retrieve all farmers from DATABASE

	@Override
	public List<Farmer> retrieveAllFarmers() {
		log.info(" Calling findAll() of farmerRepository");
		return farmerRepo.findAll();
	}

	// Retrieve farmers by id

	@Override
	public Farmer retrieveFarmerById(int id) {
		log.info(" Calling findById() of farmerRepository");
		 f = farmerRepo.findById(id);// Getting the farmer info by id and storing in f
		if (!f.isPresent()) {// if farmer is not present of given id then return null
			return null;
		}
		return f.get();// if farmer of given id is present then return the farmer details
	}

	// Updating the farmer details

	@Override
	public Farmer updateFarmer(int id, Farmer farmer) {
		log.info(" Calling findById() of farmerRepository to update");
		f = farmerRepo.findById(id); // Getting the farmer info by id and storing in f
		if (!f.isPresent()) {
			return null;
		}
		// setting the values of each field

		f.get().setName(farmer.getName());
		f.get().setContactNumber(farmer.getContactNumber());
		f.get().setEmailId(farmer.getEmailId());
		f.get().setAadharNumber(farmer.getAadharNumber());
		f.get().setPanNumber(farmer.getPanNumber());
		f.get().setFarmAddress(farmer.getFarmAddress());
		f.get().setCity(farmer.getCity());	
		f.get().setState(farmer.getState());
		f.get().setPincode(farmer.getPincode());
		f.get().setAccountNumber(farmer.getAccountNumber());
		f.get().setBankName(farmer.getBankName());
		f.get().setIfscCode(farmer.getIfscCode());
		
		

		return farmerRepo.save(f.get()); // returning the updated farmer details
	}

	// Delete farmer by id

	@Override
	public Farmer deleteFarmerById(int id) {
		log.info(" Calling findById() of farmerRepository to delete");
	    f = farmerRepo.findById(id);// Getting the farmer info by id and storing in f
		if (!f.isPresent()) { // if farmer is not present of given id then return null
			return null;
		}
		farmerRepo.deleteById(id);
		return f.get(); // if farmer of given id is present then return the deleted farmer details
	}

	@Override
	public Farmer addCropForBidding(int farmerId, int cropId) {
		f = farmerRepo.findById(farmerId);
		c = cropRepo.findById(cropId);
		if(!f.isPresent() || !c.isPresent()) {
			return null;
		}
		Farmer farmer= f.get();
		Crop crop=c.get();
		farmer.getCrops().add(crop);
		crop.getFarmersList().add(farmer);
		return farmerRepo.save(farmer);
	}
	@Override
	public Farmer addCropByFarmerId(int farmerId,Crop crop) {
		f = farmerRepo.findById(farmerId);
		if(!f.isPresent()) {
			return null;
		}
		Farmer farmer=f.get();
		
		farmer.getCrops().add(crop);
		return farmerRepo.save(farmer);
	}
	

	
	// Retrieve farmers by name
	@Override
	public Farmer retrieveFarmerByName(String name) {
		log.info(" Calling findByName() of farmerRepository");
		 f = farmerRepo.findByName(name);// Getting the farmer info by name and storing in f
		if (!f.isPresent()) {// if farmer is not present of given name then return null
			return null;
		}
		return f.get();// if farmer of given name is present then return the farmer details
	}

	

	
}
