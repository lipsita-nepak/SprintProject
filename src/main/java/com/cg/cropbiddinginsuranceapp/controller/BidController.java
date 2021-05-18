package com.cg.cropbiddinginsuranceapp.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cropbiddinginsuranceapp.entity.Bid;
import com.cg.cropbiddinginsuranceapp.entity.BidErrorResponse;
import com.cg.cropbiddinginsuranceapp.exception.BidNotFoundException;
import com.cg.cropbiddinginsuranceapp.service.IBidService;

@RestController
public class BidController {
	
		
		@Autowired
		IBidService bidService;

		// create method to handle exception and annotate with @ExceptionHandler
		
		@ExceptionHandler
		public ResponseEntity<BidErrorResponse> handleException(BidNotFoundException exception){
		BidErrorResponse error = new BidErrorResponse();
			
		error.setStatus(HttpStatus.NOT_FOUND.value()); //404
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}
		
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
		public Bid addBid(@Valid @RequestBody Bid bid) {
			return bidService.save(bid);
		}

		/*// Updating specific property
		@PatchMapping("bid")
		public Bid updateBid(@PathVariable("id") int id, Bid bid) {
			return new Bid();
		}*/

		// Updating all the values
		@PutMapping("/bid/{id}")
		public Bid putBid(@PathVariable("id") int bidId,Bid bid) {
			return bidService.update(bid);
		}

}
