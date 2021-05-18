package com.cg.cropbiddinginsuranceapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	// Fields

	@Id
	@NotBlank
	private String houseno;

	@NotBlank
	private String street;

	@NotBlank
	private String city;

	@NotBlank
	private String state;

	@Size(min = 6, max = 6, message = "Pin Code should have 6 numeric values")
	private String pincode;

}
