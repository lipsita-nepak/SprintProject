package com.cg.cropbiddinginsuranceapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cropbiddinginsuranceapp.entity.Bid;
import com.cg.cropbiddinginsuranceapp.repository.IBidRepository;

@Service
public class BidServiceImpl implements IBidService {
	/**
	 * AutoWiring the service class to call down the service
	 */
	@Autowired
	IBidRepository bidRepo;

	/**
	 * This function is used to get the bid by id and redirects to the bid
	 * repository
	 */
	@Override
	public Bid findByBidId(int id) {
		Optional<Bid> opt = bidRepo.findById(id);
		if (!opt.isPresent()) {
			return null;
		}
		return opt.get();
	}

	/**
	 * This function is used to get all the bids and redirects to the bid repository
	 */
	@Override
	public List<Bid> findAll() {
		return bidRepo.findAll();
	}

	/**
	 * This function is used to delete a bid by id and redirects to the bid
	 * repository
	 */
	@Override
	public Bid deleteByBidId(int id) {
		Optional<Bid> opt = bidRepo.findById(id);
		if (!opt.isPresent()) {
			return null;
		}
		return opt.get();
	}

	/**
	 * This function is used to update all the bid by id and redirects to the bid
	 * repository
	 */
	@Override
	public Bid update(Bid bid) {
		Bid bid1 = bidRepo.findById(bid.getBidId()).get();

		bid1.setBidId(bid.getBidId());
		bid1.setDateOfBidding(bid.getDateOfBidding());
		bid1.setBidPerQuintal(bid.getBidPerQuintal());
		bid1.setBidStatus(bid.getBidStatus());
		
		return bidRepo.save(bid1);
	}

	/**
	 * This function is used to save a new bid and redirects to the bid repository
	 */
	@Override
	public Bid save(Bid bid) {
		return bidRepo.save(bid);
	}
}