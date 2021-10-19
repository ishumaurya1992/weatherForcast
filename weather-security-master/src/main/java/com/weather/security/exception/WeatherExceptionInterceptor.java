package com.weather.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WeatherExceptionInterceptor {
	
	@ExceptionHandler(WeatherCustomException.class)
	  public final ResponseEntity<Object> handleAllExceptions(GenericBadException ex) {
	    GenericExceptionSchema exceptionResponse =
	        new GenericExceptionSchema(
	            ex.getMessage(), ex.getErrorCode());
	    return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	  }

}
