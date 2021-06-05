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
import javax.validation.constraints.Size;

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
	private int userId;

	@NonNull
	private String name;

	@NonNull
	private String contactNumber;

	@NonNull
	private String emailId;

	@NonNull
	private String aadharNumber;

	@NonNull
	private String panNumber;

	// HAS-A-Relationship between farmer and address
	// HAS-A-Relationship between Bidder and address 	

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "HomeNo", referencedColumnName = "houseno")
	private Address homeAddress;

	// HAS-A-Relationship between farmer and account
	// HAS-A-Relationship between Bidder and account
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "accountId", referencedColumnName = "accountId")
	private Account bankDetails;
}
