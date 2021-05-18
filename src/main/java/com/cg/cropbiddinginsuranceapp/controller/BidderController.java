package com.cg.cropbiddinginsuranceapp.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.cropbiddinginsuranceapp.entity.*;
import com.cg.cropbiddinginsuranceapp.controller.BidderController;
import com.cg.cropbiddinginsuranceapp.exception.PersonNotFoundException;
import com.cg.cropbiddinginsuranceapp.service.IBidderService;

@RestController
public class BidderController {
	
	Logger logger = LogManager.getLogger(BidderController.class);
	@Autowired
	IBidderService bidService;
	
	//getting bidder using userId
	
	@GetMapping("/bidder/{id}")
	public Bidder retrieveBidderById(@PathVariable("id") int id)
	{
		logger.info("Bidder Service Instantiated");
		if(bidService.retrieveBidderById(id)==null)
		{
			throw new PersonNotFoundException("Bidder not found");
		}
		return bidService.retrieveBidderById(id);
	}
	
	//getting all bidders from database
	
	@GetMapping("/bidder")
	public List<Bidder> retrieveAllBidders()
	{
		
		return bidService.retrieveAllBidders();
	}
	
	//adding bidder 
	
	@PostMapping("/bidder")
	public Bidder addBidder(@RequestBody Bidder  bidder)
	{
		return bidService.addBidder(bidder);
	}
	
	//deleting bidder
	
	@DeleteMapping("/bidder/{id}")
	public Bidder deleteBidder(@PathVariable("id") int id)
	{
		return bidService.deleteBidder(id);
	}

	//updating the bidder
	
	@PutMapping("/bidder/{id}") 
	public Bidder updateBidder(@PathVariable("id") int id, @RequestBody Bidder bidder) 
	{
		return bidService.updateBidder(bidder);
	}
	
}
