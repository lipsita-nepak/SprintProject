package com.cg.cropbiddinginsuranceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cg.cropbiddinginsuranceapp.entity.Address;


@RepositoryRestResource(collectionResourceRel="address", path="address")
public interface IAddressRepository extends JpaRepository<Address, String> {

}
