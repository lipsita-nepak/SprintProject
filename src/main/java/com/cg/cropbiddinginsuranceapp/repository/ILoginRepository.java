package com.cg.cropbiddinginsuranceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.cropbiddinginsuranceapp.entity.LoginEntity;

@Repository
public interface ILoginRepository extends JpaRepository<LoginEntity, String> {

}
