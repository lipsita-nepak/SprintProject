package com.cg.cropbiddinginsuranceapp.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cropbiddinginsuranceapp.entity.Bidding;
import com.cg.cropbiddinginsuranceapp.repository.IBiddingDao;

import java.util.List;
import java.util.Optional;



@Service
public class BiddingServiceImpl implements IBiddingService{

	@Autowired
	IBiddingDao bdao;
	
	@Override
	public Bidding addBidding(Bidding bidding) {
		return bdao.save(bidding);
	}

	@Override
	public List<Bidding> retriveAllBidding() {
		return bdao.findAll();
	}

	@Override
	public Bidding updateBiddingStatus(int id,Bidding bidding) {
		Bidding bid=bdao.findById(id).get();
		bid.setBidStatus(bidding.getBidStatus());
		bid.setBidder(bidding.getBidder());
		bid.setBid(bidding.getBid());
		return bdao.save(bid);
	}

	@Override
	public Bidding findById(int id) {
		Optional<Bidding> opt= bdao.findById(id);
		if(!opt.isPresent()) {
			return null;
		}
		return opt.get();
	}

}
