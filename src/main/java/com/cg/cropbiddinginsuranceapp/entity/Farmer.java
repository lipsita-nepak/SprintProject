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

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Farmer extends Person { // IS-A-Relationship between person and farmer

	// HAS-A-Relationship between farmer and address

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "FarmNo", referencedColumnName = "houseno")
	private Address farmAddress;
	
	// HAS-A-Relationship between farmer and crop
	@ManyToMany(cascade=CascadeType.ALL,targetEntity= Crop.class)
	@JoinTable(name="farmer_crop",
				joinColumns= {@JoinColumn(name="userId")},
				inverseJoinColumns= {@JoinColumn(name="cropId")})
	private List<Crop> crops=new ArrayList<>();
	
	@JsonManagedReference
	public List<Crop> getCrop(){
		return crops;
	}

	// Constructor

	public Farmer(String name, String contactNumber, String emailId, String aadharNumber, String panNumber) {
		super(name, contactNumber, emailId, aadharNumber, panNumber);
	}

}
