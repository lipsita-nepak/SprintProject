package com.cg.cropbiddinginsuranceapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cropbiddinginsuranceapp.entity.Address;

import com.cg.cropbiddinginsuranceapp.exception.PersonNotFoundException;
import com.cg.cropbiddinginsuranceapp.service.IAddressService;
import com.cg.cropbiddinginsuranceapp.service.IBidderService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping()
public class AddressController {

	//logger
	Logger logger = LogManager.getLogger(BidderController.class);
	
	@Autowired
	IAddressService addService;

  //getting bidder using userId
	
	@GetMapping("/address/{id}")
	public Address retrieveAddressById(@PathVariable("id") int id) {
		logger.info("address Service Instantiated");
		if (addService.retrieveAddressById(id) == null) {
			throw new PersonNotFoundException("Address not found");
		}
		logger.info("view address by id "+id);
		return addService.retrieveAddressById(id);
	}
	
	//getting all address from database
	@GetMapping("/address")
	public List<Address> retrieveAllAddress() {

		logger.info("get all address");
		return addService.retrieveAllAddress();
	}

	//adding address
	@PostMapping("/address")
	public Address addAddress(@Valid @RequestBody Address address) {
		logger.info("New address added");
		return addService.addAddress(address);
	}

  //deleting address
	@DeleteMapping("/address/{id}")
	public Address deleteAddress(@PathVariable("id") int id) {
		if (addService.retrieveAddressById(id) == null) {
			throw new PersonNotFoundException("Address not found");
		}
		logger.info("address deleted with id "+id);
		return addService.deleteAddress(id);
	}
  
	//updating the address
	
	@PutMapping("/address/{id}") 
	public Address updateAddress(@PathVariable("id") int id, @Valid @RequestBody Address address) 
	{
		logger.info("Address updated with id "+id);
		return addService.updateAddress(address);
	}

	
}
