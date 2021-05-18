package com.cg.cropbiddinginsuranceapp.exception;

public class CropNotFoundException extends RuntimeException {

	public CropNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CropNotFoundException(String message) {
		super(message);
	}

	public CropNotFoundException(Throwable cause) {
		super(cause);
	}

}
