package com.cg.cropbiddinginsuranceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cropbiddinginsuranceapp.entity.Farmer;


@Repository
public interface IFarmerRepository extends JpaRepository<Farmer, Integer> {

}
