package com.cg.cropbiddinginsuranceapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cropbiddinginsuranceapp.entity.Bidder;
import com.cg.cropbiddinginsuranceapp.repository.IBidderRepository;



@Service
public class BidderServiceImpl implements IBidderService {

	@Autowired
	IBidderRepository bidRepo;
	
	@Override
	public Bidder addBidder(Bidder bidder) {
		
		return bidRepo.save(bidder);
	}

	@Override
	public Bidder updateBidder(Bidder bidder) {
		Bidder bid=bidRepo.findById(bidder.getUserId()).get();
		bid.setAadharNumber(bidder.getAadharNumber());
		bid.setBankDetails(bidder.getBankDetails());
		bid.setContactNumber(bidder.getContactNumber());
		bid.setEmailId(bidder.getEmailId());
		bid.setHomeAddress(bidder.getHomeAddress());
		bid.setName(bidder.getName());
		bid.setPanNumber(bidder.getPanNumber());
		bid.setTraderLicence(bidder.getTraderLicence());
		
		return bidRepo.save(bid);
	}

	@Override
	public Bidder deleteBidder(int id) {
		Bidder bid =bidRepo.findById(id).get();
		bidRepo.deleteById(id);
		return bid;
	}

	@Override
	public List<Bidder> retrieveAllBidders() {
		
		return bidRepo.findAll();
	}

	@Override
	public Bidder retrieveBidderById(int id) {
		
		Optional<Bidder> opt=bidRepo.findById(id);
		if(!opt.isPresent())
		{
			return null;
		}
		return opt.get();
	}

}
