package com.cg.cropbiddinginsuranceapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
	@NonNull
	@Min(1)
	private int bidId;
	@NonNull
	@NotEmpty(message = "bid date should not be empty")
	private String dateOfBidding;

	// HAS-A relation between Farmer and crop
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "farmer", referencedColumnName = "userId")
	private Farmer farmer;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "crop", referencedColumnName = "cropId")
	private Crop crop;
}
