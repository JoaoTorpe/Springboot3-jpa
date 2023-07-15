package com.educaweb.curso.resources.exeptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educaweb.curso.services.exeptions.ResourceNotFoundExption;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class responseExeptionHandler {

		@ExceptionHandler(ResourceNotFoundExption.class)
	public ResponseEntity<standardError> resourceNotFound(ResourceNotFoundExption e, HttpServletRequest request ){
		
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		standardError err = new standardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	
	
}
