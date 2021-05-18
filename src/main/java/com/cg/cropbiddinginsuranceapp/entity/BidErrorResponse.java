package com.cg.cropbiddinginsuranceapp.entity;

public class BidErrorResponse {

	private int status; //  error code 404
	private String message; // bid not found with the given id
	private long timeStamp;
	
	
	// constructor
	public BidErrorResponse() {}
	public BidErrorResponse(int status, String message, long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	// Getters and Setters
	
	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public long getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(long l) {
		this.timeStamp = l;
	}
	
	
}
