package com.cg.cropbiddinginsuranceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cropbiddinginsuranceapp.entity.Bidder;

@Repository
public interface IBidderRepository extends JpaRepository<Bidder, Integer>{

	
}
