package com.cg.cropbiddinginsuranceapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonErrorResponse {

	// Fields
	private int status;
	private String message;
	private long timeStamp;

}
