package com.cg.cropbiddinginsuranceapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cropbiddinginsuranceapp.dto.LoginDto;
import com.cg.cropbiddinginsuranceapp.entity.LoginEntity;
import com.cg.cropbiddinginsuranceapp.entity.UserEntity;
import com.cg.cropbiddinginsuranceapp.exception.UserNotFoundException;
import com.cg.cropbiddinginsuranceapp.service.ILoginService;
import com.cg.cropbiddinginsuranceapp.service.IUserService;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoginController {
	/*
	 * Logger
	 */
	Logger logger =LogManager.getLogger(LoginController.class);
	/**
	 * AutoWiring the service class to call down the service
	 */
	@Autowired
	ILoginService loginService;
	@Autowired
	IUserService  userService;
	/*
	 *  performs Login operation
	 */
	@PostMapping("/login")
	public LoginDto Login(@RequestBody LoginEntity loginentity) {
		logger.info("logged in Successfully ");
		return loginService.login(loginentity);
	}
    /*
     * performs logout operation
     */
	@GetMapping("/logout/{userid}")
	public String Logout( @PathVariable("userid")String userid){
		logger.info("logout Sucessfully");
		return loginService.logout(userid);
	}

}