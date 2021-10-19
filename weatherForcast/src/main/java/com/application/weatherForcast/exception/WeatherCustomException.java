package com.application.weatherForcast.exception;

public class WeatherCustomException extends RuntimeException{
	
	private String message;
	private Integer errorCode;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public WeatherCustomException(String message, Integer errorCode) {
		super();
		this.message = message;
		this.errorCode = errorCode;
	}

	

}
