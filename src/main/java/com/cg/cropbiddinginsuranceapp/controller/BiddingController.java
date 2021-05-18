package com.cg.cropbiddinginsuranceapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cropbiddinginsuranceapp.entity.Bidding;
import com.cg.cropbiddinginsuranceapp.exception.BidNotFoundException;
import com.cg.cropbiddinginsuranceapp.service.IBiddingService;


@RestController
public class BiddingController {
	@Autowired
	IBiddingService bs;
	
	@PostMapping("/bidding")
	public Bidding addBidding(@RequestBody Bidding bidding)
	{
		return bs.addBidding(bidding);
	}
	
	@GetMapping("/bidding")
	public List<Bidding> retrieveAll()
	{
		return bs.retriveAllBidding();
	}
	
	@GetMapping("/bidding/id/{id}")
	public Bidding retrieveById(@PathVariable("id")int id)
	{
		if(bs.findById(id)==null)
		{
			throw new BidNotFoundException("Bid not found with given id: "+id);
		}
		return bs.findById(id);
	}
	
	@PatchMapping("/bidding/status/{id}")
	public Bidding updateStatusById(@PathVariable("id") int id, @RequestBody Bidding bidding) {
		if(bs.findById(id)==null)
		{
			throw new BidNotFoundException("Bid not found with given id: "+id);
		}
		return bs.updateBiddingStatus(id, bidding);
	}

}
