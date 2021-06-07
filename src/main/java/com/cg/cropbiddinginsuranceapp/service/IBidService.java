package com.cg.cropbiddinginsuranceapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.cg.cropbiddinginsuranceapp.entity.Bid;

@Service
public interface IBidService {

	Bid findByBidId(int id);
	List<Bid> findAll();

	Bid update(Bid bid);

	Bid save(Bid bid);

	Bid deleteByBidId(int id);
	
}
