package com.cg.cropbiddinginsuranceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cg.cropbiddinginsuranceapp.entity.Account;


@RepositoryRestResource(collectionResourceRel="account", path="account")
public interface IAccountRepository extends JpaRepository<Account, Long> {

}
