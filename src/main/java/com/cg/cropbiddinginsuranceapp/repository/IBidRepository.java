package com.cg.cropbiddinginsuranceapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cropbiddinginsuranceapp.entity.Bid;

// Spring Data JPA
@Repository
	public interface IBidRepository extends JpaRepository<Bid, Integer > {

	

	
	}

