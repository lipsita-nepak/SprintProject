package com.cg.cropbiddinginsuranceapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Bid {

@Id
	private int bidId;
	private String dateOfBidding;
	

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="farmer",referencedColumnName="userId")
	private Farmer farmer;

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="crop",referencedColumnName="cropId")
	private Crop crop;
	
	
	
	public Bid() {}
	public Bid(int bidId, String dateOfBidding) {
		this.bidId = bidId;
		this.dateOfBidding = dateOfBidding;
		
	}


	//Getters & Setters
	public int getBidId() {
		return bidId;
	}
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}
	public String getDateOfBidding() {
		return dateOfBidding;
	}
	public void setDateOfBidding(String dateOfBidding) {
		this.dateOfBidding = dateOfBidding;
	}
	public Farmer getFarmer() {
		return farmer;
	}
	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}
	public Crop getCrop() {
		return crop;
	}
	public void setCrop(Crop crop) {
		this.crop = crop;
	}
	
	
	@Override
	public String toString() {
		return "Bid [bidId=" + bidId + ", dateOfBidding=" + dateOfBidding + ", farmer=" + farmer + ", crop=" + crop
				+ "]";
	}
	
	
}