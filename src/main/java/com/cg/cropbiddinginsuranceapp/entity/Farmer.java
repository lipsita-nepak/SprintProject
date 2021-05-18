package com.cg.cropbiddinginsuranceapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Farmer extends Person { // IS-A-Relationship between person and farmer

	// HAS-A-Relationship between farmer and address

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "FarmNo", referencedColumnName = "houseno")
	private Address farmAddress;

	// Constructor

	public Farmer(String name, String contactNumber, String emailId, String aadharNumber, String panNumber) {
		super(name, contactNumber, emailId, aadharNumber, panNumber);
	}

}
