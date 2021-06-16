package com.cg.cropbiddinginsuranceapp.service;

import com.cg.cropbiddinginsuranceapp.dto.LoginDto;
import com.cg.cropbiddinginsuranceapp.entity.LoginEntity;

public interface ILoginService {
	/*
	 * Login User
	 */
	LoginDto login(LoginEntity user);
/*
 * Logout User
 */
	String logout(String userId);

}
