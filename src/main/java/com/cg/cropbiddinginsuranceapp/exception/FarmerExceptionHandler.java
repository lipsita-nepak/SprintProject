package com.cg.cropbiddinginsuranceapp.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.cg.cropbiddinginsuranceapp.entity.ErrorResponse;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class FarmerExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(FarmerNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
        
		log.error("Handling Farmer Not Found Exception");
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception exception) {
		ErrorResponse error = new ErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		log.error("Handling Exception");
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
