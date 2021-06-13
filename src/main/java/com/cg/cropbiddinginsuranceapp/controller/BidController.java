package com.cg.cropbiddinginsuranceapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
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

import com.cg.cropbiddinginsuranceapp.entity.Bid;
import com.cg.cropbiddinginsuranceapp.exception.BidNotFoundException;
import com.cg.cropbiddinginsuranceapp.service.IBidService;

@CrossOrigin
@RestController
@RequestMapping()
public class BidController {
	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(BidController.class);
	/**
	 * AutoWiring the service class to call down the service
	 */
	@Autowired
	IBidService bidService;

	/**
	 * This below function is used to get a specific bid and id as parameter and
	 * redirects to the bid service
	 */
	@GetMapping("/bid/{id}")
	public Bid findById(@PathVariable("id") int bidId) {
		logger.info("Get the bid details By Id ");
		return bidService.findByBidId(bidId);
	}

	/**
	 * This below function is used to get all the bid and redirects to the bid
	 * service
	 */
	@GetMapping("/bid")
	public List<Bid> findAll() {
		logger.info("Find the details of the bid");
		return bidService.findAll();
	}


	/**
	 * This below function is used to delete a specific bid based on the give Id and
	 * redirects to the bid service
	 */
	@DeleteMapping("/bid/{id}")
	public Bid deleteById(@PathVariable("id") int bidId) {
		logger.info("delete the bid By Id");
		return bidService.deleteByBidId(bidId);
	}
	/**
	 * This below function is used to create a new bid and redirects to the bid
	 * service
	 */
	@PostMapping("/bid")
	public Bid addBid(@Valid @RequestBody Bid bid) {
		logger.info("add the details of the bid");
		return bidService.save(bid);
	}

	/**
	 * This below function is used to update a specific values in bid and id as
	 * parameter and redirects to the bid service
	 */
	@PutMapping("/bid/update/{id}")
	public Bid updateBid(@PathVariable("id") int id, @RequestBody Bid bid) {
		logger.info("update the bid details by id");
		return bidService.update(id,bid);
	}

}
