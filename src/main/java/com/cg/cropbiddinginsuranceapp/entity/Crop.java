package com.cg.cropbiddinginsuranceapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


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
	@NotEmpty(message="croptype should not be empty")
	private String cropType;
	@NotEmpty(message="cropname should not be empty")
	private String cropName;
	@NotEmpty(message="croptype should not be empty")
	private String soilType;
	@NotNull(message="basePricePerQuintal should not be empty")
	private double basePricePerQuintal;
	@NotNull(message="quantity should not be empty")
	private double quantity;
	
	@Enumerated(EnumType.STRING)
	private StorageSpace storageSpace;
	@Enumerated(EnumType.STRING)
	private CropVerificationStatus cvStatus;
	
	
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
}
