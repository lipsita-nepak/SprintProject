package com.cg.cropbiddinginsuranceapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Bank {

	// Fields
	@Id
	@NonNull
	@Min(1)
	private long bankId;

	@NonNull
	@NotBlank(message = "Bank Name is mandatory")
	private String bankName;

	@NonNull
	@NotBlank(message = "IFSC Code is mandatory")
	private String ifscCode;

	// HAS-A-Relationship between bank and address

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "BankPlotNo", referencedColumnName = "houseno")
	private Address address;

}
