package com.application.weatherForcast.exception;

public class GenericBadException extends RuntimeException {

	private static final long serialVersionUID = -762180121635539939L;

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
	public GenericBadException(String message, Integer errorCode) {
		super();
		this.message = message;
		this.errorCode = errorCode;
	}

	

}
