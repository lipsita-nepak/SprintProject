package com.cg.cropbiddinginsuranceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.cropbiddinginsuranceapp.entity.Bidder;


public interface IBidderRepository extends JpaRepository<Bidder, Integer>{

	
}
