package com.cg.cropbiddinginsuranceapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	// HAS-A-Relationship between bidder and crop
		@ManyToMany(cascade=CascadeType.ALL,targetEntity= Crop.class)

		
		@JoinTable(name="bidder_crop",
					joinColumns= {@JoinColumn(name="userId")},
					inverseJoinColumns= {@JoinColumn(name="cropId")})
		private List<Crop> crops=new ArrayList<>();
		

		@JsonManagedReference
		public List<Crop> getCrop(){
			return crops;
		}

	
	//constructor
	public Bidder(String traderLicence,String name, String contactNumber, String emailId, String aadharNumber, String panNumber) {
		super(name, contactNumber, emailId, aadharNumber, panNumber);
		this.traderLicence=traderLicence;
	}

	
	

}