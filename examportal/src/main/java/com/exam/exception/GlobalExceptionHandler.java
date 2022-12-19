
package com.exam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity userNotFound(UserNotFoundException ex) {
		return new ResponseEntity(" User not found",HttpStatus.NOT_FOUND);
		}
	@ExceptionHandler(value=UserAlreadyExistsException.class)
	public ResponseEntity userAlreadyExists(UserAlreadyExistsException ex) {
		return new ResponseEntity("No duplicate allowed",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=CategoryNotFoundException.class)
	public ResponseEntity categoryNotFound(CategoryNotFoundException ex) {
		return new ResponseEntity(" Category not found",HttpStatus.NOT_FOUND);
		}	
	@ExceptionHandler(value=CategoryAlreadyExistsException.class)
	public ResponseEntity categoryAlreadyExists(CategoryAlreadyExistsException ex) {
		return new ResponseEntity("No duplicate allowed",HttpStatus.NOT_FOUND);
	}
}
