package com.telstra.studentapi.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleException(RuntimeException ex,WebRequest webRequest){
	ExceptionResponse res = new ExceptionResponse(HttpStatus.Series.SERVER_ERROR.name()+". "+ex.getClass().getName(),
			HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),ex.getMessage(),ex.getStackTrace().toString()); 
	return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	
	@ExceptionHandler(EntityNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleException(EntityNotFoundException ex,WebRequest webRequest){
	ExceptionResponse res = new ExceptionResponse(HttpStatus.Series.SERVER_ERROR.name()+". "+ex.getClass().getName(),
			HttpStatus.BAD_REQUEST.getReasonPhrase(),ex.getMessage(),ex.getStackTrace().toString()); 
	return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
	}

}
