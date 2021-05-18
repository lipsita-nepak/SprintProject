package com.cg.cropbiddinginsuranceapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.cropbiddinginsuranceapp.entity.PersonErrorResponse;



@ControllerAdvice
public class PersonExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException b)
	{
		PersonErrorResponse error=new PersonErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(b.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<PersonErrorResponse> handleException(Exception b)
	{
		PersonErrorResponse error=new PersonErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("Bad Request");
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
}
