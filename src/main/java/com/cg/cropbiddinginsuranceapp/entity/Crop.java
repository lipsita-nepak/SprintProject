package com.cg.cropbiddinginsuranceapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Crop {

	@Id
	private int cropId;
	private String cropType;
	private String cropName;
	private String soilType;
	private double basePricePerQuintal;
	private double quantity;
	
	@Enumerated(EnumType.STRING)
	private StorageSpace storageSpace;
	@Enumerated(EnumType.STRING)
	private CropVerificationStatus cvStatus;
	
	public Crop() {}
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
	public Crop(int cropId, String cropType, String cropName, String soilType, double basePricePerQuintal,
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
	public int getCropId() {
		return cropId;
	}
	public void setCropId(int cropId) {
		this.cropId = cropId;
	}
	public String getCropType() {
		return cropType;
	}
	public void setCropType(String cropType) {
		this.cropType = cropType;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public String getSoilType() {
		return soilType;
	}
	public void setSoilType(String soilType) {
		this.soilType = soilType;
	}
	public double getBasePricePerQuintal() {
		return basePricePerQuintal;
	}
	public void setBasePricePerQuintal(double basePricePerQuintal) {
		this.basePricePerQuintal = basePricePerQuintal;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public StorageSpace getStorageSpace() {
		return storageSpace;
	}
	public void setStorageSpace(StorageSpace storageSpace) {
		storageSpace = storageSpace;
	}
	public CropVerificationStatus getCvStatus() {
		return cvStatus;
	}
	public void setCvStatus(CropVerificationStatus cvStatus) {
		this.cvStatus = cvStatus;
	}
	
	@Override
	public String toString() {
		return "Crop [cropId=" + cropId + ", cropType=" + cropType + ", cropName=" + cropName + ", soilType=" + soilType
				+ ", basePricePerQuintal=" + basePricePerQuintal + ", quantity=" + quantity + ", StorageSpace="
				+ storageSpace + ", cvStatus=" + cvStatus + "]";
	}
}
