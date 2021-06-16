package com.cg.cropbiddinginsuranceapp.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.cropbiddinginsuranceapp.dto.LoginDto;
import com.cg.cropbiddinginsuranceapp.entity.LoginEntity;
import com.cg.cropbiddinginsuranceapp.exception.InvalidCredentialsException;
import com.cg.cropbiddinginsuranceapp.exception.UserNotFoundException;
import com.cg.cropbiddinginsuranceapp.repository.ILoginRepository;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	ILoginRepository loginRepo;
	
	


	@Override
	public LoginDto login(LoginEntity user)throws UserNotFoundException,InvalidCredentialsException {
		Optional<LoginEntity> dbUsr = loginRepo.findById(user.getUserId());
		if (!dbUsr.isPresent() ) {
			throw new UserNotFoundException("User not found with a given id :"+user.getUserId());
		}
		LoginEntity login = dbUsr.get();
		LoginDto loginDto=new LoginDto();
		if(user.getPassword().equals(login.getPassword()) && user.getUserRole().equals(login.getUserRole())) {
			login.setLoggedIn(true);
			loginRepo.save(login);	
			loginDto.setUserId(login.getUserId());
			loginDto.setUserRole(login.getUserRole());
			loginDto.setLoggedIn(true);
		}
		else {
			throw new InvalidCredentialsException("UserId or Password is Invalid");
		}
		return loginDto;
		
	}
	
	@Override
	public String logout(String userid) {
		Optional<LoginEntity> userfield = loginRepo.findById(userid);
		LoginEntity dbUsr = null;
		if (userfield.isPresent()) {
			dbUsr = userfield.get();
		}
		if (dbUsr != null && dbUsr.getUserId().equals(userid) && dbUsr.isLoggedIn()) {

			dbUsr.setLoggedIn(false);
			loginRepo.save(dbUsr);
			return "logout successfully";
		}
		throw new UserNotFoundException("User not logged in");
	}
	
	
}