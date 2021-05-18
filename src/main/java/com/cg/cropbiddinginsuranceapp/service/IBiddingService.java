package com.cg.cropbiddinginsuranceapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.cg.cropbiddinginsuranceapp.entity.Bidding;

@Service
public interface IBiddingService {
	
	Bidding addBidding(Bidding bidding);
	List<Bidding> retriveAllBidding();
	Bidding updateBiddingStatus(int id,Bidding bidding);
	Bidding findById(int id);
}
