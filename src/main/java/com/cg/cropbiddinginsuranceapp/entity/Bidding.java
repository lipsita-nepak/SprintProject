package com.cg.cropbiddinginsuranceapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bidding {
	@Id
	private int biddingId;
	@NotNull(message="bidPerQuintal should not be empty")
	private double bidPerQuintal;
	@Enumerated(EnumType.STRING)
	private BidStatus bidStatus;

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="bidder",referencedColumnName="userId")
	private Bidder bidder;

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="bid",referencedColumnName="bidId")
	private Bid bid;

	public Bidding(int biddingId, double bidPerQuintal, BidStatus bidStatus) {
		super();
		this.biddingId = biddingId;
		this.bidPerQuintal = bidPerQuintal;
		this.bidStatus = bidStatus;
	}	
}
