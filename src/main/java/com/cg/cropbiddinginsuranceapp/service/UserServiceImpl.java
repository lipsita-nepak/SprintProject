package com.cg.cropbiddinginsuranceapp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.cropbiddinginsuranceapp.entity.UserEntity;
import com.cg.cropbiddinginsuranceapp.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserRepository regRepo;
/**
 * creating a user in database
 * 
 */
	@Override
	public UserEntity createUser(UserEntity user){
		return regRepo.save(user);

	}

	@Override
	public UserEntity findUserByUserId(String userid) {
		Optional<UserEntity> optional = regRepo.findById(userid);
		if (!optional.isPresent()) {
			return null;
		}

		return optional.get();
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return regRepo.findAll();
	}

	@Override
	public UserEntity updateUser(UserEntity user) {
		UserEntity dbUser = getUser(user);
		if (isNullOrEmpty(dbUser.getFirstname())) {
			dbUser.setFirstname(user.getFirstname());
		}
		if (isNullOrEmpty(dbUser.getLastname())) {
			dbUser.setLastname(user.getLastname());
		}
		if (isNullOrEmpty(dbUser.getEmail())) {
			dbUser.setEmail(user.getEmail());
		}
		if (isNullOrEmpty(dbUser.getPassword())) {
			dbUser.setPassword(user.getPassword());
		}
		if (isNullOrEmpty(dbUser.getMobileNumber())) {
			dbUser.setMobileNumber(user.getMobileNumber());
		}
		return regRepo.save(dbUser);
	}

	private boolean isNullOrEmpty(String value) {
		return value != null && !value.equals("");
	}

	private UserEntity getUser(UserEntity user) {
		Optional<UserEntity> userfield = regRepo.findById(user.getUserid());
		UserEntity dbUser=null;
		if (userfield.isPresent()) {
			dbUser = userfield.get();
		}
		return dbUser;
	}

	@Override
	public UserEntity deleteUserByUserId(String userid) {
		Optional<UserEntity> optional = regRepo.findById(userid);
		if (!optional.isPresent()) {
			return null;
		}
		regRepo.deleteById(userid);
		return optional.get();
	}

	
}
