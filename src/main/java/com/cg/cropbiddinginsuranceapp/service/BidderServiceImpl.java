package com.cg.cropbiddinginsuranceapp.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cropbiddinginsuranceapp.entity.Bidder;
import com.cg.cropbiddinginsuranceapp.entity.Crop;
import com.cg.cropbiddinginsuranceapp.repository.IBidderRepository;
import com.cg.cropbiddinginsuranceapp.repository.ICropDao;

@Service
public class BidderServiceImpl implements IBidderService {

	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger =LogManager.getLogger(BidderServiceImpl.class);
	
	@Autowired
	IBidderRepository bidRepo;
	
	@Autowired
	ICropDao cRepo;
	
	//adding bidder into database
	@Override
	public Bidder addBidder(Bidder bidder) {

		logger.info("save method");
		return bidRepo.save(bidder);
	}

	//updating bidder in database
	@Override
	public Bidder updateBidder(Bidder bidder) {
		Bidder bid = bidRepo.findById(bidder.getUserId()).get();
		bid.setAadharNumber(bidder.getAadharNumber());
		bid.setBankDetails(bidder.getBankDetails());
		bid.setContactNumber(bidder.getContactNumber());
		bid.setEmailId(bidder.getEmailId());
		bid.setHomeAddress(bidder.getHomeAddress());
		bid.setName(bidder.getName());
		bid.setPanNumber(bidder.getPanNumber());
		bid.setTraderLicence(bidder.getTraderLicence());
		logger.info("update method");
		return bidRepo.save(bid);
	}

	//deleting bidder from database
	
	@Override
	public Bidder deleteBidder(int id) {
		Optional<Bidder> opt = bidRepo.findById(id);
		if (!opt.isPresent()) {
			return null;
		}
		bidRepo.deleteById(id);
		logger.info("delete bidder by id");
		return opt.get();
	}

	//retrieving all bidders from database
	@Override
	public List<Bidder> retrieveAllBidders() {
		logger.info("get all bidders");
		return bidRepo.findAll();
	}

	//retrieving bidder using userId from database
	@Override
	public Bidder retrieveBidderById(int id) {

		Optional<Bidder> opt = bidRepo.findById(id);
		if (!opt.isPresent()) {
			return null;
		}
		logger.info("get bidder by id");
		return opt.get();
	}

	//get all crops
	@Override
	public List<Crop> getCropList() {
		logger.info("get all crops");
		return cRepo.findAll();
	}
}
