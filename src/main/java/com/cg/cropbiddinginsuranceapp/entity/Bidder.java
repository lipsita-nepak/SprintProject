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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Bidder extends Person {

	// fields
	@NonNull
	@NotNull
	@NotEmpty
	private String traderLicence;
	
	// HAS-A-Relationship between bidder and crop
		@JsonIgnore
		@ManyToMany(cascade=CascadeType.ALL,targetEntity= Crop.class)

	
		@JoinTable(name="bidder_crop",
					joinColumns= {@JoinColumn(name="userId")},
					inverseJoinColumns= {@JoinColumn(name="cropId")})
		private List<Crop> crops=new ArrayList<>();
		
		@JsonIgnore
		@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		@JoinColumn(name="bid",referencedColumnName="bidId")
		private Bid bid;

		//constructor
		public Bidder(@NonNull String traderLicence,@NonNull String name, @NonNull String contactNumber, @NonNull String emailId,
				@NonNull String aadharNumber, @NonNull String panNumber, @NonNull String accountNumber,
				@NonNull String bankName, @NonNull String ifscCode) {
			super(name, contactNumber, emailId, aadharNumber, panNumber, accountNumber, bankName, ifscCode);
			this.traderLicence=traderLicence;
		}
	
	


}