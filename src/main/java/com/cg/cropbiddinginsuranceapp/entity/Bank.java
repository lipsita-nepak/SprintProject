package com.cg.cropbiddinginsuranceapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bankId;
	
	@NonNull
	@Size(min=12, max=16, message="Account Number is mandatory")
	@Pattern(regexp="\\d+")
	private String accountNumber;

	@NonNull
	@Pattern(regexp = "[A-Za-z]+",message="Bank Name is Invalid")
    @Size(min=3,message = "Bank Name is mandatory")
	private String bankName;

	@NonNull
	@Pattern(regexp = "^[A-Z]{4}0[A-Z0-9]{6}$",message="IFSC Code is Invalid")
	@NotBlank(message = "IFSC Code is mandatory")
    private String ifscCode;
	
    // HAS-A-Relationship between bank and address

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "BankPlotNo", referencedColumnName = "houseno")
	private Address address;

}
