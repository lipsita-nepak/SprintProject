package com.cg.cropbiddinginsuranceapp.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.cropbiddinginsuranceapp.entity.Farmer;
import com.cg.cropbiddinginsuranceapp.exception.FarmerNotFoundException;
import com.cg.cropbiddinginsuranceapp.service.IFarmerService;

import lombok.extern.log4j.Log4j2;

@CrossOrigin
@RestController
@Log4j2
public class FarmerController {
	
	
	// AutoWiring the service class to call down the service

	@Autowired
	IFarmerService farmerService; 

	// Read Operation

	// Getting all farmers from database
	@GetMapping("/farmer")
	public ResponseEntity<List<Farmer>> retrieveAllFarmers() {
		log.info("Getting all Farmers from database");
		return new ResponseEntity<>(farmerService.retrieveAllFarmers(), HttpStatus.OK);

	}

	// Getting Farmer based on given userId
	@GetMapping("/farmer/{id}")
	public ResponseEntity<Farmer> retrieveFarmerById(@PathVariable("id") int userId) {
		
		// If farmer of given userId is not there then it throws an Exception
		if (farmerService.retrieveFarmerById(userId) == null) { 
			log.error("Cannot display as Farmer not found with id: " + userId);
			throw new FarmerNotFoundException("Farmer not found with given id: " + userId);
		}
		log.info("Getting Farmer info with id: " + userId);
		
		// If farmer of given userId is there then it displays that farmer dtls
		return new ResponseEntity<>(farmerService.retrieveFarmerById(userId),HttpStatus.OK);
	}

	// Write operation

	// Adding a new farmer into the database
	@PostMapping("/farmer")
	public ResponseEntity<Farmer> addFarmer(@Valid @RequestBody Farmer farmer) {
		log.info("Adding a new Farmer into database");
		return new ResponseEntity<>(farmerService.addFarmer(farmer),HttpStatus.OK);
	}

	// Update Operation

	// Updating Farmer Information based on userId and data given
	@PutMapping("/farmer/{id}")
	public ResponseEntity<Farmer> updateFarmer(@PathVariable("id") int userId, @Valid @RequestBody Farmer farmer) {
		
		// If farmer of given userId is not there then it throws an Exception
		if (farmerService.retrieveFarmerById(userId) == null) {
			log.error("Cannot Update as Farmer not found with id: " + userId);
			throw new FarmerNotFoundException("Farmer not found with given id: " + userId);
		}
		log.info("Updating Farmer info with id: " + userId);
		
		// If farmer of given userId is there then it updates that farmer dtls and displays the updated farmer dtls
		return new ResponseEntity<>(farmerService.updateFarmer(userId, farmer),HttpStatus.OK);
	}

	// Delete Operation

	// Deleting a Farmer of given uerId
	@DeleteMapping("/farmer/{id}")
	public ResponseEntity<Farmer> deleteFarmer(@PathVariable("id") int userId) {
		
		// If farmer of given userId is not there then it throws an Exception
		if (farmerService.retrieveFarmerById(userId) == null) {
			log.error("Cannot Delete as Farmer not found with id: " + userId);
			throw new FarmerNotFoundException("Farmer not found with given id: " + userId);
		}
		log.info("Deleting the Farmer info with id: " + userId);
		
		// If farmer of given userId is there then it deletes that farmer and displays the deleted farmer dtls
		return new ResponseEntity<>(farmerService.deleteFarmerById(userId),HttpStatus.OK);
	}
}
