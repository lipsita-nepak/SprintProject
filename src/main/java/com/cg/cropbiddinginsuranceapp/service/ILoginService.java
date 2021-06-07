package com.cg.cropbiddinginsuranceapp.service;

import com.cg.cropbiddinginsuranceapp.entity.LoginEntity;

public interface ILoginService {
	/*
	 * Login User
	 */
	String login(LoginEntity user);
/*
 * Logout User
 */
	String logout(String userId);

}

