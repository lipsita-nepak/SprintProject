package com.cg.cropbiddinginsuranceapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
	private Integer userId;

	@NonNull
	@NotBlank(message = "Name is mandatory")
	private String name;

	@NonNull
	@Size(min = 10, max = 10, message = "Contact Number should have 10 numeric values")
	private String contactNumber;

	@Email
	@NonNull
	@NotBlank(message = "Email is mandatory")
	private String emailId;

	@NonNull
	@Pattern(regexp = "\\d{4}\\s\\d{4}\\s\\d{4}", message = "AadharNo must be of pattern (xxxx xxxx xxxx)")
	private String aadharNumber;

	@NonNull
	@NotBlank(message = "panNumber is mandatory")
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
