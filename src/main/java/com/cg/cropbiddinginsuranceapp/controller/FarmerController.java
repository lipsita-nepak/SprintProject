package com.cg.cropbiddinginsuranceapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cropbiddinginsuranceapp.entity.Crop;
import com.cg.cropbiddinginsuranceapp.entity.Farmer;
import com.cg.cropbiddinginsuranceapp.exception.FarmerNotFoundException;
import com.cg.cropbiddinginsuranceapp.service.IFarmerService;

@RestController
public class FarmerController {

	@Autowired
	IFarmerService farmerService;

	// Read Operation

	// Getting all farmers from database
	@GetMapping("/farmer")
	public List<Farmer> retrieveAllFarmers() {
		return farmerService.retrieveAllFarmers();
	}

	// Getting Farmer based on given userId
	@GetMapping("/farmer/{id}")
	public Farmer retrieveFarmerById(@PathVariable("id") int userId) {
		if (farmerService.retrieveFarmerById(userId) == null) { // If farmer of given userId is not there then it throws
			// an Exception
			throw new FarmerNotFoundException("Farmer not found with given id: " + userId);
		}
		return farmerService.retrieveFarmerById(userId);
	}

	// Write operation

	// Adding a new farmer into the database
	@PostMapping("/farmer")
	public Farmer addFarmer(@Valid @RequestBody Farmer farmer) {
		return farmerService.addFarmer(farmer);
	}

	// Update Operation

	// Updating Farmer Information based on userId and data given
	@PutMapping("/farmer/{id}")
	public Farmer updateFarmer(@PathVariable("id") int id, @Valid @RequestBody Farmer farmer) {
		return farmerService.updateFarmer(id, farmer);
	}

	// Delete Operation

	// Deleting a Farmer of given uerId
	@DeleteMapping("/farmer/{id}")
	public Farmer deleteFarmer(@PathVariable("id") int userId) {
		return farmerService.deleteFarmerById(userId);
	}
	
	@GetMapping("/crop")
	public List<Crop> getCropList(){
		return farmerService.getCropList();
	}

}
