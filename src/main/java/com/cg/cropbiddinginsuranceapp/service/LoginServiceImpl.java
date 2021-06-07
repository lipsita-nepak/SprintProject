package com.cg.cropbiddinginsuranceapp.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cropbiddinginsuranceapp.entity.LoginEntity;
import com.cg.cropbiddinginsuranceapp.exception.UserNotFoundException;
import com.cg.cropbiddinginsuranceapp.repository.ILoginRepository;

@Service
public class LoginServiceImpl implements ILoginService {
	
	@Autowired
	ILoginRepository loginRepo;
	


	@Override
	public String login(LoginEntity user) {
		Optional<LoginEntity> dbUsr = loginRepo.findById(user.getUserid());
		String message = null;
		if (!dbUsr.isPresent() || !dbUsr.get().isLoggedIn()) {
			user.setLoggedIn(true);
			loginRepo.save(user);
			message = "Succesfully logged in " + user.getUserid();
		} else {
			message = "Already logged in " + user.getUserid();
		}

		return message;
	}

	@Override
	public String logout(String userId) {
		Optional<LoginEntity> userfield = loginRepo.findById(userId);
		LoginEntity dbUsr = null;
		if (userfield.isPresent()) {
			dbUsr = userfield.get();
		}
		if (dbUsr != null && dbUsr.getUserid().equals(userId) && dbUsr.isLoggedIn()) {

			dbUsr.setLoggedIn(false);
			loginRepo.save(dbUsr);
			return "logout successfully";
		}
		throw new UserNotFoundException("User not logged in");
	}
	

}
