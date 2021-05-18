package com.cg.cropbiddinginsuranceapp.exception;

public class FarmerNotFoundException extends RuntimeException {

	public FarmerNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public FarmerNotFoundException(String message) {
		super(message);
	}

	public FarmerNotFoundException(Throwable cause) {
		super(cause);
	}
}
