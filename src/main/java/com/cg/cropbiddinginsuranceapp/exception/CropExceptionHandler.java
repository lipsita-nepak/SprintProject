package com.cg.cropbiddinginsuranceapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.cropbiddinginsuranceapp.entity.ErrorResponse;

@ControllerAdvice
public class CropExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(CropNotFoundException e){
		ErrorResponse error=new ErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}

}
