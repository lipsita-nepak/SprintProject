package com.cg.cropbiddinginsuranceapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.cg.cropbiddinginsuranceapp.entity.UserErrorMessage;

@ControllerAdvice
public class UserExceptionHandler {
	
	/*
	 * UserNotFoundException
	 */
	@ExceptionHandler
	public ResponseEntity<UserErrorMessage> handleExeption(UserNotFoundException exception) {
		UserErrorMessage error = new UserErrorMessage();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}
/*
 * GenericType Exception Handler
 */
	@ExceptionHandler
	public ResponseEntity<UserErrorMessage> handleException(Exception exception) {
		UserErrorMessage error = new UserErrorMessage();
		error.setStatus(HttpStatus.BAD_REQUEST.value()); // 400
		error.setMessage(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }

}
