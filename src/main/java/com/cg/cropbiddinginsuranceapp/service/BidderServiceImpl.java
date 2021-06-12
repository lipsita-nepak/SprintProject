package com.cg.cropbiddinginsuranceapp.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cropbiddinginsuranceapp.entity.Address;
import com.cg.cropbiddinginsuranceapp.entity.Bank;
import com.cg.cropbiddinginsuranceapp.entity.Bid;
import com.cg.cropbiddinginsuranceapp.entity.Bidder;
import com.cg.cropbiddinginsuranceapp.entity.Crop;
import com.cg.cropbiddinginsuranceapp.entity.Farmer;
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
	
	Optional<Crop> c;

	Optional<Bidder> b;
	
	
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
		bid.setContactNumber(bidder.getContactNumber());
		bid.setEmailId(bidder.getEmailId());
		bid.setName(bidder.getName());
		bid.setPanNumber(bidder.getPanNumber());
		bid.setTraderLicence(bidder.getTraderLicence());
		bid.setCity(bidder.getCity());	
		bid.setState(bidder.getState());
		bid.setPincode(bidder.getPincode());
		bid.setAccountNumber(bidder.getAccountNumber());
		bid.setBankName(bidder.getBankName());
		bid.setIfscCode(bidder.getIfscCode());
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

	@Override
	public Bidder addCropForBidding(int bidderId, int cropId) {
		b = bidRepo.findById(bidderId);
		c = cRepo.findById(cropId);
		if(!b.isPresent() || !c.isPresent()) {
			return null;
		}
		Bidder bidder= b.get();
		Crop crop=c.get();
		bidder.getCrops().add(crop);
		crop.getBiddersList().add(bidder);
		return bidRepo.save(bidder);
	}
	
	@Override
	public Bidder addBidByBidderId(int bidderId, Bid bid) {
		b = bidRepo.findById(bidderId);
		if(!b.isPresent()) {
			return null;
		}
		Bidder bidder=b.get();
		
		bidder.setBid(bid);
		return bidRepo.save(bidder);
		
	}

	
	
		
}
