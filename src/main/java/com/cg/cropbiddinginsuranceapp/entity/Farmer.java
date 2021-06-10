package com.cg.cropbiddinginsuranceapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;



import lombok.Data;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Farmer extends Person { // IS-A-Relationship between person and farmer

	// HAS-A-Relationship between farmer and address

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "FarmNo", referencedColumnName = "houseno")
	private Address farmAddress;
	

	// HAS-A-Relationship between farmer and crop
	@JsonIgnore
	@ManyToMany(cascade=CascadeType.ALL,targetEntity= Crop.class)
	@JoinTable(name="farmer_crop",
				joinColumns= {@JoinColumn(name="userId")},
				inverseJoinColumns= {@JoinColumn(name="cropId")})
	private List<Crop> crops=new ArrayList<>();
	

	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="bid",referencedColumnName="bidId")
	private Bid bid;


	

	// Constructor

	public Farmer(String name, String contactNumber, String emailId, String aadharNumber, String panNumber) {
		super(name, contactNumber, emailId, aadharNumber, panNumber);
	}
	
}
