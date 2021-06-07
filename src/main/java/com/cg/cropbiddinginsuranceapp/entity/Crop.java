package com.cg.cropbiddinginsuranceapp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Crop {

	@Id
	private int cropId;
	@NotEmpty(message="crop type should not be empty")
	private String cropType;
	@NotEmpty(message="crop name should not be empty")
	private String cropName;
	private String soilType;
	private double basePricePerQuintal;
	private double quantity;
	
	@Enumerated(EnumType.STRING)
	private StorageSpace storageSpace;
	@Enumerated(EnumType.STRING)
	private CropVerificationStatus cvStatus;
	
	@JsonIgnore
	@ManyToMany(mappedBy="crops",cascade=CascadeType.ALL)

	private List<Farmer> farmersList;
	
	@JsonIgnore
	@ManyToMany(mappedBy="crops",cascade=CascadeType.ALL)

	private List<Bidder> biddersList;
	
	
	@JsonBackReference
	public List<Farmer> getFarmer(){
		return farmersList;
	}
	
	@JsonBackReference
	public List<Bidder> getBidder(){
		return biddersList;
	}
	

	

	
  /**
	 * Required Constructor for the entity class crop
	 */
	public Crop(int cropId, String cropType, String cropName, String soilType, double basePricePerQuintal,
			double quantity) {
		super();
		this.cropId = cropId;
		this.cropType = cropType;
		this.cropName = cropName;
		this.soilType = soilType;
		this.basePricePerQuintal = basePricePerQuintal;
		this.quantity = quantity;
	}



	/**
	 * Required Constructor for the entity class crop
	 */
	public Crop(int cropId,String cropType,String cropName, String soilType,double basePricePerQuintal, 
			double quantity, StorageSpace storageSpace, CropVerificationStatus cvStatus) {
		super();
		this.cropId = cropId;
		this.cropType = cropType;
		this.cropName = cropName;
		this.soilType = soilType;
		this.basePricePerQuintal = basePricePerQuintal;
		this.quantity = quantity;
		this.storageSpace = storageSpace;
		this.cvStatus = cvStatus;
	}

}
