package com.cg.cropbiddinginsuranceapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Person {

	// Fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@NonNull
	@Pattern(regexp = "[A-Za-z]+\\s[A-Za-z]+",message="Name is Invalid")
	@Size(min=3, message = "Name is mandatory")
   private String name;

	@NonNull
    @Pattern(regexp = "^[0-9]{10}$",message="Mobile Number is Invalid")
    @Size(min = 10, max = 10, message = "Contact Number should have 10 numeric values")

	private String contactNumber;

	@NonNull
	@Pattern(regexp= "^[A-Za-z0-9]+@[a-z]+\\.[a-z]+",message="EmailId is Invalid")
	@NotBlank(message = "Email is mandatory")
	private String emailId;

	@NonNull
	@Pattern(regexp = "\\d{4}\\s\\d{4}\\s\\d{4}", message = "AadharNo must be of pattern (xxxx xxxx xxxx)")
	private String aadharNumber;

	@NonNull
	@Pattern(regexp="[A-Z]{5}[0-9]{4}[A-Z]{1}", message="Pan Number is Invalid" )
	@Size(min=10, max=10, message=" Pan number should have 10 character long alpha-numeric value")
	private String panNumber;

	// HAS-A-Relationship between farmer and address
	// HAS-A-Relationship between Bidder and address
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "HomeNo", referencedColumnName = "id")
	private Address homeAddress;

	// HAS-A-Relationship between farmer and account
	// HAS-A-Relationship between Bidder and account

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "accountId", referencedColumnName = "bankId")
	private Bank bankDetails;
}
