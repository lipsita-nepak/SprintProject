package com.cg.cropbiddinginsuranceapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Bidding {
	
	@Id
	private int biddingId;
	private double bidPerQuintal;
	
	@Enumerated(EnumType.STRING)
	private BidStatus bidStatus;

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="bidder",referencedColumnName="userId")
	private Bidder bidder;

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="bid",referencedColumnName="bidId")
	private Bid bid;

	
	public Bidding() {}
	
	public Bidding(int biddingId, double bidPerQuintal, BidStatus bidStatus) {
		super();
		this.biddingId = biddingId;
		this.bidPerQuintal = bidPerQuintal;
		this.bidStatus = bidStatus;
	}



	public Bid getBid() {
		return bid;
	}

	public void setBid(Bid bid) {
		this.bid = bid;
	}

	public int getBiddingId() {
		return biddingId;
	}
	public void setBiddingId(int biddingId) {
		this.biddingId = biddingId;
	}
	public double getBidPerQuintal() {
		return bidPerQuintal;
	}
	public void setBidPerQuintal(double bidPerQuintal) {
		this.bidPerQuintal = bidPerQuintal;
	}
	public BidStatus getBidStatus() {
		return bidStatus;
	}
	public void setBidStatus(BidStatus bidStatus) {
		this.bidStatus = bidStatus;
	}
	
	public Bidder getBidder() {
		return bidder;
	}

	public void setBidder(Bidder bidder) {
		this.bidder = bidder;
	}

	@Override
	public String toString() {
		return "Bidding [biddingId=" + biddingId + ", bidPerQuintal=" + bidPerQuintal + ", bidStatus=" + bidStatus
				+ ", bidder=" + bidder + ", bid=" + bid + "]";
	}

	
	
}
