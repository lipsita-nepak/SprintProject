package com.cg.cropbiddinginsuranceapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.cropbiddinginsuranceapp.entity.Crop;
import com.cg.cropbiddinginsuranceapp.entity.Farmer;

@Repository
public interface ICropDao extends JpaRepository<Crop, Integer >{
	
	/**
	 * Custom method to get the crop details by crop name 
	 */
	List<Crop> findAllByCropName(String cropName);
	
	/**
	 * Custom query to get the crop details by crop name
	 */
	/*@Query ("select c from Crop c where c.cropName=:n")
	public Crop getCropByName(@Param("n") String cropName);*/
	
	
}



