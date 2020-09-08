package com.vti.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorDetails resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ErrorDetails message = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return message;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorDetails globalExceptionHandler(Exception ex, WebRequest request) {
		ErrorDetails message = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return message;
	}
}
