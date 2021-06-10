package com.cg.cropbiddinginsuranceapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "bid")
@NoArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@ToString

public class Bid {
	@Id
	@Min(1)
	private int bidId;
	@NonNull
	@NotEmpty(message = "bid date should not be empty")
	private String dateOfBidding;
	
	@NotNull(message="bidPerQuintal should not be empty")
	@NonNull
	private double bidPerQuintal;
	
	@Enumerated(EnumType.STRING)
	@NonNull
	private BidStatus bidStatus;

	

	

}
