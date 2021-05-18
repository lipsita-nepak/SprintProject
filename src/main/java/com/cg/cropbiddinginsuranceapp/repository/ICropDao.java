package com.cg.cropbiddinginsuranceapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.cropbiddinginsuranceapp.entity.Crop;

@Repository
public interface ICropDao extends JpaRepository<Crop, Integer >{
	
	//custom method
	Optional<Crop> findByCropName(String cropName);
	
	//Query
	@Query ("select c from Crop c where c.cropName=:n")
	public Crop getCropByName(@Param("n") String cropName);
	
}
