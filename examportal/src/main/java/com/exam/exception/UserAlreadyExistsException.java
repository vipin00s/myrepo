package com.exam.exception;

public class UserAlreadyExistsException extends Exception{
private String message;
public UserAlreadyExistsException() {}
public UserAlreadyExistsException(String message) {
	super(message);
	this.message=message;
}
}