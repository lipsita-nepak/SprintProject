package com.cg.cropbiddinginsuranceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cropbiddinginsuranceapp.entity.UserEntity;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, String> {

}
