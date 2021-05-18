package com.cg.cropbiddinginsuranceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cropbiddinginsuranceapp.entity.Bidding;

@Repository
public interface IBiddingDao extends JpaRepository<Bidding, Integer >{

}
