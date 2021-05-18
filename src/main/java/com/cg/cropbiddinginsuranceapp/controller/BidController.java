package com.cg.cropbiddinginsuranceapp.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cropbiddinginsuranceapp.entity.Bid;
import com.cg.cropbiddinginsuranceapp.exception.BidNotFoundException;
import com.cg.cropbiddinginsuranceapp.service.IBidService;

@RestController
public class BidController {
	
		
		@Autowired
		IBidService bidService;
		
		@GetMapping("/bid/{id}")
		public Bid findById(@PathVariable("id") int bidId) {
				if(bidService.findByBidId(bidId)==null) {
					throw new BidNotFoundException("Bid not found with given id: "+bidId );
				}
			
					return bidService.findByBidId(bidId);
		}

		
		// To get either single user or all the users
		@GetMapping("/bid")
		public List<Bid> findAll(){
			return bidService.findAll();
		}

		@DeleteMapping("/bid/{id}")
		public Bid deleteById(@PathVariable("id") int bidId) {
			return bidService.deleteByBidId(bidId);
		}

		@PostMapping("/bid")
		public Bid addBid(@RequestBody Bid bid) {
			return bidService.save(bid);
		}

		// Updating all the values
		@PutMapping("/bid/{id}")
		public Bid putBid(@PathVariable("id") int bidId,Bid bid) {
			return bidService.update(bid);
		}

}
