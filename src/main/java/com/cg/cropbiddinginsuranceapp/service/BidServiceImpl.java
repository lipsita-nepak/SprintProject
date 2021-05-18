package com.cg.cropbiddinginsuranceapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cropbiddinginsuranceapp.entity.Bid;
import com.cg.cropbiddinginsuranceapp.repository.IBidRepository;

@Service
public class BidServiceImpl implements IBidService {

	@Autowired
	IBidRepository bidRepo;
	
	@Override
	public Bid findByBidId(int id) {
		Optional<Bid> opt = bidRepo.findById(id);
		if (!opt.isPresent()) {
			return null;
		}
		return opt.get();
	}
	
		
	@Override
	public List<Bid> findAll() {
		return bidRepo.findAll();
	}

	@Override
	public Bid deleteByBidId(int id) {
		Optional<Bid> opt = bidRepo.findById(id);
		if(!opt.isPresent()) {
			return null;
		}
		return opt.get();
	}

	@Override
	public Bid update(Bid bid) {
		Bid bid1 = bidRepo.findById(bid.getBidId()).get();
	
		bid1.setBidId(bid.getBidId());
		bid1.setDateOfBidding(bid.getDateOfBidding());
		bid1.setCrop(bid.getCrop());
		bid.setFarmer(bid.getFarmer());
		return bidRepo.save(bid1);
	}

	@Override
	public Bid save(Bid bid) {
		return bidRepo.save(bid);
	}
}