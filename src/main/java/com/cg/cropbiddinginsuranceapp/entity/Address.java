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
	@NotBlank(message = "HouseNo is mandatory")
	private String houseno;

	@NotBlank(message = "Street is mandatory")
	private String street;

	@NotBlank(message = "City is mandatory")
	private String city;

	@NotBlank(message = "State is mandatory")
	private String state;

	@Size(min = 6, max = 6, message = "Pin Code should have 6 numeric values")
	private String pincode;

}
