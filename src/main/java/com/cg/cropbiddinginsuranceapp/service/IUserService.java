package com.cg.cropbiddinginsuranceapp.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.cg.cropbiddinginsuranceapp.entity.UserEntity;

@Service
public interface IUserService {
	
	/**
	 * Retrieves user records with userid
	 * @param userid
	 * @return UserEntity
	 */
	public UserEntity findUserByUserId(String userid);
/**
 * Retrieves user
 * @return
 */
	public List<UserEntity> getAllUsers();
	/**
	 * Creates user record in the entity table
	 * @param UserEntity
	 * @return UserEntity
	 */
	public UserEntity createUser(UserEntity user);

	public UserEntity updateUser(UserEntity user);

	public UserEntity deleteUserByUserId(String userid);


}
