package com.cg.cropbiddinginsuranceapp.exception;

public class BidNotFoundException extends RuntimeException {

	public BidNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public BidNotFoundException(String message) {
		super(message);
	}

	public BidNotFoundException(Throwable cause) {
		super(cause);
	}

}
