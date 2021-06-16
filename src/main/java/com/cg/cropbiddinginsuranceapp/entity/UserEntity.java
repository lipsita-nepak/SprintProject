package com.cg.cropbiddinginsuranceapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RegisterUser")
public class UserEntity {
	
	/**
	 * UserId Validation
	 */
	@Id
	@NotEmpty(message="Please Enter your UserId")
	@Pattern(regexp = "[A-Za-z]+",message="UserId is Invalid")
	@Size(min = 4, message = "Userid is should have atleast 4 character ")
	private String userId;
	
	/*
	 * Password Validation
	 */
	@NotEmpty(message="Please Enter your Password")
	@Pattern(regexp = "[A-Za-z0-9]+",message="Password is Invalid")
	@Size(min = 8, max = 15, message = "Password should have atleast 8 characters not less than 15 characters")
	private String password;
	
	/**
	 * Name Validation
	 */
	@NotEmpty(message="Please Enter your Name")
	@Pattern(regexp = "[A-Za-z]+\\s[A-Za-z]*",message="Name is Invalid")
	@Size(min=3, message = "Name is mandatory")
    private String name;
	
	/**
	 * MobileNumber Validation
	 */
	@NotEmpty(message="Please Enter Your EmailId")
	@Pattern(regexp = "^[0-9]{10}$",message="Mobile Number is Invalid")
	@Size(min = 10, max = 10, message = "Mobile Number less than 10 is Invalid")
	private String mobileNumber;
	
	/*
	 * Email Validation
	 */
	@Email
	@NotEmpty(message="Please Enter Your Email Id")
	private String email;
    private String userRole;
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="login_fk")
	private LoginEntity login;
}


