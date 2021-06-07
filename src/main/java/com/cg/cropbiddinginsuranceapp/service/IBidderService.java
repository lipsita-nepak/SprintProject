package com.cg.cropbiddinginsuranceapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.cropbiddinginsuranceapp.entity.Bidder;
import com.cg.cropbiddinginsuranceapp.entity.Crop;


@Service
public interface IBidderService {
	public Bidder addBidder(Bidder  bidder);
	
	public Bidder updateBidder(Bidder  bidder);
	
	public Bidder deleteBidder(int id);

	public List<Bidder> retrieveAllBidders();

	public Bidder retrieveBidderById(int id);

	public List<Crop> getCropList();
}
