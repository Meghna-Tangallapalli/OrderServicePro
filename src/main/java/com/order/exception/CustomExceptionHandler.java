package com.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.order.errors.ErrorResponse;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@Log4j2
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(DataNotFoundException.class)
	ResponseEntity<ErrorResponse> dataNotfoundException(DataNotFoundException dataNotFound){
		ErrorResponse error = new ErrorResponse();
		error.setMessage(dataNotFound.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND);
		log.error("error response is:" + error);
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	//Global Exception Handler
	@ExceptionHandler(Exception.class)
	ResponseEntity<ErrorResponse> globalExceptionHandler(Exception exception){
		ErrorResponse error = new ErrorResponse();
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		log.error("error response is:" + error);
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
}
