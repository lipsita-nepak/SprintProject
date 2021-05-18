package com.cg.cropbiddinginsuranceapp.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Bidder extends Person {

	// fields
	
	@NotNull
	@NotEmpty
	private String traderLicence;

	//constructor
	public Bidder(String traderLicence,String name, String contactNumber, String emailId, String aadharNumber, String panNumber) {
		super(name, contactNumber, emailId, aadharNumber, panNumber);
		this.traderLicence=traderLicence;
	}

	
	

}