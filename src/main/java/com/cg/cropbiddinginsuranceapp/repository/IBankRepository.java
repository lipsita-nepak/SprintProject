package com.cg.cropbiddinginsuranceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cg.cropbiddinginsuranceapp.entity.Bank;

@RepositoryRestResource(collectionResourceRel="bank", path="bank")
public interface IBankRepository extends JpaRepository<Bank, Long> {

}
