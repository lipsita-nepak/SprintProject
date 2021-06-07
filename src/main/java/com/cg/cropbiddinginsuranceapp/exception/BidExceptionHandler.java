package com.cg.cropbiddinginsuranceapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.cropbiddinginsuranceapp.entity.BidErrorResponse;
import com.cg.cropbiddinginsuranceapp.entity.CropErrorMessage;

@ControllerAdvice
public class BidExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<BidErrorResponse> handleException(BidNotFoundException exception) {
		BidErrorResponse error = new BidErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value()); 
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<BidErrorResponse> handleException(Exception exception) {
		BidErrorResponse error = new BidErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value()); 
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}