package com.cg.cropbiddinginsuranceapp.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.cropbiddinginsuranceapp.entity.*;
import com.cg.cropbiddinginsuranceapp.controller.BidderController;
import com.cg.cropbiddinginsuranceapp.exception.FarmerNotFoundException;
import com.cg.cropbiddinginsuranceapp.exception.PersonNotFoundException;
import com.cg.cropbiddinginsuranceapp.service.IBidderService;
import javax.validation.Valid;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping()
public class BidderController {

	//logger
	Logger logger = LogManager.getLogger(BidderController.class);
	
	@Autowired
	IBidderService bidService;

  //getting bidder using userId
	
	@GetMapping("/bidder/{id}")
	public ResponseEntity<Bidder> retrieveBidderById(@PathVariable("id") int id) {
		logger.info("Bidder Service Instantiated");
		if (bidService.retrieveBidderById(id) == null) {
			throw new PersonNotFoundException("Bidder not found");
		}
		logger.info("view bidder by id "+id);
		return new ResponseEntity<>(bidService.retrieveBidderById(id),HttpStatus.OK);
	}
	
	//getting all bidders from database
	@GetMapping("/bidder")
	public List<Bidder> retrieveAllBidders() {

		logger.info("get all bidders");
		return bidService.retrieveAllBidders();
	}

	//adding bidder 
	@PostMapping("/bidder")
	public ResponseEntity<Bidder> addBidder(@Valid @RequestBody Bidder bidder) {
		logger.info("New bidder added");
		return new ResponseEntity<>(bidService.addBidder(bidder),HttpStatus.OK);
	}

  //deleting bidder
	@DeleteMapping("/bidder/{id}")
	public ResponseEntity<Bidder> deleteBidder(@PathVariable("id") int id) {
		if (bidService.retrieveBidderById(id) == null) {
			throw new PersonNotFoundException("Bidder not found");
		}
		logger.info("bidder deleted with id "+id);
		return new ResponseEntity<>(bidService.deleteBidder(id),HttpStatus.OK);
	}
  
	//updating the bidder
	
	@PutMapping("/bidder/{id}") 
	public Bidder updateBidder(@PathVariable("id") int id, @Valid @RequestBody Bidder bidder) 
	{
		logger.info("bidder updated with id "+id);
		return bidService.updateBidder(bidder);
	}

	//get all crops
	
	@GetMapping("/crop")
	public List<Crop> getCropList() {

		logger.info("get all crops");
		return bidService.getCropList();
	}
	
	//Adding crop for bidding
	
	@PostMapping("/bidder/{bidderId}/crop/{cropId}")
	public ResponseEntity<Bidder> addCropForBidding(@PathVariable("bidderId") int bidderId,@PathVariable("cropId") int cropId,@Valid @RequestBody Crop crop)
	{
		Bidder bidder=bidService.addCropForBidding(bidderId, cropId);
		if (bidder==null) {
			
			throw new PersonNotFoundException("Bidder not found with given id: " + bidderId);
		}
		
		return new ResponseEntity<>(bidder,HttpStatus.OK);
	}
	
	//adding bid using bidderId
	@PostMapping("/bidder/{bidderId}/bid")
	public ResponseEntity<Bidder> addBidByBidderId(@PathVariable("bidderId") int bidderId,@Valid @RequestBody Bid bid)
	{
		Bidder bidder=bidService.addBidByBidderId(bidderId, bid);
		if (bidder==null) {
					
			throw new PersonNotFoundException("Person not found with given id: " + bidderId);
		}	
		return new ResponseEntity<>(bidder,HttpStatus.OK);
	}
	
	

}
