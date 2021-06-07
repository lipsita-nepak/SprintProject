package com.cg.cropbiddinginsuranceapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserErrorMessage {
	
	private int status;
	private String message;
	private long timestamp;

}
