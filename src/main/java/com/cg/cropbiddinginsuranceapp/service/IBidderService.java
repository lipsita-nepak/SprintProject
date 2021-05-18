package com.cg.cropbiddinginsuranceapp.service;

import java.util.List;

import com.cg.cropbiddinginsuranceapp.entity.Bidder;

public interface IBidderService {
	public Bidder addBidder(Bidder bidder);

	public Bidder updateBidder(Bidder bidder);

	public Bidder deleteBidder(int id);

	public List<Bidder> retrieveAllBidders();

	public Bidder retrieveBidderById(int id);

}
